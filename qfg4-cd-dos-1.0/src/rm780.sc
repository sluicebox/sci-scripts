;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use DeathIcon)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm780 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm780 of GloryRm
	(properties
		picture 780
	)

	(method (init)
		(gEgo init: setScaler: Scaler 132 85 186 54)
		(RemapColors 2 253 50) ; ByPercent
		(= local1 (IntArray with: 5 1 7 3 6 0 4 2))
		(if (IsFlag 316)
			(Palette 2 0 65 0) ; PalIntensity
			(Palette 2 86 255 0) ; PalIntensity
			(Palette 2 66 85 0) ; PalIntensity
			(gEgo view: 6 loop: 3 cel: 0 posn: 235 109)
		else
			(Palette 2 66 85 75) ; PalIntensity
			(gEgo posn: 319 54 normalize:)
		)
		(gLongSong number: 780 setLoop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 52 149 52 163 75 186 132 186 132 176 194 141 264 141 264 123 278 123 270 115 264 115 264 107 227 107 197 117 126 99 24 123
					yourself:
				)
		)
		(desk init: approachVerbs: 4 80 42) ; Do, openSpell, theToolkit
		(rollTop init: setPri: 185 approachVerbs: 4 80 42) ; Do, openSpell, theToolkit
		(if (and (not (IsFlag 315)) (> [gEgoStats 9] 0)) ; pick locks
			(statue init: approachVerbs: 4 13) ; Do, theBag
		)
		(drip init: setCycle: Fwd)
		(genie init: approachVerbs: 4) ; Do
		(torch1 init: setPri: 75 setCycle: Fwd)
		(torch2 init: setPri: 75 setCycle: Fwd)
		(book init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		(bottle init: approachVerbs: 4) ; Do
		(barrel init: approachVerbs: 4) ; Do
		(gargoyle1 init: approachVerbs: 4) ; Do
		(gargoyle2 init: approachVerbs: 4) ; Do
		(cask init: approachVerbs: 4) ; Do
		(stairs init: approachVerbs: 4) ; Do
		(alcove init: approachVerbs: 4) ; Do
		(sconce1 init: approachVerbs: 4) ; Do
		(sconce2 init: approachVerbs: 4) ; Do
		(genie1 init: approachVerbs: 4) ; Do
		(genie2 init: approachVerbs: 4) ; Do
		(pillar init: approachVerbs: 4) ; Do
		(avoozl init: approachVerbs: 4) ; Do
		(barrels init: approachVerbs: 4) ; Do
		(serpentCrack init: approachVerbs: 4) ; Do
		(super init: &rest)
		(if (IsFlag 316)
			(self setScript: sWakeUp)
		else
			(self setScript: sDownStairs)
		)
		(gGlory save: 1)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(local1 dispose:)
		(super dispose:)
	)
)

(instance sUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: DPath 309 95 294 72 319 54 self)
			)
			(1
				(gGlory handsOn:)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: DPath 294 72 309 95 271 124 250 124 self)
			)
			(1
				(if (not (IsFlag 319))
					(SetFlag 319)
					(gMessager say: 17 6 2 0 self) ; "There is a cold feeling down here that chills your bones and sets the hairs on the nape of your neck on end. There is a musty odor of mold and mildew mingling with the sickeningly sweet smell of decaying flesh. Welcome to your nightmare."
				else
					(= ticks 2)
				)
			)
			(2
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 17 6 3 0 self) ; "This is a dangerous place. (You probably knew that.) Handle with care. An incredible sensation of evil emanates from over by the book. That seems like an excellent thing to avoid."
				else
					(= ticks 2)
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 243 99 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					view: 4
					loop: 0
					cel: 0
					x: 237
					y: 99
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 6 4 0 0 self) ; "You tap the huge Cask of Amon Tillado. This is the strongest stuff you've ever tasted (assuming that you're not an aficionado of Dragon's Breath). Bottoms up!"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					normalize: 0
					cycleSpeed: local0
					setMotion: MoveTo 245 115 self
				)
			)
			(6
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					setCycle: 0
					view: 5
					cel: 0
					loop: 5
					cycleSpeed: 5
					setCycle: (spin new:) 7 1 self
				)
			)
			(7
				(gEgo setCycle: (spin new:) 7 1 self)
			)
			(8
				(gEgo setCycle: (spin new:) 7 1 self)
			)
			(9
				(gEgo
					view: 43
					setLoop: 1
					cel: 0
					posn: 222 120
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(10
				(SetFlag 50)
				(ClearFlag 6)
				(for ((= local4 100)) (>= local4 0) ((-= local4 10))
					(= gGameTime (+ gTickOffset (GetTime)))
					(gSounds eachElementDo: #check)
					(gTimers eachElementDo: #doit)
					(gCast doit:)
					(Palette 2 0 65 local4) ; PalIntensity
					(Palette 2 86 255 local4) ; PalIntensity
					(if (< local4 75)
						(Palette 2 66 85 local4) ; PalIntensity
					)
					(FrameOut)
				)
				(= cycles 1)
			)
			(11
				(SetFlag 316)
				(gEgo cycleSpeed: local0)
				(gGlory handsOn:)
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance sWakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 316)
				(= seconds 2)
			)
			(1
				(for ((= local4 0)) (< local4 100) ((+= local4 10))
					(gGlory doit:)
					(Palette 2 0 65 local4) ; PalIntensity
					(Palette 2 86 255 local4) ; PalIntensity
					(if (not (> local4 75))
						(Palette 2 66 85 local4) ; PalIntensity
					)
					(FrameOut)
				)
				(= cycles 1)
			)
			(2
				(SetFlag 6)
				(ClearFlag 50)
				(= local0 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 10 setCycle: End self)
			)
			(3
				(gEgo posn: 214 114 cycleSpeed: local0 normalize: 5)
				(gMessager say: 17 6 1 0 self) ; "Man, have you got a headache! Fortunately, the Dark One Rising seems to have been just a vision, not the reality... yet."
			)
			(4
				(drip loop: 3 setCycle: End self)
			)
			(5
				(= seconds 2)
			)
			(6
				(gMessager say: 17 6 14 0 self) ; "A scroll has formed from the cask's wine droplets."
			)
			(7
				(gEgo setMotion: MoveTo 235 105 self)
			)
			(8
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(drip hide:)
				(gEgo get: 53 setCycle: Beg self) ; theBloodRit
			)
			(10
				(gEgo normalize: 0)
				(= seconds 2)
			)
			(11
				(gMessager say: 17 6 15 0 self) ; "You pick up the rolled paper on the floor. It has the symbol of a drop of blood at the top, and the inscription, "Ritual of Blood." You can't read any of the other writing on it."
			)
			(12
				(gEgo setMotion: MoveTo 235 114 self)
			)
			(13
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(switch register
					(1
						(gMessager say: 19 166 12 0 self) ; "You force the drawer open with your incredible strength."
					)
					(2
						(gMessager say: 19 166 11 0 self) ; "You pick the lock on the desk."
					)
					(3
						(= cycles 1)
					)
					(else
						(gGlory handsOn:)
						(if ((ScriptID 648 0) init: show: dispose:) ; ticTacPuz
							(DisposeScript 648)
							(= cycles 1)
						else
							(DisposeScript 648)
							(if (IsFlag 182)
								(ClearFlag 182)
								(= local3 1)
								(= cycles 1)
							else
								(self changeState: 5)
							)
						)
					)
				)
			)
			(1
				1
				(gGlory handsOff:)
				(SetFlag 317)
				(rollTop setCycle: Beg self)
			)
			(2
				2
				(SetFlag 318)
				(if (or (OneOf register 2 1 3) (== local3 1))
					(gasCloud init: setPri: 196 setCycle: End self)
				else
					(self changeState: 5)
				)
			)
			(3
				3
				(gasCloud cel: 0)
				(if (== register 3)
					(= cycles 1)
				else
					(gMessager say: 17 6 8 0 self) ; "Opening the desk set off a trap! A billowing cloud of poisonous gas surrounds you for a moment before dissipating. You're having trouble breathing."
				)
			)
			(4
				4
				(cond
					((== register 3)
						(gMessager say: 2 80 0 0 self) ; "A swirling cloud of undoubtedly poisonous gas surrounds the desk for a few seconds after your spell opens it. Then the cloud subsides."
					)
					((gEgo takeDamage: 25)
						(SetFlag 14)
						(+= global479 30)
						(self changeState: 5)
					)
					(else
						(EgoDead 8 0 977 1 912)
					)
				)
			)
			(5
				5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(SetFlag 317)
					(rollTop setCycle: Beg self)
				else
					(ClearFlag 317)
					(rollTop setCycle: End self)
				)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSetFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 41)
				(gEgo addHonor: 500)
				(= cycles 1)
			)
			(1
				(gGlory handsOff:)
				(= seconds 2)
			)
			(2
				(gMessager say: 12 76 6 0 self) ; "The ancient book catches fire instantly and burns far brighter than you would have imagined. You high-tail it out of the monastery basement."
			)
			(3
				(book view: 783 loop: 0 cel: 0 posn: 73 81 setCycle: End self)
			)
			(4
				(= local6 gEgoGait)
				(book loop: 1 cel: 0 setCycle: Fwd)
				(gEgo
					normalize:
					changeGait: 1 ; running
					setMotion: PolyPath 230 120 self
				)
			)
			(5
				(fire1 init: setPri: 196 setCycle: Fwd)
				(fire2 init: setPri: 196 setCycle: Fwd)
				(gEgo setMotion: PolyPath 270 120 self)
			)
			(6
				(= gEgoGait local6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBookDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 12 4 0 0 self) ; "The huge book on the altar looks fascinating. You could almost swear you saw it move. The title says "Necrophilicon." Haven't you heard about this book somewhere?"
			)
			(1
				(book hide:)
				(gEgo
					setScale: 0
					view: 781
					loop: 0
					cel: 0
					x: 82
					y: 118
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(book show:)
				(gEgo loop: 1 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(EgoDead 4 0 0 0 912)
			)
		)
	)
)

(instance sSlugDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(genie view: 782 loop: 1 cel: 0 posn: 148 99 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(gMessager say: 16 4 0 0 self) ; "You feel a funny tingling sensation, then a slimy one, as you reach out to touch the statue. This is not good."
			)
			(2
				(= seconds 2)
			)
			(3
				(= local5 (gEgo xStep:))
				(gEgo
					setScale: 0
					setCycle: 0
					view: 5
					xStep: 1
					setLoop: 6
					setMotion: MoveTo 124 113 self
				)
			)
			(4
				(= local0 (gEgo cycleSpeed:))
				(genie setCycle: 0 view: 782 loop: 0 cel: 0 posn: 146 99)
				(gEgo
					view: 782
					loop: 2
					cel: 0
					posn: 121 116
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(EgoDead 7 0 975 1 912)
			)
		)
	)
)

(instance sBagStatue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 31 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(1
				(statue hide:)
				(gEgo get: 43) ; theStatue
				(SetFlag 315)
				(= cycles 2)
			)
			(2
				(gMessager say: 16 13 0 0 self) ; "You pick up the statue in the shopping bag, carefully avoiding any contact with your own flesh. The statue glows briefly as it slips into the bag, then subsides."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deskTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== (CueObj client:) rollTop) (IsFlag 318))
						(if (IsFlag 317)
							(gCurRoom setScript: sDoDesk 0 0)
						else
							(gCurRoom setScript: sDoDesk 0 1)
						)
					)
					((IsFlag 318)
						(if (IsFlag 317)
							(if (not (IsFlag 233))
								(SetFlag 233)
							)
							(gMessager say: 2 4 9) ; "You rifle through the Mad Monk's desk and find the diary of Amon Tillado. Boy, was this guy whacko! Reading this makes your head hurt. However, it does give you some information about the Dark One Rituals."
						else
							(gMessager say: 2 4 13) ; "There is nothing else useful in the desk."
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				10 ; Look for Traps
				(and (gEgo has: 24) (IsFlag 242)) ; theToolkit
				12 ; Force Drawer Open
				(>= [gEgoStats 0] 300) ; strength
				11 ; Pick Desk Lock
				(gEgo has: 24) ; theToolkit
		)
	)

	(method (sayMessage)
		(switch iconValue
			(12 ; Force Drawer Open
				(self clean:)
				(gCurRoom setScript: sOpenDesk 0 1)
			)
			(11 ; Pick Desk Lock
				(self clean:)
				(gCurRoom setScript: sOpenDesk 0 2)
			)
			(10 ; Look for Traps
				(self clean:)
				(gCurRoom setScript: sOpenDesk 0 0)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance rollTop of Prop
	(properties
		noun 2
		sightAngle 180
		x 162
		y 162
		priority 186
		fixPriority 1
		view 780
		signal 20481
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 317))
			(self setCel: (rollTop lastCel:))
		)
		(= actions deskTeller)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_P)
			(= approachX 73)
			(= approachY 156)
		else
			(= approachX 123)
			(= approachY 186)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(desk doVerb: theVerb &rest)
	)
)

(instance book of TargProp
	(properties
		noun 12
		sightAngle 180
		approachX 87
		approachY 108
		x 49
		y 69
		view 781
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sBookDeath)
			)
			(39 ; theFlint
				(if
					(and
						(IsFlag 138)
						(IsFlag 233)
						(or (gEgo has: 53) ((gInventory at: 53) chestAmout:)) ; theBloodRit, theBloodRit
					)
					(self setScript: sSetFire)
				else
					(gMessager say: 12 76 5) ; "You have some work to do in the monastery before you can afford to set the place on fire."
				)
			)
			(76 ; theTorch
				(if
					(and
						(IsFlag 138)
						(IsFlag 233)
						(or (gEgo has: 53) ((gInventory at: 53) chestAmout:)) ; theBloodRit, theBloodRit
					)
					(self setScript: sSetFire)
				else
					(gMessager say: 12 76 5) ; "You have some work to do in the monastery before you can afford to set the place on fire."
				)
			)
			(86 ; flameDartSpell
				(if
					(and
						(IsFlag 138)
						(IsFlag 233)
						(or (gEgo has: 53) ((gInventory at: 53) chestAmout:)) ; theBloodRit, theBloodRit
					)
					(= global441 gMouseX)
					(= global442 gMouseY)
					(gCurRoom setScript: sSetFire 0 1)
				else
					(gMessager say: 12 76 5) ; "You have some work to do in the monastery before you can afford to set the place on fire."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (getHurt param1)
		(if (== param1 86)
			(self doVerb: param1)
		)
	)
)

(instance genie of Prop
	(properties
		noun 10
		sightAngle 180
		approachX 176
		approachY 119
		x 146
		y 99
		priority 60
		fixPriority 1
		view 782
		signal 16385
	)
)

(instance gasCloud of Prop
	(properties
		x 162
		y 142
		view 780
		loop 1
		signal 16385
	)
)

(instance drip of Prop
	(properties
		noun 6
		sightAngle 180
		approachX 237
		approachY 107
		x 254
		y 81
		view 781
		loop 4
		signal 16385
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(cask doVerb: theVerb &rest)
	)
)

(instance fire1 of Prop
	(properties
		x 53
		y 138
		view 783
		loop 2
		signal 16385
	)
)

(instance fire2 of Prop
	(properties
		x 27
		y 162
		view 783
		loop 5
		signal 16385
	)
)

(instance torch1 of Prop
	(properties
		x 101
		y 17
		view 780
		loop 3
		signal 16385
		detailLevel 3
	)
)

(instance torch2 of Prop
	(properties
		x 200
		y 16
		view 780
		loop 2
		signal 16385
		detailLevel 3
	)
)

(instance statue of View
	(properties
		noun 16
		sightAngle 90
		approachX 168
		approachY 124
		x 183
		y 87
		view 781
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sSlugDeath)
			)
			(13 ; theBag
				(gCurRoom setScript: sBagStatue)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		noun 2
		nsLeft 140
		nsTop 127
		nsRight 226
		nsBottom 189
		sightAngle 180
		x 183
		y 158
	)

	(method (init)
		(super init: &rest)
		(deskTeller init: self 780 19 166)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_P)
			(= approachX 73)
			(= approachY 156)
		else
			(= approachX 123)
			(= approachY 186)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 317)
					(if (not (IsFlag 233))
						(SetFlag 233)
					)
					(gMessager say: 2 1 9) ; "You rifle through the Mad Monk's desk and find the diary of Amon Tillado. Boy, was this guy whacko! Reading this makes your head hurt. However, it does give you some information about the Dark One Rituals."
				else
					(gMessager say: 2 1 13) ; "The rolltop desk is spotted with dark and ominous stains."
				)
			)
			(42 ; theToolkit
				(if (IsFlag 242)
					(gCurRoom setScript: sOpenDesk 0 0)
				else
					(gCurRoom setScript: sOpenDesk 0 2)
				)
			)
			(80 ; openSpell
				(if (gEgo castSpell: 20)
					(= global441 168)
					(= global442 159)
					(gCurRoom setScript: (ScriptID 13 0) 0 self) ; castOpenScript
				)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sOpenDesk 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bottle of Feature
	(properties
		noun 3
		nsLeft 233
		nsTop 129
		nsRight 240
		nsBottom 143
		sightAngle 180
		x 236
		y 136
	)
)

(instance barrel of Feature
	(properties
		noun 4
		nsLeft 241
		nsTop 121
		nsRight 267
		nsBottom 150
		sightAngle 180
		x 254
		y 135
	)
)

(instance gargoyle1 of Feature
	(properties
		noun 5
		nsTop 76
		nsRight 27
		nsBottom 127
		sightAngle 180
		x 13
		y 101
	)
)

(instance gargoyle2 of Feature
	(properties
		noun 5
		nsLeft 205
		nsTop 52
		nsRight 225
		nsBottom 70
		sightAngle 180
		x 215
		y 61
	)
)

(instance cask of Feature
	(properties
		noun 6
		nsLeft 222
		nsTop 18
		nsRight 269
		nsBottom 91
		sightAngle 180
		approachX 237
		approachY 107
		x 245
		y 54
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or ((gInventory at: 53) chestAmout:) (gEgo has: 53)) ; theBloodRit, theBloodRit
					(gMessager say: 6 4 18) ; "One vision like that is quite enough! Your heart is STILL pounding."
				else
					(gCurRoom setScript: sGetDrunk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 7
		nsLeft 270
		nsTop 52
		nsRight 313
		nsBottom 126
		sightAngle 180
		x 291
		y 89
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 281 112 281 127 266 127 266 112
						yourself:
					)
					6
					0
					4
					sUpStairs
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance alcove of Feature
	(properties
		noun 8
		nsLeft 177
		nsTop 69
		nsRight 195
		nsBottom 94
		sightAngle 180
		x 186
		y 81
	)
)

(instance sconce1 of Feature
	(properties
		noun 9
		nsLeft 93
		nsTop 2
		nsRight 108
		nsBottom 46
		sightAngle 180
		x 100
		y 24
	)
)

(instance sconce2 of Feature
	(properties
		noun 9
		nsLeft 193
		nsTop 1
		nsRight 208
		nsBottom 48
		sightAngle 180
		x 200
		y 24
	)
)

(instance genie1 of Feature
	(properties
		noun 10
		nsLeft 136
		nsTop 32
		nsRight 160
		nsBottom 66
		sightAngle 180
		x 148
		y 49
	)
)

(instance genie2 of Feature
	(properties
		noun 10
		nsLeft 128
		nsTop 66
		nsRight 167
		nsBottom 85
		sightAngle 180
		x 147
		y 75
	)
)

(instance pillar of Feature
	(properties
		noun 11
		nsLeft 137
		nsTop 82
		nsRight 163
		nsBottom 102
		sightAngle 180
		x 150
		y 92
	)
)

(instance avoozl of Feature
	(properties
		noun 13
		nsLeft 30
		nsTop 20
		nsRight 88
		nsBottom 87
		sightAngle 180
		approachX 87
		approachY 108
		x 59
		y 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sBookDeath)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barrels of Feature
	(properties
		noun 14
		nsTop 127
		nsRight 56
		nsBottom 189
		sightAngle 180
		x 28
		y 158
	)
)

(instance serpentCrack of Feature
	(properties
		noun 15
		nsLeft 264
		nsTop 159
		nsRight 280
		nsBottom 179
		sightAngle 180
		x 272
		y 169
	)
)

(instance spin of CT
	(properties)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(if (== param3 1)
			(= local2 0)
			(= endCel 7)
		else
			(= local2 7)
			(= endCel 0)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(= temp0 (client loop:))
		else
			(= cycleCnt gGameTime)
			(= temp0 (local1 at: local2))
			(if (and (>= local2 0) (<= local2 endCel))
				(+= local2 cycleDir)
			)
		)
		(client loop: temp0)
		(if (== (- local2 cycleDir) endCel)
			(FrameOut)
			(= local2 0)
			(self cycleDone:)
		)
	)
)

