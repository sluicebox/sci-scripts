;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use Elevator)
(use RangeOsc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm60 0
)

(local
	local0
	[local1 12] = [0 0 319 0 319 50 154 50 103 81 0 77]
	[local13 12] = [0 86 162 86 203 59 319 59 319 189 0 189]
	[local25 16] = [0 0 319 0 319 173 261 173 270 167 250 167 236 174 0 174]
	[local41 8] = [319 184 319 189 0 189 0 184]
	local49
	local50
)

(instance rm60 of SQRoom
	(properties
		lookStr {This is an interesting place. Strange devices decorate almost every area.}
		picture 60
		east 64
		west 59
	)

	(method (notify)
		(if (== gPrevRoomNum 66)
			(HandsOff)
		)
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(HandsOff)
		(LoadMany rsSOUND 6 339)
		(LoadMany rsVIEW 160 328)
		(gFeatures
			add: balls hb mosl mdofl fllym flum hole
			eachElementDo: #init
			doit:
		)
		(iris init: stopUpd:)
		(up points: @local1 size: 6)
		(up2 points: @local13 size: 6)
		(lp points: @local25 size: 8)
		(lp2 points: @local41 size: 4)
		(if (or (== gPrevRoomNum 66) (< gPrevRoomNum 10))
			(= global166 2)
		)
		(switch gPrevRoomNum
			(east
				(= style 2)
				(gEgo x: 315)
				(if (== global166 2)
					(gEgo y: 178)
				)
			)
			(west
				(= style 12)
				(gEgo x: 10)
			)
			(else
				(= global166 2)
				(= style -32767)
			)
		)
		(if (== global166 2)
			(LoadMany rsVIEW 80)
		)
		(gEgo init:)
		(super init:)
		(gAddToPics add: robot eachElementDo: #init doit:)
		(if (== global166 1)
			(robot approachVerbs: 3 2 11 12) ; Do, Look, Taste, Smell
		)
		(DeltaurRegion eDoor1: e1Door)
		(e1Door
			view: 160
			locked: 0
			loop: 0
			posn: 133 171
			description: { elevator door}
			lookStr: {This is an elevator.}
			whereTo: 66
			level: 2
			setPri: 13
			exiting: (or (== gPrevRoomNum 66) (< gPrevRoomNum 10))
			polyCode: 0
			init:
		)
		(switch global166
			(1
				(self addObstacle: up up2)
			)
			(2
				(self addObstacle: lp lp2)
			)
		)
		(pe1 setCycle: Fwd init:)
		(pe2 setCycle: Fwd init:)
		(beam setCycle: Fwd setScript: switchit init:)
		(lamp setCycle: Fwd init:)
	)

	(method (newRoom newRoomNumber)
		(gEgo setCycle: 0 setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			(script 0)
			((and (> (gGame detailLevel:) 1) (not (beam script:)))
				(beam setScript: switchit)
			)
			((and (<= (gGame detailLevel:) 1) (beam script:))
				(pe1 show:)
				(pe2 show:)
				(beam show:)
				(lamp show:)
				(beam setScript: 0)
			)
			((e1Door inFront:)
				(e1Door open:)
			)
			((& (gEgo onControl: 0) $0002)
				(self setScript: toastEgo)
			)
		)
		(super doit: &rest)
	)
)

(instance e1Door of Elevator
	(properties
		description {elevator door}
		sightAngle 90
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(if (!= global166 level)
			(Print 60 0) ; "You are on the wrong level to do that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance up of Polygon
	(properties
		type PBarredAccess
	)
)

(instance up2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lp of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lp2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance iris of Prop
	(properties
		x 234
		y 12
		description {garbage disposal}
		lookStr {This utilitarian-looking door probably leads to the trash disposal facility.}
		view 160
		loop 1
		cycleSpeed 6
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(3 ; Do
					(gEgo setScript: shreadEgo)
				)
				(12 ; Smell
					(Print 60 1) ; "Smells like garbage, doesn't it?"
				)
				(11 ; Taste
					(Print 60 2) ; "Oh, come on!"
				)
				(5 ; Talk
					(Print 60 3) ; "You holler down the chute, but no one answers. You're relieved, somehow."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 60 4) ; "Your on the wrong level to do that."
		)
	)
)

(instance pe1 of Prop
	(properties
		x 215
		y 121
		description {purple energy}
		approachX 251
		approachY 168
		lookStr {Vast amounts of energy.}
		view 160
		loop 2
		cycleSpeed 6
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 11 12) ; Do, Taste, Smell
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
				(gCurRoom setScript: shipBlowsUp)
			else
				(super doVerb: theVerb invItem &rest)
			)
		else
			(Print 60 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance pe2 of Prop
	(properties
		x 304
		y 142
		description {purple energy}
		approachX 251
		approachY 168
		lookStr {Vast amounts of energy.}
		view 160
		loop 3
		cycleSpeed 6
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 11 12) ; Do, Taste, Smell
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
				(gCurRoom setScript: shipBlowsUp)
			else
				(super doVerb: theVerb invItem &rest)
			)
		else
			(Print 60 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance beam of Prop
	(properties
		x 266
		y 134
		description {beam}
		approachX 251
		approachY 168
		lookStr {An intense beam of energy.}
		view 160
		loop 4
		cycleSpeed 6
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 11 12) ; Do, Taste, Smell
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
				(gCurRoom setScript: shipBlowsUp)
			else
				(super doVerb: theVerb invItem &rest)
			)
		else
			(Print 60 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance lamp of Prop
	(properties
		x 64
		y 37
		description {lamp}
		lookStr {bottled energy}
		view 160
		loop 5
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(3 ; Do
					(Print 60 5) ; "You're not at home with the idea of touching this thing."
				)
				(12 ; Smell
					(Print 60 6) ; "The electric charge around the globe tickles your nose hairs."
				)
				(11 ; Taste
					(Print 60 7) ; "You really don't want to lick this."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 60 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance switchit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pe1 show:)
				(pe2 show:)
				(beam hide:)
				(= ticks (Random 18 180))
			)
			(1
				(beamSound number: 6 loop: -1 play:)
				(beam show:)
				(= ticks (Random 60 240))
			)
			(2
				(beamSound stop:)
				(beam hide:)
				(= ticks (Random 18 60))
			)
			(3
				(-= state 4)
				(pe1 hide:)
				(pe2 hide:)
				(= ticks (Random 18 180))
			)
		)
	)
)

(instance shreadEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 249 41 self)
			)
			(1
				(HandsOff)
				(gEgo view: 160 loop: 7 cel: 0)
				(iris startUpd: setCycle: End self)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo x: 259 y: 35 loop: 8 cel: 0 setCycle: End self)
			)
			(4
				(EgoDead 160 8 0 60 8) ; "Yikes! I guess that was a bad idea, eh! I guess you'll be staying out of the garbage disposal in the future."
				(self dispose:)
			)
		)
	)
)

(instance toastEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf (gEgo loop:) 0 4 6)
					(= register 1)
				else
					(= register 0)
				)
				(if (== (DeltaurRegion egoStatus:) 1)
					(gEgo setLoop: 2)
				else
					(gEgo setLoop: 0)
				)
				(= local50 (+ (gEgo y:) 10))
				(if register
					(= local49 (- (gEgo x:) 30))
				else
					(= local49 (+ (gEgo x:) 30))
				)
				(gEgo
					loop: (+ (gEgo loop:) register)
					view: 80
					cel: 0
					cycleSpeed: 3
					setCycle: CT 13 1 self
					setMotion: JumpTo local49 local50
				)
			)
			(1
				(gEgo cycleSpeed: 10 setCycle: RangeOsc 5 11 13 self)
			)
			(2
				(EgoDead 80 0 5 60 9) ; "Gee, that must have been a pretty powerful energy beam, seeing as how it reduced you to a pile of carbonized matter."
				(self dispose:)
			)
		)
	)
)

(instance shipBlowsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 53)
				(= ticks 18)
				(DeltaurRegion script: 0)
				(gEgo setScript: (ScriptID 703 22) self) ; firePulsar
			)
			(1
				(pe1 dispose:)
				(pe2 dispose:)
				(lamp dispose:)
				(beam
					view: 328
					loop: 0
					cel: 0
					cycleSpeed: 27
					setCycle: 0
					setPri: 13
					setScript: 0
					posn: 247 169
					setCycle: End self
				)
			)
			(2
				(ShakeScreen 3 7) ; ssFULL_SHAKE | $0004
				(gLongSong number: 339 loop: 1 play: self)
			)
			(3
				(iris dispose:)
				((ScriptID 703 16) dispose:) ; sarienOfficer3
				((ScriptID 703 17) dispose:) ; sarienOfficer4
				(gEgo hide:)
				(e1Door dispose:)
				(gCurRoom drawPic: 50 7)
				(beam
					view: 328
					loop: 0
					cel: 0
					cycleSpeed: 36
					setCycle: 0
					setPri: 1
					setScript: 0
					posn: 186 70
				)
				(= ticks 60)
			)
			(4
				(ShakeScreen 3 7) ; ssFULL_SHAKE | $0004
				(gLongSong number: 339 loop: 1 play: self)
			)
			(5
				(beam posn: 188 60 setCycle: CT 1 1 self)
			)
			(6
				(beam posn: 192 55 setCycle: End self)
			)
			(7
				(EgoDead 945 0 0 60 10) ; "Good shootin', Tex. You really did it now, Wilco. Don't you know that macromat field integrators are extremely fragile pieces of equipment and indiscriminatly shooting at them with a pulseray gun can be hazardous to your health?"
				(self dispose:)
			)
		)
	)
)

(instance balls of RegionFeature
	(properties
		x 253
		y 132
		description {electric balls}
		onMeCheck 16384
		lookStr {From the looks of them, these globes contain high-power Wally coils, each one capable of discharging jillions of volts of deadly electricity.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Smell
				(Print 60 11) ; "This close to the Wally globes, all your nose hairs are standing on end."
			)
			(11 ; Taste
				(Print 60 12) ; "I don't think you want to do that."
			)
			(5 ; Talk
				(Print 60 13) ; "Get real."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mosl of RegionFeature
	(properties
		x 176
		y 21
		description {blue machine}
		onMeCheck 8192
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Smell
				(Print 60 14) ; "Smells sort of blue."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hb of RegionFeature
	(properties
		x 63
		y 21
		description {bottled energy}
		onMeCheck 4096
		lookStr {The egg-shaped globe pulses with blue-white light. It appears to be some exotic form of bottled energy, or maybe a 60,000 watt light bulb.}
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 60 5) ; "You're not at home with the idea of touching this thing."
			)
			(12 ; Smell
				(Print 60 6) ; "The electric charge around the globe tickles your nose hairs."
			)
			(11 ; Taste
				(Print 60 7) ; "You really don't want to lick this."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mdofl of RegionFeature
	(properties
		x 68
		y 137
		description {rounded purple thing}
		onMeCheck 2048
		lookStr {Looks like a great place to curl up and take a nap. Too bad you're in such a hurry.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 60 15) ; "Hmmmm. Soft."
			)
			(11 ; Taste
				(Print 60 16) ; "Fuzzy. Provocative. Well-seasoned."
			)
			(5 ; Talk
				(Print 60 17) ; "There's nobody in there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fllym of RegionFeature
	(properties
		description {gold machine}
		onMeCheck 1024
		lookStr {It's an expensive-looking machine that goes `ping.'}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 60 18) ; "You are reluctant to tarnish the shiny gold casing."
			)
			(12 ; Smell
				(Print 60 19) ; "It smells expensive."
			)
			(11 ; Taste
				(Print 60 20) ; "Not bad."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flum of RegionFeature
	(properties
		x 11
		y 63
		description {blue speaker}
		onMeCheck 64
		lookStr {It does sort of look like a speaker, doesn't it. But it isn't.}
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 60 21) ; "It does sort of look like a speaker, doesn't it. But it isn't."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hole of RegionFeature
	(properties
		x 219
		y 158
		description {hole}
		onMeCheck 512
		lookStr {Your engineering expertise informs you that this is a carelessly discarded Williamson coil.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 60 22) ; "Your engineering expertise informs you that this is a carelessly discarded Williamson coil."
				(Print 60 23) ; "Of course it could also be a humongous escargot."
			)
			(3 ; Do
				(Print 60 24) ; "Not knowing whether it's alive or not, you're not eager to touch it."
			)
			(12 ; Smell
				(Print 60 25) ; "Garlic - chives - butter..."
			)
			(11 ; Taste
				(Print 60 2) ; "Oh, come on!"
			)
			(5 ; Talk
				(Print 60 26) ; "No time for chit-chat. You're here on a mission, remember?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robot of PicView
	(properties
		x 266
		y 48
		description {cleaning droid}
		approachX 250
		approachY 53
		lookStr {Broom at the ready, the cleaning droid waits for something useful to do.}
		view 160
		loop 6
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(3 ; Do
					(Print 60 27) ; "You give the cleaning droid a shove. It appears to be in standby mode and doesn't budge."
				)
				(12 ; Smell
					(Print 60 28) ; "The heady scents of petroleum distillates and Sarien refuse titillates your nostrils."
				)
				(11 ; Taste
					(Print 60 29) ; "You can't be serious!"
				)
				(5 ; Talk
					(Print 60 30) ; "The droid does not speak to you. It's possible you've been snubbed."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print 60 0) ; "You are on the wrong level to do that."
		)
	)
)

(instance beamSound of Sound
	(properties
		number 6
	)
)

