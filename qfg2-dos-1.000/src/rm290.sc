;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use Stage)
(use Interface)
(use fakirsPitch)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
	saurus1 1
	saurus2 2
	gate 3
)

(local
	dayTime
	fakirGone
	fakirHere
	guardSaidIt
	[guardPts 16] = [296 114 296 123 269 123 269 111 0 0 0 0 0 0 0 0]
	[guardList 33] = [1 2 3 0 4 5 6 7 8 9 10 11 12 0 13 14 15 0 16 17 18 19 20 21 22 23 24 25 26 27 28 0 29]
	[guardSpecList 22] = [-1 '//saurii,ride' 30 '//preparation,waterbag,compass,food,supply,water,prepare' 33 '//stable' 36 '//skareen' 37 '//bedouin' 38 '//oasis' 39 '//dune' 40 '//griffin' 41 '//nest' 42 '//bazaar' 0 0]
	[str1 30]
)

(instance rm290 of Stage
	(properties
		picture 290
		style 1
		horizon 114
		north 300
		south 780
		topFromX 254
		topFromY 113
		topToX 240
		topToY 133
	)

	(method (init)
		(SetFlag 152) ; f290
		(LoadMany rsVIEW 290 11 295 299)
		(Load rsSCRIPT 985)
		(Load rsSOUND 290)
		(ClearFlag 82) ; fDesert
		(SetFlag 16) ; fShapeir
		(if (== gEgoGait 3) ; riding
			(= gEgoGait 3) ; riding
		else
			(= gEgoGait 0) ; walking
		)
		(NormalEgo)
		(gEgo illegalBits: -32766 init:)
		(if (IsFlag 149) ; fReturningSaurus
			(= inOut 3)
		)
		(= fakirGone (IsFlag 45)) ; fBoughtSaurus
		(= global76 1)
		(super init:)
		(self addObstacle: guardPoly)
		(guardPoly points: @guardPts size: 4)
		(gate palette: (if gNight 2 else 1) init:)
		(= [guardList 31] 35)
		(if (and (= dayTime (not gNight)) (< gDay 17))
			(theGuard
				title: {Uns al-Wujud:}
				myName: '//alwujud,guard,man'
				init:
				stopUpd:
			)
		else
			(theGuard
				title: {Abdallah bin Tahir:}
				myName: '//abdallah,guard,man'
				init:
				stopUpd:
			)
		)
		(gCSound number: 290 loop: -1 playBed:)
		(if
			(= fakirHere
				(if
					(and
						(not fakirGone)
						(>= gDay 2)
						(< gDay 17)
						(not (IsFlag 149)) ; fReturningSaurus
					)
					dayTime
				)
			)
			(Load rsVIEW 292)
			(Load rsVIEW 297)
			(Load rsSCRIPT 291)
			(Load rsTEXT 292)
			(Load rsSOUND 293)
			(InitAddToPics aliSign)
			(InitFakirP)
		)
		(InitAddToPics guardBod)
		(InitFeatures cityGate corral corral2 canopy shadow)
		(saurus1 init: illegalBits: 0 setScript: saurus1S)
		(if (or (>= gHowFast 2) (and (== gHowFast 1) (not fakirHere)))
			(saurus2 init: illegalBits: 0 setScript: saurus2S)
		)
		(if
			(and
				(IsFlag 45) ; fBoughtSaurus
				(!= gEgoGait 3) ; riding
				(!= gPrevRoomNum 780) ; cityRoom
				(not (IsFlag 149)) ; fReturningSaurus
			)
			((ScriptID 660 1) ; saurus
				init:
				view: 11
				posn: -20 149
				setLoop: Grooper
				setCycle: Walk
				setScript: wimpInCorral
			)
		)
		(if (and (not (IsFlag 155)) (not (gCast contains: (ScriptID 660 1)))) ; fRodeSaurusOut, saurus
			((ScriptID 660 1) init:) ; saurus
		)
		(if (< gDay 17)
			(if (== gEgoGait 3) ; riding
				(SetFlag 173) ; fGuardWillDoIt
				(ClearFlag 155) ; fRodeSaurusOut
			)
			(self setRegions: 660) ; desertReg
		)
		(if (IsFlag 149) ; fReturningSaurus
			(gEgo view: 4 loop: 1 cel: 0 posn: 143 140)
			(NormalEgo)
			(gEgo illegalBits: -32766)
			((ScriptID 660 1) ; saurus
				loop: 1
				cel: 0
				posn: 84 147
				setPri: -1
				init:
				setCycle: Walk
				illegalBits: 0
				ignoreActors:
				setMotion: MoveTo 55 147
			)
			(HighPrint 290 0 25 4 103) ; "Pesky saurus!"
			(HandsOn 1)
		)
		(= entranceScript
			(cond
				((>= gDay 17) lateForCaravan)
				(fakirHere
					(ScriptID 291 0) ; fakirsPitch
				)
				(else helloS)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(> (gEgo y:) 180)
					(not (IsFlag 48)) ; fIntoDesertOnce
					(not (gEgo has: 50)) ; Saurus
					(< gDay 17)
				)
				(Say theGuard 290 1) ; "You are not likely to live long if you go that way. One cannot travel in the desert unless one is better prepared, or joins a caravan."
				(SetFlag 48) ; fIntoDesertOnce
			)
			((and (== gEgoGait 3) (< (gEgo y:) 120) (not (gEgo script:))) ; riding
				(gEgo setScript: guardStopsEgo)
			)
			((gEgo edgeHit:)
				(if (IsFlag 172) ; fLoseIfLeaves
					(EgoDead 1 290 2 #title {Terminal Stubbornness}) ; "You just can't take a hint, can you? The Saurus you should have bought went to the wrong customer, and the entire free world will soon be enslaved as a result."
				else
					(gCurRoom setScript: 0)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (== gEgoGait 3) ; riding
			(SetFlag 155) ; fRodeSaurusOut
		else
			(ClearFlag 155) ; fRodeSaurusOut
		)
		(ClearFlag 149) ; fReturningSaurus
		(ClearFlag 173) ; fGuardWillDoIt
		(gCSound fade:)
		(gMiscSound stop:)
		(DisposeScript 291)
		(super dispose: &rest)
	)

	(method (notify)
		(if (IsFlag 173) ; fGuardWillDoIt
			(Say theGuard 290 3) ; "I will be honored to put your saurus back into the stable for you, Effendi."
		)
		(ClearFlag 173) ; fGuardWillDoIt
		(= guardSaidIt 1)
		(super notify: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 290 4) ; "Outside of the main gate of Shapeir is a corral for the townspeople's sauruses (saurii?...you decide)."
				(if fakirHere
					(HighPrint 290 5) ; "But today, someone seems to have opened up a business here."
				)
			)
			(
				(or
					(Said 'get,get[<!*]/saurii,roget')
					(Said
						'mount,ride,(climb,climb,get,get<on,up)[/saurii,roget]'
					)
					(and (!= gEgoGait 3) (Said 'get,get[<!*][/saurii,roget]')) ; riding
				)
				(cond
					((== gEgoGait 3) ; riding
						(HighPrint 290 6) ; "You are riding your saurus."
					)
					((IsFlag 155) ; fRodeSaurusOut
						(HighPrint 290 7) ; "You left your saurus out in the desert. You would never find him if you went out looking. Better hope he wanders in like the guard said."
					)
					((not (IsFlag 45)) ; fBoughtSaurus
						(HighPrint 290 8) ; "Those sauruses don't belong to you."
					)
					(
						(or
							(& ((ScriptID 660 1) onControl: 1) $0002) ; saurus
							(< ((ScriptID 660 1) x:) 1) ; saurus
						)
						((ScriptID 660 1) setScript: 0) ; saurus
						(self setScript: egoGetSaurus)
					)
					((Said 'open,open')
						(HighPrint 290 8) ; "Those sauruses don't belong to you."
					)
					(else
						(SetFlag 173) ; fGuardWillDoIt
						(event claimed: 0)
					)
				)
			)
			((Said 'replace,put/saurii,roget')
				(cond
					((IsFlag 173) ; fGuardWillDoIt
						(self notify:)
					)
					((== guardSaidIt 1)
						(HighPrint 290 9) ; "Let the guard do that for you."
					)
					((== gEgoGait 3) ; riding
						(HighPrint 290 10) ; "You need to dismount to do that."
					)
					((IsFlag 155) ; fRodeSaurusOut
						(HighPrint 290 7) ; "You left your saurus out in the desert. You would never find him if you went out looking. Better hope he wanders in like the guard said."
					)
					((not (IsFlag 45)) ; fBoughtSaurus
						(HighPrint 290 8) ; "Those sauruses don't belong to you."
					)
					(
						(or
							(& ((ScriptID 660 1) onControl: 1) $0002) ; saurus
							(< ((ScriptID 660 1) x:) 1) ; saurus
						)
						(HighPrint 290 11) ; "Your saurus is already in the stable."
					)
					(else
						(HighPrint 290 12) ; "You don't have a saurus."
					)
				)
			)
		)
	)
)

(instance helloS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(
						(and
							(== gDay 12)
							(not (IsFlag 93)) ; fDervishMsg
							(not (IsFlag 168)) ; fDervishDailyMsg
						)
						(Say theGuard self 290 13) ; "The Dervish, passing a message through one of the local bedouins, has sent for you. The Dervish says, "Man who looks for trouble comes to right place." He also says, "Good comes from evil when dark is enlightened.""
						(SetFlag 93) ; fDervishMsg
					)
					((and (== gDay 1) (not (IsFlag 46))) ; fFromGateOnce
						(Say theGuard self 290 14) ; "So, you are the stranger the merchants are talking about. The gate to Shapeir is always open, but never have I seen an entrance to the city like yours. To fly in on a carpet, it must be grand."
						(SetFlag 46) ; fFromGateOnce
					)
					(
						(and
							(IsFlag 45) ; fBoughtSaurus
							(not (IsFlag 93)) ; fDervishMsg
							(not (IsFlag 174)) ; fSawDervish
							(== gPrevRoomNum (gCurRoom north:))
						)
						(Say theGuard self 290 15) ; "If you are exploring the desert, you should visit the Dervish at the Oasis. He is a very wise man."
					)
					(
						(and
							(not (IsFlag 47)) ; fFromDesertOnce
							(== gPrevRoomNum (gCurRoom south:))
							(not fakirHere)
						)
						(if dayTime
							(Say theGuard self 290 16) ; "It is good that you have returned safely from the desert."
						else
							(Say theGuard self 290 17) ; "Thank heavens that thee hast survived the night desert. It can be truly dangerous when the sun has set."
						)
						(SetFlag 47) ; fFromDesertOnce
					)
					((and (< gDay 7) (not fakirHere))
						(if dayTime
							(Say theGuard self 290 18) ; "Good day, Effendi."
						else
							(Say theGuard self 290 19) ; "May thee be granted a happy evening, Effendi."
						)
					)
					((< 6 gDay 14)
						(cond
							((and (== gDay 11) (not (IsFlag 145))) ; f1msgCaravan
								(Say theGuard self 290 20) ; "There is a caravan which will pass by us six days from now. If you wish to journey to Raseir, you will need to join it."
								(SetFlag 145) ; f1msgCaravan
							)
							(dayTime
								(Say theGuard self 290 21) ; "Good day, Hero."
							)
							(else
								(Say theGuard self 290 22) ; "May thee walk safely this evening, Hero of Shapeir."
							)
						)
					)
					((and (== gDay 15) (== gPrevRoomNum (gCurRoom north:)))
						(cond
							((and (== gDay 15) (not (IsFlag 146))) ; f2msgCaravan
								(Say theGuard self 290 23) ; "The caravan to Raseir will leave here at the light of dawn in two days time."
								(SetFlag 146) ; f2msgCaravan
							)
							(dayTime
								(Say theGuard self 290 24) ; "Hero, the Caravan to Raseir leaves here in two days time, granting that there are no elementals in the city."
							)
							(else
								(Say theGuard self 290 25) ; "The Caravan traveling to Raseir will depart the morning after this day, oh Hero."
							)
						)
					)
					((and (== gDay 16) (== gPrevRoomNum (gCurRoom north:)))
						(if dayTime
							(Say theGuard self 290 26) ; "The Caravan to Raseir will leave with the dawn of tomorrow's sun, Hero."
						else
							(Say theGuard self 290 27) ; "May your journey tomorrow be a safe one, Hero of Shapeir."
						)
					)
					(dayTime
						(Say theGuard self 290 21) ; "Good day, Hero."
					)
					(else
						(Say theGuard self 290 22) ; "May thee walk safely this evening, Hero of Shapeir."
					)
				)
			)
			(1
				(if (and (IsFlag 155) (== gEgoGait 0)) ; fRodeSaurusOut, walking
					(Say theGuard self 290 28) ; "I see you left your saurus out in the desert. Most sauruses find their way back here to the stables."
				)
				(gate stopUpd:)
				(self dispose:)
			)
		)
	)
)

(class SaurusScript of Script
	(properties)

	(method (changeState newState &tmp dinars)
		(switch (= state newState)
			(0
				(= seconds (Random 2 8))
			)
			(1
				(client
					setCycle: Fwd
					cycleSpeed: 0
					y: (Random 120 137)
					setMotion: MoveTo (Random 30 80) (client y:) self
				)
			)
			(2
				(client setCycle: 0 setMotion: 0)
				(self
					changeState:
						(switch (Random 0 5)
							(1 3)
							(2 4)
							(3 6)
							(4 9)
							(5 12)
						)
				)
			)
			(3
				(client setLoop: 5 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(client setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(client setCycle: Beg self)
			)
			(6
				(client setLoop: 2 setCycle: End self)
			)
			(7
				(client setCycle: Beg self)
			)
			(8
				(self changeState: 12)
			)
			(9
				(client setLoop: 6 cel: 0 setCycle: End self)
			)
			(10
				(= seconds 5)
			)
			(11
				(client setCycle: Beg self)
			)
			(12
				(= cycles 8)
				(client setCycle: 0)
			)
			(13
				(client setLoop: 6 cel: 0 setCycle: End self)
			)
			(14
				(client setLoop: 7 setCycle: Beg self)
			)
			(15
				(client
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 0
					setMotion: MoveTo -29 (client y:) self
				)
			)
			(16
				(client setLoop: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance saurus1S of SaurusScript
	(properties)
)

(instance saurus2S of SaurusScript
	(properties)
)

(instance wimpInCorral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				((ScriptID 660 1) setMotion: MoveTo 18 147 self) ; saurus
			)
			(1
				2
				(= seconds (Random 4 7))
			)
			(2
				3
				((ScriptID 660 1) setMotion: MoveTo 55 147 self) ; saurus
			)
			(3
				4
				(self dispose:)
			)
		)
	)
)

(instance egoGetSaurus of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo setScript: (ScriptID 660 6)) ; mountSaurus
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 140 140 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gate setCycle: End self)
			)
			(3
				((ScriptID 660 1) setCycle: Walk setMotion: MoveTo 200 147 self) ; saurus
			)
			(4
				(gate setCycle: Beg self)
			)
			(5
				(gate stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance guardStopsEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setHeading: 45 self)
			)
			(1
				(Say theGuard self 290 29) ; "All sauruses must be stabled in the corral. Only if you dismount may you enter the city."
			)
			(2
				(gEgo setMotion: MoveTo 220 130 self)
			)
			(3
				(gEgo setMotion: MoveTo 230 140 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance cityGate of Feature
	(properties
		x 252
		y 71
		noun '/arch,gateway,entrance,(gate<shapeir)'
		nsTop 25
		nsLeft 212
		nsBottom 117
		nsRight 292
		description {the Gateway to the City of Shapeir}
		lookStr {This is the Main (and only) gateway to the City of Shapeir.}
	)
)

(instance corral of Feature
	(properties
		x 55
		y 128
		noun '/corral,pen,fence,stable'
		nsTop 99
		nsLeft 1
		nsBottom 158
		nsRight 110
		description {the corral}
		lookStr {The corral is used to keep the sauruses penned in.}
	)
)

(instance corral2 of Feature
	(properties
		x 152
		y 103
		noun '/corral,pen,fence,stable'
		nsTop 79
		nsLeft 111
		nsBottom 127
		nsRight 194
		description {the corral}
		lookStr {The corral is used to keep the sauruses penned in.}
	)
)

(instance canopy of Feature
	(properties
		x 73
		y 30
		noun '/awning,awning'
		nsTop 19
		nsLeft 1
		nsBottom 41
		nsRight 146
		description {the canopy over the saurus lot}
		lookStr {There is a small canopy for shade and color.}
	)
)

(instance shadow of Feature
	(properties
		x 73
		y 57
		noun '/shadow'
		nsTop 49
		nsBottom 66
		nsRight 147
		description {the shade of the awning}
		lookStr {Only really tall people appreciate the awning's shade.  One can only speculate that it is purely decorative.}
	)
)

(instance guardPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance guardBod of PicView
	(properties
		x 283
		y 121
		view 295
		loop 7
	)
)

(instance theGuard of Talker
	(properties
		x 282
		y 82
		description {the guard}
		lookStr {The guard looks much like any other well-trained soldier.}
		view 295
		loop 4
		signal 24592
		illegalBits 0
		tLoop 4
		talkSpeed 1
		myName '//guard,man'
		title {Guard Name:}
		color 14
		back 0
		msgFile 294
	)

	(method (onMe)
		(return (or (super onMe: &rest) (guardBod onMe: &rest)))
	)

	(method (showText what)
		(Face gEgo self)
		(switch what
			(29
				(if dayTime
					(Say self 290 30) ; "My name is Uns al-Wujud, which means "Delight in Existing Things"."
				else
					(Say self 290 31) ; "May it please you, I am called "Abdallah bin Tahir"."
				)
			)
			(15
				(Say theGuard 290 32 290 33 290 34) ; "The desert is a very dangerous place for any man."
			)
			(9
				(if dayTime
					(Say self 290 35 290 36 290 37) ; "It is my duty to protect this city against monsters that approach it."
				else
					(Say self 290 35 290 38 290 39) ; "It is my duty to protect this city against monsters that approach it."
				)
			)
			(27
				(if fakirGone
					(Say self 290 40) ; "Ali Fakir said after you left that he had sold his last saurus and must be going."
				else
					(Say self 290 41) ; "The Seller of Sauruses is a strange man. I have not heard one who can talk faster when trying to sell a saurus."
				)
			)
			(14
				(Format
					@str1
					{There will be a caravan to Raseir in %u Days.}
					(- 17 gDay)
				)
				(Say self 290 42 @str1) ; "A caravan is many travelers journeying together. It is much less dangerous that way."
			)
			(-1
				(if (== gDay 1)
					(Say self 290 43 290 44 290 45 290 46) ; "You can see the riding sauruses in the stable over there."
				else
					(Say self 290 43 290 44 290 45) ; "You can see the riding sauruses in the stable over there."
				)
			)
			(30
				(self showMany: 30 32)
			)
			(33
				(self showMany: 33 34)
			)
			(else
				(self messages: 294 what)
			)
		)
	)

	(method (atSpec which)
		(return [guardSpecList which])
	)

	(method (atGen which)
		(return [guardList which])
	)

	(method (messages)
		(self setPri: 9)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk: &rest)
		(self setPri: 0)
	)
)

(instance saurus1 of Actor
	(properties
		x -29
		y 124
		noun '[<!*]/(saurii[<red]),animal,monster,creature,dragon,dinosaur'
		description {the red saurus}
		lookStr {It is a variety of red saurus that you never saw in Spielburg.}
		view 299
		loop 1
		cel 1
		priority 7
		signal 16400
		xStep 7
	)
)

(instance saurus2 of Actor
	(properties
		x -32
		y 132
		noun '[<!*]/(saurii[<red]),animal,monster,creature,dragon,dinosaur'
		description {the red saurus}
		lookStr {It is a variety of red saurus that you never saw in Spielburg.}
		view 299
		loop 1
		cel 1
		priority 7
		signal 16400
		xStep 7
	)
)

(instance aliSign of PicView
	(properties
		x 41
		y 172
		noun '/sign'
		description {the sign}
		lookStr {The only thing that's honest about Ali is the fact that he honestly can't spell "Saurus."}
		view 290
		loop 1
		signal 16400
	)
)

(instance gate of Prop
	(properties
		x 134
		y 132
		noun '/gate,door,stable,grass'
		description {the gate to the saurus lot}
		lookStr {Through this gate saunter some of the sorriest sauruses ever.}
		view 290
		priority 7
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((== gEgoGait 3) ; riding
						(HighPrint 290 47) ; "You can't open the gate while you're riding your saurus."
					)
					((IsFlag 155) ; fRodeSaurusOut
						(HighPrint 290 48) ; "You left your saurus out in the desert. You would never find him if you went out looking. Better hope he wanders in like the guard said."
					)
					((not (IsFlag 45)) ; fBoughtSaurus
						(HighPrint 290 8) ; "Those sauruses don't belong to you."
					)
					(
						(or
							(& ((ScriptID 660 1) onControl: 1) $0002) ; saurus
							(< ((ScriptID 660 1) x:) 1) ; saurus
						)
						((ScriptID 660 1) setScript: 0) ; saurus
						(self setScript: egoGetSaurus)
					)
					(else
						(HighPrint 290 8) ; "Those sauruses don't belong to you."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lateForCaravan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 2)
				(= cycles 4)
			)
			(1
				(Print 290 49) ; "The guard tells you the Caravan leaves immediately for Raseir."
				(= cycles 1)
			)
			(2
				(Print 290 50) ; "You run and say goodbye to Shema and Shameen. They give you some food and clothing and wish you luck, knowing you will need it."
				(ClearFlag 3) ; fThirsty
				(ClearFlag 137) ; fDyingOfThirst
				(ClearFlag 4) ; fHungry
				(ClearFlag 5) ; fStarving
				(gEgo get: 49 get: 3 12) ; SpareClothes, Food
				(if (not (gEgo has: 37)) ; Waterskin
					(gEgo get: 37) ; Waterskin
				)
				(++ gFreeMeals)
				(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
				(= cycles 2)
			)
			(3
				(if (== gEgoGait 3) ; riding
					(Print 290 51) ; "As you pass back through the gate of Shapeir, you see ahead in the desert sands awaits a mass of Saurii and riders being led by the Caravan Master, a huge Centaur who orders the Caravan into motion."
				else
					(Print 290 52) ; "As you pass back through the gate of Shapeir, the gate guard presents you with a new saurus, a gift from the Sultan. Ahead in the desert sands awaits a mass of Saurii and riders being led by the Caravan Master, a huge Centaur who orders the Caravan into motion."
				)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 861)
			)
		)
	)
)

