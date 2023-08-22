;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use StopWalk)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	rm1 0
)

(local
	local0
	[local1 3]
	[local4 3] = [51 170 288]
	[local7 3] = [155 156 158]
)

(instance rm1 of Rm
	(properties
		picture 1
		horizon 78
		north 53
		east 83
		west 2
	)

	(method (init)
		(LoadMany rsVIEW 201 202 267 186 0)
		(LoadMany rsSOUND 78 79 80 11)
		(self keep: 0)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 41)
					(east 40)
					(south 4)
					(else
						(MenuBar state: 1)
						(if (proc0_24 1) 17 else 15)
					)
				)
		)
		(gate illegalBits: 0 ignoreHorizon: setPri: 3 stopUpd:)
		(self setRegions: 605) ; moatRg
		(for ((= local0 0)) (< local0 3) ((++ local0))
			((= [local1 local0] (Clone Ripple))
				view: 202
				cycleSpeed: 1
				setPri: 3
				x: [local4 local0]
				y: [local7 local0]
				setLoop: 0
				ignoreActors: 1
				sightAngle: 180
				closeRangeDist: 500
				longRangeDist: 500
				description: {ripples}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(super init:)
		(if (not (and (gEgo has: 16) (gEgo has: 14) (gEgo has: 1))) ; Magic_Shield, Magic_Mirror, Chest
			(gAddToPics add: g1 g2 eachElementDo: #init doit:)
		)
		(gAddToPics add: urn1 urn2 eachElementDo: #init doit:)
		(if (IsFlag 40)
			(ClearFlag 40)
			(MenuBar draw:)
			(SL enable:)
		)
		(switch gPrevRoomNum
			(200 ; intro
				(gCurRoom setScript: exitCastle)
			)
			(west
				(gEgo posn: 3 (proc0_17 112 (gEgo y:) 100) init:)
				(gate init:)
				(proc0_1)
			)
			(east
				(gEgo posn: 317 (proc0_17 113 (gEgo y:) 100) init:)
				(gate init:)
				(proc0_1)
			)
			(else
				(gCurRoom setScript: exitCastle)
			)
		)
		(vine1 init:)
		(vine2 init:)
		(vine3 init:)
		(vine4 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'open,open/door,gate')
				(cond
					((> (gEgo y:) 86)
						(Print 1 0) ; "You cannot reach the door from here."
					)
					((IsFlag 2)
						(Print 1 1) ; "You recall a rule prohibiting goats (except seeing-eye goats) from entering the castle."
					)
					((and (gEgo has: 14) (gEgo has: 1) (gEgo has: 16)) ; Magic_Mirror, Chest, Magic_Shield
						(Print 1 2) ; "That's odd. Why aren't the guards at their posts?"
						((ScriptID 0 23) fade:) ; backSound
						(SetScore 111 3)
						(gate setScript: enterCastle)
					)
					(else
						(Print 1 3) ; "You reconsider the wisdom of returning to King Edward without having recovered Daventry's three lost treasures."
					)
				)
			)
			((Said 'close,close/gate,door')
				(Print 1 4) ; "The portcullis is already closed."
			)
			((Said 'knock/door,gate')
				(if (< (gEgo y:) 86)
					(Print 1 5) ; "Your knock echoes within the castle. Unfortunately, no one answers."
				else
					(Print 1 0) ; "You cannot reach the door from here."
				)
			)
			((Said 'get,get,use/planter,caldron,planter')
				(Print 1 6) ; "If you inherit the throne, you may do whatever you please with the urns. Until then, leave them alone."
			)
			(
				(or
					(Said 'get,get<in/planter,planter,caldron')
					(Said 'hide<in/planter,planter,caldron')
				)
				(Print 1 7) ; "The pots are full of dirt and roots. There's nothing remotely helpful in or around the urns."
			)
			((Said 'look,look,talk,talk,kick,kill,kiss,hit/guard')
				(Print 1 8) ; "There are no guards in sight."
			)
			((proc0_14 event 101 30 120 48 3)
				(Print 1 9) ; "This deep swampy moat is patrolled by vicious serpents."
			)
			((Said 'look,look/planter,caldron')
				(Print 1 10) ; "The vines creeping up the walls of the castle are rooted in these two large urns."
			)
			((Said 'look,look/ceder,vine,bury')
				(Print 1 11) ; "The castle walls are carpeted with a thick tangle of vines."
			)
			((Said 'look,look/blossom')
				(if (< (gEgo y:) 112)
					(Print 1 12) ; "You can't see any flowers from where you stand."
				else
					(Print 1 13) ; "There are small flowers growing along the moat."
				)
			)
			((Said 'remove/ring')
				(if
					(and
						(IsFlag 1)
						(not
							(and
								(gEgo has: 16) ; Magic_Shield
								(gEgo has: 14) ; Magic_Mirror
								(gEgo has: 1) ; Chest
							)
						)
					)
					(Print 1 14) ; "The guards are surprised at your sudden appearance."
					(event claimed: 0)
				else
					(event claimed: 0)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance enterCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 78 priority: 15 loop: 1 init: play:) ; gameSound
				(gate
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					startUpd:
					setMotion: MoveTo 160 25 self
				)
			)
			(1
				((ScriptID 0 21) stop:) ; gameSound
				(gate stopUpd:)
				((ScriptID 0 23) number: 11 loop: -1 play:) ; backSound
				(if (IsFlag 1)
					(Print 1 15) ; "Before entering the castle, you remove your ring so as not to startle the ailing King."
					(ClearFlag 1)
					(gEgo view: 0)
					(proc0_1)
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setLoop: 3
					setMotion: MoveTo (gEgo x:) 76 self
				)
			)
			(2
				(SetScore 111 3)
				(HandsOn)
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance exitCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gate posn: 160 25 ignoreActors: init: stopUpd:)
				(gEgo
					setPri: -1
					view: 0
					loop: 2
					illegalBits: 0
					ignoreHorizon:
					posn: 164 76
					setCycle: StopWalk 2
					init:
					setMotion: MoveTo 164 86 self
				)
			)
			(1
				((ScriptID 0 21) number: 79 init: play:) ; gameSound
				(gate setMotion: MoveTo 160 75 self)
			)
			(2
				((ScriptID 0 21) number: 80 play:) ; gameSound
				(gate setMotion: MoveTo 160 80 self)
			)
			(3
				(gate ignoreActors: 0 stopUpd:)
				(HandsOn)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance g1 of RPicView
	(properties
		x 203
		y 85
		description {guard}
		sightAngle 180
		closeRangeDist 300
		longRangeDist 300
		view 186
		signal 4
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/guard,man')
				(self doVerb: 1)
			)
			((Said 'talk,talk,ask/guard,man')
				(Print 1 16) ; "These stone-faced guards must have been trained not to converse with anybody. They ignore you, Sir Graham."
			)
			((Said 'give[/*]/guard')
				(Print 1 17) ; "The guards are well provided-for by King Edward. They are not interested in any of your belongings."
			)
			((Said 'hit,kick,kill/guard')
				(Print 1 18) ; "These are the guards of your king, King Edward. It would be very unwise to make enemies of them, Sir Graham."
			)
			((Said 'kiss,hug/guard')
				(Print 1 19) ; "These stone-faced guards must have been trained not to show any type of affection. They ignore you, Sir Graham."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 20) ; "These guards protect the King's castle."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance g2 of RPicView
	(properties
		x 119
		y 85
		description {guard}
		sightAngle 180
		closeRangeDist 300
		longRangeDist 300
		view 186
		cel 1
		signal 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 20) ; "These guards protect the King's castle."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Actor
	(properties
		x 160
		y 80
		view 201
		signal 4
		illegalBits 0
	)

	(method (init)
		(self
			yStep:
				(cond
					((proc0_24 2) 2)
					((proc0_24 1) 4)
					((proc0_24 0) 7)
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/gate,door')
				(self doVerb: 1)
			)
			((Said 'enter/castle,gate,door')
				(Print 1 21) ; "Just walk up to the portcullis and open it."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 22) ; "This portcullis is the only entrance to the King's castle."
			)
		)
	)
)

(instance urn1 of RPicView
	(properties
		x 35
		y 103
		description {urn}
		sightAngle 180
		closeRangeDist 300
		longRangeDist 300
		view 267
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/planter,planter,planter,caldron')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 23) ; "These beautiful urns adorn the front of the castle."
			)
		)
	)
)

(instance urn2 of RPicView
	(properties
		x 292
		y 103
		description {urn}
		sightAngle 180
		closeRangeDist 300
		longRangeDist 300
		view 267
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 23) ; "These beautiful urns adorn the front of the castle."
			)
		)
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/moat,water,brook')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 1 24) ; "You never know what sort of fierce creatures lie just beneath the surface of the moat."
			)
		)
	)
)

(instance vine1 of NewFeature
	(properties
		x 37
		y 24
		noun '/vine,ivy,bury,ceder'
		nsTop -1
		nsBottom 50
		nsRight 74
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance vine2 of NewFeature
	(properties
		x 35
		y 56
		noun '/vine,ivy,bury,ceder'
		nsTop 50
		nsLeft 29
		nsBottom 62
		nsRight 41
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance vine3 of NewFeature
	(properties
		x 282
		y 24
		noun '/vine,ivy,bury,ceder'
		nsLeft 246
		nsBottom 49
		nsRight 319
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance vine4 of NewFeature
	(properties
		x 284
		y 56
		noun '/vine,ivy,bury,ceder'
		nsTop 50
		nsLeft 279
		nsBottom 62
		nsRight 290
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

