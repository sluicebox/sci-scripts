;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use Interface)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	local0
	local1
)

(instance rm680 of GloryRm
	(properties
		picture 680
		west 628
	)

	(method (init)
		(if gDebugging
			(= local0 (GetNumber {Event #?}))
		else
			(= local0 (if (not (IsFlag 232)) 1 else 0))
		)
		(gLongSong number: 680 setLoop: -1 play:)
		(RemapColors 2 253 140) ; ByPercent
		(RemapColors 2 254 60) ; ByPercent
		(gEgo
			posn: 163 42
			init:
			setScaler: Scaler 105 52 154 35
			normalize: 5
		)
		(pCoffinLid init: approachVerbs: 4) ; Do
		(pKatrina init: approachVerbs: 4 hide:) ; Do
		(fireSound play:)
		(pTorch1 setCycle: Fwd init:)
		(pTorch2 setCycle: Fwd init:)
		(pTorch3 setCycle: Fwd init:)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 619 -300 619 489 302 489 162 178 147 166 161 151 189 142 223 145 224 143 186 139 156 139 145 152 85 159 39 86 194 34 191 29 189 28 23 83 32 150 39 489 -300 489
					yourself:
				)
		)
		(fSconce1 init: approachVerbs: 4) ; Do
		(fSconce2 init: approachVerbs: 4) ; Do
		(fSconce3 init: approachVerbs: 4) ; Do
		(fShield init: approachVerbs: 4) ; Do
		(fMirror init: approachVerbs: 4) ; Do
		(fChair init: approachVerbs: 4) ; Do
		(fDesk init: approachVerbs: 4) ; Do
		(fStatue1 init: approachVerbs: 4) ; Do
		(fStatue2 init: approachVerbs: 4) ; Do
		(fPlant1 init: approachVerbs: 4) ; Do
		(fPlant2 init: approachVerbs: 4) ; Do
		(fCurtain1 init: approachVerbs: 4) ; Do
		(fUrn1 init: approachVerbs: 4) ; Do
		(fUrn2 init: approachVerbs: 4) ; Do
		(fCoffin init: approachVerbs: 4) ; Do
		(fTassles init: approachVerbs: 4) ; Do
		(fCurtain2 init: approachVerbs: 4) ; Do
		(fBedCurtain init: approachVerbs: 4) ; Do
		(fRoom init:)
		(fDoor init:)
		(gCurRoom setScript: sEnter)
		(katrinaTeller init: pKatrina 680 18 4)
		(gGlory save: 1)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not local1)
			(switch theVerb
				(86 ; flameDartSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(93 ; lightningBallSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(88 ; forceBoltSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(37 ; theThrowdagger
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(91 ; jugglingLightsSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(21 ; theRocks
					(gEgo use: 6) ; theRocks
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
				(1 ; Look
					(gMessager say: 1 1 0 0) ; "You are in a lady's richly-decorated bedroom. The coffin where there should be a bed seems a bit out of place, but there's no accounting for tastes."
				)
				(171 ; theHammer
					(gCurRoom setScript: sKatrinaKilled)
				)
				(170 ; theStake
					(gCurRoom setScript: sKatrinaKilled)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(171 ; theHammer
					(gCurRoom setScript: sKatrinaKilled)
				)
				(170 ; theStake
					(gCurRoom setScript: sKatrinaKilled)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				local1
				(not (event modifiers:))
				(OneOf (event type:) evKEYBOARD evMOUSEBUTTON)
				(not (gCurRoom script:))
			)
			(cond
				((== ((gTheIconBar getCursor:) view:) 942)
					(event claimed: 1)
					(katrinaTeller doVerb: 4)
				)
				(
					(and
						(== ((gTheIconBar getCursor:) view:) 905)
						(== ((gTheIconBar getCursor:) loop:) 4)
						(or
							(== ((gTheIconBar getCursor:) cel:) 6)
							(== ((gTheIconBar getCursor:) cel:) 7)
						)
					)
					(event claimed: 1)
					(gCurRoom setScript: sKatrinaKilled)
				)
				(else
					(event claimed: 1)
					(gCurRoom setScript: sKatrinaMad)
				)
			)
		else
			(event claimed: 0)
			(super handleEvent: event &rest)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 24)
			)
			(1
				(gEgo setMotion: PolyPath 102 165 self)
			)
			(2
				(gEgo normalize:)
				(if (== local0 1)
					(gMessager say: 15 6 1 1 self) ; "You are in a lady's richly-decorated bedroom. The coffin where there should be a bed seems a bit out of place, but there's no accounting for tastes."
				else
					(self cue:)
				)
			)
			(3
				(if (and (== gHeroType 3) (== local0 1)) ; Paladin
					(gMessager say: 15 6 2 1 self) ; "You sense deadly danger here... to your body and your soul."
				else
					(self cue:)
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTo670 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(fDoor approachX:)
						(fDoor approachY:)
						self
				)
			)
			(1
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance sBringUpInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setLoop: 4 1)
				(openSound play:)
				(pCoffinLid setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(= local1 1)
				(gCast eachElementDo: #hide)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(self cue:)
			)
			(3
				(vMyInset posn: 58 38 ignoreActors: 1 init:)
				(gEgo
					view: 612
					setLoop: 0 1
					setCel: 0
					posn: 132 166
					setPri: 163
					ignoreActors: 1
					setCycle: 0
					setScaler: Scaler 100 100 189 0
					show:
				)
				(gGlory handsOn:)
				(gUser canInput: 0)
				(self dispose:)
			)
		)
	)
)

(instance sKatrinaKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if
					(and
						(!= (gEgo view:) 612)
						(or
							(!= (gEgo x:) (fCoffin x:))
							(!= (gEgo y:) (fCoffin y:))
						)
					)
					(gEgo setMotion: PolyPath (fCoffin x:) (fCoffin y:) self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(vMyInset hide: dispose:)
				(gEgo hide:)
				(gMessager say: 18 4 4 1 self) ; "Taking a deep breath, you place the stake over the Vampire's black heart and pound it in with three mighty blows of the hammer."
			)
			(4
				(gEgo
					posn: 237 147
					normalize:
					show:
					setScaler: Scaler 105 52 154 35
				)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 680 0)
				(= seconds 2)
			)
			(5
				(gMessager say: 15 6 9 1 self) ; "You stare at the lifeless corpse in the coffin. You never thought that killing a Vampire would be anywhere near this easy."
			)
			(6
				(pAdavis init: setCycle: End self)
			)
			(7
				(= ticks 60)
			)
			(8
				(gMessager say: 17 6 10 1 self) ; "At last, I am free of her dominion over me! You did precisely what I wanted you to do -- destroy Katrina. So nice of you to cooperate with me."
			)
			(9
				(pAdavis
					view: 674
					setLoop: 0 1
					setCel: 0
					posn: 89 156
					setCycle: End self
				)
			)
			(10
				(pAdavis setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(11
				(spellSound play:)
				(pAdavis setCycle: Beg)
				(aProjectile init: setCycle: End self)
			)
			(12
				(aProjectile hide: dispose:)
				(gEgo
					view: 672
					setLoop: 0 1
					posn: 214 145
					cycleSpeed: 12
					setCycle: End
				)
				(pAdavis
					setLoop: 0 1
					setCel: 15
					cycleSpeed: 10
					setCycle: CT 12 -1 self
				)
			)
			(13
				(pAdavis setCycle: CT 15 1 self)
			)
			(14
				(pAdavis
					setLoop: 0 1
					setCel: 15
					cycleSpeed: 10
					setCycle: CT 12 -1 self
				)
			)
			(15
				(pAdavis setCycle: CT 15 1 self)
			)
			(16
				(pAdavis
					setLoop: 0 1
					setCel: 15
					cycleSpeed: 10
					setCycle: CT 12 -1 self
				)
			)
			(17
				(gEgo hide:)
				(pAdavis setCycle: CT 15 1 self)
			)
			(18
				(EgoDead 11 680) ; "You really helped Ad Avis this time. By getting rid of Katrina, you only turned him loose."
			)
		)
	)
)

(instance sKatrinaKissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 234)
				(= seconds 2)
			)
			(1
				(gMessager say: 18 4 8 1 self) ; "Now's your chance! You lean over the open coffin and kiss Katrina long and hard on the lips."
			)
			(2
				(gCurRoom setScript: sKatrinaMad)
			)
		)
	)
)

(instance sKatrinaWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 18 4 6 1 self) ; "You lean over the coffin and gently shake Katrina awake."
			)
			(1
				(self setScript: sKatrinaMad)
			)
		)
	)
)

(instance sKatrinaFeels of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 18 4 7 0 self) ; "She won't duck away this time! You decide to perform an anatomical survey to prove once and for all whether or not Katrina is in fact a Vampire."
			)
			(1
				(self setScript: sKatrinaMad)
			)
		)
	)
)

(instance sKatrinaMad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 235)
				(vMyInset x: 1000 hide:)
				(gEgo hide:)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(= seconds 2)
			)
			(1
				(gEgo
					posn: 237 147
					show:
					normalize:
					setPri: 142
					setScaler: Scaler 105 52 154 35
				)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 680)
				(= seconds 2)
			)
			(2
				(pCoffinLid setLoop: 5 1 setPri: 143)
				(pKatrina setPri: 144 approachVerbs: 4 show: setCycle: End self) ; Do
			)
			(3
				(gMessager say: 15 6 12 1 self) ; "Suddenly you find yourself totally unable to move."
			)
			(4
				(if (IsFlag 234)
					(gMessager say: 16 6 13 1 self) ; "What? What are you doing here? How did you get in here? You dare to kiss me?"
				else
					(gMessager say: 16 6 14 1 self) ; "You! What are you... How dare you! Try to kill me, will you?"
				)
			)
			(5
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance aProjectile of Actor
	(properties
		x 90
		y 156
		priority 207
		fixPriority 1
		view 674
		loop 2
		signal 16385
	)
)

(instance pCoffinLid of Prop
	(properties
		noun 12
		approachX 218
		approachY 137
		x 245
		y 133
		priority 163
		fixPriority 1
		view 680
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 12 1 0 0) ; "Where a bed would normally be is a closed coffin. It is an ornate affair, apparently custom-designed for someone who expected to be in and out of it frequently."
		else
			(pKatrina doVerb: theVerb)
		)
	)
)

(instance pKatrina of Prop
	(properties
		noun 16
		approachX 218
		approachY 137
		x 236
		y 150
		priority 148
		fixPriority 1
		view 680
		loop 4
		signal 20481
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gCurRoom setScript: sBringUpInset)
			)
			((== theVerb 21) ; theRocks
				(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
			)
			((== theVerb 37) ; theThrowdagger
				(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
			)
			((OneOf 91 79)
				(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pTorch1 of Prop
	(properties
		noun 2
		x 11
		y 13
		view 680
		loop 1
		cel 3
		detailLevel 2
	)
)

(instance pTorch2 of Prop
	(properties
		noun 2
		x 82
		y 11
		view 680
		loop 1
		cel 4
		detailLevel 2
	)
)

(instance pTorch3 of Prop
	(properties
		noun 2
		x 135
		y 8
		view 680
		loop 1
		cel 4
		detailLevel 2
	)
)

(instance pAdavis of Prop
	(properties
		noun 17
		x 88
		y 156
		view 680
		loop 3
	)
)

(instance pBloodyMouth of Prop ; UNUSED
	(properties
		x 131
		y 166
		priority 174
		fixPriority 1
		view 613
		loop 1
		cel 1
		signal 16385
	)
)

(instance vMyInset of View
	(properties
		noun 16
		x 58
		y 38
		view 601
	)
)

(instance fRoom of Feature
	(properties
		noun 1
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 5
		y 10
	)

	(method (doVerb theVerb)
		(if (not local1)
			(switch theVerb
				(86 ; flameDartSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(93 ; lightningBallSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(88 ; forceBoltSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(37 ; theThrowdagger
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(91 ; jugglingLightsSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(84 ; zapSpell
					(gMessager say: 15 6 3) ; "Your attack doesn't seem to affect the coffin in any way."
				)
				(21 ; theRocks
					(gEgo use: 6) ; theRocks
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
				(1 ; Look
					(gMessager say: 1 1 0 0) ; "You are in a lady's richly-decorated bedroom. The coffin where there should be a bed seems a bit out of place, but there's no accounting for tastes."
				)
				(171 ; theHammer
					(gCurRoom setScript: sKatrinaKilled)
				)
				(170 ; theStake
					(gCurRoom setScript: sKatrinaKilled)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(171 ; theHammer
					(gCurRoom setScript: sKatrinaKilled)
				)
				(170 ; theStake
					(gCurRoom setScript: sKatrinaKilled)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance fDoor of Feature
	(properties
		noun 1
		nsLeft 158
		nsTop 1
		nsRight 193
		nsBottom 43
		sightAngle 180
		approachX 175
		approachY 38
		x 193
		y 20
		z 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTo670)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sTo670)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSconce1 of Feature
	(properties
		noun 2
		nsLeft 2
		nsTop -1
		nsRight 29
		nsBottom 32
		sightAngle 180
		x 15
		y 15
	)
)

(instance fSconce2 of Feature
	(properties
		noun 2
		nsLeft 77
		nsRight 97
		nsBottom 30
		sightAngle 180
		x 87
		y 15
	)
)

(instance fSconce3 of Feature
	(properties
		noun 2
		nsLeft 133
		nsRight 149
		nsBottom 21
		sightAngle 180
		x 141
		y 10
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 173 31 210 31 210 40 173 40
						yourself:
					)
					3
					6
					0
					sTo670
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

(instance fShield of Feature
	(properties
		noun 3
		nsLeft 235
		nsTop -1
		nsRight 264
		nsBottom 28
		sightAngle 180
		x 249
		y 84
		z 71
	)
)

(instance fMirror of Feature
	(properties
		noun 4
		nsLeft 151
		nsTop 90
		nsRight 173
		nsBottom 112
		sightAngle 180
		x 162
		y 101
	)
)

(instance fChair of Feature
	(properties
		noun 5
		nsLeft 169
		nsTop 103
		nsRight 186
		nsBottom 133
		sightAngle 180
		x 177
		y 118
	)
)

(instance fDesk of Feature
	(properties
		noun 6
		nsLeft 142
		nsTop 113
		nsRight 173
		nsBottom 122
		sightAngle 180
		x 157
		y 117
	)
)

(instance fStatue1 of Feature
	(properties
		noun 7
		nsTop 136
		nsRight 30
		nsBottom 183
		sightAngle 180
		x 15
		y 159
	)
)

(instance fStatue2 of Feature
	(properties
		noun 7
		nsLeft 116
		nsTop 107
		nsRight 142
		nsBottom 144
		sightAngle 180
		x 129
		y 125
	)
)

(instance fPlant1 of Feature
	(properties
		noun 8
		nsTop 33
		nsRight 30
		nsBottom 136
		sightAngle 180
		x 15
		y 84
	)
)

(instance fPlant2 of Feature
	(properties
		noun 8
		nsLeft 94
		nsTop 61
		nsRight 118
		nsBottom 144
		sightAngle 180
		x 106
		y 102
	)
)

(instance fCurtain1 of Feature
	(properties
		noun 9
		nsLeft 208
		nsTop 52
		nsRight 226
		nsBottom 123
		sightAngle 180
		x 217
		y 87
	)
)

(instance fUrn1 of Feature
	(properties
		noun 10
		nsLeft 253
		nsTop 144
		nsRight 269
		nsBottom 169
		sightAngle 180
		x 261
		y 156
	)
)

(instance fUrn2 of Feature
	(properties
		noun 11
		nsLeft 274
		nsTop 142
		nsRight 292
		nsBottom 168
		sightAngle 180
		x 283
		y 155
	)
)

(instance fCoffin of Feature
	(properties
		noun 12
		nsLeft 210
		nsTop 123
		nsRight 291
		nsBottom 143
		sightAngle 180
		approachX 218
		approachY 137
		x 250
		y 133
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 12 1 0 0) ; "Where a bed would normally be is a closed coffin. It is an ornate affair, apparently custom-designed for someone who expected to be in and out of it frequently."
		else
			(pKatrina doVerb: theVerb)
		)
	)
)

(instance fTassles of Feature
	(properties
		noun 13
		nsLeft 294
		nsRight 319
		nsBottom 91
		sightAngle 180
		x 306
		y 45
	)
)

(instance fCurtain2 of Feature
	(properties
		noun 9
		nsLeft 294
		nsTop 91
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 306
		y 140
	)
)

(instance fBedCurtain of Feature
	(properties
		noun 14
		nsLeft 222
		nsRight 299
		nsBottom 143
		sightAngle 180
		x 260
		y 71
	)
)

(instance katrinaTeller of Teller
	(properties
		title 1
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 4 (and (gEgo has: 50) (gEgo has: 49))) ; Kill Katrina, theStake, theHammer
	)

	(method (sayMessage)
		(switch iconValue
			(6 ; Awaken Katrina
				(self clean:)
				(gCurRoom setScript: sKatrinaWakes)
			)
			(7 ; Cop a Feel
				(self clean:)
				(gCurRoom setScript: sKatrinaFeels)
			)
			(4 ; Kill Katrina
				(self clean:)
				(gCurRoom setScript: sKatrinaKilled)
			)
			(8 ; Kiss Katrina
				(self clean:)
				(gCurRoom setScript: sKatrinaKissed)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance fireSound of Sound
	(properties
		number 965
		loop -1
	)
)

(instance openSound of Sound
	(properties
		number 972
	)
)

(instance spellSound of Sound
	(properties
		number 934
	)
)

