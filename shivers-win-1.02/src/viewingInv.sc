;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use Rev)
(use Motion)
(use Actor)

(public
	viewingInv 0
)

(local
	local0 = 2
	local1 = 2
	local2
	[local3 2]
)

(instance ambience of ShiversSound
	(properties
		number 25001
		loop -1
	)
)

(instance viewingInv of ShiversRoom
	(properties)

	(method (init &tmp temp0)
		(if gPBoatView
			(gPBoatView hide:)
		)
		(gSound1 pause: 1)
		(gSound2 pause: 1)
		(gSound3 pause: 1)
		(gSound4 pause: 1)
		(gSound5 pause: 1)
		(gSound6 pause: 1)
		(gShiversInvItem hide:)
		(gNormalCursor show:)
		(pRotatingObject init:)
		(proc951_7 25001)
		(ambience play: 0 0)
		(ambience fade: 42 1 30 0 0)
		(super init: &rest)
	)

	(method (dispose)
		(ambience fade: 0 1 30 1 0)
		(pRotatingObject dispose:)
		(gSound1 pause: 0)
		(gSound2 pause: 0)
		(gSound3 pause: 0)
		(gSound4 pause: 0)
		(gSound5 pause: 0)
		(gSound6 pause: 0)
		(gShiversInvItem show:)
		(gSounds play: 15030 0 90 0)
		(super dispose: &rest)
	)
)

(instance pRotatingObject of Prop
	(properties
		x 133
		y 71
	)

	(method (init)
		(self
			view: (+ (mod global105 10) 230)
			loop: (/ (mod global105 100) 10)
			cel: 0
		)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(event claimed: 1)
			(gCurRoom newRoom: gPrevRoomNum)
			(self dispose:)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((> (- gMouseY 7) 143)
				(= local1 2)
			)
			((< -27 (- gMouseX 27) 47)
				(= local1 0)
			)
			((< 46 (- gMouseX 27) 96)
				(= local1 1)
			)
			((< 95 (- gMouseX 27) 169)
				(= local1 2)
			)
			((< 168 (- gMouseX 27) 218)
				(= local1 3)
			)
			((< 217 (- gMouseX 27) 320)
				(= local1 4)
			)
		)
		(if (!= local1 local0)
			(= local0 local1)
			(switch local1
				(0
					(PrintDebug {FastReverse})
					(= local2 0)
					(self setCycle: Fwd cycleSpeed: 6)
				)
				(1
					(PrintDebug {SlowReverse})
					(= local2 0)
					(self setCycle: Fwd cycleSpeed: 12)
				)
				(2
					(PrintDebug {Stop})
					(self setCycle: 0)
				)
				(3
					(PrintDebug {SlowForward})
					(= local2 1)
					(self setCycle: Rev cycleSpeed: 12)
				)
				(4
					(PrintDebug {FastForward})
					(= local2 1)
					(self setCycle: Rev cycleSpeed: 6)
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

