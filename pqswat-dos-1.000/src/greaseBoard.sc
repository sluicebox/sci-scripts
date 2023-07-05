;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4999)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use ForwardCounter)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	greaseBoard 0
)

(local
	local0
	local1
	local2
)

(class BoardButton of Button
	(properties
		myType 0
	)

	(method (doVerb)
		(if (& local1 myType)
			(pickManager doit:)
		else
			(gMessager say: 17 29 0 0 0 405) ; "Come on, Pup. Knock off the funny business. We don't have much time."
		)
	)

	(method (handleEvent event)
		(if
			(or
				(and (& (event type:) evMOUSE) (not (self onMe: event)))
				(not (event type:))
				(not (gUser input:))
				(and (not allowModifiers) (event modifiers:))
			)
			(super handleEvent: event)
			(return)
		)
		(if (& (event type:) $0014) ; direction | evKEYBOARD
			(if (and (!= keyMessage -1) (== keyMessage (event message:)))
				(self doVerb: 29)
				(event claimed: 1)
			)
			(event claimed:)
			(return)
		)
		(if (& (event type:) evMOUSEBUTTON)
			(self trace: event)
		)
		(event claimed:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (& local1 myType)
			(flashScript dispose:)
			(flashList eachElementDo: #setActive 1)
		else
			(self doVerb: 29)
			(param1 claimed: 1)
			(return)
		)
		(= temp1 0)
		(while 1
			(= temp5 temp1)
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent 3 param1)
			(param1 localize: plane)
			(if (& (param1 type:) $0002)
				(break)
			else
				(= temp2 view)
				(= temp3 loop)
				(= temp4 cel)
				(if (self onMe: param1)
					(self setActive: 0)
					(= temp1 1)
					(if doVerbCalled
						(self doVerb: 29)
					)
				else
					(self setActive: 1)
					(= temp1 0)
				)
			)
			(if (or (!= temp2 view) (!= temp3 loop) (!= temp4 cel))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (!= temp5 temp1)
				(= temp5 temp1)
			)
		)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(self doVerb: 29)
		)
		(param1 claimed: 1)
	)
)

(instance greaseBoard of PQRoom
	(properties
		modNum 405
		picture 420
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 4200)
		(if (== global108 7)
			(if (IsFlag 83)
				(gCurRoom setScript: consecSniper)
			else
				(gCurRoom setScript: firstSniper)
			)
		else
			(self setScript: pickEntrance)
		)
	)

	(method (doVerb)
		(gMessager say: 17 29 0 0 0 405) ; "Come on, Pup. Knock off the funny business. We don't have much time."
	)

	(method (dispose)
		(promptTimer dispose: delete:)
		(infoTimer dispose: delete:)
		(super dispose:)
	)
)

(instance pickEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(cond
					((IsFlag 78)
						(self setScript: eg0c self)
					)
					((and (<= global416 3) (not global417))
						(self setScript: eg1c self)
					)
					((and (>= global416 4) (not global417))
						(self setScript: eg2c self)
					)
					((and (>= global416 4) (== global417 1))
						(self setScript: eg3c self)
					)
					((and (>= global416 4) (>= global417 2))
						(self setScript: eg4c self)
					)
					((and (<= global416 3) (== global417 1))
						(self setScript: eg5c self)
					)
					((and (<= global416 3) (>= global417 2))
						(self setScript: eg6c self)
					)
				)
			)
			(2
				(entrance1 init:)
				(entrance2 init:)
				(= local1 1)
				(flashList add: entrance1 entrance2)
				(gGame handsOn:)
				(infoTimer setReal: infoTimer 6)
				(gCurRoom setScript: flashScript)
			)
		)
	)
)

(instance eg0c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 59 1 self 405) ; "What's the matter? Cat got your tongue? I'll start you out... Let's take a look at the building's layout."
			)
			(1
				(gMessager say: 0 0 59 2 self 405) ; "On the board we have a diagram of two buildings. Building two is a storage warehouse already cleared this morning by Pauldon's element. Building one is the main building. It's up to us to clear and secure it. Now building one has two entrances. The first, on side one, is a glass door."
			)
			(2
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(3
				(door1 dispose:)
				(gMessager say: 0 0 59 3 self 405) ; "The other is on side two."
			)
			(4
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(5
				(door2 dispose:)
				(gMessager say: 0 0 59 4 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(6
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(7
				(wall dispose:)
				(gMessager say: 0 0 59 5 self 405) ; "Pup, point out where you think we should enter."
			)
			(8
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg1c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 50 1 self 405) ; "Well, ah... Let's see... Ummmmm."
			)
			(1
				(gMessager say: 13 29 50 2 self 405) ; "Damn it, Pup! You didn't interview them! Well, then we're going to go with the information I have. This is it: Building one, or the main building, has two entrances. The first is on side one..."
			)
			(2
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(3
				(door1 dispose:)
				(gMessager say: 13 29 50 3 self 405) ; "...It's a glass door. The other is on side two."
			)
			(4
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(5
				(door2 dispose:)
				(gMessager say: 13 29 50 4 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(6
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(7
				(wall dispose:)
				(gMessager say: 13 29 50 5 self 405) ; "Pup, point out where you think we should enter."
			)
			(8
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg2c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 51 1 self 405) ; "The company's accountant told me that the office area is this front area here in the forward left corner."
			)
			(1
				(office init: setCycle: ForwardCounter 3 self)
			)
			(2
				(office dispose:)
				(gMessager say: 13 29 51 2 self 405) ; "Here on the diagram, that would be the one-two corner. Ron Eastman's office is the first office to the left when entering."
			)
			(3
				(xMark init: setCycle: ForwardCounter 3 self)
			)
			(4
				(xMark dispose:)
				(gMessager say: 13 29 51 3 self 405) ; "The accountant's office is the second to the left."
			)
			(5
				(gMessager say: 13 29 51 4 self 405) ; "All right, building one, or the main building, has two entrances. The first, on side one, is a glass door."
			)
			(6
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(7
				(door1 dispose:)
				(gMessager say: 13 29 51 5 self 405) ; "The other is on side two."
			)
			(8
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(9
				(door2 dispose:)
				(gMessager say: 13 29 51 6 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(10
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(11
				(wall dispose:)
				(gMessager say: 13 29 51 7 self 405) ; "Pup, point out where you think we should enter."
			)
			(12
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg3c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 52 1 self 405) ; "There's an office area in this front area, here in the forward left corner."
			)
			(1
				(office init: setCycle: ForwardCounter 3 self)
			)
			(2
				(office dispose:)
				(gMessager say: 13 29 52 2 self 405) ; "Here on the diagram, that would be the one-two corner. Ron Eastman's office is the first office to the left when entering."
			)
			(3
				(xMark init: setCycle: ForwardCounter 3 self)
			)
			(4
				(xMark dispose:)
				(gMessager say: 13 29 52 3 self 405) ; "The accountant's office is the second to the left."
			)
			(5
				(gMessager say: 13 29 52 4 self 405) ; "This area here houses heavy machinery, apparently some kind of sophisticated presses."
			)
			(6
				(heavyRoom init: setCycle: ForwardCounter 3 self)
			)
			(7
				(heavyRoom dispose:)
				(gMessager say: 13 29 52 5 self 405) ; "All right, the main building has two entrances. The first, on side one, is a glass door."
			)
			(8
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(9
				(door1 dispose:)
				(gMessager say: 13 29 52 6 self 405) ; "The other is on side two."
			)
			(10
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(11
				(door2 dispose:)
				(gMessager say: 13 29 52 7 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(12
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(13
				(wall dispose:)
				(gMessager say: 13 29 52 8 self 405) ; "Pup, point out where you think we should enter."
			)
			(14
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg4c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 53 1 self 405) ; "This front left corner of the building is the office area."
			)
			(1
				(office init: setCycle: ForwardCounter 3 self)
			)
			(2
				(office dispose:)
				(gMessager say: 13 29 53 2 self 405) ; "Here on the diagram, that would be the 1-2 corner. Ron Eastman's office is the first office to the left when entering."
			)
			(3
				(xMark init: setCycle: ForwardCounter 3 self)
			)
			(4
				(xMark dispose:)
				(gMessager say: 13 29 53 3 self 405) ; "The accountant's office is the second to the left."
			)
			(5
				(gMessager say: 13 29 53 4 self 405) ; "This area here houses heavy machinery, apparently some kind of sophisticated presses."
			)
			(6
				(heavyRoom init: setCycle: ForwardCounter 3 self)
			)
			(7
				(heavyRoom dispose:)
				(gMessager say: 13 29 53 5 self 405) ; "Now there's a door connecting the office with the plant floor."
			)
			(8
				(gMessager say: 13 29 53 6 self 405) ; "Where, along these two walls, I don't know."
			)
			(9
				(twoWalls init: setCycle: ForwardCounter 3 self)
			)
			(10
				(twoWalls dispose:)
				(gMessager say: 13 29 53 7 self 405) ; "Well, we know the main building has two entrances. The first, on side one, is a glass door."
			)
			(11
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(12
				(door1 dispose:)
				(gMessager say: 13 29 53 8 self 405) ; "The other is on side two."
			)
			(13
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(14
				(door2 dispose:)
				(gMessager say: 13 29 53 9 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(15
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(16
				(wall dispose:)
				(gMessager say: 13 29 53 10 self 405) ; "Pup, point out where you think we should enter."
			)
			(17
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg5c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 54 1 self 405) ; "This area here houses heavy machinery."
			)
			(1
				(heavyRoom init: setCycle: ForwardCounter 3 self)
			)
			(2
				(heavyRoom dispose:)
				(= seconds 3)
			)
			(3
				(gMessager say: 13 29 54 2 self 405) ; "That's it? Remind me to have you work on your interview technique. All right, we'll go on the information I have. Building one, or the main building, has two entrances. The first, on side one, is a glass door."
			)
			(4
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(5
				(door1 dispose:)
				(gMessager say: 13 29 54 3 self 405) ; "The other is on side two."
			)
			(6
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(7
				(door2 dispose:)
				(gMessager say: 13 29 54 4 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(8
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(9
				(wall dispose:)
				(gMessager say: 13 29 54 5 self 405) ; "Pup, point out where you think we should enter."
			)
			(10
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance eg6c of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 29 55 1 self 405) ; "This area here houses heavy machinery, large presses."
			)
			(1
				(heavyRoom init: setCycle: ForwardCounter 3 self)
			)
			(2
				(heavyRoom dispose:)
				(gMessager say: 13 29 55 2 self 405) ; "Now there's a door connecting the office with the plant floor."
			)
			(3
				(office init: setCycle: ForwardCounter 3 self)
			)
			(4
				(office dispose:)
				(gMessager say: 13 29 55 3 self 405) ; "Where, along these two walls, I don't know."
			)
			(5
				(twoWalls init: setCycle: ForwardCounter 3 self)
			)
			(6
				(twoWalls dispose:)
				(gMessager say: 13 29 55 4 self 405) ; "Well, we know the main building has two entrances. The first, on side one, is a glass door."
			)
			(7
				(door1 init: setCycle: ForwardCounter 3 self)
			)
			(8
				(door1 dispose:)
				(gMessager say: 13 29 55 5 self 405) ; "The other is on side two."
			)
			(9
				(door2 init: setCycle: ForwardCounter 3 self)
			)
			(10
				(door2 dispose:)
				(gMessager say: 13 29 55 6 self 405) ; "According to the blue prints, this building has been modified from the original plans. There's been a wall, with no indications of a passage, put in the main plant area."
			)
			(11
				(wall init: setCycle: ForwardCounter 3 self)
			)
			(12
				(wall dispose:)
				(gMessager say: 13 29 55 7 self 405) ; "Pup, point out where you think we should enter."
			)
			(13
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance flashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((flashList at: local0) setActive: 0)
				(= ticks 10)
			)
			(1
				((flashList at: local0) setActive: 1)
				(= ticks 10)
			)
			(2
				(if (== local0 (- (flashList size:) 1))
					(= local0 0)
				else
					(++ local0)
				)
				(-= state 3)
				(self cue:)
			)
		)
	)
)

(instance encouragePlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 56 0 self 405) ; "Come on, Pup. We don't have much time. Make a decision."
			)
			(1
				(promptTimer setReal: promptTimer 5)
				(self dispose:)
			)
		)
	)
)

(instance firstSniper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 4250)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 34 6 self 405) ; "Building two has already been cleared. There's an interior stairwell leading to the roof. Position yourself on the 1-4 corner."
			)
			(2
				(cornerPos init: setCycle: CT 16 1)
				(gMessager say: 0 0 34 7 self 405) ; "Your view should be the 1-2 corner of building one."
			)
			(3
				(enterPos init: cycleSpeed: 13 setCycle: End)
				(gMessager say: 0 0 34 8 self 405) ; "To get to your position on building two, you'll travel from our current position along side two."
			)
			(4
				(gMessager say: 0 0 34 9 self 405) ; "Wixell is positioned on the 1-2 corner to cover your move from side two to side one. On side one there's an unlocked door. Enter and head to your right to the stairs."
			)
			(5
				(gCurRoom newRoom: 4053)
			)
		)
	)
)

(instance consecSniper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 4250)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 35 2 self 405) ; "You'll set up on the 1-4 corner of building two."
			)
			(2
				(gMessager say: 0 0 35 3 0 405) ; "I want to know everything that's going on in building one..."
				(cornerPos init: setCycle: CT 16 1 self)
			)
			(3
				(gMessager say: 0 0 35 4 self 405) ; "...how many are in there, if you can see our hostage, Ron Eastman. Eastman is a male white, mid-fifties, gray hair. Five-ten, two hundred pounds. I want any and all information."
				(enterPos cel: 0 init: cycleSpeed: 13 setCycle: End)
			)
			(4
				(gCurRoom newRoom: 4053)
			)
		)
	)
)

(instance entrance1 of BoardButton
	(properties
		x 240
		y 194
		view 4200
		loop 7
		myType 1
	)

	(method (doVerb)
		(if (& local1 myType)
			(++ local2)
			(SetFlag 297)
			(if (IsFlag 298)
				(ClearFlag 298)
				(entrance2 setActive: 1)
			)
		)
		(super doVerb: &rest)
	)
)

(instance entrance2 of BoardButton
	(properties
		x 319
		y 250
		view 4200
		loop 12
		myType 1
	)

	(method (doVerb)
		(if (& local1 myType)
			(++ local2)
			(SetFlag 298)
			(if (IsFlag 297)
				(ClearFlag 297)
				(entrance1 setActive: 1)
			)
		)
		(super doVerb: &rest)
	)
)

(instance enterButn of BoardButton
	(properties
		x 105
		y 40
		view 4200
		myType 2
	)

	(method (doVerb)
		(if (== local1 3)
			(= local1 2)
		)
		(super doVerb: &rest)
	)
)

(instance stealthButn of BoardButton
	(properties
		x 103
		y 71
		view 4200
		loop 1
		myType 4
	)

	(method (doVerb)
		(SetFlag 295)
		(if (& local1 myType)
			(pickManager doit:)
			(if (entrance1 active:)
				(sView init: posn: 347 215)
			else
				(sView init: posn: 268 149)
			)
			(gMessager say: 20 29 0 0 0 405) ; "All right. A stealth entrance."
		else
			(gMessager say: 17 29 0 0 0 405) ; "Come on, Pup. Knock off the funny business. We don't have much time."
		)
	)
)

(instance dynamicButn of BoardButton
	(properties
		x 88
		y 100
		view 4200
		loop 2
		myType 4
	)

	(method (doVerb)
		(SetFlag 294)
		(if (& local1 myType)
			(pickManager doit:)
			(if (entrance1 active:)
				(dView init: posn: 347 215)
			else
				(dView init: posn: 268 149)
			)
			(gMessager say: 21 29 0 0 0 405) ; "A dynamic entry is always risky. Everyone, be careful."
		else
			(gMessager say: 17 29 0 0 0 405) ; "Come on, Pup. Knock off the funny business. We don't have much time."
		)
	)
)

(instance highGroundButn of BoardButton
	(properties
		x 205
		y 49
		view 4200
		loop 3
		myType 8
	)

	(method (doVerb)
		(if
			(and
				(& local1 $0010)
				(OneOf
					0
					(oneButn active:)
					(twoButn active:)
					(threeButn active:)
					(fourButn active:)
					(oneTwoButn active:)
					(twoThreeButn active:)
					(threeFourButn active:)
					(fourOneButn active:)
				)
			)
			(gCurRoom newRoom: 4053)
		else
			(super doVerb: &rest)
		)
	)
)

(instance sideButn of BoardButton
	(properties
		x 228
		y 76
		view 4200
		loop 4
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(cornerButn setActive: 1)
			(oneTwoButn setActive: 1)
			(twoThreeButn setActive: 1)
			(threeFourButn setActive: 1)
			(fourOneButn setActive: 1)
		)
		(super doVerb: &rest)
	)
)

(instance cornerButn of BoardButton
	(properties
		x 220
		y 98
		view 4200
		loop 5
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(sideButn setActive: 1)
			(oneButn setActive: 1)
			(twoButn setActive: 1)
			(threeButn setActive: 1)
			(fourButn setActive: 1)
		)
		(super doVerb: &rest)
	)
)

(instance oneButn of BoardButton
	(properties
		x 228
		y 76
		view 4200
		loop 4
		cel 2
		upCel 2
		downCel 3
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(sideButn setActive: 0)
			(sideButn doVerb:)
			(twoButn setActive: 1)
			(threeButn setActive: 1)
			(fourButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance twoButn of BoardButton
	(properties
		x 228
		y 76
		view 4200
		loop 4
		cel 4
		upCel 4
		downCel 5
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(sideButn setActive: 0)
			(sideButn doVerb:)
			(oneButn setActive: 1)
			(threeButn setActive: 1)
			(fourButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance threeButn of BoardButton
	(properties
		x 228
		y 76
		view 4200
		loop 4
		cel 6
		upCel 6
		downCel 7
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(sideButn setActive: 0)
			(sideButn doVerb:)
			(twoButn setActive: 1)
			(oneButn setActive: 1)
			(fourButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance fourButn of BoardButton
	(properties
		x 228
		y 76
		view 4200
		loop 4
		cel 8
		upCel 8
		downCel 9
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(sideButn setActive: 0)
			(sideButn doVerb:)
			(oneButn setActive: 1)
			(twoButn setActive: 1)
			(threeButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance oneTwoButn of BoardButton
	(properties
		x 220
		y 98
		view 4200
		loop 5
		cel 2
		upCel 2
		downCel 3
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(cornerButn setActive: 0)
			(cornerButn doVerb:)
			(twoThreeButn setActive: 1)
			(threeFourButn setActive: 1)
			(fourOneButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance twoThreeButn of BoardButton
	(properties
		x 220
		y 98
		view 4200
		loop 5
		cel 4
		upCel 4
		downCel 5
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(cornerButn setActive: 0)
			(cornerButn doVerb:)
			(oneTwoButn setActive: 1)
			(threeFourButn setActive: 1)
			(fourOneButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance threeFourButn of BoardButton
	(properties
		x 220
		y 98
		view 4200
		loop 5
		cel 6
		upCel 6
		downCel 7
		myType 16
	)

	(method (doVerb)
		(if (& local1 myType)
			(cornerButn setActive: 0)
			(cornerButn doVerb:)
			(twoThreeButn setActive: 1)
			(oneTwoButn setActive: 1)
			(fourOneButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance fourOneButn of BoardButton
	(properties
		x 220
		y 98
		view 4200
		loop 5
		cel 8
		upCel 8
		downCel 9
		myType 16
	)

	(method (doVerb)
		(SetFlag 288)
		(if (& local1 myType)
			(cornerButn setActive: 0)
			(cornerButn doVerb:)
			(twoThreeButn setActive: 1)
			(threeFourButn setActive: 1)
			(oneTwoButn setActive: 1)
		)
		(super doVerb: &rest)
		(infoTimer setReal: infoTimer 10)
		(gMessager say: 0 0 61 0 0 405) ; "If you're confident with your decision, Pup, mark the Highground."
		(gCurRoom setScript: flashScript)
	)
)

(instance twoWalls of Prop
	(properties
		x 210
		y 170
		view 4200
		loop 18
		cycleSpeed 12
	)
)

(instance xProp of Prop
	(properties
		view 4200
		loop 11
	)
)

(instance door1 of Prop
	(properties
		x 240
		y 194
		view 4200
		loop 7
		cycleSpeed 12
	)
)

(instance door2 of Prop
	(properties
		x 319
		y 250
		view 4200
		loop 12
		cycleSpeed 12
	)
)

(instance wall of Prop
	(properties
		x 100
		y 276
		view 4200
		loop 13
		cycleSpeed 12
	)
)

(instance office of Prop
	(properties
		x 210
		y 170
		view 4200
		loop 14
		cycleSpeed 12
	)
)

(instance xMark of Prop
	(properties
		x 309
		y 177
		view 4200
		loop 15
		cycleSpeed 12
	)
)

(instance heavyRoom of Prop
	(properties
		x 98
		y 167
		view 4200
		loop 16
		cycleSpeed 12
	)
)

(instance cornerPos of Prop
	(properties
		x 429
		y 85
		view 4250
		loop 1
		cycleSpeed 12
	)
)

(instance enterPos of Prop
	(properties
		x 556
		y 256
		view 4250
		cycleSpeed 12
	)
)

(instance eView of View
	(properties
		view 4200
		loop 8
	)

	(method (init)
		(super init: &rest)
		(if (entrance1 active:)
			(self posn: 344 214)
			(xProp setLoop: 11 init: posn: 560 250 setCycle: End)
		else
			(self posn: 264 148)
			(xProp setLoop: 6 init: posn: 559 251 setCycle: End)
		)
		(gMessager say: 19 29 0 0 0 405) ; "What do you think, Pup? Stealth or dynamic?"
	)
)

(instance sView of View
	(properties
		view 4200
		loop 9
	)
)

(instance dView of View
	(properties
		view 4200
		loop 10
	)
)

(instance flashList of List
	(properties)
)

(instance pickManager of Code
	(properties)

	(method (doit)
		(= local0 0)
		(flashList release:)
		(cond
			((& local1 $0001)
				(= local1 3)
				(enterButn init:)
				(flashList add: enterButn)
				(infoTimer setReal: infoTimer 12)
				(gCurRoom setScript: flashScript)
				(cond
					((> local2 4)
						(gMessager say: 17 29 0 0 0 405) ; "Come on, Pup. Knock off the funny business. We don't have much time."
					)
					((IsFlag 297)
						(gMessager say: 14 29 0 0 0 405) ; "If you're sure about side one, why don't you go ahead and confirm your decision and mark the board?"
					)
					((IsFlag 298)
						(gMessager say: 15 29 0 0 0 405) ; "If you're sure about side two, why don't you go ahead and confirm your decision and mark the board?"
					)
				)
			)
			((& local1 $0002)
				(= local1 4)
				(eView init:)
				(stealthButn init:)
				(dynamicButn init:)
				(flashList add: stealthButn dynamicButn)
				(infoTimer setReal: infoTimer 10)
				(gCurRoom setScript: flashScript)
			)
			((& local1 $0004)
				(= local1 8)
				(highGroundButn init:)
				(flashList add: highGroundButn)
				(infoTimer setReal: infoTimer 10)
				(gCurRoom setScript: flashScript)
			)
			((& local1 $0008)
				(= local1 24)
				(fourButn init:)
				(threeButn init:)
				(twoButn init:)
				(oneButn init:)
				(fourOneButn init:)
				(threeFourButn init:)
				(twoThreeButn init:)
				(oneTwoButn init:)
				(sideButn init:)
				(cornerButn init:)
				(highGroundButn init:)
				(flashList add: highGroundButn)
				(infoTimer setReal: infoTimer 10)
			)
		)
	)
)

(instance promptTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: encouragePlayer)
		(self dispose: delete:)
	)
)

(instance infoTimer of Timer
	(properties)

	(method (cue)
		(if (> 50 (Random 1 100))
			(gMessager say: 0 0 56 0 0 405) ; "Come on, Pup. We don't have much time. Make a decision."
		else
			(gMessager say: 0 0 49 0 0 405) ; "Go ahead, Pup. Let's hear it. If you have any information, go ahead and mark on the board."
		)
		(self dispose: delete:)
	)
)

