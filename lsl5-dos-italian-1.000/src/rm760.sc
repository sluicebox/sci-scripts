;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm760 0
	bench 1
)

(local
	seenMsg
	seenWarning
	movingOffControl
	egosPrevDir
	caughtLana
	smallView
	largeView
	talkCount
	eX
	eY
	obj2Cue
	verb2Use
	[shrinkY 4] = [0 82 103 124]
	[growY 4] = [103 124 145 0]
	gonnaFall
	[building 7]
	[buildWidth 17] = [53 53 53 53 53 53 53 53 53 53 53 53 53 106 106 53 159]
	learnCounter
)

(instance rm760 of LLRoom
	(properties
		picture 760
		north 790
		east 760
		south 780
		west 700
	)

	(method (init &tmp theView)
		(LoadMany
			rsVIEW
			763
			762
			761
			764
			771
			772
			773
			774
			775
			776
			777
			778
			779
			769
			770
			791
			1731
			1795
		)
		(gTheMusic number: 700 loop: -1 play:)
		(if (gEgo skating:)
			(= smallView 765)
			(= largeView 768)
		else
			(= smallView 761)
			(= largeView 764)
		)
		(gEgo init: normalize: largeView setStep: 3 3)
		(switch gPrevRoomNum
			(north
				(HandsOn)
				(gEgo view: smallView posn: 204 85 setHeading: 180 edgeHit: EDGE_NONE)
			)
			(west
				(self setScript: sFromWest)
			)
			(else
				(HandsOn)
				(= smallView 765)
				(= largeView 768)
				(gEgo posn: 160 145 edgeHit: EDGE_NONE skating: 1 normalize: 768)
				(= gSkateAbility 2)
				(= learnCounter 99)
			)
		)
		(super init:)
		(skater1 init:)
		(skater2 init:)
		(skater3 init:)
		(skater4 init:)
		(skater5 init:)
		(skater6 init:)
		(skater7 init:)
		(skater8 init:)
		(skater9 init:)
		(bench init:)
		(post1 init:)
		(post2 init:)
		(post3 init:)
		(post4 init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 90 145 154 145 154 160 90 160
					yourself:
				)
		)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 0) ; "The commercialization of the lovely Tramp Boardwalk seems complete. Businesses line every inch of the far side of the boardwalk. At least the near side has been kept open for fishermen and skaters."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gTheMusic fade:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (OneOf script 0 sMoveLarry)))
			((StepOn gEgo 4)
				(self setScript: sScroll 0 2)
			)
			((StepOn gEgo 8)
				(cond
					(gBoardWalkDist
						(self setScript: sScroll 0 4)
					)
					((and (gEgo skating:) (not movingOffControl))
						(if (not seenWarning)
							(TPrint 760 1) ; "Be careful, Larry! You nearly skated right off the boardwalk."
							(= seenWarning 1)
						)
						(HandsOff)
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 10)
								(gEgo y:)
								self
						)
						(= movingOffControl 1)
					)
				)
			)
		)
		(if
			(and
				(gEgo skating:)
				(gEgo mover:)
				(not (gCast contains: lana))
				(== (++ learnCounter) 100)
			)
			(= learnCounter 0)
			(if (and (>= (++ gSkateAbility) 3) (not (IsFlag 3))) ; fSeenLL
				(lana init:)
			)
		)
	)

	(method (cue)
		(if movingOffControl
			(= movingOffControl 0)
			(HandsOn)
		else
			(gEgo edgeHit: EDGE_TOP)
			(gCurRoom newRoom: (gCurRoom north:))
		)
	)

	(method (handleEvent event &tmp eType eMsg)
		(= eType (event type:))
		(= eMsg (event message:))
		(cond
			((and (& eType $0040) (== eMsg JOY_NULL)) ; direction
				(event claimed: 0)
			)
			((and (== eType evKEYBOARD) (OneOf eMsg KEY_TAB KEY_ESCAPE)) 0)
			(
				(or
					(and
						(OneOf eType evMOUSEBUTTON evKEYBOARD)
						(not (event modifiers:))
						(== gTheCursor (proc0_28 6 6 6 61 6))
					)
					(and (== eType evVERB) (== eMsg JOY_UP))
				)
				(sMeetLana cue:)
			)
			((== (gEgo script:) sMeetLana) 0)
			((not (User canControl:))
				(event claimed: 1)
			)
			((& eType $0040) ; direction
				(if (not (gEgo sitting:))
					(if (and (gEgo mover:) (== eMsg egosPrevDir))
						(gEgo setMotion: 0)
						(if (== (gCurRoom script:) sMoveLarry)
							(sMoveLarry dispose:)
						)
						(= egosPrevDir JOY_NULL)
					else
						(switch eMsg
							(JOY_UP
								(event x: (gEgo x:) y: (- (gEgo y:) 20))
							)
							(JOY_UPRIGHT
								(event
									x: (+ (gEgo x:) 100)
									y: (- (gEgo y:) 20)
								)
							)
							(JOY_RIGHT
								(event x: 1000 y: (gEgo y:))
							)
							(JOY_DOWNRIGHT
								(event
									x: (+ (gEgo x:) 20)
									y: (+ (gEgo y:) 20)
								)
							)
							(JOY_DOWN
								(event x: (gEgo x:) y: (+ (gEgo y:) 20))
							)
							(JOY_DOWNLEFT
								(event
									x: (- (gEgo x:) 20)
									y: (+ (gEgo y:) 20)
								)
							)
							(JOY_LEFT
								(event x: 0 y: (gEgo y:))
							)
							(JOY_UPLEFT
								(event
									x: (- (gEgo x:) 20)
									y: (- (gEgo y:) 20)
								)
							)
							(JOY_NULL
								(gTheIconBar advanceCurIcon:)
								(event claimed: 1)
							)
						)
						(if (!= eMsg JOY_NULL)
							(= eX (event x:))
							(= eY (event y:))
							(if (OneOf (gCurRoom script:) 0 sMoveLarry)
								(gCurRoom setScript: sMoveLarry)
							)
						)
					)
					(= egosPrevDir eMsg)
				else
					(gCurRoom setScript: sStandUp 0 0)
				)
				(event claimed: 1)
			)
			(
				(or
					(and
						(== eType evMOUSEBUTTON)
						(not (event modifiers:))
						(or
							(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
							(== eMsg JOY_UP)
						)
					)
					(and
						(== eType evKEYBOARD)
						(== eMsg KEY_RETURN)
						(== gTheCursor ((gTheIconBar at: 0) cursor:))
					)
				)
				(cond
					((gEgo sitting:)
						(event claimed: 1)
						(gCurRoom setScript: sStandUp 0 0)
					)
					((OneOf (gCurRoom script:) 0 sMoveLarry)
						(event claimed: 1)
						(= eX (event x:))
						(if (> (= eY (event y:)) 158)
							(cond
								((StepOn gEgo 16384) 0)
								(
									(not
										(and
											(gEgo skating:)
											(>= (gEgo x:) 300)
										)
									)
									(gCurRoom setScript: sFall)
								)
								(else
									(= eY 145)
									(gCurRoom setScript: sMoveLarry)
								)
							)
						else
							(if (> eY 145)
								(= eY 145)
							)
							(gCurRoom setScript: sMoveLarry)
						)
					)
				)
			)
		)
	)

	(method (drawPic thePic &tmp i val theLoop theCel nextX theX appX)
		(if (!= thePic 795)
			(gCast eachElementDo: #perform showSkaterCode)
			(gAddToPics dispose:)
			(super drawPic: thePic &rest)
			(= nextX 1)
			(for ((= i 0)) (< nextX 318) ((++ i))
				(= theCel (* (+ gBoardWalkDist 1) i 37))
				(if (& $0001 (>> theCel i))
					(/= theCel 17)
				)
				(if (and (== gBoardWalkDist 3) (== i 3))
					(= theLoop 2)
					(= theCel 0)
					(= theX 106)
				else
					(= theX [buildWidth (= theCel (mod theCel 17))])
					(= theLoop 0)
					(if (> theCel 8)
						(-= theCel 9)
						(= theLoop 1)
					)
				)
				(= appX (/ (CelWide (theBuilding view:) theLoop theCel) 2))
				((theBuilding new:)
					x: nextX
					loop: theLoop
					cel: theCel
					approachX: (Min 300 (+ nextX appX))
					approachY: 85
					init:
				)
				(+= nextX theX)
			)
			(gAddToPics doit:)
		else
			(super drawPic: thePic &rest)
		)
	)
)

(class Skater of Actor
	(properties
		signal 16384
		cycleSpeed 12
		room 0
		freq 1
		nearLarry 0
		paused 0
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(= x 160)
		(self cue:)
	)

	(method (doit)
		(super doit:)
		(cond
			(nearLarry
				(-- nearLarry)
			)
			((and (== room gBoardWalkDist) (< (gEgo distanceTo: self) 30))
				(= nearLarry 18)
			)
			((and (not mover) (OneOf x 0 320))
				(self cue:)
			)
		)
		(cond
			((<= freq 0))
			((== loop 0)
				(cond
					((and (== nearLarry 18) (self isNotHidden:))
						(self turn: 4)
					)
					((< 300 x 312)
						(cond
							(
								(or
									(and (> freq 0) (== (Random 1 freq) 1))
									(== room 20)
								)
								(self turn: 4)
							)
							((& signal $0080)
								(++ room)
								(-= x 320)
								(self setMotion: MoveTo 320 y)
								(if (== room gBoardWalkDist)
									(self show:)
								)
							)
							(else
								(self
									freq: (* freq -1)
									setMotion: MoveFwd 40 self
								)
							)
						)
					)
				)
			)
			((== loop 1)
				(cond
					((and (== nearLarry 18) (self isNotHidden:))
						(self turn: 2)
					)
					((< 13 x 25)
						(cond
							(
								(or
									(and (> freq 0) (== (Random 1 freq) 1))
									(== room 0)
								)
								(self turn: 2)
							)
							((& signal $0080)
								(-- room)
								(+= x 320)
								(self setMotion: MoveTo 0 y)
								(if (== room gBoardWalkDist)
									(self show:)
								)
							)
							(else
								(self
									freq: (* freq -1)
									setMotion: MoveFwd 40 self
								)
							)
						)
					)
				)
			)
		)
	)

	(method (turn theDir)
		(switch theDir
			(4
				(self setLoop: 1 setMotion: MoveTo 0 y)
			)
			(2
				(self setLoop: 0 setMotion: MoveTo 320 y)
			)
		)
	)

	(method (cue)
		(if (== loop 1)
			(-- room)
			(self
				x: (+ x 320)
				hide:
				setMotion: MoveTo 0 y
				freq:
					(if (< freq 0)
						(* freq -1)
					else
						freq
					)
				nearLarry: 0
			)
		else
			(++ room)
			(self
				x: (- x 320)
				hide:
				setMotion: MoveTo 320 y
				freq:
					(if (< freq 0)
						(* freq -1)
					else
						freq
					)
				nearLarry: 0
			)
		)
	)
)

(instance lana of Skater
	(properties
		y 140
		description {Lana Luscious}
		view 769
		cycleSpeed 10
		xStep 6
		freq 99
	)

	(method (init &tmp roomLo roomHi)
		(super init:)
		(= roomLo (Max 0 (- gBoardWalkDist 4)))
		(= roomHi (Min 20 (+ gBoardWalkDist 4)))
		(while (== (= room (Random roomLo roomHi)) gBoardWalkDist)
		)
		(if (> room gBoardWalkDist)
			(self setLoop: 1)
		else
			(self setLoop: 0)
		)
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== room gBoardWalkDist)
				(not (& signal $0088))
				(not seenMsg)
				(< 20 x 300)
			)
			(TPrint 760 2) ; "There she is! It's Lana Luscious!! She looks just like that photo you saw in her resume!"
			(= seenMsg 1)
			(= freq 6)
		)
		(if
			(and
				seenMsg
				(not caughtLana)
				(or (== (gEgo y:) y) (gEgo sitting:))
				(< (gEgo distanceTo: self) 40)
				(self isNotHidden:)
			)
			(= caughtLana 1)
			(gEgo setScript: sMeetLana)
		)
	)

	(method (turn)
		(if nearLarry
			(= nearLarry 0)
		else
			(super turn: &rest)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 2) ; "There she is! It's Lana Luscious!! She looks just like that photo you saw in her resume!"
			)
			(5 ; Talk
				(if
					(or
						(< (lana x:) 25)
						(> (lana x:) 300)
						(!= (- (gEgo y:) 5) (lana y:))
					)
					(TPrint 760 3) ; "She must not have heard you, Larry. Perhaps you should try to get closer next time."
				else
					(= caughtLana 1)
					(gEgo setScript: sMeetLana)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(cond
			((not freq)
				(self dispose:)
			)
			((== loop 1)
				(-- room)
				(self
					x: (+ x 320)
					hide:
					setMotion: MoveTo 0 y
					freq:
						(if (< freq 0)
							(* freq -1)
						else
							freq
						)
				)
			)
			(else
				(++ room)
				(self
					x: (- x 320)
					hide:
					setMotion: MoveTo 320 y
					freq:
						(if (< freq 0)
							(* freq -1)
						else
							freq
						)
				)
			)
		)
	)
)

(instance skater1 of Skater
	(properties
		y 140
		description {Mister Z}
		view 771
		xStep 8
		room 3
		freq 4
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 4) ; "Isn't he the cute one?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 1)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater2 of Skater
	(properties
		y 121
		description {the old man}
		view 772
		xStep 8
		room 3
		freq 4
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 5) ; "He's a little old for a rollerskater, eh?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 1)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater3 of Skater
	(properties
		y 118
		z 10
		description {Hot Wheels}
		view 773
		xStep 8
		room 1
		freq 3
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 6) ; "This kid's a real showoff!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 2)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater4 of Skater
	(properties
		y 116
		description {Rockin' Roller}
		view 774
		xStep 6
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 7) ; "What's he listening to, anyway?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 2)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater5 of Skater
	(properties
		y 142
		description {Roller Pig}
		view 775
		xStep 8
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 8) ; "What talent! He can eat AND skate at the same time!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 3)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater6 of Skater
	(properties
		y 117
		description {Bill the Suit}
		view 776
		xStep 6
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 9) ; "He's way overdressed for THIS boardwalk!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 3)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater7 of Skater
	(properties
		y 131
		description {Kid Dork}
		view 777
		xStep 8
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 10) ; "What a dorky lookin' little guy! You immediately take a liking to him!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater8 of Skater
	(properties
		y 110
		description {the skater}
		view 778
		xStep 6
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 11) ; "You had no idea the boardwalk would have so many skaters!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance skater9 of Skater
	(properties
		y 91
		description {the skater}
		view 779
		xStep 6
		room 2
		freq 2
	)

	(method (doit)
		(if (not paused)
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 12) ; "Never straying far from the shops on the other side of the Boardwalk, a skater finds true happiness, blading his little heart out!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000)
				(self perform: zCode)
			)
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000)
				(self perform: zCode)
			)
		)
	)
)

(instance zCode of Code
	(properties)

	(method (doit theObj)
		(if (and (== (theObj z:) 1000) (!= (gCurRoom curPic:) 795))
			(theObj z: 0)
		else
			(theObj z: 1000)
		)
	)
)

(instance showSkaterCode of Code
	(properties)

	(method (doit obj)
		(if (obj respondsTo: #freq)
			(if (== (obj room:) gBoardWalkDist)
				(obj show:)
			else
				(obj hide:)
			)
		)
	)
)

(instance theBuilding of PicView
	(properties
		y 80
		description {the building}
		view 760
	)

	(method (doVerb theVerb &tmp evt)
		(switch theVerb
			(2 ; Look
				(switch loop
					(0
						(switch cel
							(0
								(TPrint 760 13) ; "This shanty reminds you of "The Shack," your favorite collegiate hangout!"
							)
							(1
								(TPrint 760 14) ; "What a strange location for a rocket fuel manufacturing plant."
							)
							(2
								(TPrint 760 15) ; "You haven't seen a slot-car raceway in years!"
							)
							(3
								(TPrint 760 16) ; "The "Salty Dog Saloon" is built upon the very same location as the old "Pepper Dog Saloon," which burnt down years ago in the Great Tramp Boardwalk Fire of '06."
							)
							(4
								(TPrint 760 17) ; "Wow! In this place you can watch movies for only 25 cents! What a bargain!"
							)
							(5
								(TPrint 760 18) ; "This is one of the last of the juke joints!"
							)
							(6
								(TPrint 760 19) ; "You wonder what they sell inside the "Love Shack.""
							)
							(7
								(TPrint 760 20) ; "This house was built here many years ago, before there even was a Tramp Boardwalk!"
							)
							(8
								(TPrint 760 21) ; "Recliners are a very popular item among any Atlantic City tourists that can still walk!"
							)
						)
					)
					(1
						(switch cel
							(0
								(TPrint 760 22) ; "A sign on the front door reads, "Shirts? No shoes. No service.""
							)
							(1
								(TPrint 760 23) ; "Carlos Escobar has been running this taco stand ever since he wrecked his van staring at sidewalk scenery!"
							)
							(2
								(TPrint 760 24) ; "You wonder if they have your favorite poster--the extra-large-size, full-color, "Wayne Newton Perspiring!""
							)
							(3
								(TPrint 760 25) ; "The owners of the "Live Girl" shop are faring much better financially since they changed their name from the "Dead Girl" shop!"
							)
							(4
								(TPrint 760 26) ; "If you wanna have fun, this is the place to do it."
							)
							(5
								(TPrint 760 27) ; "Contrary to popular rumor, this is NOT a jukebox recycling center."
							)
							(6
								(TPrint 760 28) ; "If you want a CD real bad, this is the place! They've got some CDs that are real bad!"
							)
							(7
								(TPrint 760 29) ; "No boardwalk is complete without the requisite salt-water taffy store."
							)
						)
					)
					(2
						(TPrint 760 30) ; "Look! It's the skate shop of the supermarket-famous Ivana Tramp! And--she's open!!"
					)
				)
			)
			(3 ; Do
				(if
					(and
						(== (gEgo view:) smallView)
						(== (gEgo x:) approachX)
						(== (gEgo y:) approachY)
					)
					(if (== loop 2)
						(if (gEgo skating:)
							(TPrint 760 31) ; "Sorry, Larry. A sign on the door clearly reads, "No shirt, no shoes, no service." You're going to have to remove your skates before entering."
						else
							(gEgo setHeading: 0 gCurRoom)
						)
					else
						(TPrint 760 32) ; "A small sign near the front door of the shop reads, "Closed in Honor of The Donald's Birthday!""
						(TPrint 760 33 67 -1 185) ; "(You had no idea Donald Tramp's birthday was a local holiday!)"
					)
				else
					(gCurRoom
						handleEvent:
							(= evt
								((Event new:)
									type: evMOUSEBUTTON
									message: JOY_UP
									x: approachX
									y: approachY
								)
							)
					)
					(= obj2Cue self)
					(= verb2Use 3)
					(evt dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sSplash of Sound
	(properties
		number 761
	)
)

(instance splash of Prop
	(properties
		y 189
		view 770
		loop 2
	)
)

(instance rightEye of Prop
	(properties
		x 165
		y 180
		z 119
		description {Lana's right eye}
		view 795
	)

	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance leftEye of Prop
	(properties
		x 140
		y 180
		z 123
		description {Lana's left eye}
		view 795
		loop 2
	)

	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance nose of Prop
	(properties
		x 149
		y 180
		z 108
		description {Lana's nose}
		view 795
		loop 1
		cycleSpeed 18
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance lanaMouth of Prop
	(properties
		x 149
		y 180
		z 101
		description {Lana's mouth}
		view 795
		loop 3
	)

	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance Lana_Luscious_a of Talker
	(properties
		name {Lana Luscious}
		x 80
		y 160
		nsTop 70
		nsLeft 140
		view 1795
		loop 1
	)

	(method (init)
		(= mouth lanaCMouth)
		(super init: &rest)
	)
)

(instance lanaCMouth of Prop
	(properties
		view 1795
	)
)

(instance Lana_Luscious_b of Talker
	(properties
		name {Lana Luscious}
		nsTop 100
		nsLeft 5
		view 1731
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust lanaFBust)
		(= mouth lanaFMouth)
		(= eyes lanaFEyes)
		(super init: &rest)
	)
)

(instance lanaFBust of View
	(properties
		view 1731
		loop 1
	)
)

(instance lanaFMouth of Prop
	(properties
		nsTop 40
		nsLeft 23
		view 1731
	)
)

(instance lanaFEyes of Prop
	(properties
		nsTop 31
		nsLeft 29
		view 1731
		loop 2
		cycleSpeed 12
	)
)

(instance sFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 764 posn: -10 145 setMotion: MoveFwd 40 self)
			)
			(1
				(HandsOn)
				((gEgo looper:) dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFall of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (StepOn gEgo 16384)
			(gEgo setMotion: MoveTo (gEgo x:) 145)
			(HandsOn)
			(if (== (gCurRoom script:) sMoveLarry)
				(sMoveLarry dispose:)
			)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 145)
					(= eY 145)
					(= obj2Cue (= verb2Use 0))
					(= gonnaFall 1)
					(client setScript: sMoveLarry)
				else
					(gEgo
						setLoop: 2
						setCycle: StopWalk -1
						setMotion: PolyPath (gEgo x:) 158 self
					)
				)
			)
			(1
				(HandsOff)
				(gEgo
					view: 770
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End
				)
				(= cycles 10)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 setCycle: End)
				(= ticks 90)
			)
			(3
				(sSplash play:)
				(splash init: x: (gEgo x:) setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 780)
			)
		)
	)
)

(instance sScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveFwd 40 self)
			)
			(1
				(if (== register 4)
					(-- gBoardWalkDist)
					(gEgo x: (+ (gEgo x:) 320))
					(gCurRoom drawPic: (gCurRoom picture:) 11)
				else
					(++ gBoardWalkDist)
					(gEgo x: (- (gEgo x:) 320))
					(gCurRoom drawPic: (gCurRoom picture:) 12)
				)
				(= cycles 1)
			)
			(2
				(= eX 0)
				(= eY 0)
				(= obj2Cue 0)
				(= verb2Use 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sMeetLana of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 145)
					(= eY 145)
					(= obj2Cue self)
					(gCurRoom setScript: sMoveLarry)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(if (== (gCurRoom script:) sMoveLarry)
					(sMoveLarry dispose:)
				)
				(Points 6 138)
				(if (and (gEgo sitting:) (!= (gEgo loop:) 4))
					(self setScript: sStandUp self 0)
				else
					(= cycles 2)
				)
			)
			(2
				(lana setMotion: 0)
				(Say gEgo 760 34) ; "Oh, Lana," you say in your friendliest voice, "Lana Luscious!"
				(Say Lana_Luscious_b 760 35 108) ; "Yes," she replies, hesitantly. "Who are you?"
				(= ticks 30)
			)
			(3
				(Say gEgo 760 36) ; "My name is Larry; Larry Laffer," you purr. "I've come a long way to meet you!"
				(Say Lana_Luscious_b 760 37 108) ; "And meet me you have, Larry," says Lana. "Whaddaya say we sit down on that bench over there? These skates are killing me!"
				(= ticks 30)
			)
			(4
				(Say gEgo 760 38) ; "It would be my pleasure."
				(= ticks 30)
			)
			(5
				(gEgo
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: MoveTo 145 145 self
				)
				(lana setScript: sLanaSits self)
			)
			(6
				(gEgo view: 791 setLoop: 4 setCel: 0 setCycle: End)
			)
			(7
				(gEgo setLoop: 5 setCel: 0 setCycle: End self sitting: 1)
			)
			(8
				(gCurRoom drawPic: 795 100)
				(= cycles 1)
			)
			(9
				(gCast eachElementDo: #perform zCode)
				(SetupExit 1)
				(HandsOn)
				(User canControl: 0)
				(rightEye init:)
				(leftEye init:)
				(nose init:)
				(lanaMouth init:)
				(gFeatures addToFront: lanaFtr)
			)
			(10
				(HandsOff)
				(SetupExit 0)
				(gCurRoom drawPic: 760 100)
				(rightEye dispose:)
				(leftEye dispose:)
				(nose dispose:)
				(lanaMouth dispose:)
				(lanaFtr dispose:)
				(gAddToPics doit:)
				(gCast eachElementDo: #perform zCode)
				(skater1 cue:)
				(skater2 cue:)
				(skater3 cue:)
				(skater4 cue:)
				(skater5 cue:)
				(skater6 cue:)
				(skater7 cue:)
				(skater8 cue:)
				(skater9 cue:)
				(= cycles 3)
			)
			(11
				(lana
					freq: 0
					setLoop: 5
					setCel: 255
					posn: 107 145
					setCycle: Beg self
				)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo setLoop: 4 setCel: 255)
				(lana setLoop: 1 setCycle: Fwd setMotion: MoveTo -20 145 lana)
				(skater5 setPri: 10)
				(SetFlag 3) ; fSeenLL
				(self dispose:)
			)
		)
	)
)

(instance sLanaSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lana setPri: 9)
				(if (< (lana x:) 51)
					(self changeState: 2)
				else
					(lana setLoop: 1 setMotion: MoveTo 50 145 self)
				)
			)
			(1
				(lana setLoop: 2 setCycle: ForwardCounter 2 self)
			)
			(2
				(lana setLoop: 3 setCycle: End setMotion: MoveTo 93 145 self)
			)
			(3
				(lana setLoop: 4 setCycle: Fwd setMotion: MoveTo 107 145 self)
			)
			(4
				(skater5 setPri: 9)
				(lana posn: (lana x:) 148 setLoop: 5 setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= eX (if register 90 else 142))
				(= eY 145)
				(= obj2Cue self)
				(= verb2Use 0)
				(gCurRoom setScript: sMoveLarry)
			)
			(1
				(if register
					(gEgo setMotion: MoveTo 90 149 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(gEgo
						view: 791
						setLoop: (if (gEgo skating:) 2 else 0)
						setCel: 0
						setCycle: End self
						sitting: 1
					)
				else
					(gEgo
						view: 791
						setLoop: 4
						setCel: 0
						setCycle: End self
						sitting: 1
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDoSkates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo skating:)
					(= smallView 761)
					(= largeView 764)
					(gEgo
						setLoop: 1
						setCel: 255
						setPri: 10
						setCycle: Beg self
					)
				else
					(Points 3 139)
					(= smallView 765)
					(= largeView 768)
					(gEgo setLoop: 1 setCel: 0 setPri: 10 setCycle: End self)
				)
			)
			(1
				(if (gEgo skating:)
					(gEgo skating: 0)
					((Inv at: 18) state: 0) ; Roller-skates
					(gEgo setLoop: 0 setCel: 255)
					(LoadMany rsVIEW 763 762 761 764)
				else
					(gEgo skating: 1)
					((Inv at: 18) state: 1) ; Roller-skates
					(gEgo setLoop: 2 setCel: 255)
					(LoadMany rsVIEW 767 766 765 768)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					sitting: 0
					setLoop: 3
					normalize: largeView
					setStep: 3 3
					setHeading: 0
					posn: (gEgo x:) 145
				)
				(if register
					(bench doVerb: 4 18)
				)
				(self dispose:)
			)
		)
	)
)

(instance sMoveLarry of Script
	(properties)

	(method (changeState newState &tmp idx)
		(switch (= state newState)
			(0
				(gEgo normalize: (gEgo view:) setStep: 3 3)
				(cond
					((< eY (- (gEgo y:) 5))
						(= register 1)
					)
					((> eY (+ (gEgo y:) 5))
						(= register 2)
					)
					(else
						(= register 0)
					)
				)
				(= cycles 1)
			)
			(1
				(switch register
					(0
						(if (not gonnaFall)
							(User canControl: 1)
						)
						(++ state)
						(gEgo
							setCycle: StopWalk -1
							setMotion:
								PolyPath
								eX
								(Min 145 (gEgo y:))
								self
						)
					)
					(1
						(User canControl: 0)
						(if (== (gEgo view:) smallView)
							(= register 0)
							(= cycles 1)
						else
							(= idx (- (gEgo view:) smallView))
							(gEgo
								setLoop: 3
								setCel: 0
								setCycle: End
								setMotion:
									PolyPath
									(gEgo x:)
									[shrinkY idx]
									self
							)
						)
					)
					(2
						(User canControl: 0)
						(if (== (gEgo view:) largeView)
							(= register 0)
							(= cycles 1)
						else
							(= idx (- (gEgo view:) smallView))
							(gEgo
								setLoop: 2
								setCel: 0
								setCycle: End
								setMotion:
									PolyPath
									(gEgo x:)
									[growY idx]
									self
							)
						)
					)
				)
			)
			(2
				(switch register
					(1
						(if (< (gEgo view:) 769)
							(gEgo
								view: (- (gEgo view:) 1)
								setLoop: -1
								setCel: 255
							)
						)
						(if (< (- (gEgo y:) eY) 6)
							(= register 0)
						)
					)
					(2
						(if (< (gEgo view:) 769)
							(gEgo
								view: (+ (gEgo view:) 1)
								setLoop: -1
								setCel: 0
							)
						)
						(if (< (- eY (gEgo y:)) 6)
							(= register 0)
						)
					)
				)
				(self changeState: 1)
			)
			(3
				(cond
					(verb2Use
						(obj2Cue doVerb: verb2Use)
					)
					(obj2Cue
						(obj2Cue cue:)
					)
				)
				(= obj2Cue (= verb2Use 0))
				(if gonnaFall
					(client setScript: sFall)
				else
					(User canControl: 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLanaTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say gEgo 760 39) ; ""Skate here often?" you ask."
				(= ticks 60)
			)
			(1
				(Say Lana_Luscious_a 760 40 108) ; ""Only when I'm trying to find a man," she says with a smile."
				(= ticks 60)
			)
			(2)
			(3
				(Say gEgo 760 41) ; ""So, does that happen often?" you ask."
				(= ticks 60)
			)
			(4
				(Say Lana_Luscious_a 760 42 108) ; ""Only when I'm here skating," she says with a smile."
				(= ticks 60)
			)
			(5)
			(6
				(Say gEgo 760 43) ; ""I must tell you how much I love your skating technique," you tell Lana."
				(= ticks 60)
			)
			(7
				(Say Lana_Luscious_a 760 44 108) ; ""If you like that, you should drop by the `Tramp This! Mud Wrestling' Show. I go on in just a few minutes!" she says with a wink."
				(= ticks 60)
			)
			(8)
			(9
				(Say gEgo 760 45) ; ""Where is the mud wrestling held?" you ask."
				(= ticks 60)
			)
			(10
				(Say Lana_Luscious_a 760 46 108) ; "Why, it's in the Tramp Ballroom. The entrance is at the rear of the casino!" she says. "And if you bring a few hundred dollars with you, I'll make sure it's an experience you'll never forget!"
				(= ticks 60)
			)
			(11
				(TPrint 760 47 67 -1 185) ; "(You now understand why Lana was one of the top three finalists back at PornProdCorp!)"
				(= ticks 60)
			)
			(12)
			(13
				(Points 2 140)
				(Say gEgo 760 48) ; "I'll be there, Lana!" you exclaim. "See you there!"
				(= ticks 60)
			)
			(14
				(Say Lana_Luscious_a 760 49 108) ; "Okay, Larry; I'll look forward to it!" she concludes, standing up. "Gotta go get out of my makeup!"
				(= ticks 60)
			)
			(15
				(TPrint 760 50 67 -1 185) ; "(Doesn't she mean "into?")"
				(= cycles 1)
			)
			(16
				(sMeetLana cue:)
				(self dispose:)
			)
		)
	)
)

(instance lanaFtr of Feature
	(properties
		x 160
		y 170
		nsBottom 189
		nsRight 319
		description {Lana Luscious}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 760 51) ; "You are sitting on the boardwalk staring directly into the eyes of a gorgeous, oversexed blond! If only you could think of something to say!"
			)
			(5 ; Talk
				(if (gCurRoom script:)
					((gCurRoom script:) cue:)
				else
					(gCurRoom setScript: sLanaTalks)
				)
			)
			(3 ; Do
				(Say Lana_Luscious_a 760 52 108) ; "Oh, Larry! You know that just drives me crazy!"
			)
			(10 ; Zipper
				(Say Lana_Luscious_a 760 53 108) ; "Larry! Here?" says Lana. "Why don't you come by the Casino later when I'm mud wrestling?"
			)
			(4 ; Inventory
				(Say Lana_Luscious_a 760 54 108) ; "Oh, I have no use for anything you could possibly offer me, Larry," says Lana. "Why, when I have total access to this sun-drenched boardwalk, the fresh ocean breezes caressing my hair, my smell of the salt water and ready access to all the mud I can roll in!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildings of Feature ; UNUSED
	(properties
		x 159
		y 29
		nsBottom 59
		nsRight 319
		description {the boardwalk buildings}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 55) ; "The far side of the Tramp Boardwalk is lined with tawdry, tacky tourist traps. A bit of blue sky peeks through the buildings."
			)
			(3 ; Do
				(TPrint 760 56) ; "Almost every building on the boardwalk is closed today in honor of a long celebrated local holiday--Donald Tramp's birthday."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bench of Feature
	(properties
		x 126
		y 140
		nsTop 129
		nsLeft 98
		nsBottom 151
		nsRight 154
		description {the bench}
		sightAngle 40
		approachX 88
		approachY 152
	)

	(method (doVerb theVerb invItem &tmp who2Cue)
		(switch theVerb
			(2 ; Look
				(TPrint 760 57) ; "A long row of park benches await your sitting pleasure along the ocean side of the boardwalk."
			)
			(3 ; Do
				(cond
					((not (gEgo sitting:))
						(gEgo
							setScript: sSitDown 0 (if (sSitDown next:) 1 else 0)
						)
					)
					((== (gEgo loop:) 4)
						(gEgo setScript: sStandUp 0 (gEgo has: 18)) ; Roller-skates
					)
					((gEgo has: 18) ; Roller-skates
						(gEgo setScript: sDoSkates)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 18) ; Roller-skates
					(sSitDown next: sDoSkates)
					(self doVerb: 3)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post1 of Feature
	(properties
		x 61
		y 160
		nsTop 131
		nsLeft 51
		nsBottom 189
		nsRight 72
		description {the post}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 58) ; "These posts hold up the boardwalk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post2 of Feature
	(properties
		x 137
		y 163
		nsTop 138
		nsLeft 125
		nsBottom 189
		nsRight 149
		description {the post}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 58) ; "These posts hold up the boardwalk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post3 of Feature
	(properties
		x 205
		y 164
		nsTop 139
		nsLeft 193
		nsBottom 189
		nsRight 221
		description {the post}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 58) ; "These posts hold up the boardwalk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post4 of Feature
	(properties
		x 295
		y 165
		nsTop 141
		nsLeft 283
		nsBottom 189
		nsRight 309
		description {the post}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 760 58) ; "These posts hold up the boardwalk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

