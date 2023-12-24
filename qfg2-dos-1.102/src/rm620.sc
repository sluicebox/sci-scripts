;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Stage)
(use TargActor)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm620 0
)

(local
	[pts1 34] = [66 106 139 105 162 97 193 96 187 104 201 104 238 115 227 127 197 129 181 136 165 135 159 139 143 139 118 131 94 128 120 126 104 116]
	[pts2 20] = [0 54 62 76 58 63 32 44 0 30 0 26 39 38 94 57 55 29 0 5]
	[pts3 12] = [319 56 303 54 283 74 298 67 307 67 319 73]
	[pts4 8] = [318 94 245 136 248 145 319 117]
	[pts5 30] = [118 2 111 9 134 29 161 2 175 39 177 2 209 34 250 4 259 35 263 19 255 4 299 38 296 18 316 18 304 2]
	[pts6 10] = [89 94 88 104 95 111 106 111 109 97]
	[pts7 12] = [177 4 190 48 192 86 204 85 198 44 176 2]
	[pts8 12] = [250 6 230 56 225 80 214 88 221 53 236 17]
	[pts9 6] = [319 137 287 188 320 189]
	[pts10 6] = [0 114 47 189 0 189]
	[pts11 32] = [0 0 1 5 50 26 61 22 84 22 106 30 136 29 159 21 182 26 220 26 230 30 254 28 270 32 304 32 320 33 319 0]
	[pts12 8] = [225 37 225 43 233 53 236 45]
	[pts13 8] = [220 50 216 57 229 71 234 63]
	[pts14 12] = [216 72 211 80 210 88 220 99 221 91 215 86]
	[pondPts 28] = [232 93 251 102 254 113 235 129 163 142 122 140 75 127 99 122 55 107 127 102 149 94 185 92 194 73 230 76]
	[dervishGenList 33] = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 0 22 23 24 25 26 27 28 0 29 30 31]
	[dervishSpecList 54] = [32 '//water' 33 '//palm,tree' 34 '//peanut,nut,hero' 35 '//freedom,temper' 36 '//saurii,reflection' 37 '//oasis,oasis,(say<wise)' 38 '//beard,whirl' 39 '//glory,errand,fable' 40 '//puzzle,w,enlightenment' 41 '//water' 42 '//griffin' 43 '//scorpion' 44 '//bandit' 45 '//dinosaur,(saurii<terror,cero)' 46 '//man<jackal' 47 '//ghoul' 48 '//time,nap,rest,night,day' 49 '//beast,birdcage,creature' 50 '//trouble' 51 '//where,location,distance' 52 '//what' 53 '//when,time' 54 '//why,reason' 56 '//how' 57 '//never,soon' 58 '//skareen,screen' 0 0]
	[enterSaying 13] = [{Day zero} {Man who go about in desert sun soon find himself Medium well} {He who turns to run away sometimes find knife in back} {Freedom is like temper} {If fire burns too bright, put damper on lamp} {Your saurus is like reflection in pool} {He who seeks answers must first ask right questions} {Early to bed and early to rise make Jack dull boy} {Quest for glory is like same old story} {Man who eat cookies in bed wake up with crumbs} {He who knows what evil lurks in the hearts of men has Shadow of doubt} {Oasis like wise saying} {Man who talk without thinking have foot-in-mouth disease}]
	[str 100]
	[ripple 6]
	[rippleX 6] = [191 217 133 174 117 150]
	[rippleY 6] = [106 124 108 98 130 136]
	[rippleLoop 7] = [3 4 4 5 5 5 0]
	onlyOnce
	thatsOne
	throwOne
	attackedOnce
	waterGotten
	[unused 3]
	saurus
	gettingOnOff
	entering
)

(procedure (AddRipples &tmp I)
	(for ((= I 0)) (< I 6) ((++ I))
		((= [ripple I] (aRipple new:))
			setLoop: [rippleLoop I]
			cel: 0
			ignoreActors: 1
			x: [rippleX I]
			y: [rippleY I]
			init:
		)
		(if (<= gHowFast 1)
			([ripple I] addToPic:)
		else
			([ripple I] setCycle: Fwd)
		)
	)
)

(instance rm620 of Stage
	(properties
		picture 620
		style 7
		north 665
		east 665
		south 665
		west 665
		topExit 3
		bottomFromX 160
		bottomFromY 200
		bottomExit 1
		bottomToX 160
		bottomToY 155
		rightFromX 340
		rightFromY 140
		rightExit 4
		rightToX 280
		rightToY 140
		leftFromX -40
		leftFromY 140
		leftExit 2
		leftToX 50
		leftToY 140
	)

	(method (dispose)
		(SetFlag 174) ; fSawDervish
		(gCSound stop:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 625 621 11 47 15 14)
		(Load rsTEXT 625)
		(Load rsSCRIPT 985)
		(self setRegions: 660) ; desertReg
		(= saurus (ScriptID 660 1)) ; saurus
		(if (or (not (IsFlag 28)) (not (== gRoomExitDir 1))) ; fTeleporting
			(gEgo init:)
		)
		(NormalEgo)
		(AddRipples)
		(dervBod init:)
		(dervish init:)
		(dervishReflection init:)
		(if (== gHowFast 0)
			(dervishReflection addToPic:)
		else
			(dervishReflection setCycle: Fwd)
		)
		(if (IsFlag 28) ; fTeleporting
			(= inOut 3)
		)
		(if (== gRoomExitDir 1)
			(= inOut 3)
		)
		(if gNight
			(= global61 1)
		else
			(= global61 0)
		)
		(= gSpellChecker gAllChecker)
		(super init:)
		(= global76 1)
		(poly1 points: @pts1 size: 17)
		(poly2 points: @pts2 size: 10)
		(poly3 points: @pts3 size: 6)
		(poly4 points: @pts4 size: 4)
		(poly5 points: @pts5 size: 15)
		(poly6 points: @pts6 size: 5)
		(poly7 points: @pts7 size: 6)
		(poly8 points: @pts8 size: 6)
		(poly9 points: @pts9 size: 3)
		(poly10 points: @pts10 size: 3)
		(poly11 points: @pts11 size: 16)
		(poly12 points: @pts12 size: 4)
		(poly13 points: @pts13 size: 4)
		(poly14 points: @pts14 size: 6)
		(pondPoly points: @pondPts size: 14)
		(self addObstacle: pondPoly)
		(InitFeatures plant pond frond beard trunk sky everythingElse)
		(gCSound number: 620 loop: -1 priority: 2 playBed:)
		(cond
			((IsFlag 28) ; fTeleporting
				(gEgo posn: 160 160 loop: 2 init:)
			)
			((== gRoomExitDir 1)
				(gEgo posn: 271 68 loop: 2 init: setScript: (ScriptID 660 2)) ; duneIn
			)
			(else
				(= entranceScript saySumpin)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(not (or (== gEgoGait 3) gettingOnOff onlyOnce entering)) ; riding
					(<= (gEgo distanceTo: dervish) 75)
				)
				(= onlyOnce 1)
				(cond
					((and (>= gDay 12) (not (IsFlag 645)))
						(Say dervish 620 0) ; "To the west of Shapeir and north of here stands a puzzle. Five W's."
					)
					((not (IsFlag 169)) ; fDervishPeanutMsg
						(SetFlag 169) ; fDervishPeanutMsg
						(Say dervish 620 1) ; "Hero business like eating peanuts."
						(if (gCast contains: saurus)
							(saurus setScript: waterSaurus)
						)
					)
				)
			)
			(script
				(script doit:)
			)
			((gEgo script:))
			((& (gEgo onControl:) $0004)
				(gEgo setScript: (ScriptID 660 3)) ; duneOut
			)
			((and (< (gEgo y:) 74) (!= (gEgo priority:) 4))
				(gEgo setPri: 4)
			)
			(
				(and
					(> (gEgo y:) 74)
					(& (gEgo signal:) $0010)
					(!= script (ScriptID 660 3)) ; duneOut
				)
				(gEgo setPri: -1)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (handleEvent event &tmp saurusCheck)
		(cond
			((super handleEvent: event))
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if (not (gEgo has: 16)) ; Rope
					(LowPrint 620 2) ; "You don't have a rope."
				else
					(LowPrint 620 3) ; "You don't need to use the rope here."
				)
			)
			((or (Said 'cast') (Said 'throw'))
				(cond
					((and (> (gEgo x:) 165) (< (gEgo y:) 120))
						(LowPrint 620 4) ; "You really don't want to do that here."
					)
					((== gEgoGait 3) ; riding
						(gEgo setScript: thrownForLoop)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 620 5) ; "The oasis looks blue and cool. You're not so sure about the character attached to the palm tree. Cool, maybe."
			)
			((or (Said 'drink') (Said 'get,get,fill/water,waterbag'))
				(if (== gEgoGait 3) ; riding
					(HighPrint 620 6) ; "You can't do that on a saurus."
				else
					(gEgo setScript: waterSlammin)
				)
			)
			((Said 'rest')
				(HighPrint 620 7) ; "Yes, this does seem like a nice place for a short nap."
				(EgoRests 1)
				(ClearFlag 3) ; fThirsty
				(ClearFlag 137) ; fDyingOfThirst
			)
			((Said 'nap')
				(HighPrint 620 8) ; "This does seem like a good place. You curl up near the pool, and soon fall asleep."
				(if gNight
					(EgoSleeps 5 0)
					(HighPrint 620 9) ; "You awaken at dawn, much refreshed."
				else
					(EgoSleeps 20 0)
					(HighPrint 620 10) ; "You awaken just after sunset, much refreshed."
				)
				(ClearFlag 3) ; fThirsty
				(ClearFlag 137) ; fDyingOfThirst
			)
			((Said 'tell,hello')
				(Say dervish 620 11) ; "Quest for Glory is like same old story."
			)
			((Said 'attack[/dervish]')
				(cond
					((== thatsOne 0)
						(Say dervish 620 12) ; "Man who keep one hand on weapon have difficulty walking in public."
					)
					((== thatsOne 1)
						(SetFlag 70) ; fDervishCurse
						(Say dervish 620 13) ; "Man who wrongfully attack peaceful dervish will soon find himself up to his earlobes in wrongful attacks."
					)
					(else
						(HighPrint 620 14) ; "It appears that not only will he not fight with you, your attacks do him no harm."
					)
				)
				(++ thatsOne)
			)
		)
	)
)

(instance pondPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance aRipple of Prop
	(properties
		x 191
		y 106
		noun '/ripple'
		description {ripples}
		lookStr {The water ripples with the desert wind.}
		view 625
		loop 3
		priority 4
		signal 24592
		cycleSpeed 1
	)
)

(instance drinkRipple of Prop
	(properties
		x 157
		y 108
		shiftClick 0
		view 625
		loop 7
	)
)

(instance drinkRipExt of Prop
	(properties
		x 161
		y 114
		shiftClick 0
		view 625
		loop 4
	)
)

(instance saurusReflection of Prop
	(properties
		x 132
		y 118
		noun '/reflection[<saurii]'
		description {the saurus'reflection}
		lookStr {The reflection of the saurus proves that he is not a vampire.}
		view 621
		loop 2
	)
)

(instance drinkingHead of Prop
	(properties
		x 146
		y 92
		noun '/saurii,(head<saurii)'
		description {the drinking saurus}
		lookStr {That's one thirsty saurus.}
		view 621
		loop 1
		signal 16384
	)
)

(instance dervBod of TargActor
	(properties
		x 226
		y 107
		description {the Dervish}
		lookStr {This guy looks like he's been in the desert too long.}
		view 625
		cel 1
		priority 7
		signal 24593
		illegalBits 0
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (hurtMe)
		(HighPrint 620 15) ; "Your attacks seem unable to hurt the dervish."
		(return 0)
	)
)

(instance dervish of Talker
	(properties
		x 225
		y 92
		description {the Dervish}
		lookStr {This guy looks like he's been in the desert too long.}
		view 625
		loop 1
		priority 8
		signal 24592
		illegalBits 0
		tLoop 1
		talkSpeed 0
		myName '//dervish,man'
		title {Dervish:}
		back 11
		msgFile 625
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(Say dervish 620 16) ; "If you want right answer, ask right person."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (hurtMe)
		(cond
			((== throwOne 0)
				(Say dervish 620 17) ; "He who attacks without cause soon attracts without pause."
			)
			((== throwOne 1)
				(SetFlag 70) ; fDervishCurse
				(Say dervish 620 13) ; "Man who wrongfully attack peaceful dervish will soon find himself up to his earlobes in wrongful attacks."
			)
			(else
				(HighPrint 620 14) ; "It appears that not only will he not fight with you, your attacks do him no harm."
			)
		)
		(++ throwOne)
		(super hurtMe:)
	)

	(method (showText what)
		(if (== what 49)
			(SolvePuzzle 641 5)
		)
		(super showText: what &rest)
	)

	(method (atSpec which)
		(return [dervishSpecList which])
	)

	(method (atGen which)
		(return [dervishGenList which])
	)

	(method (messages)
		(dervBod cycleSpeed: 1 setCycle: CT 2 1 dervBod)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(self setCycle: Beg)
		(if (dervBod cel:)
			(dervBod cycleSpeed: 1 setCycle: Beg dervBod)
		)
	)
)

(instance dervishReflection of Prop
	(properties
		x 228
		y 121
		noun '/reflection[<dervish,man]'
		description {the Dervish' reflection}
		lookStr {The Dervish spends most of his time reflecting.}
		view 625
		loop 6
		priority 3
		signal 24592
	)
)

(instance waterSaurus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(saurus view: 11 illegalBits: 0 setPri: -1)
				(= cycles 2)
			)
			(1
				(saurus setLoop: -1 setMotion: PolyPath 115 104 self)
			)
			(2
				(saurusReflection init: setCycle: Fwd)
				(saurus view: 621 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(drinkingHead setPri: 7 init: cycleSpeed: 1 setCycle: Fwd)
				(drinkRipple setPri: 6 init: setCycle: Fwd)
				(= seconds 10)
			)
			(4
				(drinkRipExt init: setPri: 8 setCycle: End)
				(drinkRipple dispose:)
				(drinkingHead setCycle: Beg self)
			)
			(5
				(drinkRipExt
					posn: (+ (drinkRipExt x:) 3) (+ (drinkRipExt y:) 3)
					cel: 0
					setCycle: End
				)
				(drinkingHead dispose:)
				(saurus setCycle: Beg self)
				(saurusReflection dispose:)
			)
			(6
				(drinkRipExt
					posn: (+ (drinkRipExt x:) 3) (+ (drinkRipExt y:) 3)
					cel: 0
					setCycle: End self
				)
			)
			(7
				(drinkRipExt dispose:)
				(self dispose:)
			)
		)
	)
)

(instance waterSlammin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 160)
					(gEgo setMotion: PolyPath 116 142 self)
				else
					(gEgo setMotion: PolyPath 216 136 self)
				)
			)
			(1
				(gEgo
					view: 47
					setLoop: (if (< (gEgo x:) 160) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(ClearFlag 3) ; fThirsty
				(ClearFlag 137) ; fDyingOfThirst
				(if waterGotten
					(HighPrint 620 18) ; "You take another deep drink of the warm, but refreshing water."
				else
					(HighPrint 620 19) ; "You take a deep drink of the warm, but refreshing water."
					(= waterGotten 1)
				)
				(= cycles 12)
			)
			(3
				(cond
					(
						(and
							(== gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
							(> [gInvNum 37] 0) ; Waterskin
						)
						(if (> [gInvNum 37] 1) ; Waterskin
							(HighPrint 620 20) ; "You check and realize that your waterskins are full."
						else
							(HighPrint 620 21) ; "You check and realize that your waterskin is full."
						)
					)
					((> [gInvNum 37] 1) ; Waterskin
						(HighPrint 620 22) ; "You then check and refill all your waterskins."
						(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
					)
					((gEgo has: 37) ; Waterskin
						(HighPrint 620 23) ; "You then check and refill your waterskin."
						(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
					)
					(else
						(HighPrint 620 24) ; "It's a shame you don't have a waterskin to fill."
					)
				)
				(= cycles 4)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance thrownForLoop of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 15 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(Say dervish self 620 25) ; "Perhaps you should not attempt such a thing while riding a saurus."
				(= cycles 3)
			)
			(2
				(saurus
					view: 11
					posn: (gEgo x:) (gEgo y:)
					setLoop: 0
					setCycle: Walk
					init:
				)
				(gEgo
					view: 15
					setLoop: 2
					cel: 0
					posn: (- (gEgo x:) 43) (+ (gEgo y:) 4)
					setCycle: End self
				)
			)
			(3
				(= gEgoGait 0) ; walking
				(NormalEgo)
				(saurus setLoop: -1 setMotion: PolyPath 50 140 self)
			)
			(4
				(saurus loop: 0 cel: 4 forceUpd:)
				(self dispose:)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance pond of Feature
	(properties
		noun '/oasis'
		description {the Oasis}
		lookStr {It's very wet.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly1))
	)
)

(instance poly2 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance frond of Feature
	(properties
		noun '/frond,frond'
		description {the palm fronds}
		lookStr {They're very green.}
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly2)
				(AvoidPath (theObj x:) (theObj y:) poly3)
				(AvoidPath (theObj x:) (theObj y:) poly4)
				(AvoidPath (theObj x:) (theObj y:) poly5)
			)
		)
	)
)

(instance poly6 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance plant of Feature
	(properties
		noun '/grass,plant'
		description {the grassy plant}
		lookStr {It's very happy in the water.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly6))
	)
)

(instance poly7 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly9 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly10 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance trunk of Feature
	(properties
		noun '/trunk,tree,palm'
		description {the trunk of the palm tree}
		lookStr {They're very sturdy.}
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly7)
				(AvoidPath (theObj x:) (theObj y:) poly8)
				(AvoidPath (theObj x:) (theObj y:) poly9)
				(AvoidPath (theObj x:) (theObj y:) poly10)
			)
		)
	)
)

(instance poly11 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance sky of Feature
	(properties
		noun '/sky,cloud,star'
		description {the sky}
		lookStr {The sky above...the sand below.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly11))
	)
)

(instance poly12 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly13 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly14 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance beard of Feature
	(properties
		noun '/beard'
		description {the beard of the Dervish}
		lookStr {Judging by the way his beard's attached to the palm, this guy must REALLY like it here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(cond
					((not (<= (gEgo distanceTo: dervish) 75))
						(LowPrint 620 26) ; "Move over to the dervish first."
					)
					((gEgo has: 14) ; Beard
						(LowPrint 620 27) ; "You have some of his beard already."
					)
					((IsFlag 184) ; fWhirlForBucks
						(Say dervish 620 28) ; "Beard must stay or dervish drift away."
					)
					(else
						(SolvePuzzle 642 5)
						(gEgo get: 14) ; Beard
						(SetFlag 184) ; fWhirlForBucks
						(Print 620 29) ; "You take a small piece of the Dervishes' beard and put it carefully away."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly12)
				(AvoidPath (theObj x:) (theObj y:) poly13)
				(AvoidPath (theObj x:) (theObj y:) poly14)
			)
		)
	)
)

(instance everythingElse of Feature
	(properties
		x 160
		y 105
		noun '/sand,desert,ground'
		nsTop 21
		nsBottom 189
		nsRight 320
		description {the sand}
		lookStr {The sand below...the sky above.}
	)
)

(instance saySumpin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= entering 1)
				(if (IsFlag 168) ; fDervishDailyMsg
					(= cycles 1)
				else
					(SetFlag 168) ; fDervishDailyMsg
					(if (< gDay 13)
						(Say
							dervish
							self
							(Format @str 620 30 [enterSaying gDay]) ; "%s."
						)
					else
						(Say dervish self 620 31) ; "Man who waits too late gets no response from man who waits even later."
					)
				)
			)
			(1
				(= entering 0)
				(self dispose:)
			)
		)
	)
)

