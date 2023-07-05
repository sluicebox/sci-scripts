;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use n027)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	MuseumRgn 0
	aCountess 1
	aOlympia 2
	aORiley 3
	aTut 4
	aWatney 5
	aYvette 6
	aZiggy 7
	fumeTimer 13
	meetingTimer 15
)

(local
	[local0 100] = [350 632 4 0 1 360 0 638 0 0 370 0 0 0 635 420 7 -1 0 624 500 15 0 608 0 510 512 128 64 31 520 0 0 575 0 530 -1 0 127 0 430 32 -1 0 94 440 28 33 64 0 448 24 0 99 0 450 0 0 103 16 454 0 111 0 0 480 95 0 0 0 490 63 0 0 0 550 0 0 639 0 600 2 12 -1 0 610 8 0 3 0 630 0 7 0 0 650 0 0 13 0]
	[local100 120] = [350 2 420 370 0 360 360 1 0 350 0 0 370 4 0 0 0 350 420 8 350 430 0 500 500 16 420 0 510 0 510 32 530 550 520 500 520 64 0 0 510 0 530 512 600 0 510 0 430 1 480 420 0 440 440 2 448 430 490 0 448 4 450 0 440 0 450 8 0 0 448 454 454 16 0 450 0 0 480 32 430 0 0 0 490 64 0 0 440 0 550 128 0 0 510 0 600 1 650 610 530 0 610 4 630 0 600 0 630 8 0 610 0 0 650 2 0 0 600 0]
	[local220 40] = [350 0 360 0 370 0 420 0 500 0 510 0 520 0 530 0 430 0 440 0 448 0 450 0 454 0 480 0 490 0 550 0 600 0 610 0 630 0 650 0]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1
		(switch param1
			(1 5)
			(2 6)
			(3 2)
		)
	)
	(for ((= temp0 0)) (< temp0 21) ((++ temp0))
		(if
			(==
				(= temp2
					(switch param1
						(1 [local0 (* temp0 temp1)])
						(2 [local100 (* temp0 temp1)])
						(3 [local220 (* temp0 temp1)])
					)
				)
				param2
			)
			(return (* temp0 temp1))
		)
	)
)

(class MuseumRgn of Rgn
	(properties
		northList 0
		northModule 0
		eastList 0
		eastModule 0
		southList 0
		southModule 0
		westList 0
		westModule 0
		northPts 0
		eastPts 0
		southPts 0
		westPts 0
		midPts 0
		legalX 0
		legalY 0
	)

	(method (init)
		(super init:)
		(self loadPolyList:)
		(if (not (IsFlag 6))
			((ScriptID 90 1) init:) ; aCountess
		)
		((ScriptID 90 2) init:) ; aOlympia
		((ScriptID 90 3) init:) ; aORiley
		((ScriptID 90 4) init:) ; aTut
		(if (not (IsFlag 3))
			((ScriptID 90 5) init:) ; aWatney
		)
		(if (not (IsFlag 5))
			((ScriptID 90 6) init:) ; aYvette
		)
		(if (not (IsFlag 2))
			((ScriptID 90 7) init:) ; aZiggy
		)
		(gKeyDownHandler addToFront: self)
		(if (not (gTimers contains: wanderTimer))
			(wanderTimer setReal: wanderTimer 120)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep
			(OneOf
				newRoomNumber
				335
				340 ; testRoom
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456 ; magRosetta
				460
				480
				490
				521 ; meanWhile
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
		)
		(= initialized 0)
		(gKeyDownHandler delete: self)
		(if (gCurRoom obstacles:)
			(DisposeScript (+ 2000 gCurRoomNum))
		)
		(if northList
			(northList dispose:)
			(= northList 0)
			(if (IsObject northPts)
				(northPts dispose:)
			)
			(= northPts 0)
			(DisposeScript northModule)
		)
		(if eastList
			(eastList dispose:)
			(= eastList 0)
			(if (IsObject eastPts)
				(eastPts dispose:)
			)
			(= eastPts 0)
			(DisposeScript eastModule)
		)
		(if southList
			(southList dispose:)
			(= southList 0)
			(if (IsObject southPts)
				(southPts dispose:)
			)
			(= southPts 0)
			(DisposeScript southModule)
		)
		(if westList
			(westList dispose:)
			(= westList 0)
			(if (IsObject westPts)
				(westPts dispose:)
			)
			(= westPts 0)
			(DisposeScript westModule)
		)
	)

	(method (dispose)
		(if (gTimers contains: wanderTimer)
			(wanderTimer dispose: delete:)
		)
		(super dispose:)
	)

	(method (crowdInRoom param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (< argc 2)
			(= temp0 (localproc_0 3 [param1 0]))
			(return [local220 (++ temp0)])
		else
			(= temp3 [param1 0])
			(= temp4 [param1 1])
			(= temp1 1)
			(while (and temp3 (<= temp1 argc))
				(if (> temp3 0)
					(= [local220 (+ temp0 1)]
						(+
							[local220 (+ (= temp0 (localproc_0 3 temp3)) 1)]
							temp4
						)
					)
				)
				(= temp3 [param1 (++ temp1)])
				(= temp4 [param1 (++ temp1)])
			)
		)
	)

	(method (findLegalPoint param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if
			(not
				(= temp1
					(switch param1
						((gCurRoom north:)
							(MuseumRgn northList:)
						)
						((gCurRoom east:)
							(MuseumRgn eastList:)
						)
						((gCurRoom south:)
							(MuseumRgn southList:)
						)
						((gCurRoom west:)
							(MuseumRgn westList:)
						)
						(gCurRoomNum
							(gCurRoom obstacles:)
						)
						(else 0)
					)
				)
			)
			(return 1)
		)
		(= temp0 1)
		(for ((= temp3 0)) (and temp0 (< temp3 (temp1 size:))) ((++ temp3))
			(= temp2 (temp1 at: temp3))
			(if
				(or
					(and
						(== (temp2 type:) 3)
						(not (AvoidPath param2 param3 temp2))
					)
					(and (!= (temp2 type:) 3) (AvoidPath param2 param3 temp2))
				)
				(= temp0 0)
			)
		)
		(if (not temp0)
			(switch param1
				((gCurRoom north:)
					(= legalX ((MuseumRgn northPts:) midPtX:))
					(= legalY ((MuseumRgn northPts:) midPtY:))
				)
				((gCurRoom east:)
					(= legalX ((MuseumRgn eastPts:) midPtX:))
					(= legalY ((MuseumRgn eastPts:) midPtY:))
				)
				((gCurRoom south:)
					(= legalX ((MuseumRgn southPts:) midPtX:))
					(= legalY ((MuseumRgn southPts:) midPtY:))
				)
				((gCurRoom west:)
					(= legalX ((MuseumRgn westPts:) midPtX:))
					(= legalY ((MuseumRgn westPts:) midPtY:))
				)
				(gCurRoomNum
					(= legalX ((MuseumRgn midPts:) midPtX:))
					(= legalY ((MuseumRgn midPts:) midPtY:))
				)
			)
		)
		(return temp0)
	)

	(method (loadPolyList)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
		)
		(if northList
			(northList dispose:)
		)
		(if eastList
			(eastList dispose:)
		)
		(if southList
			(southList dispose:)
		)
		(if westList
			(westList dispose:)
		)
		(gCurRoom obstacles: (List new:))
		((ScriptID (+ 2000 gCurRoomNum) 0) doit: (gCurRoom obstacles:))
		(if
			(OneOf
				(gCurRoom north:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= northModule (+ 2000 (gCurRoom north:)))
			((ScriptID northModule 0) doit: (= northList (List new:)))
		)
		(if
			(OneOf
				(gCurRoom east:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= eastModule (+ 2000 (gCurRoom east:)))
			((ScriptID eastModule 0) doit: (= eastList (List new:)))
		)
		(if
			(OneOf
				(gCurRoom south:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= southModule (+ 2000 (gCurRoom south:)))
			((ScriptID southModule 0) doit: (= southList (List new:)))
		)
		(if
			(OneOf
				(gCurRoom west:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= westModule (+ 2000 (gCurRoom west:)))
			((ScriptID westModule 0) doit: (= westList (List new:)))
		)
		(= midPts (ScriptID (+ 2000 gCurRoomNum) 1))
		(if
			(OneOf
				(gCurRoom north:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= northPts (ScriptID northModule 1))
		)
		(if
			(OneOf
				(gCurRoom east:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= eastPts (ScriptID eastModule 1))
		)
		(if
			(OneOf
				(gCurRoom south:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= southPts (ScriptID southModule 1))
		)
		(if
			(OneOf
				(gCurRoom west:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= westPts (ScriptID westModule 1))
		)
	)

	(method (nobodyAround)
		(if
			(OneOf
				gCurRoomNum
				((ScriptID 90 1) room:) ; aCountess
				((ScriptID 90 2) room:) ; aOlympia
				((ScriptID 90 3) room:) ; aORiley
				((ScriptID 90 4) room:) ; aTut
				((ScriptID 90 5) room:) ; aWatney
				((ScriptID 90 6) room:) ; aYvette
				((ScriptID 90 7) room:) ; aZiggy
			)
			(gMessager say: 16 46 0 0 0 0) ; "Jeepers, Laura, not in front of witnesses!"
			(return 0)
		else
			(return 1)
		)
	)

	(method (whichList param1)
		(return
			(switch param1
				(gCurRoomNum
					(gCurRoom obstacles:)
				)
				((gCurRoom north:) northList)
				((gCurRoom east:) eastList)
				((gCurRoom south:) southList)
				((gCurRoom west:) westList)
			)
		)
	)
)

(class MuseumActor of Actor
	(properties
		originalView 0
		beelining 0
		wandering 0
		room 0
		lastRoom 0
		destination 0
		originalDest 0
		roomIdx 0
		exitX 0
		exitY 0
		destX 0
		destY 0
		waitCount 0
	)

	(method (init &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 [temp7 5])
		(self
			view: (if (== room gCurRoomNum) originalView else 828)
			ignoreActors:
			ignoreHorizon:
			illegalBits: 0
			setCycle: StopWalk -1
		)
		(if (gEgo scaler:)
			(= temp2 (/ (* 110 ((gEgo scaler:) frontSize:)) 100))
			(= temp3 ((gEgo scaler:) frontY:))
			(= temp4 (/ (* 110 (+ 1 ((gEgo scaler:) backSize:))) 100))
			(= temp5 ((gEgo scaler:) backY:))
			(self setScale: Scaler temp2 temp4 temp3 temp5)
		else
			(self setScale: -1 gEgo)
			(= maxScale (/ (* 110 maxScale) 100))
		)
		(super init: &rest)
		(cond
			((not beelining)
				(cond
					(wandering
						(cond
							((== room gCurRoomNum) 0)
							((self isAdjacent:)
								(if (not (MuseumRgn findLegalPoint: room x y))
									(self
										posn:
											(MuseumRgn legalX:)
											(MuseumRgn legalY:)
									)
								)
							)
							(else
								(self posn: 160 165)
							)
						)
						(if (> (MuseumRgn crowdInRoom: room) 1)
							(-= temp6 15) ; UNINIT
						)
						(self wander: originalDest self)
					)
					((and (== room -1) (Random 0 1))
						(cond
							((== room gCurRoomNum)
								(if (not (MuseumRgn findLegalPoint: room x y))
									(self
										posn:
											(MuseumRgn legalX:)
											(MuseumRgn legalY:)
									)
								)
							)
							((self isAdjacent:)
								(if (not (MuseumRgn findLegalPoint: room x y))
									(self
										posn:
											(MuseumRgn legalX:)
											(MuseumRgn legalY:)
									)
								)
							)
							(else 0)
						)
						(self wander:)
					)
				)
			)
			(originalDest
				(cond
					((== room gCurRoomNum)
						(if (not (MuseumRgn findLegalPoint: room x y))
							(self posn: (MuseumRgn legalX:) (MuseumRgn legalY:))
						)
					)
					((self isAdjacent:)
						(if (not (MuseumRgn findLegalPoint: room x y))
							(self posn: (MuseumRgn legalX:) (MuseumRgn legalY:))
						)
					)
					(else 0)
				)
				(self goTo: originalDest self)
			)
			((== room destination)
				(= destination 0)
			)
		)
	)

	(method (dirToRoom param1 &tmp temp0 temp1)
		(= temp0 (self setBits: param1))
		(= temp1 (* roomIdx 5))
		(cond
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 1)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 2)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 3)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 4)
			)
			(else
				(return 0)
			)
		)
	)

	(method (findRendezvous param1)
		(cond
			(
				(OneOf
					room
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					335
					340
					350
					355
					360
					370
					400
				)
				(cond
					(
						(OneOf
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
						(= destination 420)
					)
					((OneOf param1 600 610 620 630 640 650 666)
						(= destination 530)
					)
				)
			)
			((OneOf room 430 435 440 448 450 454 455 456 460 480 490 521)
				(if
					(not
						(OneOf
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
					)
					(= destination 430)
				)
			)
			(
				(and
					(OneOf room 600 610 620 630 640 650 666)
					(not (OneOf param1 600 610 620 630 640 650 666))
				)
				(= destination 600)
			)
		)
		(return destination)
	)

	(method (isAdjacent)
		(return
			(switch room
				((gCurRoom north:) 1)
				((gCurRoom south:) 3)
				((gCurRoom east:) 2)
				((gCurRoom west:) 4)
				(else 0)
			)
		)
	)

	(method (goTo param1 param2 param3 param4)
		(= beelining 1)
		(if (OneOf room -1 -2)
			(self moveTo: originalDest)
		)
		(= destination (= originalDest param1))
		(if (< argc 2)
			(= param2 0)
		)
		(if (> argc 2)
			(= destX param3)
			(= destY param4)
		else
			(= destY (= destX -1))
		)
		(self setScript: (TravelToRoom new:) param2)
	)

	(method (moveTo param1 &tmp temp0 temp1)
		(if (OneOf param1 -1 -2)
			(if (MuseumRgn crowdInRoom: room)
				(MuseumRgn crowdInRoom: room -1)
			)
			(= originalDest room)
			(= room param1)
			(= beelining (= wandering 0))
			(self setScript: 0)
			(return)
		else
			(= wandering 0)
			(self setScript: 0)
			(= temp1 room)
			(= room param1)
			(if (and (> temp1 0) (!= temp1 355) (!= param1 355))
				(self setIndex: room)
				(= lastRoom (self nextRoom: (self dirToRoom: temp1)))
				(MuseumRgn crowdInRoom: lastRoom -1)
			)
			(= view (if (== room gCurRoomNum) originalView else 828))
			(MuseumRgn crowdInRoom: room 1)
		)
	)

	(method (nextRoom param1)
		(return [local100 (+ (* roomIdx 6) param1 1)])
	)

	(method (onMe)
		(if (== view 828)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (setBits param1 &tmp temp0)
		(= temp0 (localproc_0 2 param1))
		(return [local100 (++ temp0)])
	)

	(method (setIndex &tmp temp0)
		(= roomIdx (/ (= temp0 (localproc_0 2 room)) 6))
	)

	(method (wander param1 param2 param3 param4 &tmp temp0)
		(if (not argc)
			(while (== room (= temp0 [local100 (* (Random 0 22) 6)]))
				0
			)
		else
			(= temp0 param1)
		)
		(= beelining 0)
		(= wandering 1)
		(= destination (= originalDest temp0))
		(if (< argc 2)
			(= param2 0)
		)
		(if (> argc 2)
			(= destX param3)
			(= destY param4)
		else
			(= destY (= destX -1))
		)
		(= waitCount 10)
		(self setScript: (TravelToRoom new:) param2)
	)
)

(instance aCountess of MuseumActor
	(properties
		noun 1
		modNum 1884
		origStep 514
		originalView 813
	)

	(method (cue)
		(self wander:)
	)

	(method (wander param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 room)
			(while (== temp1 room)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(cond
					((== gAct 3)
						(cond
							((<= temp0 5)
								(= temp1 450)
							)
							((<= temp0 10)
								(= temp1 454)
							)
							((<= temp0 50)
								(= temp1 500)
							)
						)
					)
					((<= temp0 40)
						(= temp1 500)
					)
				)
			)
			(if temp1
				(if (== room -1)
					(if (> originalDest 0)
						(self moveTo: originalDest)
					)
					(= originalDest 0)
				)
				(super wander: temp1 self)
			else
				(if (!= room -1)
					(= originalDest room)
				)
				(self moveTo: -1)
				(= wandering 0)
			)
		else
			(super wander: param1 &rest)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 0 global364)
								(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
							else
								(gMessager say: noun 6 72 0 0 modNum) ; "He WAS rather a good-looking fellow, don't you think? Of course, I was at the PARTY when he died, surrounded by WITNESSES, but I've already TOLD Mr. O'Riley about all that."
								(proc27_1 0 @global364)
							)
						)
						((proc27_0 0 global297)
							(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
						)
						(else
							(gMessager say: noun 6 3 0 0 modNum) ; "Ah, truly a man of great ambition and integrity, mmmm?"
							(proc27_1 0 @global297)
						)
					)
				)
				(264
					(cond
						((IsFlag 143)
							(if (proc27_0 0 global366)
								(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
							else
								(gMessager say: noun 6 74 0 0 modNum) ; "Do you know anything about the circumstances of Ziggy's death?"
								(proc27_1 0 @global366)
							)
						)
						((proc27_0 0 global303)
							(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
						)
						(else
							(gMessager say: noun 6 9 0 0 modNum) ; "He seems a perfectly DREADFUL little fellow. Let's not discuss him."
							(proc27_1 0 @global303)
						)
					)
				)
				(267
					(cond
						((IsFlag 158)
							(if (proc27_0 0 global365)
								(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
							else
								(gMessager say: noun 6 71 0 0 modNum) ; "I'm SURE I have no IDEA who could have killed him."
								(proc27_1 0 @global365)
							)
						)
						((proc27_0 0 global306)
							(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
						)
						(else
							(gMessager say: noun 6 12 0 0 modNum) ; "Well, I DO wish they wouldn't let the HANDYMAN in during social functions. He's not even DRESSED properly!"
							(proc27_1 0 @global306)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET modNum noun 6 temp1 1))
							(gMessager say: noun 6 81 0 0 modNum) ; "I SIMPLY don't know HOW to answer THAT, my dear."
						)
						((proc27_0 0 [global296 (- temp1 2)])
							(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
						)
						(else
							(gMessager say: noun 6 temp1 0 0 modNum)
							(proc27_1 0 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aOlympia of MuseumActor
	(properties
		noun 1
		modNum 1892
		scaleSignal 1
		originalView 820
	)

	(method (cue)
		(self wander:)
	)

	(method (wander param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 room)
			(while (== temp1 room)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(cond
					((== gAct 3)
						(cond
							((<= temp0 15)
								(= temp1 650)
							)
							((<= temp0 25)
								(= temp1 450)
							)
							((<= temp0 35)
								(= temp1 454)
							)
							((<= temp0 85)
								(= temp1 520)
							)
						)
					)
					((<= temp0 30)
						(= temp1 650)
					)
					((<= temp0 80)
						(= temp1 520)
					)
				)
			)
			(if temp1
				(if (== room -1)
					(if (> originalDest 0)
						(self moveTo: originalDest)
					)
					(= originalDest 0)
				)
				(super wander: temp1 self)
			else
				(if (!= room -1)
					(= originalDest room)
				)
				(self moveTo: -1)
				(= wandering 0)
			)
		else
			(super wander: param1 &rest)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 3 global364)
								(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
							else
								(gMessager say: noun 6 72 0 0 modNum) ; "I think Doctor Carter is quite fortunate to have crossed into the Underworld. Now, he can finally meet Amon Ra in person. I'm sure if he'd had the choice, Doctor Carter would have WANTED to die the way he did. In a way, it sums up his entire archaeological career."
								(proc27_1 3 @global364)
							)
						)
						((proc27_0 3 global297)
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 3 0 0 modNum) ; "Doctor Carter is an odd one, if you ask me. He is so very interested in gaining personal glory. He doesn't seem to fully understand the beauty of what he has discovered. Why, the Amon Ra artifacts are a symphony, a tribute to the wonders of death. Ahh!"
							(proc27_1 3 @global297)
						)
					)
				)
				(259
					(cond
						((IsFlag 171)
							(if (proc27_0 3 global363)
								(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
							else
								(gMessager say: noun 6 69 0 0 modNum) ; "Poor Doctor Carrington. He certainly had an interesting death, didn't he? I hope I expire in an equally unique fashion when my time comes."
								(proc27_1 3 @global363)
							)
						)
						((proc27_0 3 global298)
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 4 0 0 modNum) ; "Doctor Carrington is a quiet one. I don't see him very often. I'm certain, however, that he must have a poetic soul."
							(proc27_1 3 @global298)
						)
					)
				)
				(264
					(cond
						((IsFlag 143)
							(if (proc27_0 3 global366)
								(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
							else
								(gMessager say: noun 6 74 0 0 modNum) ; "Ah, he's the odd little fellow who lost his head, yes? He must have been VERY unlucky to have been walking under that Pterodactyl at the moment it broke loose from its mount on the ceiling. Imagine, being the only human ever to die from a Pterodactyl bite!"
								(proc27_1 3 @global366)
							)
						)
						((proc27_0 3 global303)
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 9 0 0 modNum) ; "An odd little fellow, that one. He reminds me of one of the specimens in my dried rat collection."
							(proc27_1 3 @global303)
						)
					)
				)
				(266
					(cond
						((IsFlag 161)
							(if (proc27_0 3 global367)
								(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
							else
								(gMessager say: noun 6 73 0 0 modNum) ; "Yvette's death was quite...unexpected...but it holds a certain charm in the way the killer plastered her body and placed it on display. Now her dead, but perfect, form can be enjoyed by thousands of museum patrons, not to mention those who...loved her."
								(proc27_1 3 @global367)
							)
						)
						((proc27_0 3 global305)
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 11 0 0 modNum) ; "I find Yvette to be a charming young lady. Some people around here don't appreciate her...zest for life, but I find her quite refreshing."
							(proc27_1 3 @global305)
						)
					)
				)
				(267
					(cond
						((IsFlag 158)
							(if (proc27_0 3 global365)
								(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
							else
								(gMessager say: noun 6 71 0 0 modNum) ; "It's unfortunate that Ernie died, but his body IS nicely displayed on that Mastodon, don't you think? Makes quite a nice exhibit, actually."
								(proc27_1 3 @global365)
							)
						)
						((proc27_0 3 global306)
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 12 0 0 modNum) ; "I don't know Ernie very well, but he seems like a nice fellow. He never kills spiders, so my little Daisy can eat them."
							(proc27_1 3 @global306)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET modNum noun 6 temp1 1))
							(gMessager say: noun 6 81 0 0 modNum) ; "I'm SURE I DON'T have an answer for THAT, Miss Bow."
						)
						((proc27_0 3 [global296 (- temp1 2)])
							(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
						)
						(else
							(gMessager say: noun 6 temp1 0 0 modNum)
							(proc27_1 3 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aORiley of MuseumActor
	(properties
		noun 1
		modNum 1888
		originalView 818
	)

	(method (init)
		(= origStep (if (== view 818) 1282 else 770))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 4 global364)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 72 0 0 modNum) ; "Someone got tired of the man's big ego, would be my guess."
								(proc27_1 4 @global364)
							)
						)
						((proc27_0 4 global297)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 3 0 0 modNum) ; "That fella is just too big for his britches, that's all I have to say. Someone ought to take him down a notch or two."
							(proc27_1 4 @global297)
						)
					)
				)
				(259
					(cond
						((IsFlag 171)
							(if (proc27_0 4 global363)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 69 0 0 modNum) ; "I guess you've examined poor Dr. Carrington's body?"
								(proc27_1 4 @global363)
							)
						)
						((proc27_0 4 global298)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 4 0 0 modNum) ; "He's got too many brains, that one. He thinks he's better than us all."
							(proc27_1 4 @global298)
						)
					)
				)
				(264
					(cond
						((IsFlag 143)
							(if (proc27_0 4 global366)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 74 0 0 modNum) ; "Have you had a chance to examine Ziggy's body?"
								(proc27_1 4 @global366)
							)
						)
						((proc27_0 4 global303)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 9 0 0 modNum) ; "That man is a human weasel. Stay away from him, lassie."
							(proc27_1 4 @global303)
						)
					)
				)
				(266
					(cond
						((IsFlag 161)
							(if (proc27_0 4 global367)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 73 0 0 modNum) ; "Have you had a chance to examine Miss Delacroix's body?"
								(proc27_1 4 @global367)
							)
						)
						((proc27_0 4 global305)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 11 0 0 modNum) ; "Now, there's a lovely girl. A real lady, don't you know."
							(proc27_1 4 @global305)
						)
					)
				)
				(267
					(cond
						((IsFlag 158)
							(if (proc27_0 4 global365)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 71 0 0 modNum) ; "Have you had a chance to examine Mr. Leach's body yet?"
								(proc27_1 4 @global365)
							)
						)
						((proc27_0 4 global306)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 12 0 0 modNum) ; "Oh, he's an okay fella, I suppose. I haven't spent much time with the man."
							(proc27_1 4 @global306)
						)
					)
				)
				(780
					(cond
						((IsFlag 155)
							(if (proc27_0 4 global368)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							else
								(gMessager say: noun 6 75 0 0 modNum) ; "Sir, I think I've found the Dagger of Amon Ra."
								(proc27_1 4 @global368)
							)
						)
						((proc27_0 4 global332)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 38 0 0 modNum) ; "It's an oversized letter opener, if you ask me."
							(proc27_1 4 @global332)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET modNum noun 6 temp1 1))
							(gMessager say: noun 6 81 0 0 modNum) ; "Sure and begorrah, the next thing you'll be asking me is where the little people keep their pots o' gold! I can't tell you anything about that, lass."
						)
						((proc27_0 4 [global296 (- temp1 2)])
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
						)
						(else
							(gMessager say: noun 6 temp1 0 0 modNum)
							(proc27_1 4 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aTut of MuseumActor
	(properties
		noun 1
		modNum 1883
		scaleSignal 1
		originalView 821
	)

	(method (cue)
		(self wander:)
	)

	(method (wander param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 room)
			(while (== temp1 room)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 5)
						(= temp1 450)
						(continue)
					)
					(if (<= temp0 10)
						(= temp1 454)
					)
				)
			)
			(if temp1
				(if (== room -1)
					(if (> originalDest 0)
						(self moveTo: originalDest)
					)
					(= originalDest 0)
				)
				(super wander: temp1 self)
			else
				(if (!= room -1)
					(= originalDest room)
				)
				(self moveTo: -1)
				(= wandering 0)
			)
		else
			(super wander: param1 &rest)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 7 global364)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
							else
								(gMessager say: noun 6 72 0 0 modNum) ; "You DARE to mention his name to me? He is the blasphemous temple destroyer and tomb robber who stole the Dagger of Amon Ra from Egypt!"
								(proc27_1 7 @global364)
							)
						)
						((proc27_0 7 global297)
							(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
						)
						(else
							(gMessager say: noun 6 3 0 0 modNum) ; "You DARE to mention his name to me? He is the blasphemous temple destroyer and tomb robber who stole the Dagger of Amon Ra from Egypt! He will know the full force of the Curse of the Pharaohs!"
							(proc27_1 7 @global297)
						)
					)
				)
				(266
					(cond
						((IsFlag 161)
							(if (proc27_0 7 global367)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
							else
								(gMessager say: noun 6 73 0 0 modNum) ; "Her death is a great loss to all mankind. She was femininity incarnate. She would have made a suitable second wife for me if she had accepted my generous offer of marriage. I wept when I learned of her demise."
								(proc27_1 7 @global367)
							)
						)
						((proc27_0 7 global305)
							(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
						)
						(else
							(gMessager say: noun 6 11 0 0 modNum) ; "Ahh. A delightful girl. I keep asking her if she'd like to be my second wife. She is so very...feminine. And seductive. And charming. And attractive. And..."
							(proc27_1 7 @global305)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET modNum noun 6 temp1 1))
							(gMessager say: noun 6 81 0 0 modNum) ; "Ah, now that's a question worthy of the Great Sphinx. Unfortunately, I, myself, cannot answer it."
						)
						((proc27_0 7 [global296 (- temp1 2)])
							(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
						)
						(else
							(gMessager say: noun 6 temp1 0 0 modNum)
							(proc27_1 7 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aWatney of MuseumActor
	(properties
		noun 1
		modNum 1886
		originalView 815
	)

	(method (cue)
		(self wander:)
	)

	(method (wander param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 room)
			(while (== temp1 room)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 40)
						(= temp1 500)
						(continue)
					)
					(if (<= temp0 85)
						(= temp1 530)
					)
				)
			)
			(if temp1
				(if (== room -1)
					(if (> originalDest 0)
						(self moveTo: originalDest)
					)
					(= originalDest 0)
				)
				(super wander: temp1 self)
			else
				(if (!= room -1)
					(= originalDest room)
				)
				(self moveTo: -1)
				(= wandering 0)
			)
		else
			(super wander: param1 &rest)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 8 global364)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm really very busy, Miss Bow. I don't have time to cover the same subject twice."
							else
								(gMessager say: noun 6 72 0 0 modNum) ; "Dr. Carter's demise was truly a loss to us all, despite his pushy, overinflated, headline-grabbing ego. At least he completed his work on the Ancient Egypt exhibit before he passed on. Dedicated chap, I'll say that for him."
								(proc27_1 8 @global364)
							)
						)
						((proc27_0 8 global297)
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm really very busy, Miss Bow. I don't have time to cover the same subject twice."
						)
						(else
							(gMessager say: noun 6 3 0 0 modNum) ; "The fellow has quite an overinflated ego, but he's got a legitimate reason for it, I suppose."
							(proc27_1 8 @global297)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET modNum noun 6 temp1 1))
							(gMessager say: noun 6 81 0 0 modNum) ; "I'm sure I don't know how to answer THAT, I daresay."
						)
						((proc27_0 8 [global296 (- temp1 2)])
							(gMessager say: noun 6 1 0 0 modNum) ; "I'm really very busy, Miss Bow. I don't have time to cover the same subject twice."
						)
						(else
							(gMessager say: noun 6 temp1 0 0 modNum)
							(proc27_1 8 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aYvette of MuseumActor
	(properties
		noun 1
		modNum 1885
		scaleSignal 1
		originalView 817
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(gMessager say: noun theVerb 27 0 0 modNum) ; "Bonjour, Miss Bow. How are you enjoying ze museum zees evening?"
			)
			((OneOf theVerb 6 14) ; Ask, notebook
				(if
					(==
						(= temp0
							(if (== argc 2)
								invItem
							else
								(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256
							(+ temp2 1)
						)
						(512
							(+ temp2 18)
						)
						(768
							(+ temp2 26)
						)
						(1024
							(+ temp2 61)
						)
					)
				)
				(switch temp0
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 9 global365)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
								else
									(gMessager say: noun 6 71 0 0 modNum) ; "Oh, my Ernie! Ze Icepick got heem!"
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum) ; "Ahh, Monsieur Leach, he ees ze very honorable man, no? Of everyone here, I trust heem most of all. Hees pay, eet ees not very good, but I will fix that when I become ze museum President someday. In ze meantime, he must do ze extra outside work to pay hees bills."
								(proc27_1 9 @global306)
							)
						)
					)
					(259
						(cond
							((IsFlag 171)
								(if (proc27_0 9 global363)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
								else
									(gMessager say: noun 6 69 0 0 modNum) ; "Doctor Carrington was ze strange one. Only recently did he invite me into hees office for a long...talk."
									(proc27_1 9 @global363)
								)
							)
							((proc27_0 9 global298)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum) ; "Doctor Carrington, he ees my superior, so I'd rather not be saying ze bad things about heem."
								(proc27_1 9 @global298)
							)
						)
					)
					(258
						(cond
							((IsFlag 134)
								(if (proc27_0 9 global364)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
								else
									(gMessager say: noun 6 72 0 0 modNum) ; "Ah, Monsieur Pippin, eet ees so sad. Such a great man, to die in such a way makes my heart break, no? We had not talked much until zees evening when he finally had ze time during ze party. He was going to meet me after ze party so we could get to know each other."
									(proc27_1 9 @global364)
								)
							)
							((proc27_0 9 global297)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum) ; "Ah, Monsieur Pippin, he ees such a great man...and quite attractive, no?"
								(proc27_1 9 @global297)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
						else
							(gMessager say: noun 6 24 0 0 modNum) ; "Ah, ze Steve, he ees so beeg and handsome. I showed him ze Old Masters Gallery, but he kept wanting to go back to ze party for some reason. Zen I showed heem my office, and he was so kind to massage my neck for me."
							(proc27_1 9 @global302)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "I am not knowing how to answer zees. My Engleesh, she is not so good sometimes, no?"
							)
							((proc27_0 9 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 9 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aZiggy of MuseumActor
	(properties
		noun 1
		modNum 1890
		originalView 816
	)

	(method (cue)
		(self wander:)
	)

	(method (wander param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 room)
			(while (== temp1 room)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 5)
						(= temp1 450)
						(continue)
					)
					(if (<= temp0 10)
						(= temp1 454)
					)
				)
			)
			(if temp1
				(if (== room -1)
					(if (> originalDest 0)
						(self moveTo: originalDest)
					)
					(= originalDest 0)
				)
				(super wander: temp1 self)
			else
				(if (!= room -1)
					(= originalDest room)
				)
				(self moveTo: -1)
				(= wandering 0)
			)
		else
			(super wander: param1 &rest)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
			(if
				(==
					(= temp0
						(if (== argc 2)
							invItem
						else
							(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum) ; "Can't help youse with dat, toots."
				)
				((proc27_0 11 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum) ; "How many times are ya gonna ask me? I already told ya everything I know about dat."
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(class TravelToRoom of Script
	(properties
		useDoor 0
		fromRendezvous 0
	)

	(method (dispose param1)
		(if (or (not argc) (not param1))
			(= caller 0)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(switch (= state newState)
			(0
				(= register 0)
				(= cycles 1)
			)
			(1
				(if
					(and
						(==
							(= temp1
								(client findRendezvous: (client originalDest:))
							)
							(client room:)
						)
						(not fromRendezvous)
					)
					(self changeState: 9)
				else
					(if fromRendezvous
						(++ state)
					)
					(= cycles 1)
				)
			)
			(2
				(= temp0 (* (client setIndex:) 11))
				(if (!= (client destination:) (client room:))
					(= register (client dirToRoom: (client destination:)))
					(= temp6 (client isAdjacent:))
				)
				(= temp2
					(switch temp6
						(1
							(MuseumRgn northPts:)
						)
						(2
							(MuseumRgn eastPts:)
						)
						(3
							(MuseumRgn southPts:)
						)
						(4
							(MuseumRgn westPts:)
						)
						(else
							(if (== (client room:) gCurRoomNum)
								(MuseumRgn midPts:)
							else
								0
							)
						)
					)
				)
				(switch register
					(1
						(client
							exitX:
								(if temp2
									(temp2 northPtX:)
								else
									160
								)
							exitY:
								(if temp2
									(temp2 northPtY:)
								else
									0
								)
						)
					)
					(2
						(client
							exitX:
								(if temp2
									(temp2 eastPtX:)
								else
									320
								)
							exitY:
								(if temp2
									(temp2 eastPtY:)
								else
									95
								)
						)
					)
					(3
						(client
							exitX:
								(if temp2
									(temp2 southPtX:)
								else
									160
								)
							exitY:
								(if temp2
									(temp2 southPtY:)
								else
									190
								)
						)
					)
					(4
						(client
							exitX:
								(if temp2
									(temp2 westPtX:)
								else
									0
								)
							exitY:
								(if temp2
									(temp2 westPtY:)
								else
									95
								)
						)
					)
					(else
						(client exitX: 0 exitY: 0)
					)
				)
				(if (>= (= temp4 (client exitX:)) 1000)
					(client exitX: (- temp4 1000))
					(= useDoor register)
				)
				(= cycles 1)
			)
			(3
				(if fromRendezvous
					(= temp3 (client room:))
				else
					(= temp3 (client nextRoom: register))
				)
				(cond
					(
						(and
							(== (client room:) 530)
							(== temp3 600)
							(== gCurRoomNum 530)
						)
						(= ticks 600)
					)
					(fromRendezvous
						(= cycles 1)
					)
					((> (MuseumRgn crowdInRoom: temp3) 1)
						(if (not (= temp6 (client waitCount:)))
							(-- state)
							(= ticks 15)
						else
							(client waitCount: (-- temp6))
							(-- state)
							(= ticks (* (Random 3 8) 60))
						)
					)
					((== (client room:) gCurRoomNum)
						(= ticks 60)
					)
					((not (client beelining:))
						(= ticks (* (Random 3 15) 60))
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(if fromRendezvous
					(= cycles 1)
				else
					(= temp2 (MuseumRgn whichList: (client room:)))
					(client
						setMotion:
							PolyPath
							(client exitX:)
							(client exitY:)
							self
							1
							temp2
					)
				)
			)
			(5
				(if (and useDoor (== (client room:) gCurRoomNum))
					(self setScript: (sUseDoor new:) self 1)
				else
					(= cycles 1)
				)
			)
			(6
				(= temp0 (* (client roomIdx:) 5))
				(if fromRendezvous
					(client
						view:
							(if (== (client room:) gCurRoomNum)
								(client originalView:)
							else
								828
							)
					)
					(= fromRendezvous 0)
				else
					(= temp3 (client nextRoom: register))
					(client
						lastRoom: (client room:)
						room: temp3
						view:
							(if (== temp3 gCurRoomNum)
								(client originalView:)
							else
								828
							)
						setIndex:
					)
					(MuseumRgn
						crowdInRoom: (client room:) 1
						crowdInRoom: (client lastRoom:) -1
					)
				)
				(= temp8 register)
				(= temp0 (* (client roomIdx:) 6))
				(if (> (client lastRoom:) 0)
					(= temp3 (client lastRoom:))
					(for ((= register 1)) (< register 5) ((++ register))
						(if (== [local100 (+ temp0 register 1)] temp3)
							(break)
						)
					)
				else
					(= register -1)
				)
				(= temp9 register)
				(= temp0 (* (client roomIdx:) 11))
				(cond
					((== (client room:) gCurRoomNum)
						(= temp2 (MuseumRgn midPts:))
					)
					((client isAdjacent:)
						(= temp2
							(switch temp8
								(1
									(MuseumRgn northPts:)
								)
								(2
									(MuseumRgn eastPts:)
								)
								(3
									(MuseumRgn southPts:)
								)
								(4
									(MuseumRgn westPts:)
								)
							)
						)
					)
					(else
						(= temp2 0)
					)
				)
				(switch temp9
					(1
						(if temp2
							(= temp4 (temp2 northPtX:))
							(= temp5 (temp2 northPtY:))
						else
							(= temp4 160)
							(= temp5 50)
						)
					)
					(2
						(if temp2
							(= temp4 (temp2 eastPtX:))
							(= temp5 (temp2 eastPtY:))
						else
							(= temp4 320)
							(= temp5 120)
						)
					)
					(3
						(if temp2
							(= temp4 (temp2 southPtX:))
							(= temp5 (temp2 southPtY:))
						else
							(= temp4 160)
							(= temp5 190)
						)
					)
					(4
						(if temp2
							(= temp4 (temp2 westPtX:))
							(= temp5 (temp2 westPtY:))
						else
							(= temp4 0)
							(= temp5 120)
						)
					)
					(-1
						(if temp2
							(= temp4 (temp2 midPtX:))
							(= temp5 (temp2 midPtY:))
						else
							(= temp4 160)
							(= temp5 165)
						)
					)
					(else
						(= temp4 (= temp5 0))
					)
				)
				(client posn: temp4 temp5)
				(if (>= temp4 1000)
					(-= temp4 1000)
					(= useDoor register)
				)
				(= cycles 1)
			)
			(7
				(if (and useDoor (== (client room:) gCurRoomNum))
					(self setScript: (sUseDoor new:) self -1)
				else
					(= cycles 1)
				)
			)
			(8
				(if (== (client destX:) -1)
					(cond
						(
							(and
								(== gCurRoomNum 510)
								(or
									(and
										(== (client lastRoom:) 520)
										(< (client originalDest:) 510)
									)
									(and
										(== (client lastRoom:) 500)
										(== (client originalDest:) 520)
									)
								)
							)
							(= temp4 80)
							(= temp5 165)
						)
						((> (MuseumRgn crowdInRoom: (client room:)) 1)
							(= temp4 (- ((MuseumRgn midPts:) midPtX:) 15))
							(= temp5 (- ((MuseumRgn midPts:) midPtY:) 15))
						)
						((== (client room:) gCurRoomNum)
							(= temp4 ((MuseumRgn midPts:) midPtX:))
							(= temp5 ((MuseumRgn midPts:) midPtY:))
						)
						(else
							(= temp4 160)
							(= temp5 165)
						)
					)
				else
					(= temp4 (client destX:))
					(= temp5 (client destY:))
				)
				(= temp2 (MuseumRgn whichList: (client room:)))
				(client setMotion: PolyPath temp4 temp5 self 1 temp2)
			)
			(9
				(cond
					((!= (client room:) (client destination:))
						(= register 0)
						(self changeState: 2)
					)
					((!= (client originalDest:) (client destination:))
						(cond
							(
								(==
									[local0
										(+ (* (= temp0 (client setIndex:)) 5) 1)
									]
									-1
								)
								(= register 1)
								(client
									exitX: ((MuseumRgn midPts:) northPtX:)
									exitY: ((MuseumRgn midPts:) northPtY:)
								)
							)
							((== [local0 (+ (* temp0 5) 2)] -1)
								(= register 2)
								(client
									exitX: ((MuseumRgn midPts:) eastPtX:)
									exitY: ((MuseumRgn midPts:) eastPtY:)
								)
							)
							((== [local0 (+ (* temp0 5) 3)] -1)
								(= register 3)
								(client
									exitX: ((MuseumRgn midPts:) southPtX:)
									exitY: ((MuseumRgn midPts:) southPtY:)
								)
							)
							((== [local0 (+ (* temp0 5) 4)] -1)
								(= register 4)
								(client
									exitX: ((MuseumRgn midPts:) westPtX:)
									exitY: ((MuseumRgn midPts:) westPtY:)
								)
							)
						)
						(= temp2 (MuseumRgn whichList: (client room:)))
						(client
							setMotion:
								PolyPath
								(client exitX:)
								(client exitY:)
								self
								1
								temp2
						)
					)
					(else
						(client beelining: 0)
						(self dispose: 1)
					)
				)
			)
			(10
				(= temp3
					[local100 (+ (* (= temp0 (client roomIdx:)) 6) register 1)]
				)
				(client
					lastRoom: (client room:)
					room: temp3
					destination: (client originalDest:)
					setIndex:
				)
				(MuseumRgn
					crowdInRoom: (client room:) 1
					crowdInRoom: (client lastRoom:) -1
				)
				(= fromRendezvous 1)
				(self changeState: 1)
			)
		)
	)
)

(instance sUseDoor of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gUser canControl: 0 canInput: 0)
				(gGame setCursor: gWaitCursor)
				(if (== register -1)
					((client client:)
						setPri:
							(-
								((ScriptID gCurRoomNum (client useDoor:))
									priority:
								)
								1
							)
						posn:
							((ScriptID gCurRoomNum (client useDoor:)) moveToX:)
							((ScriptID gCurRoomNum (client useDoor:)) moveToY:)
					)
				)
				((ScriptID gCurRoomNum (client useDoor:)) setCycle: End self)
				(gAltPolys
					delete: ((ScriptID gCurRoomNum (client useDoor:)) doorPoly:)
				)
			)
			(1
				(= temp0
					(if (== register 1)
						((ScriptID gCurRoomNum (client useDoor:)) moveToX:)
					else
						((ScriptID gCurRoomNum (client useDoor:)) approachX:)
					)
				)
				(= temp1
					(if (== register 1)
						((ScriptID gCurRoomNum (client useDoor:)) moveToY:)
					else
						((ScriptID gCurRoomNum (client useDoor:)) approachY:)
					)
				)
				((client client:)
					setPri: -1
					setMotion: PolyPath temp0 temp1 self
				)
			)
			(2
				((ScriptID gCurRoomNum (client useDoor:)) setCycle: Beg)
				(gAltPolys
					add: ((ScriptID gCurRoomNum (client useDoor:)) doorPoly:)
				)
				(client useDoor: 0)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gUser canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance fumeTimer of Timer
	(properties)

	(method (setReal)
		(MuseumRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(ClearFlag 20)
	)
)

(instance meetingTimer of Timer
	(properties)

	(method (setReal param1 param2 param3 param4 param5)
		(= gClockTimeMustDos param5)
		(MuseumRgn timer: self)
		(super setReal: param1 param2 param3 param4)
	)

	(method (cue)
		(gCurRoom notify:)
		((ScriptID 22 0) doit: gClockTimeMustDos) ; triggerAndClock
	)
)

(instance wanderTimer of Timer
	(properties)

	(method (cue &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
			(if
				(and
					((= temp1 (gCast at: temp0)) respondsTo: #room)
					(== (temp1 room:) -1)
				)
				(temp1 wander:)
			)
		)
		(self setReal: self 120)
	)
)

