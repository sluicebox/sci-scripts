;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64015)
(include sci.sh)
(use Main)
(use oMainMenu)
(use TiledBitmap)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use Motion)
(use Actor)
(use System)

(public
	oInset 0
)

(local
	local0
)

(instance poWalker of Prop
	(properties
		x 120
		y 216
		view 60100
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed (gGame nGameSpeed:))
		(self setCycle: Fwd)
	)
)

(instance foMove of MoveFeature
	(properties)
)

(instance oInset of ModalPlane
	(properties)

	(method (init &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15)
		(super init: &rest)
		(poWalker init: self setPri: 100)
		(oClose init: self)
		(oAllLeft init: self)
		(oStepLeft init: self)
		(oAllRight init: self)
		(oStepRight init: self)
		(= temp2 (CelHigh (poWalker view:) (poWalker loop:) (poWalker cel:)))
		(= temp15 (CelHigh (oAllLeft view:) (oAllLeft loop:) (oAllLeft cel:)))
		(= temp3 (CelWide (oAllLeft view:) (oAllLeft loop:) (oAllLeft cel:)))
		(= temp4 (CelWide (oStepLeft view:) (oStepLeft loop:) (oStepLeft cel:)))
		(= temp5 (CelWide (oAllRight view:) (oAllRight loop:) (oAllRight cel:)))
		(= temp6
			(CelWide (oStepRight view:) (oStepRight loop:) (oStepRight cel:))
		)
		(= temp7 (+ temp3 temp4 temp5 temp6 25))
		(= temp8 (+ temp15 temp2 15))
		(= temp11 (TiledView new:))
		(temp11 view: 60019 init: temp7 temp8 0 1 self)
		(= temp9 (temp11 nWidth:))
		(= temp10 (temp11 nHeight:))
		(= temp12 (TextItem new:))
		(temp12
			font: global268
			nLeading: global269
			maxWidth: (- temp9 18)
			nMinWidth: (- temp9 12)
			fore: global274
			back: 255
			skip: 255
			border: 5
			bTileBorder: 1
			vTile: 60020
			text: (MakeMessageText 0 0 8 1 14)
			setPri: 50
			init: self
		)
		(+= temp10 (temp12 nHeight:))
		(if (== global302 -1)
			(= global302
				(+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp9) 2))
			)
			(= global303
				(+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp10) 2))
			)
		)
		(self
			setRect:
				global302
				global303
				(- (+ global302 temp9) 1)
				(- (+ global303 temp10) 1)
		)
		(UpdatePlane self)
		(= temp13 (temp11 nOffsetX:))
		(= temp14 (temp11 nOffsetY:))
		(temp11 posn: (temp11 x:) (+ (temp11 y:) (temp12 nHeight:)))
		(+= temp14 (temp12 nHeight:))
		(poWalker posn: (+ temp13 (/ temp7 2)) (+ temp14 -3 temp2))
		(UpdateScreenItem poWalker)
		(oAllLeft posn: (+ temp13 5) (+ temp14 10 temp2))
		(UpdateScreenItem oAllLeft)
		(oStepLeft posn: (+ (oAllLeft x:) temp3 5) (oAllLeft y:))
		(UpdateScreenItem oStepLeft)
		(oStepRight posn: (+ (oStepLeft x:) temp4 5) (oAllLeft y:))
		(UpdateScreenItem oStepRight)
		(oAllRight posn: (+ (oStepRight x:) temp6 5) (oAllLeft y:))
		(UpdateScreenItem oAllRight)
		(UpdateScreenItem temp11)
		(foMove init: self)
		(foMove makeTopBorder: (temp12 nHeight:))
	)
)

(instance oClose of DismissButton
	(properties
		priority 100
		x 10
		y 10
		loop 4
		view 60017
		fixPriority 1
		bDefault 1
	)

	(method (doSelect &tmp temp0)
		(= temp0 (poWalker cycleSpeed:))
		(gGame nGameSpeed: temp0)
		(gEgo setSpeed: temp0)
		(= global302 (plane left:))
		(= global303 (plane top:))
		(proc64000_3)
		(oInset dispose:)
		(DisposeScript 64015)
	)
)

(instance oAllLeft of PushButton
	(properties
		loop 2
		view 60017
	)

	(method (doSelect)
		(poWalker cycleSpeed: 10)
	)
)

(instance oStepLeft of PushButton
	(properties
		view 60017
	)

	(method (doClick)
		(poWalker cycleSpeed: (Min 10 (+ 1 (poWalker cycleSpeed:))))
		(= local0 (+ gGameTime 20))
	)

	(method (doHeld)
		(if (> gGameTime local0)
			(poWalker cycleSpeed: (Min 10 (+ 1 (poWalker cycleSpeed:))))
			(= local0 (+ gGameTime 5))
		)
	)
)

(instance oStepRight of PushButton
	(properties
		loop 1
		view 60017
	)

	(method (doClick)
		(poWalker cycleSpeed: (Max (- (poWalker cycleSpeed:) 1) 1))
		(= local0 (+ gGameTime 20))
	)

	(method (doHeld)
		(if (> gGameTime local0)
			(poWalker cycleSpeed: (Max (- (poWalker cycleSpeed:) 1) 1))
			(= local0 (+ gGameTime 5))
		)
	)
)

(instance oAllRight of PushButton
	(properties
		loop 3
		view 60017
	)

	(method (doSelect)
		(poWalker cycleSpeed: 1)
	)
)

