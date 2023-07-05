;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm330 of GloryRm
	(properties
		picture 330
	)

	(method (init)
		(= local0
			(cond
				((== gPrevRoomNum 270) 8)
				((== global427 4) 5)
				((and (IsFlag 39) (< global427 4)) 4)
				(
					(and
						gPrevDomoTalkDayNumber
						(IsFlag 138)
						(not (IsFlag 154))
						(not (IsFlag 139))
					)
					11
				)
				(
					(and
						gPrevDomoTalkDayNumber
						(>= gDay 12)
						(not (== gDay gPrevDomoTalkDayNumber))
						(not (IsFlag 130))
						(not (IsFlag 155))
					)
					12
				)
				(
					(and
						gPrevDomoTalkDayNumber
						(>= gDay 16)
						(not (== gDay gPrevDomoTalkDayNumber))
						(IsFlag 139)
						(not (IsFlag 115))
						(not (IsFlag 156))
					)
					13
				)
				((and (>= gDay 5) (IsFlag 37) (not (IsFlag 48))) 3)
				((== global428 2) 1)
				((== global428 4) 2)
				((and (IsFlag 110) (not (IsFlag 153))) 10)
				((== global427 6) 75)
				((== global427 5)
					(not (IsFlag 115))
					7
				)
				(else 0)
			)
		)
		(gEgo init: normalize:)
		(switch gPrevRoomNum
			(320
				(gEgo
					posn: 115 240
					setScaler: Scaler 120 103 161 126
					setPri: 170
				)
			)
			(260
				(Palette 2 0 255 0) ; PalIntensity
				(gLongSong number: 320 setLoop: -1 play:)
				(gEgo
					view: 7
					loop: 4
					cel: 7
					posn: 68 101
					setScaler: Scaler 121 113 102 91
				)
			)
			(270
				(Palette 2 0 85 0) ; PalIntensity
				(Palette 2 112 255 0) ; PalIntensity
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					setScaler: Scaler 120 103 161 126
					view: 57
					setLoop: 1 1
					setCel: 0
					posn: 202 132
				)
			)
			(else
				(gEgo posn: 160 160 setScaler: Scaler 120 103 161 126)
			)
		)
		(gWalkHandler addToFront: self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 208 189 208 163 261 145 232 133 156 151 92 129 52 133 52 189 0 189 0 0
					yourself:
				)
		)
		(if gNight
			(winPatch init: approachVerbs: 4) ; Do
		)
		(garlic1 init: approachVerbs: 4) ; Do
		(garlic2 init: approachVerbs: 4) ; Do
		(rug init: approachVerbs: 4) ; Do
		(candle init: approachVerbs: 4 39) ; Do, theFlint
		(lamp init: approachVerbs: 4 39) ; Do, theFlint
		(theWindow init: approachVerbs: 4 33) ; Do, theGrapnel
		(bedPost init: approachVerbs: 4) ; Do
		(bed init: approachVerbs: 4) ; Do
		(bedHead init: approachVerbs: 4) ; Do
		(chest init: approachVerbs: 4) ; Do
		(chestLid init: setPri: 120)
		(if (IsFlag 152)
			(if (and (IsFlag 82) (< global427 9))
				(ClearFlag 152)
			else
				(note init: approachVerbs: 4) ; Do
			)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(270
				(gCurRoom setScript: sGoToBed 0 3)
			)
			(260
				(gCurRoom setScript: sEnterThruWin)
			)
			(else
				(gCurRoom setScript: sEnterScr)
			)
		)
	)

	(method (doit)
		(if (and (not script) (!= gTime local9))
			(= local9 gTime)
			(cond
				((>= gTime 4)
					(if (not (gCast contains: winPatch))
						(winPatch init: approachVerbs: 4) ; Do
					)
				)
				((gCast contains: winPatch)
					(winPatch dispose:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104 ; Sleep all night
				(gCurRoom setScript: sGoToBed 0 1)
			)
			(103 ; Sleep 1 hour or less
				(gCurRoom setScript: sGoToBed 0 2)
			)
			(89 ; levitateSpell
				(if gNight
					(gCurRoom setScript: sExitThruWin 0 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== ((gTheIconBar getCursor:) view:) 940) (>= (event y:) 163))
			(gCurRoom setScript: sExitScript)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 115 162 self)
			)
			(1
				(gEgo setPri: -1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 115 162 self)
			)
			(1
				(gEgo setPri: 170 setMotion: MoveTo 115 240 self)
			)
			(2
				(gGlory handsOn:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sEnterThruWin of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (< local8 100)
			(Palette 2 0 255 (+= local8 5)) ; PalIntensity
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 70)
				(= local3 (gEgo cycleSpeed:))
				(= cycles 2)
			)
			(1
				(gEgo cycleSpeed: 12 setCycle: Beg self)
			)
			(2
				(gEgo
					posn: 68 141
					setScaler: Scaler 120 103 161 126
					cycleSpeed: local3
					normalize: 3
					setMotion: PolyPath 68 151 self
				)
			)
			(3
				(while (< local8 100)
					(self doit:)
					(for ((= temp0 0)) (< temp0 70) ((++ temp0))
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(SetFlag 70)
					(gEgo setMotion: PolyPath 68 141 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					setScaler: Scaler 121 113 102 91
					view: 7
					loop: 4
					cel: 0
					posn: 68 101
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(2
				(if register
					(gMessager say: 0 89 29 0 self) ; "You open the window and gently float down to the street below."
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo cycleSpeed: local3)
				(gGlory handsOn:)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sUseChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 123 140 self)
			)
			(1
				(Face gEgo 319 150 self)
			)
			(2
				(gEgo view: 4 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(chestLid setCycle: End self)
			)
			(4
				(= seconds 1)
			)
			(5
				(if register
					((ScriptID 29 1) init: register) ; useCode
				else
					((ScriptID 29 0) init:) ; doCode
				)
				(= cycles 1)
			)
			(6
				(gGlory handsOff:)
				(chestLid setCycle: Beg self)
			)
			(7
				(gEgo view: 4 loop: 0 cel: 2 setCycle: Beg self)
			)
			(8
				(gEgo normalize: 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToBed of Script
	(properties)

	(method (handleEvent event)
		(if (and (== state 2) (not register))
			(switch (event message:)
				(KEY_h
					(self cue:)
					(event claimed: 1)
					(return)
				)
				(KEY_g
					(= register 2)
					(self changeState: 9)
					(event claimed: 1)
					(return)
				)
				(else
					(self changeState: 9)
					(event claimed: 1)
					(return)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(if (and (== register 3) (== local0 8))
					(= register 0)
					(= local3 (gEgo cycleSpeed:))
					(gEgo
						setScaler: Scaler 120 103 161 126
						view: 57
						setLoop: 1 1
						setLooper: 0
						setCel: 0
					)
					(self changeState: 4)
				else
					(gEgo setMotion: PolyPath 202 132 self)
				)
			)
			(1
				1
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					view: 57
					setCel: 0
					setLoop: 0 1
					posn: 202 132
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(2
				2
				(if register
					(if (== register 2)
						(self changeState: 9)
					else
						(= cycles 1)
					)
				else
					((ScriptID 7 2) init:) ; doSleep
					(DisposeScript 7)
					(DisposeScript 34)
				)
			)
			(3
				3
				(gGlory handsOff:)
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 85 temp0) ; PalIntensity
					(Palette 2 112 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(if local7
					(= local7 0)
					(candleLight dispose:)
				)
				(gCast eachElementDo: #hide)
				(= cycles 3)
			)
			(4
				(cond
					(
						(and
							(OneOf local0 11 12 13)
							(<= gTime 6)
							(not local10)
						)
						(= local10 1)
						(= local4 1)
						(= cycles 1)
					)
					((and (== local0 5) gNight (!= global427 5))
						(= local5 1)
						(gMessager say: 10 6 15 0 self) ; "Your sleep is interrupted around midnight."
					)
					(else
						(if (gCast contains: winPatch)
							(winPatch dispose:)
						)
						(if
							(or
								(and
									(IsFlag 79)
									(not (IsFlag 82))
									(not (IsFlag 152))
									(>= gDay (+ gPrevKatrinaDayNumber 3))
									(not (IsFlag 115))
								)
								(and (== global427 8) (IsFlag 161))
							)
							(if (not (gCast contains: note))
								(if (and (== global427 8) (IsFlag 161))
									(= global427 9)
								)
								(SetFlag 152)
								(note hide: init:)
							)
							(= cycles 1)
						else
							(switch local0
								(1
									(gMessager say: 10 6 12 0 self) ; "In your sleep, you seem to hear voices."
								)
								(2
									(gMessager say: 10 6 13 0 self) ; "While you sleep, you dream you hear voices. They are strangely familiar."
								)
								(3
									(gMessager say: 10 6 14 0 self) ; "As you sleep, you dream about voices again."
								)
								(4
									(= global427 4)
									(= cycles 1)
								)
								(7
									(= global427 6)
									(= cycles 1)
								)
								(75
									(= global427 7)
									(gMessager say: 10 6 17 0 self) ; "Again your sleep is disturbed by the sound of voices."
								)
								(8
									(= global427 8)
									(= cycles 1)
								)
								(10
									(SetFlag 153)
									(gMessager say: 10 6 20 0 self) ; "You have another dream."
								)
								(else
									(= cycles 1)
								)
							)
						)
					)
				)
			)
			(5
				5
				(gCast eachElementDo: #show)
				(if local4
					(domovoi init: setPri: 238)
				)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 5))
					(Palette 2 0 85 temp0) ; PalIntensity
					(Palette 2 112 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 2)
			)
			(6
				6
				(if (and (not local4) (not local5))
					(++ global428)
					(= [gEgoStats 19] (gEgo maxMana:)) ; mana
					(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
					(= [gEgoStats 17] (gEgo maxHealth:)) ; health
					((ScriptID 7 7) init: 7) ; egoSleeps
				)
				(= cycles 1)
			)
			(7
				7
				(cond
					(local4
						(switch local0
							(11
								(gMessager say: 10 6 21 0 self) ; "The Domovoi appears in the room beside you."
							)
							(12
								(gMessager say: 10 6 23 0 self) ; "You awaken to find the Domovoi in your room."
							)
							(13
								(gMessager say: 10 6 23 0 self) ; "You awaken to find the Domovoi in your room."
							)
							(else
								(= cycles 1)
							)
						)
					)
					(local5
						(SetFlag 136)
						(if (>= gTime 4)
							(= gTime 6)
							((ScriptID 7 7) init: 1 0 1) ; egoSleeps
						)
						(= global427 5)
						(gMessager say: 10 6 16 0 self) ; "You can hear weeping from somewhere below your room."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				8
				(if local4
					(= gPrevDomoTalkDayNumber gDay)
					(switch local0
						(11
							(SetFlag 154)
							(gMessager say: 12 6 22 0 self) ; "You help okay. Domovoi much wetter now. Maybe help you okay, I will. You fine Hero. You okay."
						)
						(12
							(SetFlag 155)
							(gMessager say: 12 6 28 0 self) ; "Other needs help. Help funny man be funny, you should. Talk to funny man. Talk to Leshy. Maybe even talk to Ogress, too. That Hero business. That your job, okay?"
						)
						(13
							(SetFlag 156)
							(SetFlag 144)
							(gMessager say: 12 6 24 0 self) ; "You help big time, this time. Father very sad. Mother very sad. Go to castle. Find child, you will. Take child to Staff."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(9
				9
				(if (and (not (gCast contains: winPatch)) (>= gTime 4))
					(winPatch init: approachVerbs: 4) ; Do
				)
				(if (== register 2)
					((ScriptID 7 5) init: global402 1) ; egoRests
				)
				(gEgo
					cycleSpeed: 8
					setLoop: 0 1
					setCel: 11
					setCycle: Beg self
				)
			)
			(10
				10
				(gEgo
					normalize: 1
					cycleSpeed: local3
					setMotion: MoveTo 201 146 self
				)
			)
			(11
				11
				(if local4
					(= local4 0)
					(domovoi dispose:)
				)
				(= local5 0)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chestLid of Prop
	(properties
		noun 4
		sightAngle 40
		approachX 93
		approachY 128
		x 130
		y 125
		priority 34
		fixPriority 1
		view 330
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(chest doVerb: theVerb &rest)
	)
)

(instance domovoi of Prop
	(properties
		noun 12
		sightAngle 180
		x 143
		y 115
		view 330
		loop 2
		signal 16385
	)
)

(instance note of View
	(properties
		noun 11
		x 137
		y 110
		priority 121
		fixPriority 1
		view 330
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 152)
				(SetFlag 399)
				(self hide:)
				(if (< global427 9)
					(gMessager say: 11 4 5) ; "The note reads "Please meet me tonight outside the town gates. I will be waiting." It's signed, "Your friend, Katrina.""
				else
					(SetFlag 34)
					(gMessager say: 11 4 6) ; "The note says "Meet me at the castle gates tonight. We have much to talk about.    -- Katrina.""
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of View
	(properties
		heading 180
		noun 4
		x 130
		y 125
		priority 17
		fixPriority 1
		view 330
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			((and (gCast contains: note) (note isNotHidden:))
				(note doVerb: theVerb &rest)
			)
			((OneOf theVerb 4 -80) ; Do, openSpell (part 2)
				(chestLid setScript: sUseChest 0 0)
			)
			(
				(OneOf
					theVerb
					1 ; Look
					2 ; Talk
					85 ; calmSpell
					83 ; dazzleSpell
					81 ; detectMagicSpell
					87 ; fetchSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					102 ; healingSpell
					91 ; jugglingLightsSpell
					89 ; levitateSpell
					93 ; lightningBallSpell
					80 ; openSpell
					90 ; reversalSpell
					94 ; ritualSpell
					92 ; summonStaffSpell
					82 ; triggerSpell
					84 ; zapSpell
					95 ; invisibleSpell
					96 ; auraSpell
					97 ; protectionSpell
					98 ; resistanceSpell
					11 ; glideSpell
					10 ; Jump
				)
				(super doVerb: theVerb &rest)
			)
			(else
				(chestLid setScript: sUseChest 0 theVerb)
			)
		)
	)
)

(instance garlic1 of View
	(properties
		noun 1
		x 37
		y 19
		view 330
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 22) ; theGarlic
					(gMessager say: 1 4 27) ; "You don't need that much garlic. Besides, it lends a certain "air" to the room, don't you think?"
				else
					(gEgo get: 22) ; theGarlic
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garlic2 of View
	(properties
		noun 1
		x 154
		y 19
		view 330
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(garlic1 doVerb: theVerb &rest)
	)
)

(instance rug of View
	(properties
		noun 2
		approachX 145
		approachY 152
		x 79
		y 133
		priority 17
		fixPriority 1
		view 330
		cel 3
		signal 16384
	)
)

(instance winPatch of View
	(properties
		noun 9
		sightAngle 180
		approachX 68
		approachY 141
		x 41
		y 52
		view 330
		loop 5
		signal 16384
	)

	(method (doVerb theVerb)
		(theWindow doVerb: theVerb)
	)
)

(instance candleLight of Prop
	(properties
		noun 6
		x 263
		y 89
		view 330
		loop 6
		cycleSpeed 8
	)

	(method (init)
		(self setCycle: RandCycle)
		(super init: &rest)
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose:)
	)
)

(instance candle of Feature
	(properties
		noun 6
		nsLeft 256
		nsTop 91
		nsRight 270
		nsBottom 106
		sightAngle 180
		approachX 251
		approachY 141
		x 263
		y 98
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 39) ; Do, theFlint
			(if local7
				(= local7 0)
				(candleLight dispose:)
				(gMessager say: 6 4 26) ; "You put the candle out."
			else
				(= local7 1)
				(candleLight init:)
				(gMessager say: 6 4 25) ; "You light the candle."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 7
		nsLeft 80
		nsTop 43
		nsRight 103
		nsBottom 64
		sightAngle 180
		approachX 94
		approachY 131
		x 91
		y 100
		z 47
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 39) ; Do, theFlint
			(if local6
				(= local6 0)
				(gMessager say: 7 4 26) ; "You put out the lamp."
			else
				(= local6 1)
				(gMessager say: 7 4 25) ; "You light the lamp."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 9
		nsLeft 37
		nsTop 48
		nsRight 104
		nsBottom 98
		sightAngle 180
		approachX 68
		approachY 141
		x 70
		y 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(if (== (gEgo trySkill: 11 200) 1) ; climbing
						(gCurRoom setScript: sExitThruWin)
					else
						(gMessager say: 10 6 1 1) ; "It's too dangerous. You'd have to climb over the roof to get out."
					)
				else
					(gMessager say: 10 6 2 1) ; "The townspeople have a poor opinion of people whom they see climbing out of windows and over roofs."
				)
			)
			(33 ; theGrapnel
				(if gNight
					(gCurRoom setScript: sExitThruWin)
				else
					(gMessager say: 10 6 2 1) ; "The townspeople have a poor opinion of people whom they see climbing out of windows and over roofs."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bedPost of Feature
	(properties
		noun 8
		nsLeft 170
		nsTop 104
		nsRight 181
		nsBottom 140
		sightAngle 180
		x 175
		y 122
	)
)

(instance bed of Feature
	(properties
		noun 5
		nsLeft 116
		nsTop 94
		nsRight 245
		nsBottom 128
		sightAngle 180
		approachX 201
		approachY 146
		x 180
		y 109
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGoToBed 0 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bedHead of Feature
	(properties
		noun 5
		nsLeft 183
		nsTop 73
		nsRight 254
		nsBottom 99
		sightAngle 180
		x 218
		y 86
	)
)

