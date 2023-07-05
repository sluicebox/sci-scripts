;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
	Rex 39
)

(local
	local0
	local1
	local2
)

(instance rm480 of LBRoom
	(properties
		noun 1
		picture 480
		north 430
	)

	(method (init)
		(LoadMany rsVIEW 423 424 741 426 482 442 483 481 480 831)
		(LoadMany rsSOUND 52 483 480 481 482)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 110 0 190 0
		)
		(if (== gAct 5)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2480 0) doit: (gCurRoom obstacles:)) ; poly2480Code
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(switch gPrevRoomNum
			(north
				(gEgo x: 138 y: 121)
				(gCurRoom setScript: sEnterNorth)
			)
			(740
				(gCurRoom setScript: sChaseSequence)
				(lump init:)
				(rexMouth approachVerbs: 4 1 init:) ; Do, Look
				(gEgo hide:)
				(steve init: hide:)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(signButton approachVerbs: 1 4 init:) ; Look, Do
		(painting init:)
		(dino init:)
		(rexMouth approachVerbs: 4 1) ; Do, Look
		(rex approachVerbs: 4 1 init:) ; Do, Look
		(if (not (gEgo has: 18)) ; dinoBone
			(bone init: stopUpd:)
		)
		(dinoBones approachVerbs: 4 1 init:) ; Do, Look
		(gNarrator x: 10 y: 10)
	)

	(method (handleEvent event)
		(if
			(and
				(gNarrator modeless:)
				(or
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_ESCAPE KEY_RETURN)
					)
					(and (== (event type:) evMOUSEBUTTON) (not (event modifiers:)))
				)
			)
			(event claimed: 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(if local1
			(sWrapMusic dispose: 1)
		)
		(DisposeScript 2480)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gCurRoom script:) sChaseSequence) (StepOn gEgo 2))
				((self script:) cue:)
			)
			(script)
			((StepOn gEgo 2)
				(self setScript: sExitNorth)
			)
			((StepOn gEgo 4)
				(self setScript: sAroundTRexCCW)
			)
			((StepOn gEgo 32)
				(self setScript: sAroundTRexCW)
			)
			((StepOn gEgo 16)
				(self setScript: sAroundDinoCCW)
			)
			((StepOn gEgo 8)
				(self setScript: sAroundDinoCW)
			)
		)
	)

	(method (notify)
		(if (== gAct 5)
			(if (gCurRoom script:)
				((gCurRoom script:) next: sCaughtYou)
			else
				(gCurRoom setScript: sCaughtYou)
			)
		)
	)
)

(instance sCaughtYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oriley
					init:
					view: 423
					posn: 137 122
					setPri: -1
					setCycle: Walk
					setScale: Scaler 110 0 160 0
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 219 179 self)
			)
			(3
				(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				(oriley setMotion: MoveTo 169 124 self)
			)
			(4
				(oriley setMotion: PolyPath 196 173 self)
			)
			(5
				(Face gEgo oriley)
				(= cycles 3)
			)
			(6
				(oriley view: 424 cel: 0 setCycle: End self)
			)
			(7
				(noise number: 80 flags: 5 loop: 1 play:)
				(gEgo view: 858 setCycle: End self)
			)
			(8
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sChaseSequence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 482)
				(Load rsSOUND 480)
				(gGameMusic2 stop:)
				(gGameMusic1 number: 482 loop: -1 flags: 1 play:)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(rexMouth setCycle: End self)
				(noise number: 480 flags: 5 play:)
			)
			(2
				(if (IsFlag 46)
					(self setScript: sRatsFall self)
				else
					(= cycles 1)
				)
			)
			(3
				(lump cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					show:
					view: 482
					setLoop: 3
					yStep: 8
					cel: 0
					posn: 184 141
					setPri: 12
					setCycle: Fwd
					setMotion: MoveTo 179 160 self
				)
			)
			(5
				(gEgo setLoop: 0 setCycle: End self)
				(= local2 (gEgo moveSpeed:))
			)
			(6
				(gEgo
					view: 831
					setLoop: 6
					yStep: 2
					posn: 171 158
					setCycle: Rev
					setSpeed: 10
					setMotion: MoveTo 165 162 self
				)
			)
			(7
				(lump cel: 0 setCycle: End self)
			)
			(8
				(steve show: setCel: 0 yStep: 8 setLoop: 1)
				(= cycles 1)
			)
			(9
				(steve setMotion: MoveTo 179 160 self)
			)
			(10
				(gEgo normalize: 426 setSpeed: local2)
				(signButton approachX: 296 approachY: 189 approachVerbs: 4 1) ; Do, Look
				(steve posn: 179 160 setCycle: End self)
			)
			(11
				(steve setLoop: 1 setMotion: MoveTo 160 158 self)
			)
			(12
				(gGame handsOn:)
				(= seconds 20)
			)
			(13
				(gGame handsOff:)
				(oriley init: setScale: Scaler 110 0 190 0 hide:)
				(if local0
					(self setScript: sOrileyCaught)
				else
					(self setScript: sKillThem)
				)
			)
		)
	)

	(method (doit)
		(if (and (== (self state:) 12) local0)
			(gGame handsOff:)
			(self cue:)
		)
		(super doit:)
	)
)

(instance sOrileyCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 1 138)
				(rexMouth setCycle: End self)
			)
			(1
				(lump cel: 0 setCycle: End self)
			)
			(2
				(rexMouth setCycle: End self)
				(noise number: 480 flags: 5 play:)
			)
			(3
				(oriley show:)
				(= cycles 1)
			)
			(4
				(gGameMusic1 stop:)
				(oriley setLoop: 0 setMotion: MoveTo 181 121 self)
				(rexMouth setCycle: End self)
			)
			(5
				(= local1 1)
				(WrapMusic pause: 1)
				(sWrapMusic init: 0 1481 483)
				0
			)
			(6
				(rexMouth setCycle: Beg self)
				(oriley setCycle: End)
			)
			(7
				(oriley setCycle: CT 3 -1 self)
			)
			(8
				(oriley setCycle: End self)
			)
			(9
				(= seconds 2)
				(steve ignoreActors: 1)
			)
			(10
				(gEgo setMotion: PolyPath 169 141 self)
			)
			(11
				(= seconds 1)
			)
			(12
				(gEgo view: 483 loop: 13 cel: 0 setCycle: End self)
			)
			(13
				(= seconds 3)
			)
			(14
				((ScriptID 22 0) doit: $0002) ; triggerAndClock
				(gGame points: 1 151)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 485)
				(= seconds 5)
			)
			(15 0)
			(16
				(WrapMusic pause: 0)
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (localSound number:) 483)
				(== (localSound prevSignal:) -1)
				(== (self state:) 15)
			)
			(self cue:)
		)
		(super doit:)
	)
)

(instance sKillThem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				(= cycles 1)
			)
			(1
				(lump cel: 0 setCycle: End self)
			)
			(2
				(oriley setLoop: 1 posn: 186 141 show:)
				(= cycles 1)
			)
			(3
				(oriley setCycle: End self)
			)
			(4
				(noise number: 52 flags: 5 loop: 1 play:)
				(oriley setLoop: 5 posn: 177 143 setCycle: End self)
			)
			(5
				(steve
					view: 483
					loop: 10
					cel: 0
					posn: 125 169
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(6
				(gGameMusic1 fade:)
				(cond
					((<= (gEgo x:) 131)
						(oriley setLoop: 5)
					)
					((and (<= (gEgo x:) 172) (>= (gEgo y:) 161))
						(oriley setLoop: 5)
					)
					((and (> (gEgo x:) 172) (>= (gEgo y:) 159))
						(oriley setLoop: 6)
					)
					((> (gEgo x:) 320)
						(oriley setLoop: 6)
					)
					((and (>= (gEgo x:) 180) (<= (gEgo y:) 141))
						(oriley setLoop: 7)
					)
					(else
						(oriley setLoop: 8)
					)
				)
				(oriley setCycle: End self)
				(noise number: 52 flags: 5 loop: 1 play:)
			)
			(7
				(= global145 10) ; "You'll get nowhere with that holier-than-thou attitude."
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sGetDinoBoneFromInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(inBone dispose:)
				(bone dispose:)
				(= cycles 1)
			)
			(1
				(gGame points: 1 139)
				(gEgo get: 18) ; dinoBone
				((ScriptID 21 0) doit: 787) ; addCluesCode, Dinosaur Bone
				(self dispose:)
			)
		)
	)
)

(instance sGetDinoBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo view: 481 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
				(bone dispose:)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo view: 831 loop: 7)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(gEgo normalize: (if (== gAct 5) 426 else 831) get: 18) ; dinoBone
				((ScriptID 21 0) doit: 787) ; addCluesCode, Dinosaur Bone
				(gGame points: 1 139)
				(self dispose:)
			)
		)
	)
)

(instance sRexTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canControl: 0)
				(gGame setCursor: gWaitCursor)
				(gEgo setHeading: 0)
				(rexMouth init:)
				(= seconds 2)
			)
			(1
				(gGame points: 1 138)
				(rexMouth setCycle: RandCycle)
				(gNarrator modeless: 1)
				(gMessager say: 5 4 2 0 self) ; "Welcome to the Leyendecker Museum dinosaur display. My name is Rex, and I'd like to tell you about myself. I'm a type of dinosaur known as Tyrannosaurus Rex, which means, "King of the Tyrant Lizards.""
				(noise number: 480 flags: 5 play:)
				(gEgo setMotion: PolyPath 255 184 self)
			)
			(2 0)
			(3
				(gNarrator modeless: 0 dispose: 1)
				(rexMouth stopUpd: setCycle: 0 cel: 0)
				(= cycles 5)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRatsFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat1 init:)
				(= cycles 1)
			)
			(1
				(rat2 init:)
				(rat1 setLoop: 1 yStep: 7 setMotion: MoveTo 185 157 self)
			)
			(2
				(rat2 setLoop: 1 yStep: 7 setMotion: MoveTo 186 152 self)
				(rat1
					setLoop: 8
					cel: 1
					posn: 175 155
					setMotion: MoveTo 219 200 self
				)
			)
			(3 0)
			(4
				(rat1 setLoop: 1 posn: 204 93 setMotion: MoveTo 185 157 self)
				(rat2
					setLoop: 8
					cel: 1
					posn: 171 160
					setMotion: MoveTo 228 200 self
				)
			)
			(5 0)
			(6
				(rat1
					setLoop: 8
					cel: 1
					posn: 175 155
					setMotion: MoveTo 219 200 self
				)
			)
			(7
				(= seconds 1)
			)
			(8
				(rat1 dispose:)
				(rat2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 174 125 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 138 121 self)
			)
			(2
				(if
					(and
						(== gAct 3)
						(TimeCheck $b102 1) ; can 11:15 pm occur?
						(not (IsFlag 72))
					)
					(gCurRoom newRoom: 435)
				else
					(gCurRoom newRoom: (gCurRoom north:))
				)
			)
		)
	)
)

(instance sAroundTRexCCW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 320 110 self)
			)
			(2
				(gEgo setMotion: PolyPath 220 119 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAroundTRexCW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 320 110 self)
			)
			(2
				(gEgo setMotion: PolyPath 234 181 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAroundDinoCCW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setPri: 15 setMotion: PolyPath 145 250 self)
			)
			(2
				(gEgo setMotion: PolyPath 234 181 self)
			)
			(3
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAroundDinoCW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 225 250 self)
			)
			(2
				(gEgo setPri: 15 setMotion: PolyPath 9 176 self)
			)
			(3
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookBones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 7 1 0 0 self) ; "A sign on this dinosaur bone display says: "PLEASE TOUCH." Either these bones feel lonely, or the museum wants you to learn more about the bones by coming into close personal contact with them."
			)
			(1
				(gCurRoom setInset: inBone)
				(self dispose:)
			)
		)
	)
)

(instance rexMouth of Prop
	(properties
		x 230
		y 59
		noun 3
		approachX 160
		approachY 160
		view 482
		loop 2
		priority 12
		signal 17
	)
)

(instance bone of View
	(properties
		x 32
		y 128
		view 481
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(dinoBones doVerb: &rest)
	)
)

(instance dinoBones of Feature
	(properties
		x 1
		y 140
		noun 7
		nsTop 128
		nsLeft 20
		nsBottom 145
		nsRight 65
		sightAngle 40
		approachX 56
		approachY 152
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((gEgo has: 18) ; dinoBone
						(gMessager say: 7 1 1) ; "The remaining bones are too small to hold your interest."
					)
					((== (gCurRoom script:) sChaseSequence)
						(gMessager say: 9 1 5) ; "There's no time for sightseeing right now! Someone's trying to kill you!"
					)
					(else
						(gCurRoom setScript: sLookBones)
					)
				)
			)
			(4 ; Do
				(cond
					((gEgo has: 18) ; dinoBone
						(gMessager say: 7 4 1) ; "Don't be greedy. You can't fit more than one of these huge bones into your little purse."
					)
					((== (gCurRoom script:) sChaseSequence)
						(gMessager say: 9 4 5) ; "There's no time for that right now! Someone's trying to kill you!"
					)
					(else
						(gCurRoom setScript: sGetDinoBone)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inBone of Inset
	(properties
		view 480
		x 2
		y 121
		disposeNotOnMe 1
		modNum 15
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetDinoBoneFromInset)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 191
		y 113
		view 483
		cel 3
		priority 12
		signal 16
	)
)

(instance steve of Actor
	(properties
		x 185
		y 142
		noun 8
		view 482
		loop 1
		priority 12
		signal 16
	)
)

(instance lump of Prop
	(properties
		x 258
		y 75
		noun 2
		view 480
		loop 1
		priority 12
		signal 16
	)
)

(instance rat1 of Actor
	(properties
		x 204
		y 93
		yStep 4
		view 741
		loop 1
		priority 12
		signal 16400
		xStep 4
	)
)

(instance rat2 of Actor
	(properties
		x 200
		y 90
		yStep 4
		view 741
		loop 1
		priority 12
		signal 16400
		xStep 4
	)
)

(instance signButton of Feature
	(properties
		x 296
		y 148
		noun 5
		nsTop 143
		nsLeft 290
		nsBottom 154
		nsRight 303
		sightAngle 40
		approachX 258
		approachY 181
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gCurRoom script:) sChaseSequence)
					(= local0 1)
				else
					(gCurRoom setScript: sRexTalks)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 71
		y 90
		noun 4
		nsTop 53
		nsLeft 18
		nsBottom 128
		nsRight 124
		sightAngle 40
	)
)

(instance dino of Feature
	(properties
		y 100
		noun 6
		onMeCheck 8192
	)
)

(instance rex of Feature
	(properties
		x 277
		y 149
		noun 2
		onMeCheck 16416
		approachX 160
		approachY 160
	)
)

(instance Rex of Narrator
	(properties
		x 10
		y 10
		talkWidth 150
		modeless 1
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance noise of Sound
	(properties)
)

(instance sWrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound localSound)
		(super init: &rest)
	)
)

(instance localSound of Sound
	(properties)
)

