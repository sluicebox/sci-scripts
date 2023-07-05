;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use SQEgo)
(use DScript)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm61 0
)

(local
	local0
	local1
)

(instance rm61 of SQRoom
	(properties
		lookStr {You are standing in the upper level of one of the Deltaur's hallways. You can't help but be impressed with the subtle decorating and color sense shown by the Sariens in their ship design.}
		picture 61
		east 63
	)

	(method (init)
		(HandsOff)
		(self setRegions: 703) ; DeltaurRegion
		(LoadMany rsVIEW 66 161)
		(if (gEgo has: 0) ; Cartridge
			(LoadMany rsSOUND 413 5 312)
		)
		(gFeatures
			add: bigMach smallerMach upperLevelMachine
			eachElementDo: #init
			doit:
		)
		(standingSarienHead init: standingSarien setLoop: 8 view: 66 cel: 0)
		(standingSarien
			init:
			_head: standingSarienHead
			posn: 249 188
			loop: 7
			shootEgo: shootTheEgo1
			blastID: blast1
			level: 2
			regionPathID: 0
			dead: 0
		)
		(switch gPrevRoomNum
			(62
				(gEgo posn: 324 108)
				(= global166 2)
			)
			(63
				(= style 2)
				(= global166 1)
				(gEgo ignoreActors: 0 x: 310)
			)
			(66
				(gEgo posn: 161 39)
				(= global166 1)
			)
			(else
				(gEgo posn: 9 177)
				(= global166 2)
				(if (== (DeltaurRegion egoStatus:) 0)
					(standingSarien shotsFired: 3)
				)
			)
		)
		(if (== global166 1)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 65 72 39 88 319 88 319 189 0 189 0 0 319 0 319 77 180 77 178 71 134 71 163 40 146 41 116 72
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 11 171 25 182 251 182 319 125 319 189 0 189 0 171
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 29 168 0 165 0 0 319 0 319 106 247 166 217 175 37 176
						yourself:
					)
			)
		)
		(beamSound number: 5 loop: -1 play:)
		(zap1 setCycle: Fwd init:)
		(zap2 setCycle: Fwd init:)
		(gEgo init:)
		(super init: &rest)
		(switch gPrevRoomNum
			(62
				(self setScript: fromSlantway)
			)
			(66
				(self setScript: fromElevatorRm)
			)
			(63 0)
			(else
				(self setScript: fromStorageRm)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			(
				(and
					(> (gEgo y:) 150)
					(== (gEgo priority:) 2)
					(== global166 2)
				)
				(gEgo setPri: -1)
			)
			(
				(and
					(< (gEgo y:) 150)
					(== global166 2)
					(!= (gEgo priority:) 2)
				)
				(gEgo setPri: 2)
			)
			((& (= temp0 (gEgo onControl: 1)) $0002)
				(self setScript: toSlantway)
			)
			((& temp0 $0004)
				(self setScript: toElevatorRm)
			)
			((& temp0 $0008)
				(self setScript: toStorageRm)
			)
		)
		(super doit:)
	)
)

(instance blast1 of Prop
	(properties
		view 479
		loop 15
		priority 15
		signal 16400
		cycleSpeed 6
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 61 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance shootTheEgo1 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(client cel: 0 setMotion: 0 view: 415)
				((client _head:) hide:)
				(client setLoop: (proc703_2 client gEgo))
				(= ticks 18)
			)
			(1
				(if (< (+ (client shotsFired:) 1) 5)
					(client shotsFired: (+ (client shotsFired:) 1))
					(= register 0)
				else
					(= register 1)
					(HandsOff)
				)
				(if (== (client view:) 415)
					(sarienShot play:)
					(client cel: (- (client lastCel:) 2) setCycle: End self)
				else
					(client view: 415 setMotion: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(if register
					(= temp0 (gEgo x:))
					(= temp1 (- (gEgo y:) 35))
				else
					(switch (Random 1 2)
						(1
							(= temp0 (- (gEgo nsLeft:) (Random 1 5)))
						)
						(2
							(= temp0 (+ (gEgo nsRight:) (Random 1 5)))
						)
					)
					(switch (Random 1 2)
						(1
							(= temp1 (- (gEgo nsTop:) (Random 1 5)))
						)
						(2
							(= temp1 (+ (gEgo nsBottom:) (Random 1 5)))
						)
					)
				)
				((client blastID:) init:)
				(if (OneOf (client loop:) 0 2 4)
					((client blastID:) setLoop: 1)
				else
					((client blastID:) setLoop: 2)
				)
				((client blastID:)
					ignoreActors: 1
					view: 479
					posn: temp0 temp1
					cel: 0
					setCycle: End self
				)
			)
			(3
				((client blastID:) dispose:)
				(= local0 (client x:))
				(= local1 (client y:))
				(if (and register (not (gEgo script:)))
					(gCurRoom setScript: (ScriptID 707 1)) ; egoShot
				)
				(= seconds 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance fromElevatorRm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 1
					ignoreActors: 1
					setMotion: PolyPath 121 73 self
				)
			)
			(1
				(gEgo ignoreActors: 0 setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toElevatorRm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: PolyPath 147 52 self)
			)
			(1
				(gCurRoom newRoom: 66)
			)
		)
	)
)

(instance fromStorageRm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 0 ignoreActors: 1 setMotion: MoveTo 58 177 self)
			)
			(1
				(gEgo ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toStorageRm of DScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: PolyPath 9 177 self)
			)
			(1
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance fromSlantway of DScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setPri: 2
					setLoop: 5
					setMotion: MoveTo 274 157 self
				)
			)
			(1
				(gEgo ignoreActors: 0 setLoop: -1 setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toSlantway of DScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 2
					ignoreActors: 1
					setMotion: MoveTo 324 108 self
				)
			)
			(1
				(gEgo setPri: -1)
				(gCurRoom newRoom: 62)
			)
		)
	)
)

(instance standingSarien of sarienGuard
	(properties
		description 3718
		approachX 217
		approachY 183
		lookStr 3687
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 12 11) ; Talk, Smell, Taste
	)

	(method (doit)
		(if
			(and
				(not guardLocked)
				(not script)
				(== level global166)
				(not (gEgo script:))
				(not dead)
				(!= (DeltaurRegion egoStatus:) 1)
				(not (gCurRoom script:))
			)
			(self setScript: shootEgo)
		)
		(super doit: &rest)
	)
)

(instance standingSarienHead of Head
	(properties
		view 66
		loop 8
		cycleSpeed 216
	)
)

(instance zap1 of Prop
	(properties
		x 206
		y 138
		lookStr {The globes crackle with many colors of light and, you suspect, even less healthful manifestations of the electromagnetic spectrum.}
		view 161
		loop 3
		cel 1
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 61 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance zap2 of Prop
	(properties
		x 106
		y 138
		lookStr {The globes crackle with many colors of light and, you suspect, even less healthful manifestations of the electromagnetic spectrum.}
		view 161
		loop 3
		cel 1
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(super doVerb: theVerb &rest)
		else
			(Print 61 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance bigMach of RegionFeature
	(properties
		x 157
		y 112
		description {viewer}
		onMeCheck 8192
		level 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gEgo has: 0) ; Cartridge
					(= lookStr
						{It looks like some kind of cartridge reader. Maybe the cartridge you have will work in it.}
					)
				else
					(= lookStr
						{A tiny little sign tacked on the front reads: Witzend Coil. Disconnect from power supply before servicing.}
					)
				)
				(super doVerb: theVerb invItem &rest)
			)
			(4 ; Inventory
				(if (and (== invItem 0) (== global166 2)) ; Cartridge
					(gCurRoom setScript: (ScriptID 706 0)) ; viewCartridge
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance smallerMach of RegionFeature
	(properties
		x 84
		y 123
		description {small machine}
		onMeCheck 4096
		lookStr {I give up. YOU tell ME what it is.}
		level 2
	)
)

(instance upperLevelMachine of RegionFeature
	(properties
		x 254
		y 23
		description {upper level machine}
		onMeCheck 2048
		lookStr {It looks like some type of experimental orifice.}
		level 1
	)
)

(instance sarienShot of Sound
	(properties
		number 312
	)
)

(instance beamSound of Sound
	(properties)
)

