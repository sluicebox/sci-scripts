;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64033)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use Str)
(use Actor)
(use System)

(public
	TextDialog 0
	proc64033_1 1
	proc64033_2 2
	proc64033_3 3
	proc64033_4 4
	YesNoDialog 5
	proc64033_6 6
	StackedButtonDialog 7
	proc64033_8 8
	DisplayMsgSequence 9
)

(local
	local0
	local1
)

(procedure (DisplayMsgSequence param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(if (< argc 4)
		(PrintDebug {Illegal call of DisplayMsgSequence. DJM})
		(return)
	)
	(= temp0 (GetNumMessages param4 param1 param2 param3))
	(= temp1 1)
	(if (== temp0 0)
		(PrintDebug {No Messages in sequence. DisplayMsgSequence})
		(return)
	)
	(if (== temp0 1)
		(TextDialog
			(MakeMessageText param1 param2 param3 temp1 param4 1)
			(MakeMessageText 0 0 3 1 14)
		)
		(return)
	)
	(while 1
		(if (= temp3 (MakeMessageText param1 param2 param3 temp1 param4 1))
			(if (== temp1 1)
				(if
					(YesNoDialog
						temp3
						(MakeMessageText 0 0 47 1 14)
						(MakeMessageText 0 0 21 1 14)
					)
					(++ temp1)
					(continue)
				)
				(break)
			)
			(if (== temp1 temp0)
				(if
					(YesNoDialog
						temp3
						(MakeMessageText 0 0 42 1 14)
						(MakeMessageText 0 0 21 1 14)
					)
					(-- temp1)
					(continue)
				)
				(break)
			)
			(switch
				(= temp2
					(proc64033_8
						temp3
						(MakeMessageText 0 0 42 1 14)
						(MakeMessageText 0 0 47 1 14)
						(MakeMessageText 0 0 21 1 14)
					)
				)
				(1
					(-- temp1)
				)
				(0
					(++ temp1)
				)
				(-1
					(break)
				)
			)
		)
	)
)

(procedure (proc64033_1 param1 param2) ; UNUSED
	(if (< argc 2)
		(PrintDebug {illegal set of dialog font. gendialg.sc DJM})
		(return)
	)
	(= global268 param1)
	(= global269 param2)
)

(procedure (proc64033_2 param1 param2) ; UNUSED
	(if (< argc 2)
		(PrintDebug {illegal set of button font. gendialg.sc DJM})
		(return)
	)
	(= global270 param1)
	(= global271 param2)
)

(procedure (proc64033_3 param1 param2 param3) ; UNUSED
	(if (< argc 3)
		(PrintDebug {illegal set of dialog colors. gendialg.sc DJM})
		(return)
	)
	(= global274 param1)
	(= global272 param2)
	(= global273 param3)
)

(procedure (proc64033_4 param1 param2 param3) ; UNUSED
	(if (< argc 3)
		(PrintDebug {illegal set of dialog colors. gendialg.sc DJM})
		(return)
	)
	(= global275 param1)
	(= global276 param2)
	(= global277 param3)
)

(procedure (TextDialog param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21)
	(if (or (< argc 2) (not param1) (not param2))
		(if param1
			(proc64896_7 param1)
		)
		(if param2
			(proc64896_7 param2)
		)
		(PrintDebug {illegal call of TextDialog. gendialg.sc DJM})
		(return)
	)
	(if (< argc 3)
		(= temp0 0)
	else
		(= temp0 param3)
	)
	(if (< argc 4)
		(= temp2 -2)
	else
		(= temp2 param4)
	)
	(if (< argc 5)
		(= temp3 -2)
	else
		(= temp3 param5)
	)
	(if (< argc 6)
		(= temp1 300)
	else
		(= temp1 param6)
	)
	(= temp10 (DialogPlane new:))
	(temp10 init: 0 0 1 1)
	(= temp20 (TextItem new:))
	(temp20
		font: global268
		nLeading: global269
		maxWidth: temp1
		fore: global274
		back: 255
		skip: 255
		text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
		border: 0
		mode: global291
		bTileBorder: 0
		init: temp10
	)
	(= temp4 (temp20 nWidth:))
	(= temp5 (temp20 nHeight:))
	(= temp12 (DismissTextButton new:))
	(temp12
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param2)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		bDefault: 1
		init: temp10
	)
	(= temp6 (temp12 nWidth:))
	(= temp7 (temp12 nHeight:))
	(= temp8 (+ (Max temp4 temp6) 10))
	(= temp9 (+ temp5 temp7 15))
	(if temp0
		(= temp21 global289)
	else
		(= temp21 global275)
	)
	(= temp11 (TiledView new:))
	(temp11 view: temp21 init: temp8 temp9 0 1 temp10)
	(= temp14 (temp11 nWidth:))
	(= temp15 (temp11 nHeight:))
	(if temp0
		(= temp13 (TextItem new:))
		(temp13
			font: global268
			nLeading: global269
			maxWidth: (- temp14 18)
			nMinWidth: (- temp14 12)
			fore: global274
			back: 255
			skip: 255
			text: (KArray 8 (KArray 9 temp0)) ; ArrayDup, ArrayGetData
			border: 5
			bTileBorder: 1
			vTile: global290
			init: temp10
		)
		(+= temp15 (temp13 nHeight:))
	else
		(= temp13 0)
	)
	(switch temp2
		(-1
			(= temp2 (/ (- gScreenWidth temp14) 2))
		)
		(-2
			(= temp2 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp14) 2)))
		)
	)
	(switch temp3
		(-1
			(= temp3 (/ (- gScreenHeight temp15) 2))
		)
		(-2
			(= temp3 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp15) 2)))
		)
	)
	(temp10 setRect: temp2 temp3 (- (+ temp2 temp14) 1) (- (+ temp3 temp15) 1))
	(UpdatePlane temp10)
	(= temp16 (temp11 nOffsetX:))
	(= temp17 (temp11 nOffsetY:))
	(if temp13
		(temp11 posn: (temp11 x:) (+ (temp11 y:) (temp13 nHeight:)))
		(+= temp17 (temp13 nHeight:))
	)
	(temp20 posn: (+ temp16 5) (+ temp17 5))
	(= temp18 (/ (- temp14 temp6) 2))
	(= temp19 (+ temp17 10 temp5))
	(temp12 posn: temp18 temp19)
	(if param1
		(proc64896_7 param1)
	)
	(if param2
		(proc64896_7 param2)
	)
	(if temp0
		(proc64896_7 temp0)
	)
	(temp10 sitNSpin:)
)

(procedure (YesNoDialog param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23)
	(if (or (< argc 3) (not param1) (not param2) (not param3))
		(if param1
			(proc64896_7 param1)
		)
		(if param3
			(proc64896_7 param2)
		)
		(if param2
			(proc64896_7 param3)
		)
		(PrintDebug {illegal call of YesNoDialog. gendialg.sc DJM})
		(return 0)
	)
	(if (< argc 4)
		(= temp0 0)
	else
		(= temp0 param4)
	)
	(if (< argc 5)
		(= temp2 -2)
	else
		(= temp2 param5)
	)
	(if (< argc 6)
		(= temp3 -2)
	else
		(= temp3 param6)
	)
	(if (< argc 7)
		(= temp1 300)
	else
		(= temp1 param7)
	)
	(= temp10 (DialogPlane new:))
	(temp10 init: 0 0 1 1)
	(= temp20 (TextItem new:))
	(temp20
		font: global268
		nLeading: global269
		maxWidth: temp1
		fore: global274
		back: 255
		skip: 255
		text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
		mode: global291
		border: 0
		bTileBorder: 0
		init: temp10
	)
	(= temp4 (temp20 nWidth:))
	(= temp5 (temp20 nHeight:))
	(= temp22
		(+
			(= temp22
				(Max
					(GetTextWidth param2 global270 0)
					(GetTextWidth param3 global270 0)
				)
			)
			10
		)
	)
	(= temp12 (DismissTextButton new:))
	(temp12
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param2)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp22
		value: 1
		bDefault: 1
		init: temp10
	)
	(= temp13 (DismissTextButton new:))
	(temp13
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param3)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp22
		value: 0
		init: temp10
	)
	(= temp6 (temp13 nWidth:))
	(= temp7 (temp13 nHeight:))
	(= temp8 (+ (Max temp4 (+ temp6 5 temp6)) 10))
	(= temp9 (+ temp5 temp7 15))
	(if temp0
		(= temp23 60019)
	else
		(= temp23 global275)
	)
	(= temp11 (TiledView new:))
	(temp11 view: temp23 init: temp8 temp9 0 1 temp10)
	(= temp14 (temp11 nWidth:))
	(= temp15 (temp11 nHeight:))
	(if temp0
		(= temp21 (TextItem new:))
		(temp21
			font: global268
			nLeading: global269
			maxWidth: (- temp14 18)
			nMinWidth: (- temp14 12)
			fore: global274
			back: 255
			skip: 255
			text: (KArray 8 (KArray 9 temp0)) ; ArrayDup, ArrayGetData
			border: 5
			bTileBorder: 1
			vTile: 60020
			init: temp10
		)
		(+= temp15 (temp21 nHeight:))
	else
		(= temp21 0)
	)
	(switch temp2
		(-1
			(= temp2 (/ (- gScreenWidth temp14) 2))
		)
		(-2
			(= temp2 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp14) 2)))
		)
	)
	(switch temp3
		(-1
			(= temp3 (/ (- gScreenHeight temp15) 2))
		)
		(-2
			(= temp3 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp15) 2)))
		)
	)
	(temp10 setRect: temp2 temp3 (- (+ temp2 temp14) 1) (- (+ temp3 temp15) 1))
	(UpdatePlane temp10)
	(= temp16 (temp11 nOffsetX:))
	(= temp17 (temp11 nOffsetY:))
	(if temp21
		(temp11 posn: (temp11 x:) (+ (temp11 y:) (temp21 nHeight:)))
		(+= temp17 (temp21 nHeight:))
	)
	(temp20 posn: (+ temp16 5) (+ temp17 5))
	(= temp18 (/ (- temp14 (+ temp6 temp6 5)) 2))
	(= temp19 (+ temp17 10 temp5))
	(temp12 posn: temp18 temp19)
	(temp13 posn: (+ temp18 temp6 5) temp19)
	(if param1
		(proc64896_7 param1)
	)
	(if param2
		(proc64896_7 param2)
	)
	(if param3
		(proc64896_7 param3)
	)
	(if temp0
		(proc64896_7 temp0)
	)
	(return (temp10 sitNSpin:))
)

(procedure (proc64033_8 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24)
	(if (or (< argc 4) (not param1) (not param2) (not param3) (not param4))
		(if param1
			(proc64896_7 param1)
		)
		(if param2
			(proc64896_7 param2)
		)
		(if param3
			(proc64896_7 param3)
		)
		(if param4
			(proc64896_7 param4)
		)
		(PrintDebug {illegal call of YesNoDialog. gendialg.sc DJM})
		(return 0)
	)
	(if (< argc 5)
		(= temp0 0)
	else
		(= temp0 param5)
	)
	(if (< argc 6)
		(= temp2 -2)
	else
		(= temp2 param6)
	)
	(if (< argc 7)
		(= temp3 -2)
	else
		(= temp3 param7)
	)
	(if (< argc 8)
		(= temp1 300)
	else
		(= temp1 param8)
	)
	(= temp10 (DialogPlane new:))
	(temp10 init: 0 0 1 1)
	(= temp20 (TextItem new:))
	(temp20
		font: global268
		nLeading: global269
		maxWidth: temp1
		fore: global274
		back: 255
		skip: 255
		text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
		mode: global291
		border: 0
		bTileBorder: 0
		init: temp10
	)
	(= temp4 (temp20 nWidth:))
	(= temp5 (temp20 nHeight:))
	(= temp22
		(+
			(= temp22
				(Max
					(GetTextWidth param2 global270 0)
					(GetTextWidth param3 global270 0)
					(GetTextWidth param4 global270 0)
				)
			)
			10
		)
	)
	(= temp12 (DismissTextButton new:))
	(temp12
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param2)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp22
		value: 1
		bDefault: 1
		init: temp10
	)
	(= temp13 (DismissTextButton new:))
	(temp13
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param3)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp22
		value: 0
		init: temp10
	)
	(= temp24 (DismissTextButton new:))
	(temp24
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param4)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp22
		value: -1
		init: temp10
	)
	(= temp6 (temp13 nWidth:))
	(= temp7 (temp13 nHeight:))
	(= temp8 (+ (Max temp4 (+ temp6 10 temp6 temp6)) 10))
	(= temp9 (+ temp5 temp7 15))
	(if temp0
		(= temp23 60019)
	else
		(= temp23 global275)
	)
	(= temp11 (TiledView new:))
	(temp11 view: temp23 init: temp8 temp9 0 1 temp10)
	(= temp14 (temp11 nWidth:))
	(= temp15 (temp11 nHeight:))
	(if temp0
		(= temp21 (TextItem new:))
		(temp21
			font: global268
			nLeading: global269
			maxWidth: (- temp14 18)
			nMinWidth: (- temp14 12)
			fore: global274
			back: 255
			skip: 255
			text: (KArray 8 (KArray 9 temp0)) ; ArrayDup, ArrayGetData
			border: 5
			bTileBorder: 1
			vTile: 60020
			init: temp10
		)
		(+= temp15 (temp21 nHeight:))
	else
		(= temp21 0)
	)
	(switch temp2
		(-1
			(= temp2 (/ (- gScreenWidth temp14) 2))
		)
		(-2
			(= temp2 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp14) 2)))
		)
	)
	(switch temp3
		(-1
			(= temp3 (/ (- gScreenHeight temp15) 2))
		)
		(-2
			(= temp3 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp15) 2)))
		)
	)
	(temp10 setRect: temp2 temp3 (- (+ temp2 temp14) 1) (- (+ temp3 temp15) 1))
	(UpdatePlane temp10)
	(= temp16 (temp11 nOffsetX:))
	(= temp17 (temp11 nOffsetY:))
	(if temp21
		(temp11 posn: (temp11 x:) (+ (temp11 y:) (temp21 nHeight:)))
		(+= temp17 (temp21 nHeight:))
	)
	(temp20 posn: (+ temp16 5) (+ temp17 5))
	(= temp18 (/ (- temp14 (+ temp6 temp6 temp6 10)) 2))
	(= temp19 (+ temp17 10 temp5))
	(temp12 posn: temp18 temp19)
	(+= temp18 (+ temp6 5))
	(temp13 posn: temp18 temp19)
	(+= temp18 (+ temp6 5))
	(temp24 posn: temp18 temp19)
	(if param1
		(proc64896_7 param1)
	)
	(if param2
		(proc64896_7 param2)
	)
	(if param3
		(proc64896_7 param3)
	)
	(if param4
		(proc64896_7 param4)
	)
	(if temp0
		(proc64896_7 temp0)
	)
	(return (temp10 sitNSpin:))
)

(procedure (proc64033_6 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30)
	(if (or (< argc 4) (not param1) (not param2) (not param3) (not param4))
		(if param1
			(proc64896_7 param1)
		)
		(if param3
			(proc64896_7 param2)
		)
		(if param2
			(proc64896_7 param3)
		)
		(PrintDebug {illegal call of YesNoDialog. gendialg.sc DJM})
		(return 0)
	)
	(if (< argc 5)
		(= temp0 0)
	else
		(= temp0 param5)
	)
	(if (< argc 6)
		(= temp2 -2)
	else
		(= temp2 param6)
	)
	(if (< argc 7)
		(= temp3 -2)
	else
		(= temp3 param7)
	)
	(if (< argc 8)
		(= temp1 300)
	else
		(= temp1 param8)
	)
	(= temp10 (DialogPlane new:))
	(temp10 init: 0 0 1 1)
	(= temp23 (* (GetTextWidth {M} global268 0) param4))
	(= temp19 (TextItem new:))
	(temp19
		font: global268
		nLeading: global269
		maxWidth: temp1
		fore: global274
		back: 255
		skip: 255
		text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
		mode: global291
		border: 0
		bTileBorder: 0
		init: temp10
	)
	(= temp4 (temp19 nWidth:))
	(= temp5 (temp19 nHeight:))
	(= temp21
		(+
			(= temp21
				(Max
					(GetTextWidth param2 global270 0)
					(GetTextWidth param3 global270 0)
				)
			)
			10
		)
	)
	(oBtnOK
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param2)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp21
		value: 1
		bDefault: 1
		init: temp10
	)
	(= temp12 (DismissTextButton new:))
	(temp12
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param3)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp21
		value: 0
		init: temp10
	)
	(= temp6 (temp12 nWidth:))
	(= temp7 (temp12 nHeight:))
	(= temp24 (+ temp23 10))
	(= local0 (EditItem new:))
	(local0
		font: global268
		nLeading: global269
		fore: global274
		back: 255
		skip: 255
		mode: 0
		nMinWidth: temp24
		border: 3
		nMaxChars: param4
		text: (Str with: { })
		bTileBorder: 1
		vTile: global277
		init: temp10
	)
	(= temp25 (local0 nWidth:))
	(= temp26 (local0 nHeight:))
	(= temp8 (+ (Max temp4 temp25 (+ temp6 5 temp6)) 10))
	(= temp9 (+ temp5 temp7 temp26 20))
	(if temp0
		(= temp22 60019)
	else
		(= temp22 global275)
	)
	(= temp11 (TiledView new:))
	(temp11 view: temp22 init: temp8 temp9 0 1 temp10)
	(= temp13 (temp11 nWidth:))
	(= temp14 (temp11 nHeight:))
	(if temp0
		(= temp20 (TextItem new:))
		(temp20
			font: global268
			nLeading: global269
			maxWidth: (- temp13 18)
			nMinWidth: (- temp13 12)
			fore: global274
			back: 255
			skip: 255
			text: (KArray 8 (KArray 9 temp0)) ; ArrayDup, ArrayGetData
			border: 5
			bTileBorder: 1
			vTile: 60020
			init: temp10
		)
		(+= temp14 (temp20 nHeight:))
	else
		(= temp20 0)
	)
	(switch temp2
		(-1
			(= temp2 (/ (- gScreenWidth temp13) 2))
		)
		(-2
			(= temp2 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp13) 2)))
		)
	)
	(switch temp3
		(-1
			(= temp3 (/ (- gScreenHeight temp14) 2))
		)
		(-2
			(= temp3 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp14) 2)))
		)
	)
	(temp10 setRect: temp2 temp3 (- (+ temp2 temp13) 1) (- (+ temp3 temp14) 1))
	(UpdatePlane temp10)
	(= temp15 (temp11 nOffsetX:))
	(= temp16 (temp11 nOffsetY:))
	(if temp20
		(temp11 posn: (temp11 x:) (+ (temp11 y:) (temp20 nHeight:)))
		(+= temp16 (temp20 nHeight:))
	)
	(= temp27 (/ (- temp13 temp4) 2))
	(= temp28 (+ temp16 5))
	(temp19 posn: temp27 temp28)
	(= temp29 (/ (- temp13 temp25) 2))
	(= temp30 (+ temp28 temp5 5))
	(local0 posn: temp29 temp30)
	(= temp17 (/ (- temp13 (+ temp6 temp6 5)) 2))
	(= temp18 (+ temp30 temp26 5))
	(oBtnOK posn: temp17 temp18)
	(temp12 posn: (+ temp17 temp6 5) temp18)
	(UpdateScreenItem oBtnOK)
	(UpdateScreenItem temp12)
	(UpdateScreenItem local0)
	(UpdateScreenItem temp19)
	(UpdateScreenItem temp11)
	(FrameOut)
	(if param1
		(proc64896_7 param1)
	)
	(if param2
		(proc64896_7 param2)
	)
	(if param3
		(proc64896_7 param3)
	)
	(if temp0
		(proc64896_7 temp0)
	)
	(= local1 0)
	(local0 doVerb:)
	(temp10 sitNSpin:)
	(return local1)
)

(procedure (StackedButtonDialog param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 10] temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29)
	(if (or (< argc 4) (not [param4 0]) (> argc 13))
		(PrintDebug {Illegal call of StackedButtonDialog. slidesho.sc MFM})
		(return 0)
	)
	(= temp4 (DialogPlane new:))
	(temp4 init: 0 0 1 1)
	(= temp26 0)
	(for ((= temp23 0)) (< temp23 param1) ((++ temp23))
		(= temp27 (GetTextWidth [param4 temp23] global270 -1))
		(if (< temp26 temp27)
			(= temp26 temp27)
		)
	)
	(+= temp26 10)
	(= temp23 0)
	(= temp17 0)
	(while (< temp23 param1)
		(= temp6 (DismissTextButton new:))
		(temp6
			text: (KArray 8 (KArray 9 [param4 temp23])) ; ArrayDup, ArrayGetData
			fore: global272
			back: global273
			font: global270
			vTileOff: global276
			vTileOn: global277
			bTileBorder: 1
			nLeading: global271
			value: temp23
			nMinWidth: temp26
			bCancel: 0
			init: temp4
		)
		(= [temp7 temp23] temp6)
		(if (< temp17 (temp6 nWidth:))
			(= temp17 (temp6 nWidth:))
		)
		(++ temp23)
	)
	(= temp18 (temp6 nHeight:))
	(= temp21 (+ temp17 10))
	(= temp22 (+ (* (+ temp18 5) param1) 5))
	(= temp5 (TiledView new:))
	(temp5 view: global275 init: temp21 temp22 0 1 temp4)
	(= temp2 (temp5 nWidth:))
	(= temp3 (temp5 nHeight:))
	(= temp28 (temp5 nOffsetX:))
	(= temp29 (temp5 nOffsetY:))
	(if (== param2 0)
		(= temp0 (/ (- gScreenWidth temp2) 2))
	else
		(= temp0 param2)
	)
	(if (== param3 0)
		(= temp1 (/ (- gScreenHeight temp3) 2))
	else
		(= temp1 param3)
	)
	(= temp24 0)
	(= temp25 0)
	(if (< temp0 5)
		(= temp24 (- 5 temp0))
	)
	(if (< temp1 5)
		(= temp25 (- 5 temp1))
	)
	(if (> (- (+ temp0 temp2) 1) 634)
		(= temp24 (- 634 (- (+ temp0 temp2) 1)))
	)
	(if (> (- (+ temp1 temp3) 1) 474)
		(= temp25 (- 474 (- (+ temp1 temp3) 1)))
	)
	(+= temp0 temp24)
	(+= temp1 temp25)
	(temp4 setRect: temp0 temp1 (- (+ temp0 temp2) 1) (- (+ temp1 temp3) 1))
	(UpdatePlane temp4)
	(for ((= temp23 0)) (< temp23 param1) ((++ temp23))
		(= temp6 [temp7 temp23])
		(= temp17 (temp6 nWidth:))
		(= temp19 (/ (- temp2 temp17) 2))
		(= temp20 (+ temp29 5 (* temp23 (+ 5 temp18))))
		(temp6 posn: temp19 temp20)
	)
	(for ((= temp23 0)) (< temp23 param1) ((++ temp23))
		(if [param4 temp23]
			(proc64896_7 [param4 temp23])
		)
	)
	(return (temp4 sitNSpin:))
)

(instance poNull of Prop ; UNUSED
	(properties)
)

(instance soDelayDispose of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(register dispose:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance oBtnOK of DismissTextButton
	(properties)

	(method (doSelect &tmp temp0)
		(= local1 0)
		(if local0
			(= local1 (local0 getText:))
		)
		(super doSelect: &rest)
	)
)

(instance oBtnCancel of DismissTextButton ; UNUSED
	(properties)
)

(class DialogPlane of ModalPlane
	(properties
		priority 610
		value 0
		picture -2
		bSpinning 0
	)

	(method (dispose)
		(if bSpinning
			(= bSpinning 0)
			(return)
		)
		(super dispose: &rest)
	)

	(method (sitNSpin &tmp temp0 temp1)
		(= bSpinning 1)
		(while bSpinning
			((self getMainCast:) doit:)
			(FrameOut)
			(= temp0 ((gUser curEvent:) new:))
			(gOEventHandler handleEvent: temp0)
			(temp0 dispose:)
		)
		(= temp1 value)
		(self dispose:)
		(return temp1)
	)
)

