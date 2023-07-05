;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rgClouds 0
	proc610_1 1
)

(procedure (proc610_1 param1 param2 param3 param4 param5 param6 param7 param8 param9 &tmp temp0)
	(= temp0 gPrevRoomNum)
	(if (OneOf temp0 0 -1 777)
		(= temp0 (gCurRoom param9:))
	)
	(switch temp0
		((gCurRoom north:)
			(gEgo posn: [param1 0] [param1 1])
			(gCurRoom style: 5)
		)
		((gCurRoom south:)
			(gEgo posn: [param1 2] [param1 3])
			(gCurRoom style: 4)
		)
		((gCurRoom east:)
			(gEgo posn: [param1 4] [param1 5])
			(gCurRoom style: 2)
		)
		((gCurRoom west:)
			(gEgo posn: [param1 6] [param1 7])
			(gCurRoom style: 3)
		)
	)
)

(class cloudRoom of Rm
	(properties)

	(method (init)
		(LoadMany rsVIEW 4 7 8 34 63 67)
		(LoadMany rsSOUND 95 17 4 54)
		(if (gEgo has: 5) ; Magic_Ring
			(LoadMany rsVIEW 38 39)
		)
		(if (gEgo has: 0) ; Dagger
			(Load rsVIEW 53)
		)
		(SetFlag 0)
		(proc0_1)
		(super init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (dispose)
		(ClearFlag 0)
		(super dispose:)
	)
)

(instance rgClouds of Rgn
	(properties)

	(method (init)
		(cond
			((or (== gCurRoomNum 56) (== gCurRoomNum 72) (== gCurRoomNum 82))
				(if (!= ((ScriptID 0 23) number:) 4) ; backSound
					(Load rsSOUND 4)
					((ScriptID 0 23) number: 4 loop: -1 playBed:) ; backSound
				)
			)
			(
				(or
					(== gPrevRoomNum 69)
					(== gPrevRoomNum 58)
					(!= ((ScriptID 0 23) number:) 54) ; backSound
					(== ((ScriptID 0 23) prevSignal:) -1) ; backSound
				)
				(Load rsSOUND 54)
				((ScriptID 0 23) number: 54 loop: -1 playBed:) ; backSound
			)
		)
		(LoadMany rsPIC 80 81 27)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (gCurRoom script:))
				(or
					(& (gEgo onControl:) $0020)
					(and (& (gEgo onControl:) $0002) (not global131))
				)
				(== gNewRoomNum gCurRoomNum)
			)
			(gCurRoom setScript: egoFallThruClouds)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event)
				(return 1)
			)
			((Said 'get,get/boulder,pebble,pebble')
				(Print 610 0) ; "Up here in the clouds, the selection of stones is very poor."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/around,room,cloud]')
						(if (== gCurRoomNum 58)
							(Print 610 1) ; "You are in the Land of the Clouds. There is a giant here."
						else
							(Print 610 2) ; "You are in the Land of the Clouds. It is rumored that a giant lives up here."
						)
					)
					((Said '/ceder')
						(Print 610 3) ; "These gigantic, oddly-shaped trees loom far overhead."
					)
				)
			)
		)
	)
)

(instance egoFallThruClouds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 23) fade:) ; backSound
				((ScriptID 0 21) number: 17 loop: 1 play:) ; gameSound
				(if (IsFlag 1)
					(Print 610 4) ; "As you drop through the clouds, your magic ring slips from your finger."
				)
				(gEgo view: 63 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 80 5)
				(if (gEgo blocks:)
					((gEgo blocks:) dispose:)
					(gEgo blocks: 0)
				)
				(gEgo
					view: 8
					setLoop: 5
					cel: 0
					setCycle: Fwd
					cycleSpeed: 1
					ignoreActors:
					illegalBits: 0
					setStep: 4 6
					setPri: 14
					y: -5
					setMotion: MoveTo (gEgo x:) 220 self
					show:
				)
			)
			(2
				(gCurRoom drawPic: 81 5)
				(gEgo
					y: -5
					setStep: 4 8
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(3
				(gCurRoom drawPic: 27 5)
				(gEgo
					view: 34
					setCycle: 0
					setLoop: 4
					setPri: 12
					posn: 210 -5
					setStep: 2 15
					setMotion: MoveTo 210 151 self
				)
			)
			(4
				(crater init:)
				((ScriptID 0 21) number: 95 play:) ; gameSound
				(self cue:)
			)
			(5
				(gEgo loop: 2 cel: 0 cycleSpeed: 1 posn: 210 161)
				(proc0_7)
				(ShakeScreen 6)
				(gEgo setCycle: End self)
			)
			(6
				(HandsOn)
				(EgoDead 610 5)
				(self dispose:)
			)
		)
	)
)

(instance crater of View
	(properties
		x 210
		y 161
		description {hole}
		view 34
	)
)

