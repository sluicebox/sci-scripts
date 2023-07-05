;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 422)
(include sci.sh)
(use Main)
(use RTEyeCycle)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	hanging 0
)

(local
	[local0 9] = [59 0 2 4 21 32 20 23 31]
	[local9 9] = [1420 142 1 1 2 1 1 1 0]
)

(instance hanging of Rm
	(properties
		picture 420
		style -32758
	)

	(method (init)
		(LoadMany rsPIC 420)
		(LoadMany rsVIEW 420 423 425 422 59)
		(LoadMany rsSOUND 7)
		(super init: &rest)
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(HandsOff)
		(gRgnMusic number: 7 loop: -1 play: fade: 127 6 12 0)
		(scribe init:)
		(robinH init:)
		(kingRichie init:)
		(gCurRoom setScript: dieScum)
		(gAddToPics
			add:
				guardR
				guardL
				spect1
				spect2
				spect3
				spect4
				spect5
				spect6
				fulkie
				sheriff
				abbot
				prior
			eachElementDo: #init
			doit:
		)
		(gTheIconBar enable:)
	)
)

(instance robinH of Prop
	(properties
		x 163
		y 145
		view 420
		loop 10
		priority 9
		signal 16
	)
)

(instance guardR of PicView
	(properties
		x 180
		y 164
		view 420
		loop 9
		priority 10
		signal 16
	)
)

(instance guardL of PicView
	(properties
		x 131
		y 146
		view 420
		loop 9
		priority 9
		signal 16
	)
)

(instance spect1 of PicView
	(properties
		x 51
		y 32
		view 420
		loop 2
		priority 0
		signal 16
	)
)

(instance spect2 of PicView
	(properties
		x 99
		y 19
		view 420
		loop 3
		priority 0
		signal 16
	)
)

(instance spect3 of PicView
	(properties
		x 163
		y 9
		view 420
		loop 5
		priority 0
		signal 16
	)
)

(instance spect4 of PicView
	(properties
		x 208
		y 11
		view 420
		loop 5
		cel 1
		priority 0
		signal 16
	)
)

(instance spect5 of PicView
	(properties
		x 271
		y 18
		view 420
		loop 4
		priority 0
		signal 16
	)
)

(instance spect6 of PicView
	(properties
		x 304
		y 14
		view 420
		loop 4
		cel 1
		priority 0
		signal 16
	)
)

(instance fulkie of PicView
	(properties
		x 228
		y 111
		view 423
		loop 10
		priority 0
		signal 16
	)
)

(instance sheriff of PicView
	(properties
		x 128
		y 119
		view 425
		priority 7
		signal 16
	)
)

(instance abbot of PicView
	(properties
		x 146
		y 117
		view 425
		cel 1
		priority 7
		signal 16
	)
)

(instance prior of PicView
	(properties
		x 255
		y 137
		view 425
		loop 1
		cel 3
		priority 9
		signal 16
	)
)

(instance scribe of Prop
	(properties
		x 268
		y 142
		view 420
		priority 9
		signal 16
	)
)

(instance kingRichie of Prop
	(properties
		x 205
		y 116
		view 422
		loop 1
		priority 7
		signal 16
	)
)

(instance dieScum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 180)
			)
			(1
				(kingRichie cycleSpeed: 12 setCycle: End self)
			)
			(2
				(Converse 2 @local9 @local0 3 2 2 self) ; "I've heard the testimony of all who speak for and against you, but I miss most bitterly the voice of Marian."
			)
			(3
				(gRgnMusic fade: 60 6 12 0)
				(= ticks 180)
			)
			(4
				(gCurRoom newRoom: 801) ; troub
				(self dispose:)
			)
		)
	)
)

