;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use GameControls)
(use System)

(public
	bidEuchre 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(= local0 gGameControls)
	(iconPlayAlone init:)
	(if
		(and
			(== global286 2)
			global288
			(== (Dealer dealer:) (Dealer curPlayer:))
		)
		(= temp0 iconPlayAlone)
	else
		(= temp0 iconPass)
	)
	((= gGameControls euchreBid)
		window: euchreWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: (if (not (HaveMouse)) temp0 else 0)
		add: (iconPlayAlone theObj: iconPlayAlone selector: #doit yourself:)
	)
	(if (== global286 1)
		(iconOrderUp init:)
		(gGameControls
			add:
				(iconPass theObj: iconPass selector: #doit yourself:)
				(iconOrderUp theObj: iconOrderUp selector: #doit yourself:)
		)
	else
		(iconSpades init:)
		(iconDiamonds init:)
		(iconHearts init:)
		(iconClubs init:)
		(if (or (not global288) (!= (Dealer dealer:) (Dealer curPlayer:)))
			(gGameControls
				add: (iconPass theObj: iconPass selector: #doit yourself:)
			)
		)
		(if (!= global285 0)
			(gGameControls
				add: (iconSpades theObj: iconSpades selector: #doit yourself:)
			)
		)
		(if (!= global285 2)
			(gGameControls
				add:
					(iconDiamonds
						theObj: iconDiamonds
						selector: #doit
						yourself:
					)
			)
		)
		(if (!= global285 3)
			(gGameControls
				add: (iconHearts theObj: iconHearts selector: #doit yourself:)
			)
		)
		(if (!= global285 1)
			(gGameControls
				add: (iconClubs theObj: iconClubs selector: #doit yourself:)
			)
		)
	)
	(gGameControls show:)
)

(instance bidEuchre of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance euchreWindow of InvisibleWindow
	(properties
		top 122
		left 193
		bottom 198
		right 319
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 800 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance euchreBid of HoyleGameControls
	(properties)
)

(instance iconPlayAlone of ControlIcon
	(properties
		view 800
		loop 1
		cel 0
		nsLeft 8
		nsTop 9
		signal 387
		highlightColor -1
	)

	(method (init)
		(= cel 0)
		(= global284 cel)
	)

	(method (doit)
		(if global284
			(= global284 (= cel 0))
		else
			(= cel 2)
			(= global284 1)
		)
		(self show:)
	)
)

(instance iconPass of ControlIcon
	(properties
		view 800
		loop 2
		cel 0
		nsLeft 8
		nsTop 27
		signal 387
		highlightColor -1
	)

	(method (doit)
		(= global425 -1)
		(= global284 0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance iconOrderUp of ControlIcon
	(properties
		view 800
		loop 3
		cel 0
		nsLeft 62
		nsTop 27
		signal 387
		highlightColor -1
	)

	(method (init)
		(if (== (Dealer dealer:) (Dealer curPlayer:))
			(= cel 2)
		else
			(= cel 0)
		)
	)

	(method (doit)
		(= global425 5)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance iconSpades of ControlIcon
	(properties
		view 800
		loop 4
		cel 0
		nsLeft 62
		nsTop 27
		signal 387
		highlightColor -1
	)

	(method (init)
		(= cel (== global285 0))
	)

	(method (doit)
		(if (and (not cel) (!= global285 0))
			(= global425 0)
			(gGameControls hide: dispose:)
			(proc0_1)
			(= gGameControls local0)
		)
	)

	(method (show)
		(super show: &rest)
		(if (== global285 0)
			(= hiCel 2)
			(= normalCel hiCel)
		)
	)
)

(instance iconClubs of ControlIcon
	(properties
		view 800
		loop 5
		cel 0
		nsLeft 89
		nsTop 47
		signal 387
		highlightColor -1
	)

	(method (init)
		(= cel (== global285 1))
	)

	(method (doit)
		(if (and (not cel) (!= global285 1))
			(= global425 1)
			(gGameControls hide: dispose:)
			(proc0_1)
			(= gGameControls local0)
		)
	)

	(method (show)
		(super show: &rest)
		(if (== global285 1)
			(= hiCel 2)
			(= normalCel hiCel)
		)
	)
)

(instance iconDiamonds of ControlIcon
	(properties
		view 800
		loop 6
		cel 0
		nsLeft 89
		nsTop 27
		signal 387
		highlightColor -1
	)

	(method (init)
		(= cel (== global285 2))
	)

	(method (doit)
		(if (and (not cel) (!= global285 2))
			(= global425 2)
			(gGameControls hide: dispose:)
			(proc0_1)
			(= gGameControls local0)
		)
	)

	(method (show)
		(super show: &rest)
		(if (== global285 2)
			(= hiCel 2)
			(= normalCel hiCel)
		)
	)
)

(instance iconHearts of ControlIcon
	(properties
		view 800
		loop 7
		cel 0
		nsLeft 62
		nsTop 47
		signal 387
		highlightColor -1
	)

	(method (init)
		(= cel (== global285 3))
	)

	(method (doit)
		(if (and (not cel) (!= global285 3))
			(= global425 3)
			(gGameControls hide: dispose:)
			(proc0_1)
			(= gGameControls local0)
		)
	)

	(method (show)
		(super show: &rest)
		(if (== global285 3)
			(= hiCel 2)
			(= normalCel hiCel)
		)
	)
)

