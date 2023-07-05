;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene36c 0
)

(local
	local0
)

(instance scene36c of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(glorSmoke
			setLoop: 4
			posn: 148 89
			setCycle: Fwd
			setPri: 2
			ignoreActors: 1
			init:
		)
		(glorEye setPri: 2 init: stopUpd: setScript: GlorsEyes)
		(Gloria setPri: 1 ignoreActors: 1 init:)
		(glorHand
			setLoop: 1
			setCel: 0
			setPri: 3
			xStep: 5
			yStep: 5
			ignoreActors: 1
			init:
		)
		(self setScript: twice)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance GlorsEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glorEye stopUpd:)
				(= seconds (Random 2 5))
			)
			(1
				(glorEye startUpd: setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Print 324 0 #dispose) ; "It's just Gloria listening to the Victrola."
				(= seconds 4)
			)
			(2
				(glorSmoke setMotion: MoveTo 169 89)
				(glorHand setMotion: MoveTo 186 111 self)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance Gloria of Prop
	(properties
		y 110
		x 231
		view 367
	)
)

(instance glorSmoke of Act
	(properties
		y 89
		x 148
		yStep 5
		view 367
		xStep 5
	)
)

(instance glorEye of Prop
	(properties
		y 76
		x 204
		view 367
		loop 7
	)
)

(instance glorHand of Act
	(properties
		y 111
		x 167
		view 367
	)
)

(instance myMusic of Sound
	(properties)
)

