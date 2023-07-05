;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Print)
(use GameControls)
(use System)

(public
	chooseSuit 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls chooseSuitControls)
		window: chooseWindow
		okIconItem: iconSpades
		curIcon: (if (not (HaveMouse)) iconSpades else 0)
		add:
			(iconSpades theObj: iconSpades selector: #doit init: yourself:)
			(iconClubs theObj: iconClubs selector: #doit init: yourself:)
			(iconDiamonds theObj: iconDiamonds selector: #doit init: yourself:)
			(iconHearts theObj: iconHearts selector: #doit init: yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ 241 (iconSpades nsLeft:))
			y: (+ 118 (iconSpades nsTop:))
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance chooseSuit of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance chooseWindow of InvisibleWindow
	(properties
		top 100
		left 91
		bottom 143
		right 228
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 100 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance chooseSuitControls of HoyleGameControls
	(properties)

	(method (dispatchEvent event &tmp temp0)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(= temp0 (GetPort))
			(Message msgGET 150 1 0 0 1 @global550) ; "You must choose a suit."
			(Print addText: @global550 init:)
			(SetPort temp0)
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance iconSpades of ControlIcon
	(properties
		view 100
		loop 1
		cel 0
		nsLeft 9
		nsTop 20
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= global420 0)
		(= gGameControls local0)
		(gSound2 play: 909)
	)
)

(instance iconClubs of ControlIcon
	(properties
		view 100
		loop 2
		cel 0
		nsLeft 39
		nsTop 20
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= global420 1)
		(= gGameControls local0)
		(gSound2 play: 910)
	)
)

(instance iconDiamonds of ControlIcon
	(properties
		view 100
		loop 3
		cel 0
		nsLeft 69
		nsTop 20
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= global420 2)
		(= gGameControls local0)
		(gSound2 play: 911)
	)
)

(instance iconHearts of ControlIcon
	(properties
		view 100
		loop 4
		cel 0
		nsLeft 99
		nsTop 20
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= global420 3)
		(= gGameControls local0)
		(gSound2 play: 912)
	)
)

