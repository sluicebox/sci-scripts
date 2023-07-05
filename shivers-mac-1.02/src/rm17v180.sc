;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17180)
(include sci.sh)
(use Main)
(use n951)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm17v180 0
)

(local
	local0
)

(instance rm17v180 of ShiversRoom
	(properties
		picture 17180
	)

	(method (init)
		(ClearFlag 43)
		(if (IsFlag 14)
			(if (IsFlag 77)
				(spPlay init:)
			)
			(spRewind init:)
		else
			(pDummyFilm cel: 1 init:)
		)
		(= local0 0)
		(pFilm init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spTopReel init:)
		(pTopFilm init:)
		(pBottomFilm init:)
		(pBottomReel init:)
		((View new:) view: 17180 loop: 7 setPri: 100 1 init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17170
	)
)

(instance spTopReel of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 17180
	)

	(method (doVerb)
		(if (not (IsFlag 14))
			(gCurRoom setScript: sWindOnce)
		)
	)
)

(instance pBottomReel of Prop
	(properties
		priority 25
		fixPriority 1
		view 17180
		loop 3
	)
)

(instance pFilm of Prop
	(properties
		priority 5
		fixPriority 1
		view 17180
		loop 1
	)

	(method (init)
		(if (IsFlag 14)
			(= loop 2)
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance pDummyFilm of Prop
	(properties
		priority 1
		fixPriority 1
		view 17180
		loop 2
	)
)

(instance spPlay of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 17180
		loop 4
	)

	(method (doVerb)
		(Load rsPIC 17190)
		(gSounds play: 11704 0 40 0)
		(ClearFlag 77)
		(gCurRoom setScript: sDoThumbNail)
	)
)

(instance spRewind of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 17180
		loop 5
	)

	(method (doVerb)
		(if (and (IsFlag 14) (not (IsFlag 77)))
			(gSounds play: 11704 0 40 0)
			(gCurRoom setScript: sRewind)
		)
	)
)

(instance pTopFilm of Prop
	(properties
		x 136
		y 18
		priority 5
		fixPriority 1
		view 17180
		loop 6
	)

	(method (init)
		(if (and (IsFlag 14) (IsFlag 77))
			(= cel 5)
		)
		(super init: &rest)
	)
)

(instance pBottomFilm of Prop
	(properties
		x 136
		y 100
		priority 5
		fixPriority 1
		view 17180
		loop 6
	)

	(method (init)
		(if (and (IsFlag 14) (not (IsFlag 77)))
			(= cel 5)
		)
		(super init: &rest)
	)
)

(instance sWindOnce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spTopReel setCycle: Fwd)
				(++ local0)
				(gSounds play: 11702 0 56 0)
				(if (== local0 5)
					(pFilm loop: 8 setCycle: End self)
					(pDummyFilm cel: 0)
				else
					(pFilm setCycle: Fwd)
					(= seconds 2)
				)
			)
			(1
				(gGame handsOn:)
				(gSounds stop: 11702)
				(pTopFilm cel: local0)
				(if (== local0 5)
					(pFilm hide:)
				else
					(pFilm setCycle: 0)
				)
				(spTopReel setCycle: 0)
				(if (== local0 5)
					(gSounds play: 11703 0 56 0)
					(SetFlag 14)
					(proc951_15 6750)
					(SetFlag 77)
					(spPlay init:)
					(spRewind init:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRewind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(spTopReel setCycle: Rev)
				(pBottomReel setCycle: Rev)
				(gSounds play: 11710 0 56 0)
				(= cycles 1)
			)
			(1
				(pTopFilm cel: local0)
				(pBottomFilm cel: (- 5 local0))
				(if (< (++ local0) 5)
					(-- state)
				)
				(= seconds 1)
			)
			(2
				(gGame handsOn:)
				(gSounds stop: 11710)
				(gSounds play: 11703 0 56 0)
				(spTopReel setCycle: 0)
				(pBottomReel setCycle: 0)
				(pTopFilm cel: 5)
				(pBottomFilm cel: 0)
				(SetFlag 77)
				(spPlay init:)
				(self dispose:)
			)
		)
	)
)

(instance thumbNail of Prop ; UNUSED
	(properties
		view 17185
	)

	(method (init)
		(super init: &rest)
	)
)

(instance sDoThumbNail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 13))
					(gSounds play: 11713 0 66 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom drawPic: 17190)
				(SetFlag 13)
				(gCast eachElementDo: #dispose)
				(= ticks 45)
			)
			(2
				(gCurRoom drawPic: 17182)
				(= ticks 45)
			)
			(3
				(SetFlag 43)
				(gCurRoom newRoom: 17190) ; rm17v190
			)
		)
	)
)

