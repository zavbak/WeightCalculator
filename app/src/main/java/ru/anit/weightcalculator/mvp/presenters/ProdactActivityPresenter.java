package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.anit.weightcalculator.app.App;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.views.ProdactActivityView;
import ru.anit.weightcalculator.repository.realm.repository.IProductRepository;

/**
 * Created by Alex on 17.05.2017.
 */

@InjectViewState
public class ProdactActivityPresenter extends MvpPresenter<ProdactActivityView> {
    Product mProduct;

    @Inject
    IProductRepository mIProductRepository;

    public ProdactActivityPresenter() {
        App.getAppComponent().injectProdactActivityPresenter(this);
    }

    public void setProduct(String id) {
        mProduct = new Product();

        if(id != null){
            mIProductRepository.getProductById(Long.parseLong(id), new IProductRepository.OnGetProductByIdCallback() {
                @Override
                public void onSuccess(Product product) {
                    if(product != null){
                        mProduct.setId(product.getId());
                        mProduct.setName          (product.getName());
                        mProduct.setCoefficient   (product.getCoefficient());
                        mProduct.setStartPosition (product.getStartPosition());
                        mProduct.setFinishPosition(product.getFinishPosition());
                        mProduct.setInitBarcode   (product.getInitBarcode());
                    }
                }

                @Override
                public void onError(String message) {

                }
            });
        }
    }

    public Product getProduct() {
        return mProduct;
    }

    public CharSequence getId() {
        return  Long.toString(mProduct.getId());
    }

    public void refreshPresenter() {
        getViewState().refreshView();
    }

    public void startBarcodeListActivityPresenter() {
        getViewState().startBarcodeListActivityView(Long.toString(mProduct.getId()));
    }

    public void onClickCalculate() {
        startBarcodeListActivityPresenter();
    }

    public void onClickOk() {
        mIProductRepository.saveProduct(mProduct, new IProductRepository.OnAddProductCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(String message) {

            }
        });

        getViewState().finishView();
    }

    public void onClickDell() {

        if(mProduct.getId() == 0 ){
            return;
        }

        mIProductRepository.deleteProductById(mProduct.getId(), new IProductRepository.OnDeleteProductCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(String message) {

            }
        });
        getViewState().finishView();

    }
}
