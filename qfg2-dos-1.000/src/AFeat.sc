;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TargActor)
(use Interface)
(use n702)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(local
	guy1
	guy2
	wasMoving
	xVal
	yVal
	exitingAlley
	pickLeft
	[leftDoorPos 26] = [92 174 100 156 108 139 115 128 121 115 126 105 129 97 131 90 134 84 136 81 138 74 139 69 140 66]
	[rightDoorPos 26] = [226 174 218 154 210 139 206 128 201 116 197 106 194 97 191 92 188 86 185 82 182 76 179 72 176 67]
	[leftPassPos 26] = [92 174 100 156 108 139 114 127 120 116 124 105 129 97 131 92 134 84 136 81 138 76 139 72 140 67]
	[rightPassPos 26] = [226 174 218 154 210 139 206 128 201 116 197 106 194 97 191 92 188 86 185 82 182 76 179 72 176 67]
	[sconcePositions 39] = [95 224 85 102 216 79 110 209 73 115 204 69 120 199 64 124 194 60 127 192 56 128 190 54 129 190 52 130 188 51 131 187 49 134 184 47 136 183 45]
	[featureLoops 24] = [701 0 700 4 700 2 700 0 700 0 701 2 701 4 708 0 700 0 701 8 700 1 700 6]
	[featureNames 12] = [{ AFDoor} { AFCorner} { AFEnd} { AFEndDoorway} { AFEndDoor} { AFPassage} { AFSconce} { AFPlaza} { AFHorzCrack} { AFFrontCorner} { AFEndSideDoor} { AFBarricade}]
	[doorDscs 6] = [{Someone probably lives behind this door.} {It's a door.  No doubt about it.} {Through this door lies the other side.} {I'll take what's behind door number 3.} {Huh?  It's only PAINTED on.} {If you lived here, you'd be home now.}]
	[sconceDscs 6] = [{The flame in the sconce gives a steady light.} {The wall is carrying a torch for you.} {Meager light, but ample.} {The light helps to relieve the gloom of this street.} {Just another sconce.} {Just another flame.}]
	[doorListenDscs 6] = [{You can hear termites chewing.} {You hear door-like sounds.} {Behind the locked door, you hear a family quarrel.  Better not get involved. } {Someone is whistling a familiar tune in an odd key behind this door.} {Someone behind this door is repeatedly saying 'Ma fhimt.'  You don't understand.} {Sounds like work going on behind this door.}]
	[str 300]
	[str2 100]
)

(procedure (sideName sideID sideAlley xSide ySide)
	(if (> sideID 0)
		(return (sideAlley streetName: xSide ySide))
	else
		(return
			(switch (- sideID)
				(269 {Zrir Darb})
				(120 {Money Changer})
				(200 {Astrologer})
				(199 {Sitt Tarik})
				(229 {Sahir Tarik})
				(271 {Saif Darb})
				(440 {Ignorance of the law is no excuse})
				(429 {You must carry your Visa at all times})
				(else 0)
			)
		)
	)
)

(class AFeat of View
	(properties
		description {a door}
		signal 24580
		type 0
		side 0
		pos 0
		fake 0
		illegalBits 0
	)

	(method (onMe)
		(if (OneOf type 0 10 6 11)
			(return (super onMe: &rest))
		else
			(return 0)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== type 11)
				(if (Said 'read/sign')
					(super doVerb: 1)
				)
			)
			((not (OneOf type 0 10)))
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(cond
					((not (CanPickLocks 1)))
					((> cel 1)
						(HighPrint 700 0) ; "You aren't close to a door."
					)
					(else
						(gEgo setScript: pickLock 0 self)
					)
				)
			)
			((Said 'listen')
				(HighPrint [doorListenDscs (Random 0 5)])
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (OneOf type 0 10)
					(HighPrint 700 1) ; "Everyone here keeps their doors tightly locked and bolted."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (new theType theSide thePos)
		((super new:)
			type: theType
			side: theSide
			pos: thePos
			view: [featureLoops (+ (* theType 2) 0)]
			loop: (+ [featureLoops (+ (* theType 2) 1)] (== theSide 1))
			palette: (if (<= 0 gTimeODay 4) 1 else 2)
		)
	)

	(method (init)
		(cond
			((OneOf type 0 10)
				(= description {the door})
				(= noun '/door')
				(= lookStr [doorDscs (Random 0 4)])
			)
			((== type 6)
				(= description {the sconce})
				(= noun '/sconce,light,lamp')
				(= lookStr [sconceDscs (Random 0 5)])
			)
			((== type 11)
				(= description {the barricade})
				(= noun '/board,barricade,sign')
				(= lookStr
					{This street has been barricaded off.  The sign reads 'Road closed by order of Khaveen'.}
				)
			)
		)
		(cond
			((OneOf type 1 2 3 7 10 11)
				(self posn: 160 79 setPri: 2)
			)
			((== type 4)
				(self posn: 174 75 setPri: 2)
			)
			((== type 6)
				(self setPri: 15)
			)
			((== type 8)
				(self setPri: 0 x: 160)
			)
		)
		(super init:)
	)

	(method (showSelf)
		(if (== type 8)
			(return)
		)
		(gCurRoom pos2Coords: pos)
		(Print
			(Format ; "pos %d %s x %d y %d cel %d priority %d"
				@str
				700
				2
				pos
				(switch side
					(0 {Left})
					(1 {Right})
					(2 {Center})
				)
				xVal
				yVal
				cel
				priority
			)
			#icon
			view
			loop
			cel
			#title
			[featureNames type]
		)
	)

	(method (showFront scrBotPos)
		(if (>= pos (- scrBotPos 1))
			(self showSelf:)
		)
	)

	(method (hide)
		(if (not (& signal $0088))
			(super hide:)
		)
	)

	(method (redraw scrBotPos &tmp distance theCtrl theX theY)
		(= distance (- pos scrBotPos))
		(if (not (< -1 distance 13))
			(if (== type 8)
				(+= pos 11)
				(= distance (- pos scrBotPos))
			else
				(self hide:)
				(return)
			)
		)
		(cond
			((OneOf type 0 5 9)
				(cond
					((== type 0)
						(if (== side 0)
							(= theX [leftDoorPos (* distance 2)])
							(= theY [leftDoorPos (+ (* distance 2) 1)])
						else
							(= theX [rightDoorPos (* distance 2)])
							(= theY [rightDoorPos (+ (* distance 2) 1)])
						)
					)
					((== side 0)
						(= theX [leftPassPos (* distance 2)])
						(= theY [leftPassPos (+ (* distance 2) 1)])
					)
					(else
						(= theX [rightPassPos (* distance 2)])
						(= theY [rightPassPos (+ (* distance 2) 1)])
					)
				)
				(self posn: theX theY cel: distance setPri: -1)
				(cond
					((== cel 0)
						(self setPri: 12)
						(= theCtrl (if side 8192 else 512))
						(if (not fake)
							(gEgo ignoreControl: theCtrl)
						)
					)
					((== cel 1)
						(self setPri: 10)
						(= theCtrl (if side 16384 else 2048))
						(if (not fake)
							(gEgo ignoreControl: theCtrl)
						)
					)
				)
			)
			((OneOf type 1 2 3 7 10 11)
				(if (> distance 9)
					(= cel (- (self lastCel:) (- distance 9)))
				else
					(= cel (self lastCel:))
					(if (== type 1)
						(= theCtrl (if side 4096 else 1024))
						(gEgo ignoreControl: theCtrl)
					)
				)
				(if (OneOf type 3 7)
					(gEgo ignoreControl: 128)
				)
			)
			((== type 4)
				(if (> distance 9)
					(self hide:)
					(return)
				else
					(= cel 0)
				)
			)
			((== type 6)
				(self
					posn:
						[sconcePositions (+ (* distance 3) side)]
						[sconcePositions (+ (* distance 3) 2)]
					cel: distance
				)
			)
			((== type 8)
				(if
					((gCurRoom alleyFeatures:)
						firstTrue: #perform isOpeningHere pos
					)
					(self hide:)
					(return)
				else
					(self y: [leftDoorPos (+ (* distance 2) 1)])
				)
			)
		)
		(self forceUpd: show:)
	)
)

(instance isOpeningHere of Code
	(properties)

	(method (doit theFeature thePos)
		(if (== (theFeature pos:) thePos)
			(OneOf (theFeature type:) 0 5 9)
		)
	)
)

(class AlleyRoom of Rm
	(properties
		picture 700
		style 15
		vanishingY 50
		alley 0
		length 0
		scrBotPos 0
		dX 0
		dY 0
		alleyFeatures 0
		facingX 0
		facingY 0
		facingHeading 0
		orientation 0
		isScrolling 0
		isMoving 0
		nextTee 0
	)

	(method (init)
		(LoadMany rsVIEW 700 701 708 711)
		(LoadMany rsSCRIPT 701 702)
		(exploder init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(= facingHeading gRoomExitDir)
		(= gSpellChecker gAllChecker)
		(gEgo edgeHit: EDGE_NONE init:)
		(self newAlley: (Room2Alley))
		(super init:)
	)

	(method (newAlley theAlley &tmp absLen theX theY point thePos theFeatures facingType xBotCoord yBotCoord enteringFromRoom enteringFromSideRoom)
		(if (not (IsObject theAlley))
			(Print 700 3) ; "Error: new alley is not an object."
			(= gQuit 1)
			(return)
		)
		(HandsOff)
		(NormalEgo)
		(gEgo loop: 3 setMotion: 0 illegalBits: -384 x: 160 y: 147)
		(= alley theAlley)
		(= isScrolling 1)
		(= exitingAlley 0)
		(User prevDir: 0)
		(if alleyFeatures
			(self drawPic: picture 15)
			(= wasMoving (= isMoving 1))
			(alleyFeatures dispose:)
			(= enteringFromRoom 0)
		else
			(= wasMoving 0)
			(= isMoving 0)
			(= enteringFromRoom 1)
		)
		((= alleyFeatures (Collect new:)) add:)
		(if (== (alley botX:) (alley topX:))
			(= orientation 1)
		else
			(= orientation 2)
		)
		(= enteringFromSideRoom 0)
		(if (!= (& orientation $0001) (& facingHeading $0001))
			(= facingHeading orientation)
			(if (and enteringFromRoom (!= gPrevRoomNum 440) (!= gPrevRoomNum 500))
				(= enteringFromSideRoom 1)
			)
		)
		(if (== facingHeading orientation)
			(= facingX (alley topX:))
			(= facingY (alley topY:))
			(= facingType (alley topType:))
		else
			(= facingX (alley botX:))
			(= facingY (alley botY:))
			(= facingType (alley botType:))
		)
		(= dX (= dY 0))
		(cond
			((== orientation 1)
				(if (== facingY (alley topY:))
					(= dY 1)
				else
					(= dY -1)
				)
			)
			((== facingX (alley topX:))
				(= dX 1)
			)
			(else
				(= dX -1)
			)
		)
		(= xBotCoord gXEgo)
		(= yBotCoord gYEgo)
		(if
			(<
				(= absLen (+ 1 (Abs (- facingX xBotCoord)) (Abs (- facingY yBotCoord))))
				3
			)
			(= absLen 3)
			(= xBotCoord (- facingX (* dX 2)))
			(= yBotCoord (- facingY (* dY 2)))
			(gEgo y: 100)
		)
		(= length (- (* absLen 4) 3))
		(= nextTee (= scrBotPos 0))
		(= theX xBotCoord)
		(= theY yBotCoord)
		(= thePos 0)
		(for ((= point 0)) (< point absLen) ((++ point))
			(if (= theFeatures (alley at: theX theY))
				(self addFeatures: theFeatures thePos)
				(if (and (>= thePos 8) (== theFeatures 771))
					(= nextTee (- thePos 8))
				)
			)
			(+= theX dX)
			(+= theY dY)
			(+= thePos 4)
		)
		(if (or (!= (- theX dX) facingX) (!= (- theY dY) facingY))
			(Printf 700 4) ; "Error: facing != last coords"
		)
		(self add: 8 2 8)
		(self add: 8 2 6)
		(self add: 8 2 4)
		(self add: 8 2 2)
		(self add: 8 2 0)
		(if enteringFromSideRoom
			(self setScript: enterFromSide)
		else
			(HandsOn)
		)
	)

	(method (addFeatures featuresWord thePos &tmp isFake)
		(if (& featuresWord $0004)
			(self add: 6 0 thePos)
			(&= featuresWord $fffb)
		)
		(if (& featuresWord $0008)
			(self add: 6 1 thePos)
			(&= featuresWord $fff7)
		)
		(if (& featuresWord $0010)
			(&= featuresWord $ffef)
		)
		(if (& featuresWord $0020)
			(&= featuresWord $ffdf)
		)
		(if (& featuresWord $0400)
			(&= featuresWord $fbff)
			(= isFake 1)
		else
			(= isFake 0)
		)
		(switch featuresWord
			(1
				(self add: 0 0 thePos isFake)
			)
			(2
				(self add: 0 1 thePos isFake)
			)
			(257
				(self add: 5 0 thePos)
			)
			(258
				(self add: 5 1 thePos)
			)
			(259
				(self add: 5 0 thePos)
				(self add: 5 1 thePos)
			)
			(769
				(if thePos
					(self add: 1 0 thePos)
					(self add: 2 1 thePos)
				else
					(self add: 9 0 thePos)
				)
			)
			(770
				(if thePos
					(self add: 2 0 thePos)
					(self add: 1 1 thePos)
				else
					(self add: 9 1 thePos)
				)
			)
			(771
				(if thePos
					(self add: 1 0 thePos)
					(self add: 1 1 thePos)
				else
					(self add: 9 0 thePos)
					(self add: 9 1 thePos)
				)
			)
			(576
				(self add: 7 2 thePos)
			)
			(4096
				(self add: 11 2 thePos)
			)
			(128
				(self add: 2 0 thePos)
				(self add: 2 1 thePos)
			)
			(513
				(self add: 2 1 thePos)
				(self add: 10 2 thePos)
			)
		)
	)

	(method (add aType aSide aPos isFake)
		(if (and (not aPos) (OneOf aType 2 3 4 7 11 10))
			(return)
		)
		(if (!= orientation facingHeading)
			(= aSide
				(switch aSide
					(0 1)
					(1 0)
					(else aSide)
				)
			)
		)
		(alleyFeatures
			add:
				((self newFeature: aType aSide aPos)
					fake: (if (< argc 4) 0 else isFake)
					init:
					redraw: scrBotPos
					yourself:
				)
		)
	)

	(method (newFeature aType aSide aPos)
		(AFeat new: aType aSide aPos)
	)

	(method (exitAlley ctrl &tmp newLoc)
		(= exitingAlley 1)
		(cond
			((OneOf ctrl 1024 4096 512 2048 8192 16384)
				(if (OneOf ctrl 1024 512 2048)
					(= facingHeading (self changeHeading: facingHeading -1))
				else
					(= facingHeading (self changeHeading: facingHeading 1))
				)
				(self egoPos2Coords:)
				(alley at: gXEgo gYEgo)
				(if (not (= newLoc (alley atLoc:)))
					(Printf 700 5 (alley name:) gXEgo gYEgo) ; "error: %s has no location at %d,%d"
					(= gQuit 1)
					(return)
				)
				(if (< newLoc 0)
					(= gRoomExitDir facingHeading)
					(self newRoom: (- newLoc))
				else
					(DisposeScript gAlleyScript)
					(self newAlley: (AlleyID2Alley newLoc))
				)
			)
			((== ctrl 128)
				(alley at: facingX facingY)
				(if (not (= newLoc (alley atLoc:)))
					(Printf 700 5 (alley name:) gXEgo gYEgo) ; "error: %s has no location at %d,%d"
					(= gQuit 1)
					(return)
				)
				(= gRoomExitDir facingHeading)
				(self newRoom: (- newLoc))
			)
		)
	)

	(method (turnAround &tmp aXEgo)
		(= aXEgo (gEgo x:))
		(= facingHeading (self changeHeading: facingHeading 2))
		(self egoPos2Coords:)
		(self newAlley: alley)
		(gEgo x: 160)
	)

	(method (changeHeading curDir nCompassPoints &tmp newDir)
		(cond
			((> (= newDir (+ curDir nCompassPoints)) 4)
				(-= newDir 4)
			)
			((< newDir 1)
				(+= newDir 4)
			)
		)
		(return newDir)
	)

	(method (showSelf)
		(Print
			(Format ; "length %d scrBotPos %d dX %d dY %d facingX %d facingY %d facingHeading %d orientation %d ego priority %d"
				@str
				700
				6
				length
				scrBotPos
				dX
				dY
				facingX
				facingY
				facingHeading
				orientation
				(gEgo priority:)
			)
			#title
			(alley name:)
		)
	)

	(method (showAll)
		(self showSelf:)
		(alleyFeatures eachElementDo: #showSelf)
	)

	(method (showFront)
		(self showSelf:)
		(alleyFeatures eachElementDo: #showFront scrBotPos)
	)

	(method (pos2Coords aPos &tmp absDistFromEnd)
		(= absDistFromEnd (/ (- length aPos) 4))
		(= xVal (- facingX (* absDistFromEnd dX)))
		(= yVal (- facingY (* absDistFromEnd dY)))
	)

	(method (egoPos2Coords)
		(self pos2Coords: scrBotPos)
		(= gXEgo xVal)
		(= gYEgo yVal)
		(if (<= (gEgo y:) 116)
			(+= gXEgo (* dX 2))
			(+= gYEgo (* dY 2))
		)
	)

	(method (handleEvent event)
		(if (and gDebugging (== (event message:) KEY_ALT_f))
			(self showFront:)
			(event claimed: 1)
			(return)
		)
		(if (and gDebugging (== (event message:) KEY_ALT_a))
			(self showAll:)
			(event claimed: 1)
			(return)
		)
		(if
			(and
				(OneOf (event type:) evMOUSEBUTTON $0040) ; direction
				(or (not isScrolling) (not (User controls:)))
			)
			(event claimed: 0)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (not (event modifiers:))
					(if (< 137 (event y:))
						(if isMoving
							(= isMoving 0)
							(event claimed: 1)
						)
					else
						(= isMoving 1)
						(gEgo loop: 3)
						(event claimed: 1)
					)
				)
			)
			($0040 ; direction
				(cond
					((OneOf (event message:) JOY_UP JOY_UPRIGHT JOY_UPLEFT)
						(if (and isMoving (== (gEgo loop:) 3))
							(= isMoving 0)
						else
							(= isMoving 1)
							(gEgo loop: 3)
						)
						(event claimed: 1)
					)
					((== (event message:) JOY_NULL)
						(= isMoving 0)
						(gEgo setMotion: 0 setCycle: 0)
						(event claimed: 1)
					)
					(else
						(= isMoving 1)
					)
				)
			)
			(evSAID
				(cond
					((Said 'look,look,read/sign')
						(if (not (self showSign:))
							(HighPrint 700 7) ; "No street signs are visible from here."
						)
					)
					(
						(and
							(Said
								'look,look[/alley,passage,street,road,wall,ground]'
							)
							(not (self showSign:))
						)
						(HighPrint 700 8) ; "You are walking through one of the many twisty streets of the city."
					)
				)
			)
		)
		(event claimed:)
	)

	(method (crossIntersection)
		(if (and (Random 0 1) (> gHowFast 0))
			(gGame setScript: randomCrossers)
		)
	)

	(method (doit &tmp ctrl theCel theCycler timeToCycle cyclerIsObj)
		(super doit:)
		(= cyclerIsObj (IsObject (= theCycler (gEgo cycler:))))
		(cond
			((or script exitingAlley (gEgo script:)))
			((and cyclerIsObj (theCycler isMemberOf: Grycler)))
			((& $7e80 (gEgo onControl:))
				(if (& $7e80 (= ctrl (gEgo onControl: 1)))
					(self exitAlley: ctrl)
				)
			)
			((>= (gEgo y:) 179)
				(self turnAround:)
			)
			((not isScrolling))
			((not isMoving)
				(if wasMoving
					(EgoGait -1 0)
				)
			)
			((!= (gEgo loop:) 3)
				(if (or (not cyclerIsObj) (not (theCycler isMemberOf: StopWalk)))
					(EgoGait -1 0)
				)
			)
			((and isScrolling (<= (- length scrBotPos) 9))
				(= isScrolling 0)
				(EgoGait -1 0)
				(gEgo setDirection: 1)
				(if (and (== scrBotPos nextTee) nextTee)
					(self crossIntersection:)
				)
			)
			(else
				(if (gEgo mover:)
					(gEgo setMotion: 0)
				)
				(if (== (gEgo view:) 4)
					(EgoGait -1 0)
				)
				(if (IsObject (gEgo cycler:))
					(gEgo setCycle: 0)
				)
				(if (> (= theCel (+ (gEgo cel:) 1)) (gEgo lastCel:))
					(= theCel 0)
				)
				(gEgo cel: theCel forceUpd:)
				(= timeToCycle 0)
				(cond
					((or (== gEgoGait 2) (== (gEgo xStep:) 1)) ; sneaking
						(if (not theCel)
							(= timeToCycle 1)
						)
					)
					((== gEgoGait 1) ; running
						(= timeToCycle 1)
					)
					((not (& theCel $0001))
						(= timeToCycle 1)
					)
				)
				(if timeToCycle
					(gEgo observeControl: -384)
					(alleyFeatures eachElementDo: #redraw scrBotPos)
					(++ scrBotPos)
				)
			)
		)
		(= wasMoving isMoving)
		(if gDebugging
			(self egoPos2Coords:)
			(DrawStatus
				(Format ; "%s: dir %c loc %d,%d"
					@str
					700
					9
					(alley name:)
					(StrAt {NESW} (- facingHeading 1))
					gXEgo
					gYEgo
				)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(DisposeScript gAlleyScript)
		(DisposeScript 701)
		(alleyFeatures dispose:)
		(super dispose:)
	)

	(method (showSign &tmp theNode theFeat thePos sideID thisName crossName xLeftCoord yLeftCoord xRightCoord yRightCoord sideAlley tmpAlleyScr aHgt aSide xSide ySide anyShown mustShowSelf)
		(= anyShown 0)
		(= mustShowSelf 1)
		(= str 0)
		(for
			((= theNode (alleyFeatures first:)))
			theNode
			((= theNode (alleyFeatures next: theNode)))
			
			(= theFeat (NodeValue theNode))
			(if
				(and
					(not (& (theFeat signal:) $0088))
					(OneOf (theFeat type:) 1 5 9)
				)
				(= thePos (theFeat pos:))
				(= tmpAlleyScr gAlleyScript)
				(self pos2Coords: thePos)
				(alley at: xVal yVal)
				(if (> (= sideID (alley atLoc:)) 0)
					(= sideAlley (AlleyID2Alley sideID))
					(if (not (IsObject sideAlley))
						(return (Printf 700 10 xVal yVal)) ; "Error: sideAlley at %d,%d not an object"
					)
				)
				(= xLeftCoord (= xRightCoord xVal))
				(= yLeftCoord (= yRightCoord yVal))
				(switch facingHeading
					(1
						(-= xLeftCoord 1)
						(+= xRightCoord 1)
					)
					(3
						(+= xLeftCoord 1)
						(-= xRightCoord 1)
					)
					(2
						(+= yLeftCoord 1)
						(-= yRightCoord 1)
					)
					(4
						(-= yLeftCoord 1)
						(+= yRightCoord 1)
					)
				)
				(if (!= (+ xVal yVal) (+ gXEgo gYEgo))
					(if (<= (gEgo y:) 116)
						(= aHgt { down the street })
					else
						(= aHgt { up the street })
					)
				else
					(= aHgt { })
				)
				(if (== (theFeat side:) 0)
					(= xSide xLeftCoord)
					(= ySide yLeftCoord)
					(= aSide {left})
				else
					(= xSide xRightCoord)
					(= ySide yRightCoord)
					(= aSide {right})
				)
				(= thisName (alley streetName: xVal yVal))
				(if (= crossName (sideName sideID sideAlley xSide ySide))
					(StrCat
						@str
						(Format ; "%s sign%sto the %s%sreads: '%s'."
							@str2
							700
							11
							(if anyShown {Another} else {There is a})
							aHgt
							aSide
							(if anyShown { } else {, which })
							crossName
						)
					)
				else
					(StrCat @str (Format @str2 700 12 aHgt aSide)) ; "There is an unmarked alley%sto the %s."
				)
				(if (and thisName crossName (not (StrCmp thisName crossName)))
					(= mustShowSelf 0)
				)
				(= anyShown 1)
				(if (!= gAlleyScript tmpAlleyScr)
					(DisposeScript gAlleyScript)
					(= gAlleyScript tmpAlleyScr)
				)
			)
		)
		(if anyShown
			(= thisName (alley streetName: xVal yVal))
			(if (and mustShowSelf thisName)
				(StrCat
					@str
					(Format @str2 700 13 (alley streetName: xVal yVal)) ; "The sign on your street reads '%s'."
				)
			)
			(HighPrint @str)
		)
		(return anyShown)
	)
)

(instance randomCrossers of Script
	(properties)

	(method (changeState newState &tmp i [unused 4] aX aY aLoop nGuys guy aHeading toX)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom isMoving: 0)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(2
				(= nGuys (Random 1 2))
				(for ((= i 0)) (< i nGuys) ((++ i))
					(if (not i)
						(= guy (= guy1 (Actor new:)))
					else
						(= guy (= guy2 (Actor new:)))
					)
					(gCurRoom makeCrosser: guy)
					(if (Random 0 1)
						(= aLoop 0)
						(= aHeading 90)
						(= aX 107)
						(if (== i 1)
							(-= aX (Random 5 20))
						)
						(= toX 191)
					else
						(= aLoop 1)
						(= aHeading 270)
						(= aX 191)
						(if (== i 1)
							(+= aX (Random 5 20))
						)
						(= toX 100)
					)
					(= aY 81)
					(if (== i 1)
						(+= aY 2)
					)
					(guy
						loop: aLoop
						x: aX
						y: aY
						heading: aHeading
						signal: 16384
						illegalBits: 0
						init:
						setCycle: Walk
						setMotion: MoveTo toX aY
					)
					(if (or (== i 1) (== nGuys 1))
						((guy mover:) caller: self)
					)
					(gCast delete: guy)
					(gCast addToFront: guy)
				)
			)
			(3
				(guy1 dispose:)
				(= guy1 0)
				(if (IsObject guy2)
					(guy2 dispose:)
					(= guy2 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterFromSide of Script
	(properties)

	(method (changeState newState &tmp theMult theHeading)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (- gRoomExitDir (gCurRoom facingHeading:)) 1)
					(= theMult -1)
					(= theHeading 90)
				else
					(= theMult 1)
					(= theHeading 270)
				)
				(gEgo x: (+ 160 (* 70 theMult)) y: 164)
				(gEgo setMotion: MoveTo 160 (gEgo y:) self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 147 self)
			)
			(2
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance exploder of TargActor
	(properties)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (onMe)
		(return 0)
	)

	(method (hurtMe)
		(return 1)
	)
)

(instance pickLock of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= pickLeft (== (register side:) 0))
				(gEgo
					setMotion:
						MoveTo
						(+ (register x:) (if pickLeft 13 else -13))
						(- (register y:) 2)
						self
				)
			)
			(1
				(gEgo view: 47 loop: (+ 4 pickLeft) cel: 0 setCycle: End self)
				(SetFlag 117)
			)
			(2
				(= cycles 20)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= cycles 10)
			)
			(5
				(NormalEgo)
				(gEgo loop: (if pickLeft 7 else 6))
				(ClearFlag 117)
				(if (PickLock 80 1 1)
					(HighPrint 700 14) ; "You got some useful lockpicking practice, but the door has been bolted from the inside. No amount of skill will allow you to open it."
				)
				(self dispose:)
			)
		)
	)
)

