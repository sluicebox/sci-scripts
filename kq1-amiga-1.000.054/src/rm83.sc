;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm83 0
)

(local
	local0
	[local1 6]
	[local7 6] = [263 224 62 24 203 123]
	[local13 6] = [167 171 169 159 178 178]
	[local19 6] = [3 3 3 3 2 1]
)

(instance rm83 of Rm
	(properties
		picture 83
		horizon 74
		north 16
		east 8
		west 1
	)

	(method (init)
		(LoadMany rsVIEW 202 267)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 41)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 296 (+ horizon 2))
			)
			(west
				(gEgo x: 3)
			)
			(east
				(gEgo posn: 317 99)
			)
			(else
				(gEgo loop: 1 posn: 317 99)
			)
		)
		(gEgo init:)
		(proc0_1)
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
		(bridge init:)
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
					(Print 83 0) ; "You can't see any flowers from where you stand."
				else
					(Print 83 1) ; "There are small flowers growing along the moat."
				)
			)
			((Said 'get,get,use/planter,caldron,planter')
				(Print 83 2) ; "If you inherit the throne, you may do whatever you please with the urns. Until then, leave them alone."
			)
			(
				(or
					(Said 'get,get<in/planter,planter,caldron')
					(Said 'hide<in/planter,planter,caldron')
				)
				(Print 83 3) ; "The pots are full of dirt and roots. There's nothing remotely helpful in or around the urns."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance urn of PicView
	(properties
		x 34
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
				(Print 83 4) ; "These beautiful urns adorn the front of the castle."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 83 4) ; "These beautiful urns adorn the front of the castle."
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
				(Print 83 5) ; "You never know what sort of fierce creatures lie just beneath the surface of the moat."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 83 5) ; "You never know what sort of fierce creatures lie just beneath the surface of the moat."
			)
		)
	)
)

(instance bridge of NewFeature
	(properties
		x 224
		y 113
		noun '/bridge'
		nsTop 94
		nsLeft 138
		nsBottom 133
		nsRight 311
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {A sturdy stone bridge has been built here to span the moat.}
	)
)

(instance vine1 of NewFeature
	(properties
		x 35
		y 24
		noun '/vine,ivy,bury,ceder'
		nsTop -1
		nsLeft 3
		nsBottom 49
		nsRight 68
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance vine2 of NewFeature
	(properties
		x 31
		y 55
		noun '/vine,ivy,bury,ceder'
		nsTop 49
		nsLeft 27
		nsBottom 62
		nsRight 36
		description {vine}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The castle walls are carpeted with a thick tangle of vines.}
	)
)

(instance turret of NewFeature
	(properties
		x 144
		y 50
		noun '/turret,castle'
		nsTop -1
		nsLeft 75
		nsBottom 101
		nsRight 214
		description {turret}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Massive turrets, from which the guards can defend the castle, stretch to the sky above.}
	)
)

(instance moat1 of NewFeature
	(properties
		x 225
		y 85
		noun '/water'
		nsTop 80
		nsLeft 215
		nsBottom 91
		nsRight 235
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance moat2 of NewFeature
	(properties
		x 262
		y 121
		noun '/water'
		nsTop 93
		nsLeft 223
		nsBottom 150
		nsRight 302
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance moat3 of NewFeature
	(properties
		x 245
		y 88
		noun '/water'
		nsTop 84
		nsLeft 236
		nsBottom 92
		nsRight 254
		description {moat}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {You never know what sort of fierce creatures lie just beneath the surface of the moat.}
	)
)

(instance tree of NewFeature
	(properties
		x 267
		y 32
		noun '/ceder'
		nsTop -1
		nsLeft 215
		nsBottom 65
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The forest is slowly encroaching on the castle grounds; there are tall, ancient trees everywhere you look.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 291
		y 83
		noun '/ceder'
		nsTop 64
		nsLeft 264
		nsBottom 103
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 500
		shiftClick 367
		lookStr {The forest is slowly encroaching on the castle grounds; there are tall, ancient trees everywhere you look.}
	)
)

