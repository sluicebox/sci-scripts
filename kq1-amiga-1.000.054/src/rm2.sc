;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm2 0
)

(local
	local0
	[local1 6]
	[local7 6] = [137 203 296 258 96 56]
	[local13 6] = [178 178 159 168 171 167]
	[local19 6] = [1 2 3 3 3 3]
)

(instance rm2 of Rm
	(properties
		picture 2
		horizon 67
		north 15
		east 1
		south 47
		west 3
	)

	(method (init)
		(LoadMany rsVIEW 202 267)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 40)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 58 (+ horizon 2))
			)
			(south
				(gEgo posn: 163 188)
			)
			(west
				(gEgo posn: 3 100)
			)
			(east
				(gEgo x: 317)
			)
			(else
				(gEgo posn: 3 100)
			)
		)
		(gEgo init:)
		(proc0_1)
		(bridge init:)
		(tree init:)
		(tree1 init:)
		(self setRegions: 605) ; moatRg
		(for ((= local0 0)) (< local0 6) ((++ local0))
			((= [local1 local0] (Clone Ripple))
				view: 202
				cycleSpeed: 1
				setPri: 3
				x: [local7 local0]
				y: [local13 local0]
				setLoop: [local19 local0]
				ignoreActors: 1
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
		(gAddToPics add: urn eachElementDo: #init doit:)
		(vine1 init:)
		(vine2 init:)
		(turret init:)
		(moat1 init:)
		(moat2 init:)
		(moat3 init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/blossom')
				(if (< (gEgo y:) 112)
					(Print 2 0) ; "You can't see any flowers from where you stand."
				else
					(Print 2 1) ; "There are small flowers growing along the moat."
				)
			)
			((Said 'get,get,use/planter,caldron,planter')
				(Print 2 2) ; "If you inherit the throne, you may do whatever you please with the urns. Until then, leave them alone."
			)
			(
				(or
					(Said 'get,get<in/planter,planter,caldron')
					(Said 'hide<in/planter,planter,caldron')
				)
				(Print 2 3) ; "The pots are full of dirt and roots. There's nothing remotely helpful in or around the urns."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance urn of PicView
	(properties
		x 288
		y 103
		noun '/planter,caldron'
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
				(Print 2 4) ; "These beautiful urns adorn the front of the castle."
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
				(Print 2 5) ; "You never know what sort of fierce creatures lie just beneath the surface of the moat."
			)
		)
	)
)

(instance bridge of NewFeature
	(properties
		x 91
		y 111
		noun '/bridge'
		nsTop 95
		nsLeft 3
		nsBottom 128
		nsRight 179
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A sturdy bridge has been built here to span the moat.}
	)
)

(instance vine1 of NewFeature
	(properties
		x 281
		y 27
		noun '/vine,ivy,bury,ceder'
		nsLeft 246
		nsBottom 55
		nsRight 317
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance vine2 of NewFeature
	(properties
		x 280
		y 59
		noun '/vine,ivy,bury,ceder'
		nsTop 55
		nsLeft 274
		nsBottom 63
		nsRight 287
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance turret of NewFeature
	(properties
		x 173
		y 49
		noun '/castle,turret'
		nsTop -1
		nsLeft 104
		nsBottom 100
		nsRight 242
		description {turret}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Massive turrets, from which the guards can defend the castle, stretch to the sky above.}
	)
)

(instance moat1 of NewFeature
	(properties
		x 57
		y 125
		noun '/moat'
		nsTop 102
		nsLeft 22
		nsBottom 149
		nsRight 93
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance moat2 of NewFeature
	(properties
		x 78
		y 93
		noun '/moat'
		nsTop 86
		nsLeft 59
		nsBottom 101
		nsRight 97
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance moat3 of NewFeature
	(properties
		x 97
		y 82
		noun '/moat'
		nsTop 75
		nsLeft 90
		nsBottom 90
		nsRight 105
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance tree of NewFeature
	(properties
		x 52
		y 32
		noun '/ceder'
		nsTop -1
		nsBottom 65
		nsRight 104
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees around the castle are tall and old; they were just as tall back when King Edward was just a young prince!}
	)
)

(instance tree1 of NewFeature
	(properties
		x 13
		y 74
		noun '/ceder'
		nsTop 64
		nsBottom 84
		nsRight 27
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees around the castle are tall and old; they were just as tall back when King Edward was just a young prince!}
	)
)

