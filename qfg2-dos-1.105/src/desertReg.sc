;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use TargActor)
(use Interface)
(use desert)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Grooper)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	desertReg 0
	saurus 1
	duneIn 2
	duneOut 3
	FindNextDune 4
	CheckSaurus 5
	mountSaurus 6
	dismountSaurus 7
	twoDunesIn 8
	twoDunesOut 9
	MakeSaurusPoly 10
	saurusPoly 11
)

(local
	eX
	eY
	[saurusPts 8]
)

(procedure (FindNextDune startX startY whichControl lookUp &tmp findBlack ctrlBits)
	(= findBlack 0)
	(while (< 0 startY 190)
		(= ctrlBits (OnControl CONTROL startX startY))
		(cond
			((not findBlack)
				(if (& ctrlBits whichControl)
					(= findBlack 1)
					(= lookUp 0)
				)
			)
			((& ctrlBits whichControl))
			(else
				(break)
			)
		)
		(if lookUp
			(-- startY)
		else
			(++ startY)
		)
	)
	(if (not findBlack)
		(= startY 0)
	)
	(return startY)
)

(procedure (CheckSaurus event &tmp retVal theX theY)
	(= retVal 3)
	(cond
		((!= (event type:) 128)
			(= retVal 0)
		)
		((not (== gEgoGait 3)) ; riding
			(= retVal 0)
			(cond
				((Said 'mount,ride,(climb,climb,get,get<on,up)[/saurii,roget]')
					(if (or (gCast contains: saurus) (== (gEgo view:) 12))
						(= retVal 2)
					else
						(HighPrint 660 21) ; "Your saurus is not here."
					)
				)
				((Said 'dismount,(climb,climb,get,get<off,down)[/saurii,roget]')
					(HighPrint 660 22) ; "You have to be ON a saurus to get OFF a saurus."
					(if (not (IsFlag 75))
						(SetFlag 75)
						(Print 660 23) ; "Q. How do you get down off a saurus?"
						(Print 660 24) ; "A. You don't. You get down off a duck."
					)
				)
			)
		)
		((Said 'dismount,(climb,climb,get,get<off,down)[/saurii,roget]')
			(= retVal 1)
		)
		((Said 'mount,ride,(climb,climb,get,get<on,up)[/saurii,roget]')
			(HighPrint 660 25) ; "Whee! Nothing like a Saurus ride in the desert!"
		)
		((Said 'quit,look,look,ask>'))
		((Said 'go/home')
			(cond
				((OneOf gCurRoomNum 780 880) ; cityRoom, cityRoom
					(= theX (gEgo x:))
					(= theY 0)
				)
				((== gCurRoomNum 665) ; desert
					(= gDesertRoom (if (>= gDay 27) 8699 else 1301))
					(= theX -20)
					(= theY (gEgo y:))
				)
				((gCurRoom respondsTo: #inOut)
					(gCurRoom west: (if (>= gDay 27) 880 else 780))
					(= theX -20)
					(= theY (gEgo y:))
				)
				(else
					(gCurRoom west: (if (>= gDay 27) 880 else 780))
					(= theX -20)
					(= theY (gEgo y:))
				)
			)
			(HighPrint 660 26) ; "Your saurus' natural homing instinct quickly sets you on the right path."
			(gEgo setMotion: PolyPath theX theY)
		)
		((Said 'get,use,eat,eat/pill')
			(event claimed: 0)
		)
		(else
			(event claimed: 1)
			(HighPrint 660 27) ; "You can't do that while riding a Saurus. You'd fall off."
		)
	)
	(return retVal)
)

(procedure (MakeSaurusPoly &tmp rL rT rR rB theObj theList)
	(if (== gEgoGait 3) ; riding
		(= theObj gEgo)
	else
		(= theObj saurus)
	)
	(BaseSetter saurus)
	(= rL (- (theObj brLeft:) 10))
	(= rT (- (theObj brTop:) 10))
	(= rR (+ (theObj brRight:) 10))
	(= rB (+ (theObj brBottom:) 5))
	(= [saurusPts 0] (= [saurusPts 6] rL))
	(= [saurusPts 1] (= [saurusPts 3] rT))
	(= [saurusPts 2] (= [saurusPts 4] rR))
	(= [saurusPts 5] (= [saurusPts 7] rB))
	(saurusPoly points: @saurusPts size: 4)
	(if
		(or
			(not (= theList (gCurRoom obstacles:)))
			(not (theList contains: saurusPoly))
		)
		(gCurRoom addObstacle: saurusPoly)
	)
)

(instance desertReg of Rgn
	(properties)

	(method (init)
		(Load rsSCRIPT 985)
		(LoadMany rsVIEW 0 5 11 12 13 14 659)
		(if (not gNight)
			(sandPoof init:)
		)
		(= global76 1)
		(super init:)
		(if
			(and
				(== gCurRoomNum (- gSaurusRoom))
				(!= gCurRoomNum 290)
				(!= gEgoGait 3) ; riding
				(gEgo has: 50) ; Saurus
			)
			(saurus view: 298 init:)
			(if (== gCurRoomNum 650)
				(saurus posn: 285 150 loop: 3)
			else
				(saurus posn: 50 150 loop: 2)
			)
			(MakeSaurusPoly)
		)
	)

	(method (handleEvent event &tmp checkSpec)
		(cond
			((super handleEvent: event))
			(
				(and
					(not
						(or (gCast contains: saurus) (== (gEgo view:) 12))
					)
					(Said '/saurii')
				)
				(HighPrint 660 0) ; "You search for your Saurus. Sorry, your Saurus is nowhere to be seen. It seems to have split."
			)
			((Said 'ask,talk,talk/saurii,roget')
				(HighPrint 660 1) ; "Roget, the Saurus, is at a loss for words."
			)
			((Said 'look,look>')
				(cond
					(
						(or
							(Said
								'search,look,look[<at,around][/room,area][/!*]'
							)
							(Said 'look,look/desert')
						)
						(HighPrint 660 2) ; "The waves of desert dunes roll towards the mountains."
					)
					((Said '/saddle,bridle,rein,stirrup')
						(if
							(or
								(gCast contains: saurus)
								(== (gEgo view:) 12)
							)
							(HighPrint 660 3) ; "It was most fortunate that Ali Fakir provided you with some amenities to go with your saurus."
						else
							(HighPrint 660 4) ; "The saurus-riding equipment is on the saurus, wherever he is."
						)
					)
					((or (Said '<up') (Said '/sky,sun,star'))
						(if (& global61 $0001)
							(HighPrint 660 5) ; "The blazing stars take on new meanings in the deserts of Shapeir."
						else
							(HighPrint 660 6) ; "Only a Fresno Raisin could love the blazing orange sun of Shapeir."
						)
					)
					((or (Said '<down') (Said '/ground,sand,boulder'))
						(if (& global61 $0001)
							(HighPrint 660 7) ; "The sand and rock maintain their heat, even during the chilly evening hours."
						else
							(HighPrint 660 8) ; "The searing heat from the bright, burning sands is too much for your strained eyes."
						)
					)
				)
			)
			((== (= checkSpec (CheckSaurus event)) 3))
			((== checkSpec 2)
				(if (and (== gCurRoomNum 620) (saurus script:))
					(HighPrint 660 9) ; "Your saurus seems to want a drink."
				else
					(gCurRoom setScript: mountSaurus)
				)
			)
			((== checkSpec 1)
				(gCurRoom setScript: dismountSaurus)
			)
			((Said 'get,get,(lockpick<up)/boulder')
				(gEgo setScript: (ScriptID 60)) ; getRock
			)
			((Said 'get,get,(lockpick<up)/sand')
				(cond
					((gEgo has: 38) ; ClothBag
						(HighPrint 660 10) ; "You scoop some sand into the cloth bag."
						(+= global318 9)
						(gEgo use: 38 1) ; ClothBag
						(gEgo get: 51 1) ; BagOfSand
					)
					((gEgo has: 51) ; BagOfSand
						(HighPrint 660 11) ; "You have bagged all the sand you can bag."
					)
					(else
						(HighPrint 660 12) ; "You pick up a handful of sand and watch mournfully as it trickles through your fingers and disappears."
					)
				)
			)
		)
	)
)

(instance dismountSaurus of HandsOffScript
	(properties)

	(method (dispose)
		(cond
			((== gCurRoomNum 665) ; desert
				(= oldIllBits -32512)
			)
			((and (== gCurRoomNum 290) (!= gEgoGait 3)) ; riding
				(gCurRoom notify:)
			)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp egoPri)
		(switch (= state newState)
			(0
				(if
					(or
						(NoRoom 15)
						(and (== gCurRoomNum 665) (SaurusToFeature)) ; desert
						(and (== gCurRoomNum 290) (< (gEgo y:) 136))
					)
					(HighPrint 660 13) ; "Your saurus needs more room before you can dismount."
					(self dispose:)
				else
					(self cue:)
				)
			)
			(1
				(if (== gCurRoomNum 620)
					(gEgo setMotion: PolyPath 50 140 self)
				else
					(self cue:)
				)
			)
			(2
				(if (> (gEgo loop:) 1)
					(gEgo loop: 0)
				)
				(= cycles 2)
			)
			(3
				(gEgo view: 14 cel: 5 cycleSpeed: 1 setCycle: Beg self)
			)
			(4
				(= egoPri (gEgo priority:))
				(saurus
					view: 11
					setLoop: Grooper
					loop: (gEgo loop:)
					setPri: (- egoPri 1)
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					init:
				)
				(= gEgoGait 0) ; walking
				(NormalEgo)
				(= cycles 1)
			)
			(5
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(+ (gEgo y:) 7)
						self
				)
			)
			(6
				(saurus setLoop: -1 setCycle: Walk)
				(cond
					((== gCurRoomNum 650)
						(saurus setMotion: PolyPath 285 150 self)
					)
					((== gCurRoomNum 640)
						(saurus setMotion: PolyPath 22 125 self)
					)
					((== gCurRoomNum 620)
						(self cue:)
					)
					((== gCurRoomNum 630)
						(self changeState: 8)
					)
					(else
						(self changeState: 9)
					)
				)
			)
			(7
				(if (== gCurRoomNum 640)
					(saurus setHeading: 90 self)
				else
					(saurus setHeading: 270 self)
				)
			)
			(8
				(saurus view: 298 setLoop: (+ (saurus loop:) 2) setPri: -1)
				(= cycles 1)
			)
			(9
				(if (== gCurRoomNum 665) ; desert
					(= gSaurusRoom gDesertRoom)
				else
					(= gSaurusRoom (- gCurRoomNum))
				)
				(saurus ignoreActors: 0)
				(MakeSaurusPoly)
				(self dispose:)
			)
		)
	)
)

(instance mountSaurus of HandsOffScript
	(properties)

	(method (changeState newState &tmp theDiff theLoop)
		(switch (= state newState)
			(0
				(if
					(not
						(= theDiff
							(if (== gCurRoomNum 665) ; desert
								(SaurusToFeature)
							else
								0
							)
						)
					)
					(self cue:)
				else
					((gCurRoom obstacles:) delete: saurusPoly)
					(saurus
						view: 11
						setLoop: -1
						setPri: -1
						setCycle: Walk
						setMotion:
							PolyPath
							(- (saurus x:) theDiff)
							(saurus y:)
							self
					)
				)
			)
			(1
				(if (not ((gCurRoom obstacles:) contains: saurusPoly))
					(MakeSaurusPoly)
				)
				(EgoGait 0 0) ; walking
				(if
					(and
						(== gCurRoomNum 650)
						(< (gEgo x:) 110)
						(< (gEgo y:) 170)
					)
					(gEgo setMotion: MoveTo 110 170 self)
				else
					(= cycles 1)
				)
			)
			(2
				(saurusPoly type: PNearestAccess)
				(gEgo setMotion: PolyPath (saurus x:) (+ (saurus y:) 3) self)
			)
			(3
				(saurus setPri: (- (saurus priority:) 1))
				(gEgo setMotion: MoveTo (saurus x:) (saurus y:) self)
			)
			(4
				(saurusPoly type: PBarredAccess)
				(= theLoop (saurus loop:))
				(gEgo
					view: 14
					setLoop: (if (OneOf theLoop 1 3) 1 else 0)
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(saurus dispose:)
				(= gSaurusRoom 0)
			)
			(5
				(if ((gCurRoom obstacles:) contains: saurusPoly)
					((gCurRoom obstacles:) delete: saurusPoly)
				)
				(= gEgoGait 3) ; riding
				(NormalEgo)
				(gEgo setHeading: (if (gEgo loop:) 270 else 90))
				(self dispose:)
			)
		)
	)
)

(instance duneOut of Script
	(properties)

	(method (dispose)
		(if (== client gEgo)
			(HandsOn)
			(if (== gCurRoomNum 665) ; desert
				(= gRoomExitDir 1)
			else
				(= gRoomExitDir (gCurRoom topExit:))
			)
			(super dispose:)
			(gCurRoom newRoom: (gCurRoom north:))
		else
			(super dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gEgo)
					(HandsOff)
				)
				(= eX (client x:))
				(= eY (FindNextDune eX (client y:) 4 1))
				(client setLoop: 3 setMotion: MoveTo eX eY self)
			)
			(1
				(client
					setPri: 2
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo (client x:) (+ (client y:) 65) self
				)
			)
			(2
				(if (== client gEgo)
					(NormalEgo)
					(self dispose:)
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance duneIn of Script
	(properties)

	(method (dispose)
		(if (== client gEgo)
			(HandsOn)
			(gEgo illegalBits: -32768 ignoreActors: 0)
			(User prevDir: 5)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= eX (client x:))
				(= eY (FindNextDune eX (client y:) 4 0))
				(if (== client gEgo)
					(HandsOff)
					(NormalEgo)
					(gEgo illegalBits: 0 ignoreActors: 1)
				)
				(client
					posn: eX (+ eY 65)
					setLoop: 2
					setPri: 2
					setMotion: MoveTo eX eY self
				)
			)
			(1
				(client
					setPri: -1
					setLoop: -1
					setMotion: PolyPath (client x:) (+ (client y:) 10) self
				)
			)
			(2
				(client setMotion: PolyPath (client x:) 200)
				(self dispose:)
			)
		)
	)
)

(instance twoDunesOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= eX (client x:))
				(= eY (FindNextDune eX (client y:) 4 1))
				(client
					setLoop: 3
					setPri: 2
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo eX (+ eY 65) self
				)
			)
			(1
				(if (== gEgoGait 3) ; riding
					(client view: 13 setStep: 2 2)
				else
					(client view: 5 setStep: 1 1)
				)
				(cond
					((< eX 130)
						(= eX 130)
					)
					((> eX 190)
						(= eX 190)
					)
				)
				(client x: eX setMotion: MoveTo eX eY self)
			)
			(2
				(= eY (FindNextDune eX (client y:) 2 1))
				(client setMotion: MoveTo eX eY self)
			)
			(3
				(client setPri: 1 setMotion: MoveTo eX (+ eY 20) self)
			)
			(4
				(if (== gCurRoomNum 665) ; desert
					(= gRoomExitDir 1)
				else
					(= gRoomExitDir (gCurRoom topExit:))
				)
				(self dispose:)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance twoDunesIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gEgoGait 3) ; riding
					(client view: 13 setStep: 2 2)
				else
					(client view: 5 setStep: 1 1)
				)
				(= eX (client x:))
				(= eY (FindNextDune eX (client y:) 2 0))
				(client illegalBits: 0 ignoreActors: 1 setPri: 1 setLoop: 2)
				(client
					posn: eX (+ eY 20)
					setMotion: MoveTo eX eY self
				)
			)
			(1
				(= eY (FindNextDune eX eY 4 0))
				(client setPri: 2 setMotion: MoveTo eX (+ eY 65) self)
			)
			(2
				(EgoGait -1 0)
				(client
					posn: eX (+ eY 65)
					setLoop: 2
					setMotion: MoveTo eX eY self
				)
			)
			(3
				(NormalEgo)
				(client
					illegalBits: 0
					setMotion: PolyPath eX (+ eY 10) self
				)
			)
			(4
				(client setMotion: PolyPath eX 200)
				(self dispose:)
			)
		)
	)
)

(instance saurusPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance sandPoof of Prop
	(properties
		shiftClick 0
		contClick 0
		view 659
		signal 16384
	)

	(method (doit)
		(if
			(and
				(== (gEgo view:) 0)
				(gEgo mover:)
				(not (gEgo script:))
			)
			(= loop (gEgo loop:))
			(= cel (gEgo cel:))
			(= x (gEgo x:))
			(= y (gEgo y:))
			(self show:)
		else
			(self hide:)
		)
		(super doit:)
	)
)

(instance saurus of TargActor
	(properties
		noun '/saurii,roget'
		description {saurus}
		yStep 3
		view 11
		loop 1
		xStep 5
	)

	(method (dispose)
		(if (not gSaurusRoom)
			(if (== gCurRoomNum 665) ; desert
				(= gSaurusRoom gDesertRoom)
			else
				(= gSaurusRoom (- gCurRoomNum))
			)
		)
		(super dispose:)
	)

	(method (doit)
		(if (and (not script) (& (self onControl:) $0004))
			(self setScript: duneOut)
		else
			(super doit:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== gEgoGait 3) ; riding
					(HighPrint 660 14) ; "Don't these things ever sweat?"
				else
					(HighPrint 660 15) ; "In Spielburg, these things weren't so friendly."
				)
			)
			(7
				(if (== gEgoGait 3) ; riding
					(HighPrint 660 16) ; "You got it."
				else
					(HighPrint 660 17) ; "Just walk on over and get it."
				)
			)
			(4
				(HighPrint 660 18) ; "Where's that clothespin!"
			)
			(6
				(HighPrint 660 19) ; "If it tastes anything like it smells...!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (hurtMe)
		(HighPrint 660 20) ; "That's not a good idea."
	)

	(method (handleEvent event)
		(if (and (== gCurRoomNum 290) (Said 'get,get/saurii,roget'))
			(event claimed: 0)
			(gCurRoom handleEvent: event)
		else
			(super handleEvent: event)
		)
	)
)

