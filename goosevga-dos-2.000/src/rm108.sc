;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 108)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm108 0
)

(instance rm108 of Rm
	(properties
		picture 801
		style 10
	)

	(method (init)
		(Load rsSOUND 603)
		(SetPort 0 0 200 320 0 0)
		(super init: &rest)
		(= global104 1)
		(self setScript: seeMeGo)
		(sparkle1 init:)
		(sparkle2 init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event)
		(gLongSong stop:)
		(seeMeGo state: 3 cycles: 1)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gCast eachElementDo: #dispose eachElementDo: #delete release:)
		(super dispose: &rest)
	)
)

(instance seeMeGo of Script
	(properties)

	(method (doit)
		(if (< (self state:) 4)
			(Palette palANIMATE 96 218 -1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 603 loop: 1 play: self)
			)
			(1
				(sparkle1 setCycle: End)
			)
			(2
				(sparkle1 dispose:)
				(sparkle2 setCycle: CT 6 1)
			)
			(3
				(sparkle2 setCycle: End)
			)
			(4
				(sparkle2 dispose:)
				(gLongSong number: 600 setLoop: -1 play:)
				(= global104 0)
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

(instance sparkle1 of Prop
	(properties
		x 133
		y 35
		view 805
		cycleSpeed 8
	)
)

(instance sparkle2 of Prop
	(properties
		x 60
		y 155
		view 805
		loop 1
		cycleSpeed 8
	)
)

