;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room10 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance Room10 of Rm
	(properties
		picture 10
	)

	(method (init)
		(= north 4)
		(= south 16)
		(= east 11)
		(= west 9)
		(= horizon 72)
		(= gIndoors 0)
		(= global189 1)
		(if gNight
			(= picture 110)
		)
		(super init:)
		(self setRegions: 508 517) ; Forest_Region, Ogre_s_Region
		(Load rsVIEW 250)
		(Load rsVIEW 78)
		(Load rsVIEW 79)
		(Load rsVIEW 681)
		(switch gPrevRoomNum
			(16
				(if (< (gEgo x:) 63)
					(gEgo posn: 63 187)
				else
					(gEgo posn: (gEgo x:) 187)
				)
			)
			(4
				(if (< (gEgo x:) 200)
					(gEgo posn: 205 (+ horizon 2))
				else
					(gEgo posn: (gEgo x:) (+ horizon 2))
				)
			)
		)
		(= local4 (Prop new:))
		(local4
			view: 626
			loop: 0
			cel: 0
			posn: 233 26
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(cond
			((and (== gPrevRoomNum 4) global121 (not (gEgo has: 33))) ; Magic_Hen
				(= global121 (Act new:))
				(global121
					posn: 202 85
					view: 250
					xStep: 6
					yStep: 2
					setCycle: Walk
					ignoreActors:
					init:
				)
				(= local2 0)
				(self setScript: ogreActions)
				(ogreActions changeState: 1)
			)
			((and (<= (Random 1 100) 40) (not global121) (!= global165 4))
				(= global121 (Act new:))
				(global121
					posn: 19 182
					view: 250
					xStep: 6
					yStep: 2
					setCycle: Walk
					ignoreActors:
					init:
				)
				(self setScript: ogreActions)
			)
			(else
				(= global121 0)
			)
		)
		(if (== global165 4)
			(= global165 5)
		)
		(gEgo view: 2 init:)
		(if (not gNight)
			(if (< (Random 1 100) 50)
				(= local6 (Prop new:))
				(local6
					view: 342
					loop: 5
					cel: 1
					posn: 146 11
					setPri: 14
					setScript: bird1Actions
					init:
				)
			)
			(if (< (Random 1 100) 50)
				(= local7 (Prop new:))
				(local7
					view: 342
					loop: 4
					cel: 1
					posn: 65 55
					setPri: 14
					setScript: bird2Actions
					init:
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= global189 0)
		(gSounds eachElementDo: #dispose)
		(gTimers eachElementDo: #dispose 192)
		(if (gCast contains: global121)
			(= global173 (global121 y:))
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/cottage')
					(Print 10 0) ; "It's too far in the distance to see it clearly."
				)
				((Said '[<around][/room]')
					(Print 10 1) ; "A thick forest of pine trees surrounds you. You see a house in the distance to the north."
				)
			)
		)
	)
)

(instance ogreActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 6))
			)
			(1
				(if (== local2 0)
					(= local2 1)
					(= local5 (Sound new:))
					(local5 number: 5 loop: -1 play:)
					(global121
						setAvoider: (Avoid new:)
						ignoreActors:
						setMotion: Chase gEgo 6 self
					)
					(= global189 1)
				)
			)
			(2
				(HandsOff)
				(gEgo hide:)
				(global121 view: 78 cel: 0 setCycle: End self)
			)
			(3
				(local5 dispose:)
				(= local5 (Sound new:))
				(local5 number: 6 loop: 1 play: self)
				(Print 10 2) ; "Oh no! You're caught! The terrible ogre grabs you by the braids and drags you off to an untimely end. Dinner will definitely be on YOU tonight!"
				(global121 view: 79 setCycle: Walk setMotion: MoveTo 200 80)
			)
			(4
				(= gDeathFlag 1)
			)
		)
	)
)

(instance bird1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local6 setCycle: Fwd)
				(= seconds (Random 1 12))
			)
			(1
				(local6 setCycle: 0 cel: 0)
				(= seconds (Random 1 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bird2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local7 setCycle: Fwd)
				(= seconds (Random 1 12))
			)
			(1
				(local7 cel: 0 setCycle: 0)
				(= seconds (Random 1 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

