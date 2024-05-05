;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 665)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Interface)
(use desertReg)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	desert 0
	SaurusToFeature 1
)

(local
	pseudoPic = 660
	inDesert
	[unused 3]
	caughtEgo
	nightSky
	egoToX
	egoToY
	saurus
	monster
	monDistance = 100
	monRange
	mtnScene
	theJet
	strokeCount = 832
	searchX
	searchY
	polyTop
	oldX
	oldY
	hasTail
	hasClaws
	[string1 40]
	[string2 100]
	[roomMap 10] = [-650 1296 -780 1300 -640 1307 -620 6303 -880 8700]
	[cageEntry 4] = [-630 4295 0 0]
	[featPtsL 8]
	[featPtsR 8]
	[nonePts 8] = [0 0 1 0 1 1 0 1]
	[bodyPts 8]
	[roomStyles 4] = [5 41 4 40]
	[dayMonsters 6] = [680 680 680 670 670 675]
	[nightMonsters 6] = [685 685 695 695 670 675]
	[bodySaids 10] = [680 '/bandit,man' 671 '/scorpion' 675 '/dinosaur,(saurii<terror)' 685 '/ghoul,skeleton' 695 '/jackal,(man<jackal),jackal']
	[golfPhrases 10] = [{Damn} {Rats} {Shoot} {Blast} {Argh} {Ack} {Camel Dung} {#@!%$} {Snarl} {Glastnost}]
	[signLooks 6] = [{Albuquerque___152,700 cubits} {Hours: Mon - Fri__8:00 - 5:00} {Keep off the grass} {Desertside litter removal crews next 3 dunes} {Maximum Speed 1.5} {Downtown Shapeir next exit}]
	[rockLooks 4] = [{Aye, 'tis a rock.} {The rock reflects the desert heat.} {The rock is made of red sandstone.} {This rock looks, predictably, much like any other desert rock.}]
	[bushLooks 4] = [{One of few living things in the desert.} {The plant seems to have adapted to the desert heat.} {The dry heat of the desert has stunted the plant's growth.} {If it were larger, you could sit in the shade.}]
	[heatMsg 6] = [{The blazing desert sun beats down fiercely on your head.} {It is amazing that anything can survive in the furnace-like desert.} {The hot desert air scorches your throat as you breathe.} {The searing desert heat seems to draw the water right out of you.} {The sound of your footsteps seem to echo "water" in your ears.} {Without water, you would not survive even an hour in the desert.}]
)

(procedure (calcRoom oldRoom oldDir &tmp index nr)
	(if (< (= nr oldRoom) 0)
		(for ((= index 0)) [roomMap index] ((+= index 2))
			(if (== oldRoom [roomMap index])
				(= nr [roomMap (+ index 1)])
				(break)
			)
		)
		(if (< nr 0)
			(Printf 665 15 nr oldDir) ; "Bad desert room: room %d, direction %d"
			(= nr 1300)
			(= oldDir 3)
			(gEgo posn: 160 70)
		)
	)
	(if (and (>= nr 5000) (>= oldRoom 0))
		(= oldDir (FlipDir oldDir))
	)
	(switch oldDir
		(1
			(-= nr 1000)
		)
		(3
			(+= nr 1000)
		)
		(2
			(++ nr)
		)
		(4
			(-- nr)
		)
	)
	(for ((= index 1)) [roomMap index] ((+= index 2))
		(if (== nr [roomMap index])
			(return [roomMap (- index 1)])
		)
	)
	(return nr)
)

(procedure (initDesertRoom nr theDir &tmp mod4 myPal theStyle oldRoom upsideDown feat1 feat2 theRow)
	(= oldRoom gDesertRoom)
	(= gDesertRoom nr)
	(= mtnScene 0)
	(= global61 0)
	(= mod4 (& nr $0003))
	(= myPal (& nr $0002))
	(cond
		((< nr 2000)
			(= pseudoPic (+ 666 mod4))
			(= mtnScene 1)
		)
		((< nr 3000)
			(= pseudoPic (+ 662 mod4))
		)
		((< nr 4000)
			(= pseudoPic (+ 660 (& nr $0001)))
			(= global61 myPal)
		)
		((< nr 5000)
			(= pseudoPic (+ 660 (- 1 (& nr $0001))))
			(= global61 myPal)
		)
		((< nr 6000)
			(= pseudoPic (+ 660 (- 1 (& nr $0001))))
			(= global61 (- 2 myPal))
		)
		((< nr 7000)
			(= pseudoPic (+ 660 (& nr $0001)))
			(= global61 (- 2 myPal))
		)
		((< nr 8000)
			(= pseudoPic (+ 660 (- 5 mod4)))
		)
		(else
			(= pseudoPic (+ 660 (- 9 mod4)))
			(= mtnScene 1)
		)
	)
	(= nightSky 0)
	(if gNight
		(++ global61)
		(if (not mtnScene)
			(= nightSky 1)
		)
	)
	(if (>= nr 5000)
		(= theDir (FlipDir theDir))
	)
	(= theStyle [roomStyles (- theDir 1)])
	(cond
		((> oldRoom 0))
		((== theStyle 41)
			(= theStyle 3)
		)
		((== theStyle 40)
			(= theStyle 2)
		)
	)
	(gCurRoom style: theStyle drawPic: pseudoPic picture: pseudoPic)
	(= feat1 (mod nr 37))
	(= feat2 (mod nr 31))
	(cond
		((< feat1 12)
			(MakeRockOrBush 1 nr 0)
			(featPolyL points: @featPtsL)
		)
		((< feat1 24)
			(MakeRockOrBush 0 nr 0)
			(featPolyL points: @featPtsL)
		)
		(else
			(featPolyL points: @nonePts)
		)
	)
	(cond
		((< feat2 12)
			(MakeRockOrBush 1 nr 1)
			(featPolyR points: @featPtsR)
		)
		((< feat2 24)
			(MakeRockOrBush 0 nr 1)
			(featPolyR points: @featPtsR)
		)
		(else
			(featPolyR points: @nonePts)
		)
	)
	(if nightSky
		(gCurRoom overlay: 659 100)
		(if (>= nr 5000)
			(stellar1
				cel: 0
				x: 208
				y: 72
				noun: '/star,constellation<dragon'
				description: {the Dragon constellation}
				lookStr: {The star pattern known as the Dragon.}
			)
			(stellar2
				cel: 1
				x: 86
				y: 36
				noun: '/star,constellation<scorpion'
				description: {the Scorpion constellation}
				lookStr: {The sign of the Scorpion.}
			)
		else
			(stellar1
				cel: 2
				x: 273
				y: 65
				noun: '/star,constellation<hand'
				description: {the Dark Hand constellation}
				lookStr: {The stars here appear to form a Dark Hand.}
			)
			(stellar2
				cel: 3
				x: 67
				y: 43
				noun: '/star,constellation<saurii'
				description: {the Saurus constellation}
				lookStr: {This constellation is said to resemble a Saurus.}
			)
		)
		(InitAddToPics stellar1 stellar2)
	)
	(cond
		((and gGriffinHealth (not mtnScene))
			(= gMonsterNum 655)
			(= gMonsterHealth gGriffinHealth)
			((ScriptID 655 0) initAmbush:) ; griffin
		)
		((and gMonsterNum gMonsterHealth)
			((= monster (ScriptID gMonsterNum 0)))
			(if (== gPrevRoomNum 666) ; rmCombat
				(= monRange (monster attackRange:))
				(monster x: 130 y: 160 heading: 90 attackRange: 0 initChase: 0)
				(EgoGait 1 0) ; running
				(HandsOff)
				(gEgo setMotion: Flee monster)
			else
				(DontMove 0)
				(if
					(or
						(< monDistance 350)
						(and (== gMonsterNum 695) (< gTimeODay 5))
					)
					(if (== gRoomExitDir 3)
						(monster y: 170)
					)
					(if monRange
						(monster attackRange: monRange)
					)
					(monster initChase: monDistance)
				else
					(if (gCast contains: monster)
						(monster dispose:)
					)
					(= gMonsterNum 0)
					(= gNumJackals 0)
					(= gJackalsKilled 0)
					(= caughtEgo 0)
				)
			)
		)
		((FunStuff))
		(
			(and
				(!= gEgoGait 3) ; riding
				(gEgo has: 50) ; Saurus
				(== gDesertRoom gSaurusRoom)
				(not (gCast contains: deadBody))
			)
			(saurus
				view: 298
				setLoop: (< (gEgo x:) 160)
				posn: 160 180
				init:
				setScript: sheepScript
			)
		)
	)
	(= egoToX (gEgo x:))
	(= egoToY (gEgo y:))
	(if
		(or
			(and (== (= theRow (/ oldRoom 1000)) 4) (== gRoomExitDir 3))
			(and (== theRow 5) (== gRoomExitDir 1))
		)
		(= egoToX (- 320 egoToX))
	)
	(switch theDir
		(-1)
		(3
			(gEgo posn: egoToX 60)
			(if
				(or
					gMonsterNum
					(> (Random 0 5) 1)
					(not (FindNextDune (gEgo x:) (gEgo y:) 2 0))
				)
				(gEgo setScript: (ScriptID 660 2)) ; duneIn
			else
				(gEgo setScript: (ScriptID 660 8)) ; twoDunesIn
			)
		)
		(else
			(gEgo setScript: egoEnters 0 theDir)
		)
	)
)

(procedure (FunStuff &tmp rc artX)
	(= rc 0)
	(if
		(and
			(> gDay 2)
			(not (Random 0 8))
			(not (gCast contains: deadBody))
			(not gNight)
		)
		(switch (++ gDesertFunCtr)
			(1
				(arthur x: (if (< (gEgo x:) 160) 220 else 120) init:)
				(= rc 1)
			)
			(2
				(switch (gCurRoom picture:)
					(662
						(gulfFlag x: 74)
						(InitAddToPics gulfFlag)
						(gulfer posn: 43 129 setCycle: gulfCycle init:)
						(= rc 1)
					)
					(663
						(gulfFlag x: 246)
						(InitAddToPics gulfFlag)
						(gulfer posn: 277 129 setCycle: gulfCycle init:)
						(= rc 1)
					)
					(else
						(-- gDesertFunCtr)
					)
				)
			)
			(3
				((= theJet (Actor new:))
					view: 660
					setLoop: 7
					setCel: 1
					x: -50
					y: 40
					xStep: 10
					init:
					setMotion: MoveTo 350 40
					noun: '/airplane,airplane,airplane,mirage'
					lookStr: {It's just a Mirage.}
					description: {the Mirage}
				)
				(= rc 1)
			)
			(4
				(theSign lookStr: [signLooks (Random 0 5)])
				(InitAddToPics theSign)
				(-- gDesertFunCtr)
				(= rc 1)
			)
		)
	)
	(return rc)
)

(procedure (GolfPrint &tmp [string 20] [printRect 4] theWidth theX)
	(if (== (++ strokeCount) 900)
		(StrCpy @string {Um... That's a gimme.})
	else
		(Format @string 665 16 [golfPhrases (Random 0 9)] strokeCount) ; "%s! %d..."
	)
	(TextSize @[printRect 0] @string gUserFont 0)
	(= theWidth [printRect 3])
	(= theX
		(if (> (gulfer x:) 160)
			(- 300 theWidth)
		else
			20
		)
	)
	(Print @string #title {Persian Golfer} #at theX 20 #width theWidth #dispose)
	(gulfer z: (- (gulfer z:) 1))
)

(procedure (MakeRockOrBush isRock theRoom onRight &tmp theObj theSeed result theLoop theCel theX theY theArray fL fT fR fB)
	(if onRight
		(= theSeed (+ (* (mod theRoom 10) 10) (/ theRoom 10)))
	else
		(= theSeed (+ (* (mod theRoom 10) 100) (/ theRoom 100)))
	)
	(= theX (* (= result (+ (mod (+= theRoom theSeed) 11) 1)) 10))
	(if onRight
		(= theX (- 320 theX))
	)
	(= theY (+ 150 (* result 2)))
	(= theLoop (+ 3 (> (= theCel (mod (+ result onRight) 8)) 3)))
	(if isRock
		(+= theLoop 2)
	)
	(-= theCel (* 4 (> theCel 3)))
	(if isRock
		((= theObj (rock new:))
			cel: (if (and (== gDesertRoom 6300) (not onRight)) 4 else theCel)
			lookStr: [rockLooks (Random 0 3)]
		)
	else
		((= theObj (bush new:)) cel: theCel lookStr: [bushLooks (Random 0 3)])
	)
	(theObj loop: theLoop x: theX y: theY palette: (+ gNight 1))
	(InitAddToPics theObj)
	(= fL (- (theObj nsLeft:) 10))
	(= fT (- (theObj nsBottom:) 15))
	(= fR (+ (theObj nsRight:) 10))
	(= fB (+ (theObj nsBottom:) 5))
	(= theArray (if onRight @featPtsR else @featPtsL))
	(WriteArray theArray 0 (Max fL 0))
	(WriteArray theArray 1 (Max fT 0))
	(WriteArray theArray 2 (Min fR 320))
	(WriteArray theArray 3 (Max fT 0))
	(WriteArray theArray 4 (Min fR 320))
	(WriteArray theArray 5 (Min fB 190))
	(WriteArray theArray 6 (Max fL 0))
	(WriteArray theArray 7 (Min fB 190))
)

(procedure (SetMonsterTimer &tmp loTime hiTime theTime)
	(= loTime (- 70 (* 20 gArcadeLevel)))
	(= hiTime (- 90 (* 20 gArcadeLevel)))
	(= theTime (Random loTime hiTime))
	(if gNight
		(/= theTime 2)
	)
	(StartTimer monsterTimer theTime)
)

(procedure (SetDrinkTimer &tmp theTime)
	(= theTime (+ (if (== gEgoGait 3) 60 else 30) (* 60 gNight))) ; riding
	(StartTimer drinkTimer theTime)
)

(procedure (ReadArray theArray idx)
	(if (== argc 1)
		(= idx 0)
	)
	(Memory memPEEK (+ theArray (* idx 2)))
)

(procedure (WriteArray theArray idx theValue)
	(Memory memPOKE (+ theArray (* idx 2)) theValue)
)

(procedure (SaurusToFeature &tmp lDist rDist lLimit rLimit rc theX)
	(= lLimit (ReadArray (featPolyL points:) 2))
	(= rLimit (ReadArray (featPolyR points:) 0))
	(if (== (featPolyL points:) @nonePts)
		(= lLimit 0)
	)
	(if (== (featPolyR points:) @nonePts)
		(= rLimit 320)
	)
	(if (== gEgoGait 3) ; riding
		(= theX (gEgo x:))
	else
		(= theX (saurus x:))
	)
	(= lDist (- theX lLimit))
	(= rDist (- rLimit theX))
	(= rc 0)
	(cond
		((< lDist 48)
			(= rc (- lDist))
		)
		((< rDist 48)
			(= rc rDist)
		)
	)
	(return rc)
)

(procedure (FlipDir theDir)
	(if (> theDir 0)
		(return (+ (& (+ theDir 1) $0003) 1))
	else
		(return theDir)
	)
)

(instance desert of Rm
	(properties)

	(method (init &tmp nr)
		(LoadMany rsPIC 659 660 661 662 663 664 665 666 667 668 669)
		(LoadMany rsVIEW 0 5 11 12 13 14 15 47 298 660 83 84)
		(Load rsSOUND 291 660 661)
		(if (< gDay 12)
			(= [cageEntry 0] (= [cageEntry 1] 0))
		)
		(if (== (= nr gPrevRoomNum) 666)
			(= gRoomExitDir -1)
			(= nr gDesertRoom)
		else
			(= gDesertRoom (- nr))
			(= nr (calcRoom gDesertRoom gRoomExitDir))
			(= gBattleResult 0)
		)
		(NormalEgo)
		(gEgo x: 170 y: 175 init:)
		(= picture 0)
		(= gSpellChecker desertChecker)
		(= global76 1)
		(super init: &rest)
		(self setRegions: 660) ; desertReg
		(gCSound number: 660 priority: 0 loop: -1 play:)
		(if gNight
			(nightSound play:)
		)
		(= saurus (ScriptID 660 1)) ; saurus
		(featPolyL points: @featPtsL size: 4)
		(featPolyR points: @featPtsR size: 4)
		(bodyPoly points: @bodyPts size: 4)
		(self addObstacle: featPolyL featPolyR)
		(switch gBattleResult
			(0
				(if (or (== gMonsterNum 655) (not gMonsterNum))
					(SetMonsterTimer)
				)
			)
			(58
				(switch gMonsterNum
					(670
						(deadBody
							view: 671
							loop: 7
							cel: 2
							init:
							noun: '/scorpion,body,monster,creature'
							lookStr: {It is a thoroughly dead Scorpion.}
							description: {the dead Scorpion}
						)
						(= searchX -6)
						(= polyTop 35)
						(SolvePuzzle 674 3 0)
					)
					(675
						(deadBody
							view: 675
							loop: 2
							cel: 6
							init:
							noun:
								'/dinosaur,(saurii<terror),body,monster,creature'
							lookStr: {The Terrorsaurus is quite dead.}
							description: {the dead Terrorsaurus}
						)
						(= searchX 18)
						(= polyTop 15)
						(SolvePuzzle 673 3 0)
					)
					(680
						(deadBody
							view: 680
							loop: 2
							cel: 4
							init:
							noun: '/bandit,man,body,monster,creature'
							lookStr: {It is a recently-croaked brigand.}
							description: {the dead brigand}
						)
						(= searchX 25)
						(= polyTop 20)
						(SolvePuzzle 670 3 0)
					)
					(685
						(deadBody
							view: 685
							loop: 2
							cel: 2
							init:
							noun: '/ghoul,skeleton,body,monster,creature'
							lookStr: {You have killed the Ghoul.__Again.}
							description: {the re-dead Ghoul}
						)
						(= searchX 25)
						(= polyTop 20)
						(SolvePuzzle 671 3 0)
					)
					(695
						(deadBody
							view: 695
							loop:
								(switch gJackalsKilled
									(1 2)
									(2 12)
									(else 13)
								)
							cel: 3
							posn: 140 150
							init:
							noun:
								'/jackal,(man<jackal),jackal,body,monster,creature'
						)
						(if (== gJackalsKilled 1)
							(deadBody
								lookStr: {It is a dead Jackalman.}
								description: {the dead Jackalman}
							)
						else
							(deadBody
								lookStr: {They are dead Jackalmen.}
								description: {the dead Jackalmen}
							)
						)
						(= searchX 25)
						(= searchY 20)
						(= polyTop 15)
						(SolvePuzzle 672 3 0)
					)
				)
				(if (!= gMonsterNum 655)
					(= [bodyPts 0] (= [bodyPts 6] (- (deadBody brLeft:) 10)))
					(= [bodyPts 1]
						(= [bodyPts 3] (- (deadBody brBottom:) polyTop))
					)
					(= [bodyPts 2] (= [bodyPts 4] (+ (deadBody brRight:) 10)))
					(= [bodyPts 5] (= [bodyPts 7] (+ (deadBody brBottom:) 5)))
					(self addObstacle: bodyPoly)
				)
				(if (or (!= gMonsterNum 695) (not gNumJackals))
					(= gMonsterNum (= gMonsterHealth 0))
				)
				(SetMonsterTimer)
			)
		)
		(= gBattleResult 0)
		(SetDrinkTimer)
		(if (not gNight)
			(StartTimer msgTimer 45 60)
		)
		(initDesertRoom nr gRoomExitDir)
		(= inDesert 1)
	)

	(method (notify which)
		(if (== which 54)
			(= caughtEgo 1)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(= global61 0)
		(if (gSounds contains: nightSound)
			(nightSound dispose:)
		)
		(gCSound stop:)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((gEgo script:))
			(
				(and
					(gCast contains: arthur)
					(not (arthur cycler:))
					(< (gEgo distanceTo: arthur) 60)
				)
				(arthur setCycle: End arthur)
			)
			((!= gCurRoomNum gNewRoomNum))
			(caughtEgo
				(= caughtEgo 0)
				(self setScript: prepCombat)
			)
			((= gRoomExitDir (gEgo edgeHit:))
				(self setScript: walkOff 0 gRoomExitDir)
			)
			((& (gEgo onControl:) $0004)
				(if
					(or
						(> (Random 0 5) 1)
						(not (FindNextDune (gEgo x:) (gEgo y:) 2 1))
					)
					(gEgo setScript: (ScriptID 660 3)) ; duneOut
				else
					(gEgo setScript: (ScriptID 660 9)) ; twoDunesOut
				)
			)
			((and gMonsterNum (or (gCast contains: monster) (== gMonsterNum 655)))
				(cond
					((== gEgoGait 3) ; riding
						(gEgo setScript: throwEgo)
					)
					(
						(and
							(gCast contains: saurus)
							(saurus inRect: 0 0 320 190)
							(not (saurus mover:))
						)
						(saurus setMotion: Flee monster)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp eL)
		(= caughtEgo 0)
		(if (and gMonsterNum (not gGriffinHealth))
			(= monDistance (gEgo distanceTo: monster))
		)
		(if (and (!= newRoomNumber 666) (<= gMonsterHealth 0)) ; rmCombat
			(= gMonsterNum 0)
			(if (gCast contains: monster)
				(monster endCombat:)
			)
		)
		(gFeatures eachElementDo: #dispose release:)
		(if gModelessDialog
			(cls)
		)
		(switch gDesertFunCtr
			(1
				(if (gCast contains: arthur)
					(arthur dispose:)
				)
			)
			(2
				(if (gCast contains: gulfer)
					(cls)
					(gulfer dispose:)
				)
			)
			(3
				(if (gCast contains: theJet)
					(theJet dispose:)
				)
			)
		)
		(if (gCast contains: deadBody)
			(deadBody dispose: delete:)
			(obstacles delete: bodyPoly)
			(= hasTail (= hasClaws 0))
		)
		(if (and (gCast contains: saurus) (saurus inRect: 0 0 320 190))
			(saurus dispose: delete:)
			(obstacles delete: (ScriptID 660 11)) ; saurusPoly
		)
		(HandsOn 1)
		(self setScript: 0)
		(gEgo setScript: 0)
		(if (= eL (gEgo looper:))
			(eL dispose:)
		)
		(cond
			((== newRoomNumber 666) ; rmCombat
				(= gEgoX (gEgo x:))
				(= gEgoY (gEgo y:))
				(super newRoom: newRoomNumber)
			)
			((< (= newRoomNumber (calcRoom gDesertRoom gRoomExitDir)) 0)
				(if (>= gDesertRoom 5000)
					(= gRoomExitDir (FlipDir gRoomExitDir))
				)
				(= gMonsterNum (= gMonsterHealth 0))
				(super newRoom: (- newRoomNumber))
			)
			(else
				(if (and gMonsterNum (gCast contains: monster))
					(monster dispose:)
				)
				(= gPrevRoomNum desert)
				(if (>= gDesertRoom 5000)
					(= gRoomExitDir (FlipDir gRoomExitDir))
				)
				(initDesertRoom newRoomNumber gRoomExitDir)
			)
		)
	)

	(method (handleEvent event &tmp theSaid i)
		(cond
			((Said 'go/home')
				(monsterTimer dispose:)
				(event claimed: 0)
			)
			(
				(and
					gMonsterNum
					(Said
						'mount,ride,(climb,climb,get,get<on,up)[/saurii,roget]'
					)
				)
				(HighPrint 665 0) ; "You'll have to catch him first!"
			)
			((super handleEvent: event))
			((Said 'get,get/blade,weapon')
				(if
					(and
						(gCast contains: deadBody)
						(OneOf (deadBody view:) 680 695)
					)
					(HighPrint 665 1) ; "It is in such bad shape that it would be of no use to you."
				else
					(event claimed: 0)
				)
			)
			((Said 'look,look/tail,stinger')
				(cond
					((not (gCast contains: deadBody))
						(HighPrint 665 2) ; "You don't see one here."
					)
					((OneOf (deadBody view:) 685 680)
						(HighPrint 665 3) ; "It does not have a tail."
					)
					((== (deadBody view:) 671)
						(HighPrint 665 4) ; "The Scorpion's stinger drips its deadly venom."
					)
				)
			)
			((Said 'look,look/claw,nail,bone,hand,finger')
				(cond
					((not (gCast contains: deadBody))
						(HighPrint 665 2) ; "You don't see one here."
					)
					((== (deadBody view:) 680)
						(HighPrint 665 5) ; "It does not have claws."
					)
					((== (deadBody view:) 685)
						(HighPrint 665 6) ; "The Ghoul's claws are a deadly weapon."
					)
				)
			)
			((Said 'get,get,cut,search,get/tail,stinger')
				(cond
					((not (gCast contains: deadBody))
						(HighPrint 665 2) ; "You don't see one here."
					)
					((OneOf (deadBody view:) 685 680)
						(HighPrint 665 3) ; "It does not have a tail."
					)
					(hasTail
						(HighPrint 665 7) ; "You have already taken its tail."
					)
					((== (deadBody view:) 671)
						(HighPrint 665 8) ; "You get the scorpion's tail, carefully avoiding its venom."
						(gEgo get: 29) ; ScorpionTail
						(= hasTail 1)
						(SolvePuzzle 669 5 0)
					)
					(else
						(HighPrint 665 9) ; "You have no use for its tail."
					)
				)
			)
			((Said 'get,get,cut,search,get/claw,nail,bone,hand,finger')
				(cond
					((not (gCast contains: deadBody))
						(HighPrint 665 10) ; "You don't see any here."
					)
					((OneOf (deadBody view:) 680 671)
						(HighPrint 665 11) ; "It does not have any claws."
					)
					(hasClaws
						(HighPrint 665 12) ; "You have already relieved the poor Ghoul of all of its claws."
					)
					((== (deadBody view:) 685)
						(HighPrint 665 13) ; "You get the ghoul's claws."
						(gEgo get: 30 2) ; GhoulClaw
						(= hasClaws 1)
						(SolvePuzzle 668 5 0)
					)
					(else
						(HighPrint 665 14) ; "You have no use for its claws."
					)
				)
			)
			((Said 'search,strip>')
				(if (gCast contains: deadBody)
					(for ((= i 0)) (< i 10) ((+= i 2))
						(if (== [bodySaids i] (deadBody view:))
							(= theSaid [bodySaids (+ i 1)])
							(break)
						)
					)
					(if
						(or
							(Said '/body,monster,alm,loot')
							(Said '[/!*]')
							(Said theSaid)
						)
						(gEgo setScript: searchBody)
					else
						(event claimed: 1)
						(HighPrint 665 2) ; "You don't see one here."
					)
				)
			)
			((gCast contains: monster)
				(cond
					((Said 'attack,attack,kill')
						(self setScript: prepCombat)
					)
					((Said 'run,escape')
						(if (!= gEgoGait 3) ; riding
							(EgoGait 1 0) ; running
						)
						(gEgo setMotion: Flee monster)
					)
				)
			)
		)
	)
)

(instance nightSound of Sound
	(properties
		number 661
		priority 1
		loop -1
	)
)

(instance featPolyR of Polygon
	(properties
		type PBarredAccess
	)
)

(instance featPolyL of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bodyPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance saurusHead of Prop
	(properties
		view 298
	)
)

(instance deadBody of View
	(properties
		x 140
		y 160
		signal 1
	)

	(method (init)
		(= searchY 2)
		(super init: &rest)
	)
)

(instance rock of PicView
	(properties
		noun '/boulder'
		description {the rock}
		view 660
		signal 16384
	)

	(method (handleEvent event)
		(if (and (not (== gEgoGait 3)) (Said 'get,get,(lockpick<up)/boulder')) ; riding
			(gEgo setScript: (ScriptID 60)) ; getRock
		else
			(super handleEvent: event)
		)
	)
)

(instance bush of PicView
	(properties
		noun '/bush,bush,tree,plant,cactus'
		description {the plant}
		view 660
		signal 16384
	)
)

(instance arthur of Prop
	(properties
		y 170
		noun '/man,arthur,king'
		description {the man}
		lookStr {He looks vaguely familiar... maybe you've seen him in a camel lot?}
		view 660
		loop 9
		cycleSpeed 1
	)

	(method (cue)
		(self dispose:)
	)
)

(instance gulfFlag of PicView
	(properties
		y 150
		noun '/flag'
		description {the golf flag}
		lookStr {It is a golf flag.}
		view 660
		loop 7
	)
)

(instance gulfer of Prop
	(properties
		noun '/man,golfer'
		description {the golfer}
		lookStr {He's participating in the Persian Golf tournament.}
		view 660
		loop 8
		priority 1
		signal 16
		cycleSpeed 1
	)
)

(instance theSign of PicView
	(properties
		x 160
		y 170
		noun '/sign'
		description {the sign}
		view 660
		loop 7
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'read/sign')
				(self doVerb: 1)
			)
		)
	)
)

(instance stellar1 of PicView
	(properties
		view 660
		loop 2
		priority 0
		signal 24592
	)
)

(instance stellar2 of PicView
	(properties
		view 660
		loop 2
		priority 0
		signal 24592
	)
)

(class gulfCycle of Fwd
	(properties
		cycles 0
	)

	(method (doit)
		(if cycles
			(if (not (-- cycles))
				(self cue:)
			)
		else
			(super doit:)
		)
	)

	(method (cue)
		(client cel: 0)
	)

	(method (cycleDone)
		(if (< strokeCount 900)
			(GolfPrint)
		)
		(= cycles 10)
	)
)

(class Flee of PolyPath
	(properties)

	(method (init actor enemy toCall)
		(if argc
			(actor setLoop: -1 setPri: -1 heading: (enemy heading:))
			(if (or mtnScene (== gMonsterNum 655))
				(if (> (enemy x:) (actor x:))
					(actor heading: 200)
				else
					(actor heading: 160)
				)
			)
			(cond
				((!= actor saurus))
				((< (actor heading:) 100)
					(actor heading: 100)
				)
				((> (actor heading:) 260)
					(actor heading: 260)
				)
			)
			(super
				init:
					actor
					(+ (actor x:) (SinMult (actor heading:) 600))
					(- (actor y:) (CosMult (actor heading:) 600))
					(and (>= argc 3) toCall)
			)
		else
			(super init:)
		)
	)

	(method (doit &tmp h)
		(super doit:)
		(if (& (client signal:) $0400)
			(client setMotion: MoveTo (client x:) 500)
		)
	)
)

(instance monsterTimer of Timer
	(properties)

	(method (cue &tmp [temp0 4])
		(cond
			(gGriffinHealth)
			((gCast contains: deadBody))
			(
				(and
					(gCast contains: saurus)
					(saurus inRect: 0 0 320 190)
					(!= (saurus view:) 11)
				))
			((or (gEgo script:) (gCurRoom script:)))
			((not gMonsterNum)
				(= gMonsterNum (Random 0 5))
				(= gMonsterNum
					(if gNight
						[nightMonsters gMonsterNum]
					else
						[dayMonsters gMonsterNum]
					)
				)
				(= gMonsterHealth 0)
				(switch gMonsterNum
					(695
						(= gNumJackals (Random 1 5))
						(= gBucks (+ (* (Random 3 8) 100) (Random 2 50)))
					)
					(680
						(= gBucks (+ (* (Random 2 6) 100) (Random 2 50)))
					)
					(else
						(= gBucks 0)
					)
				)
				((= monster (ScriptID gMonsterNum 0)) initAmbush:)
			)
		)
		(SetMonsterTimer)
	)
)

(instance msgTimer of Timer
	(properties)

	(method (cue &tmp [string 40])
		(if (not (gCast contains: monster))
			(Print
				(Format @string 665 17 [heatMsg (Random 0 5)]) ; "%s"
				#at
				-1
				20
				#dispose
			)
		)
		(StartTimer self (Random 45 60))
	)
)

(instance drinkTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (DrinkWater 0)) (not (TakeDamage (* gDrinksLeft -10))))
			(if gNight
				(= string1 {pale desert moon})
			else
				(= string1 {hot desert sun})
			)
			(EgoDead
				1
				(Format @string2 665 18 string1) ; "You collapse under the %s, and perish from dehydration. The desert is no place to be without water."
				#title
				{And not a drop to drink}
			)
		)
		(SetDrinkTimer)
	)
)

(instance desertChecker of Code
	(properties)

	(method (doit spellNum)
		(if (or (== spellNum 6) (== spellNum 28))
			(HighPrint 665 19) ; "There is no need for that here."
			(return 0)
		else
			(return 1)
		)
	)
)

(instance egoEnters of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(User prevDir: register)
	)

	(method (changeState newState &tmp eL newX newY)
		(switch (= state newState)
			(0
				(NormalEgo)
				(if (= eL (gEgo looper:))
					(eL dispose:)
				)
				(switch register
					(1
						(= register 1)
						(gEgo
							loop: 3
							posn: egoToX 210
							setMotion: PolyPath egoToX 187 self
						)
						(= egoToY 0)
					)
					(2
						(= register 3)
						(if inDesert
							(gEgo posn: (- egoToX 320) egoToY)
						else
							(gEgo posn: -20 egoToY)
						)
						(= newX (Max (+ (gEgo x:) 10) 10))
						(= egoToX 350)
						(gEgo setMotion: PolyPath newX egoToY self)
					)
					(4
						(= register 7)
						(if inDesert
							(gEgo posn: (+ egoToX 320) egoToY)
						else
							(gEgo posn: 340 egoToY)
						)
						(= newX (Min (- (gEgo x:) 10) 310))
						(= egoToX -30)
						(gEgo setMotion: PolyPath newX egoToY self)
					)
				)
			)
			(1
				(NormalEgo)
				(gEgo setMotion: PolyPath egoToX egoToY)
				(self dispose:)
			)
		)
	)
)

(instance walkOff of HandsOffScript
	(properties)

	(method (changeState newState &tmp theHeight)
		(switch (= state newState)
			(0
				(if (or (== register 3) (> (calcRoom gDesertRoom gRoomExitDir) 0))
					(switch register
						(3
							(= theHeight
								(- (gEgo nsBottom:) (- (gEgo nsTop:) 1))
							)
							(gEgo
								setMotion:
									PolyPath
									(gEgo x:)
									(+ (gEgo y:) theHeight)
									self
							)
						)
						(2
							(gEgo
								setMotion:
									PolyPath
									(+ (gEgo x:) 30)
									(gEgo y:)
									self
							)
						)
						(4
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) 30)
									(gEgo y:)
									self
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(self dispose:)
				(gCurRoom newRoom: 0)
			)
		)
	)
)

(instance throwEgo of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX)
		(switch (= state newState)
			(0
				(if (and mtnScene (NoRoom 20))
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gMiscSound number: 291 priority: 10 loop: 0 play:)
				(= gEgoGait 0) ; walking
				(gEgo
					view: 15
					setCycle: 0
					setMotion: 0
					setLoop: (if (< (gEgo heading:) 180) 0 else 1)
					setCel: 0
				)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(saurus
					view: 11
					posn: (gEgo x:) (gEgo y:)
					init:
					loop: (gEgo loop:)
					setLoop: Grooper
					setPri: -1
					setCycle: Walk
				)
				(= theX
					(if (gEgo loop:)
						(+ (gEgo x:) 43)
					else
						(- (gEgo x:) 43)
					)
				)
				(gEgo
					posn: theX (+ (gEgo y:) 4)
					setLoop: (+ (gEgo loop:) 2)
					setCel: 0
				)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: End self)
				(= gSaurusRoom gDesertRoom)
				(if monster
					(saurus setMotion: Flee monster)
				else
					(saurus setMotion: MoveTo 160 500)
				)
			)
			(5
				(NormalEgo)
				(if (!= gMonsterNum 655)
					(gEgo setMotion: MoveFwd 15 self)
				else
					(= cycles 2)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sheepScript of Script
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(if (not (saurus loop:))
					(= theX (+ (saurus x:) 23))
				else
					(= theX (- (saurus x:) 23))
				)
				(saurusHead
					x: theX
					y: (saurus y:)
					z: 32
					setLoop: (+ (saurus loop:) 4)
					setCel: 0
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(saurus setLoop: (+ (saurus loop:) 2))
				(saurusHead dispose:)
				(= cycles 1)
			)
			(2
				(MakeSaurusPoly)
				(if (gEgo script:)
					((gEgo script:) next: (ScriptID 660 6)) ; mountSaurus
				else
					(gEgo setScript: (ScriptID 660 6)) ; mountSaurus
				)
				(self dispose:)
			)
		)
	)
)

(instance prepCombat of HandsOffScript
	(properties)

	(method (changeState newState &tmp wpnView)
		(switch (= state newState)
			(0
				(if (== gEgoGait 3) ; riding
					(= cycles 1)
				else
					(if (gEgo has: 7) ; Shield
						(= wpnView 83)
					else
						(= wpnView 84)
					)
					(gEgo
						view: wpnView
						setLoop: (< (monster x:) (gEgo x:))
						cel: 0
						setCycle: End self
					)
				)
			)
			(1
				(self dispose:)
				(gCurRoom newRoom: 666) ; rmCombat
			)
		)
	)
)

(instance searchBody of HandsOffScript
	(properties)

	(method (changeState newState &tmp theD theC theX theY)
		(switch (= state newState)
			(0
				(bodyPoly type: PNearestAccess)
				(= oldX (gEgo x:))
				(= oldY (gEgo y:))
				(= theX (+ (deadBody x:) searchX))
				(= theY (+ (deadBody y:) searchY))
				(gEgo setMotion: PolyPath theX theY self)
			)
			(1
				(gEgo view: 47 setLoop: 0 setCel: 0 setCycle: End)
				(= cycles 12)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(if gBucks
					(if (== (deadBody view:) 695)
						(*= gBucks gJackalsKilled)
					)
					(= theD (/ gBucks 100))
					(if (= theC (mod gBucks 100))
						(Format @string1 665 20 theC) ; "and %d Centimes."
					else
						(Format @string1 665 21) ; "."
					)
					(HighPrint (Format @string2 665 22 theD @string1)) ; "You search the carnage and find %d Dinars%s"
					(gEgo get: 2 theD) ; Dinar
					(gEgo get: 1 theC) ; Centime
					(= gBucks 0)
				else
					(HighPrint 665 23) ; "You find nothing of value."
				)
				(= cycles 1)
			)
			(4
				(if gHitDaggers
					(HighPrint
						(Format @string2 665 24 gHitDaggers) ; "You remove %d of your daggers from the body."
						(gEgo get: 5 gHitDaggers) ; Dagger
						(= gHitDaggers 0)
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo
					illegalBits: 0
					setMotion: PolyPath oldX oldY self
				)
			)
			(6
				(bodyPoly type: PBarredAccess)
				(self dispose:)
			)
		)
	)
)

