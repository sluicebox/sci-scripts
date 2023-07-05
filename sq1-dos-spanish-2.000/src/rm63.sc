;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm63 0
)

(instance rm63 of SQRoom
	(properties
		lookStr {You don't really like the way the red floor and green walls clash but, all in all, its a pretty nice looking room.}
		picture 63
		west 61
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(HandsOff)
		(Load rsSOUND 6)
		(LoadMany rsVIEW 410 163)
		(gFeatures
			add:
				panelOfLights
				variousMachines
				transmission
				rearViewMirror
				globes
			eachElementDo: #init
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 221 78 159 78 210 50 188 50 146 78 55 79 41 79 0 79 0 0 319 0 319 189 0 189 0 87 217 87
					yourself:
				)
		)
		(if (== gPrevRoomNum west)
			(gEgo x: 10)
			(= style 3)
		)
		(panel setCycle: Fwd init:)
		(orbs setCycle: Fwd setScript: switchit init:)
		(walkingGuard setScript: walkGuard init:)
		(if (!= gPrevRoomNum west)
			(gEgo posn: 195 55)
		)
		(gEgo init:)
		(super init:)
		(gAddToPics add: standingGuard eachElementDo: #init doit:)
		(if (!= gPrevRoomNum west)
			(self setScript: fromDoor)
		else
			(gEgo ignoreActors: 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (> ((gUser curEvent:) y:) 100)
					(= lookStr
						{You don't really like the way the red floor and green walls clash but, all in all, its a pretty nice looking room.}
					)
				else
					(= lookStr
						{You don't really like the way the blue floor and green walls clash but, all in all, its a pretty nice looking room.}
					)
				)
			)
		)
		(super doVerb: theVerb invItem &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (gGame detailLevel:) 1)
			(if (not (walkingGuard script:))
				(walkingGuard setScript: walkGuard)
			)
			(if (not (orbs script:))
				(orbs setScript: switchit)
			)
		else
			(if (walkingGuard script:)
				(walkingGuard loop: 5 cel: 0 setScript: 0)
			)
			(if (orbs script:)
				(orbs show:)
				(panel show:)
				(orbs setScript: 0)
			)
		)
		(cond
			((or (self script:) (gEgo script:)) 0)
			((& (gEgo onControl: 0) $0002)
				(self setScript: intoDoor)
			)
		)
	)
)

(instance fromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 1 loop: 5 setMotion: PolyPath 160 77 self)
			)
			(1
				(gEgo ignoreActors: 0 setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance intoDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: PolyPath 195 55 self)
			)
			(1
				(gCurRoom newRoom: 62)
			)
		)
	)
)

(instance switchit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
				(orbs show:)
				(beamSound number: 6 loop: -1 play:)
			)
			(1
				(-= state 2)
				(beamSound stop:)
				(orbs hide:)
				(= seconds (Random 1 4))
			)
		)
	)
)

(instance walkGuard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 10))
			)
			(1
				(walkingGuard
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 133 180 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(-= state 4)
				(walkingGuard setLoop: 0 setMotion: MoveTo 350 180 self)
			)
		)
	)
)

(instance panel of Prop
	(properties
		x 264
		y 65
		lookStr {A panel of flashing lights.}
		view 163
		loop 1
		priority 15
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		else
			(Print 63 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance orbs of Prop
	(properties
		x 134
		y 130
		lookStr {Fantastic technology... isn't it?}
		view 163
		loop 2
		priority 15
		signal 16400
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(super doVerb: theVerb &rest)
		else
			(Print 63 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance panelOfLights of RegionFeature
	(properties
		x 254
		y 44
		description {panel of lights}
		onMeCheck 16384
		lookStr {It's a panel of lights.}
		level 4
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance variousMachines of RegionFeature
	(properties
		description {various machines}
		onMeCheck 8192
		lookStr {Since your X-ray Vision Specs have not yet arrived in the mail, you don't even know this room is over here, so quit messing around and do something useful.}
		level 4
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance transmission of RegionFeature
	(properties
		x 73
		y 155
		description {transmission}
		onMeCheck 4096
		lookStr {You're uncertain whether this is a Walwoodian cryobaric hypersleep chamber or the transmission out of a late model Buick Skylark.}
		level 4
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance rearViewMirror of RegionFeature
	(properties
		x 21
		y 127
		description {rear view mirror}
		onMeCheck 2048
		lookStr {It appears to be a standard driver-side rear view mirror, probably standard on all ships of this class.}
		level 4
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance globes of RegionFeature
	(properties
		x 133
		y 105
		description {globes-o-power}
		onMeCheck 1024
		lookStr {Two zapping, crackling globes spew forth gargantuan amounts of sizzling raw energy. Kinda neat, huh?}
		level 4
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance walkingGuard of Actor
	(properties
		x 350
		y 180
		description {guard}
		lookStr {You surmise this is a Sarien enlisted being.}
		view 410
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance standingGuard of PicView
	(properties
		x 293
		y 76
		description {guard}
		lookStr {One of those gruesome red-suited Sariens is patrolling the hallways, looking for intruders to toast.}
		view 410
		loop 4
		priority 15
		signal 16
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(Print 63 1) ; "You can't shoot that from here."
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance beamSound of Sound
	(properties)
)

