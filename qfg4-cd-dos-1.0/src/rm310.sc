;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use OccCyc)
(use PuzzleBar)
(use DText)
(use Str)
(use Print)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 (Str new:))
	(if
		(and
			(== param1 bPiePan)
			(or (gEgo has: 28) ((gInventory at: 28) chestAmout:) (IsFlag 179)) ; thePiepan, thePiepan
		)
		(Message msgGET 310 28 6 78 1 (temp2 data:)) ; "You consider purchasing another pie pan, but decide that one should be enough for all of your current baking needs."
		(Print addText: (temp2 data:) init:)
		(temp2 dispose:)
		(return)
	)
	(= temp3
		(/
			(= temp0
				(switch param1
					(bBag 50)
					(bCandy 5)
					(bFlask 100)
					(bGarlic 25)
					(bHandbroom 350)
					(bPiePan 250)
					(bRations 50)
				)
			)
			100
		)
	)
	(= temp4 ((gInventory at: 0) amount:)) ; thePurse
	(cond
		((>= global395 temp0)
			(-= global395 temp0)
			(gEgo
				get:
					(switch param1
						(bBag 51)
						(bCandy 8)
						(bFlask 15)
						(bGarlic 22)
						(bHandbroom 39)
						(bPiePan 28)
						(bRations 4)
					)
			)
			(temp2 dispose:)
		)
		(
			(or
				(> temp4 temp3)
				(and
					(== temp4 temp3)
					(>= (- (+ global395 (* temp4 100)) temp0) 0)
				)
			)
			(if (>= (-= global395 (- temp0 (* temp3 100))) 0)
				((gInventory at: 0) amount: (- temp4 temp3)) ; thePurse
			else
				((gInventory at: 0) amount: (- (- temp4 temp3) 1)) ; thePurse
				(+= global395 100)
			)
			(gEgo
				get:
					(switch param1
						(bBag 51)
						(bCandy 8)
						(bFlask 15)
						(bGarlic 22)
						(bHandbroom 39)
						(bPiePan 28)
						(bRations 4)
					)
			)
			(temp2 dispose:)
		)
		(else
			(Message msgGET 310 28 6 68 1 (temp2 data:)) ; "You do not have enough money to purchase that!"
			(Print addText: (temp2 data:) init:)
			(temp2 dispose:)
		)
	)
	(if (/ global395 100)
		((gInventory at: 0) ; thePurse
			amount: (+ ((gInventory at: 0) amount:) (/ global395 100)) ; thePurse
		)
		(= global395 (mod global395 100))
	)
	(localproc_1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 (Str new:))
	(= temp1 (Str new:))
	(= temp2 (Str new:))
	(= temp3 ((gInventory at: 0) amount:)) ; thePurse
	(= temp4 0)
	(if (or temp3 global395)
		(Message msgGET 310 0 0 82 1 (temp0 data:)) ; "You are carrying:"
		(Print addText: (temp0 data:) 0 0)
		(= temp4 (Print largeAlp:))
		(= temp5 (Print xtheX:))
		(= temp6 (Print xtheY:))
		(if temp3
			(Message msgGET 310 0 0 80 1 (temp1 data:)) ; "%d Crowns"
			(temp0 format: (temp1 data:) temp3)
			(Print largeAlp: 0 addText: (temp0 data:) 0 9)
		)
		(if global395
			(Message msgGET 310 0 0 81 1 (temp2 data:)) ; "%d Kopeks"
			(temp0 format: (temp2 data:) global395)
			(Print addText: (temp0 data:) 0 (if temp3 18 else 9))
		)
	else
		(Message msgGET 310 0 0 83 1 (temp0 data:)) ; "You don't have any more money left."
		(Print addText: (temp0 data:) 0 0)
		(= temp4 (Print largeAlp:))
		(= temp5 (Print xtheX:))
		(= temp6 (Print xtheY:))
	)
	(Print largeAlp: temp4 xtheX: temp5 xtheY: temp6 init:)
	(temp0 dispose:)
	(temp1 dispose:)
	(temp2 dispose:)
)

(procedure (localproc_2 &tmp temp0)
	(while ((= temp0 ((gUser curEvent:) new:)) type:)
	)
)

(instance rm310 of GloryRm
	(properties
		picture 310
		west 260
		leftY 173
	)

	(method (init)
		(= local2 (mod (++ global417) 3))
		(gLongSong number: 310 setLoop: -1 play:)
		(gEgo init: normalize: setScaler: Scaler 130 86 171 130)
		(gEgo posn: -15 172)
		(= local0 75)
		(= local1 173)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 61 163 61 171 0 171 0 0 319 0 319 189 208 189 0 189 0 174 61 174 61 187 207 187 207 181 170 181 202 123 264 123 264 112 164 112
					yourself:
				)
		)
		(self
			addPoly:
				((Polygon new:)
					init: 113 124 164 124 159 161 116 167 76 149
					yourself:
				)
				130
		)
		(olga init: setPri: 53 setCycle: Fwd)
		(fire init: setCycle: Fwd)
		(catOnTable init: setPri: 179)
		(catByTable init: setPri: 185)
		(catByFire init:)
		(catMantelLick init:)
		(catMantelTail init:)
		(catOnTableButt init: setPri: 196)
		(catJumpLedge init: setPri: 75 setCycle: End)
		(fireLogs init: approachVerbs: 4) ; Do
		(hearth init: approachVerbs: 4) ; Do
		(garlic1 init: approachVerbs: 4) ; Do
		(garlic2 init: approachVerbs: 4) ; Do
		(garlic3 init: approachVerbs: 4) ; Do
		(garlic4 init: approachVerbs: 4) ; Do
		(garlic5 init: approachVerbs: 4) ; Do
		(garlic6 init: approachVerbs: 4) ; Do
		(clocks init:)
		(lamp init: approachVerbs: 4) ; Do
		(candelabra init: approachVerbs: 4) ; Do
		(plate1 init: approachVerbs: 4) ; Do
		(plate2 init: approachVerbs: 4) ; Do
		(temple init: approachVerbs: 4) ; Do
		(basketCat init: approachVerbs: 4) ; Do
		(basket init: approachVerbs: 4) ; Do
		(plates init: approachVerbs: 4) ; Do
		(frames init:)
		(smallPot init: approachVerbs: 4) ; Do
		(bluePot init:)
		(ewer1 init:)
		(brownPot1 init:)
		(brownPot2 init:)
		(ewer2 init: approachVerbs: 4) ; Do
		(barrel1 init: approachVerbs: 4) ; Do
		(barrel2 init: approachVerbs: 4) ; Do
		(buckets init: approachVerbs: 4) ; Do
		(counterPot init: approachVerbs: 4) ; Do
		(crates1 init: approachVerbs: 4) ; Do
		(crates2 init: approachVerbs: 4) ; Do
		(vines1 init: approachVerbs: 4) ; Do
		(vines2 init: approachVerbs: 4) ; Do
		(shopWindow init: approachVerbs: 4) ; Do
		(counter init: approachVerbs: 4) ; Do
		(super init: &rest)
		(heroTeller
			init:
				gEgo
				310
				32
				128
				(cond
					((and (== global417 1) (not gNight)) 29)
					((and (== gDay (+ global421 1)) (== global417 2)) 30)
					(else 31)
				)
		)
		(self setScript: sEnterScr)
	)

	(method (leaveRoom)
		(++ global421)
		(cond
			((and (== global417 1) (not gNight))
				(gMessager say: 25 6 39) ; "Goodbye, or (as my dear departed Boris used to say) 'May the winds blow fair at your back.'"
			)
			((and (== gDay (+ global421 1)) (== global417 2))
				(gMessager say: 25 6 40) ; "'Be seeing you soon enough!' as my lost husband used to quote."
			)
			(else
				(proc0_17 25 6 41)
			)
		)
		(super leaveRoom:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(1
				(if (and (== global417 1) (not gNight))
					(gMessager say: 28 6 35 0 self) ; "This general store is cheery and well-lit, thanks to the warm hearth. The first things you notice are the cats -- they seem to be everywhere!"
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((and (IsFlag 37) (not (IsFlag 103)) (not (IsFlag 48)))
						(SetFlag 103)
						(gMessager say: 25 6 2 0 self) ; "Have you heard? Igor the gravedigger is missing! They say a gypsy did it. We may have a Werewolf on a stake soon."
					)
					((and (IsFlag 39) (not (IsFlag 104)))
						(SetFlag 104)
						(gMessager say: 25 6 3 0 self) ; "I suppose you heard that the gypsy didn't kill Igor after all. Dmitri has set the gypsy free. No good will come of it, you mark my words. The man was clearly a Werewolf."
					)
					((and (IsFlag 41) (not (IsFlag 105)))
						(SetFlag 105)
						(gMessager say: 25 6 4 0 self) ; "I heard that someone burned down the old monastery!  Isn't it strange how you were seen around that building recently?"
					)
					((and (IsFlag 45) (not (IsFlag 106)))
						(SetFlag 106)
						(gMessager say: 25 6 5 0 self) ; "More missing people! Now old Nikolai is gone! What is this town coming to?"
					)
					((and (IsFlag 115) (not (IsFlag 107)))
						(SetFlag 107)
						(gMessager say: 25 6 6 0 self) ; "The talk is that you're a real Hero. People say you returned little Tanya to her parents. My, my."
					)
					((and (== global417 1) (not gNight))
						(gMessager say: 25 6 36 0 self) ; "So you're the stranger in town. I've heard all about you already!"
					)
					((and (== gDay (+ global421 1)) (== global417 2))
						(gMessager say: 25 6 37 0 self) ; "It's you again. It's been a quiet day so far."
					)
					(else
						(proc0_17 25 6 38 self)
					)
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCatScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (= temp0 (Random 0 2))
					(0
						(catMantelLick
							setCycle: OccCyc self 1 5 100 (Random 1 3) self
						)
					)
					(1
						(catMantelTail
							setCycle: OccCyc self 1 5 100 (Random 1 3) self
						)
					)
					(else
						(catOnTableButt setCycle: End self)
					)
				)
			)
			(1
				(= seconds (Random 6 30))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance olgaTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 94 0)) ; olgaTalker
	)

	(method (clean)
		(super clean:)
		((ScriptID 94 1) dispose:) ; knitNeedles
	)

	(method (showCases)
		(super
			showCases:
				42 ; Shopkeeper's Name
				(not (IsFlag 84))
				46
				(IsFlag 84)
				47 ; Husband
				(and (== global418 0) (> global417 1))
				48 ; Husband
				(== global418 1)
				49 ; Husband
				(== global418 2)
				50 ; Husband
				(== global418 3)
				51 ; Husband
				(== global418 4)
				52 ; Husband
				(== global418 5)
				53 ; Husband
				(== global418 6)
				54 ; Husband
				(== global418 7)
				55 ; Husband
				(== global418 8)
				56 ; Husband
				(== global418 9)
				7 ; Innkeeper
				(and (not (IsFlag 115)) (== local2 0))
				8 ; Innkeeper's Wife
				(== local2 1)
				26 ; Monastery
				(and (== local2 1) (not (IsFlag 41)))
				27 ; Burned Monastery
				(and (IsFlag 41) (not (IsFlag 100)))
				23 ; Old Man
				(and (== local2 0) (not (IsFlag 45)))
				24 ; Old Man
				(and (not (IsFlag 45)) (IsFlag 92) (not (IsFlag 93)))
				25 ; Old Man's Death
				(and (IsFlag 45) (not (IsFlag 94)))
				13 ; Vampires
				(== local2 0)
				14 ; Werewolves
				(== local2 1)
				12 ; Adventurers
				(== local2 2)
				10 ; Borgov Family
				(== local2 0)
				15 ; Burgomeister
				(and (== local2 2) (not (IsFlag 43)))
				16 ; Burgomeister
				(and (IsFlag 43) (not (IsFlag 95)))
				11 ; Castle
				(== local2 1)
				22 ; Tanya
				(and (IsFlag 115) (not (IsFlag 96)))
				9 ; Dr. Cranium
				(== local2 2)
				17 ; Gravedigger
				(and (== local2 2) (not (IsFlag 37)))
				18 ; Gravedigger
				(and (IsFlag 37) (not (IsFlag 48)))
				19 ; Gravedigger
				(and (IsFlag 48) (not (IsFlag 97)))
				20 ; Gypsy Prisoner
				(and (IsFlag 37) (not (IsFlag 39)) (not (IsFlag 48)))
				21 ; Gypsies
				(and (IsFlag 39) (not (IsFlag 98)))
		)
	)

	(method (sayMessage &tmp temp0)
		(switch iconValue
			(42 ; Shopkeeper's Name
				(SetFlag 84)
			)
			(47 ; Husband
				(SetFlag 85)
				(if (and (== global418 0) (IsFlag 86))
					(= global418 1)
				)
			)
			(16 ; Burgomeister
				(SetFlag 95)
			)
			(19 ; Gravedigger
				(SetFlag 97)
			)
			(21 ; Gypsies
				(SetFlag 98)
			)
			(22 ; Tanya
				(SetFlag 96)
			)
			(24 ; Old Man
				(SetFlag 93)
			)
			(25 ; Old Man's Death
				(SetFlag 94)
			)
			(27 ; Burned Monastery
				(SetFlag 100)
			)
			(44 ; Purchase Goods
				(self clean:)
				(= temp0
					(gGlory
						setCursor:
							((gTheIconBar getCursor:)
								view: 999
								loop: 0
								cel: 0
								yourself:
							)
					)
				)
				(SetFlag 51)
				(SetFlag 148)
				(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
				(purchase init: show: dispose:)
				(ClearFlag 51)
				(gGlory setCursor: temp0)
			)
		)
		(if (!= iconValue 44) ; Purchase Goods
			(super sayMessage: &rest)
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				42 ; Introduce Yourself
				(not (IsFlag 84))
				48 ; Tell About Gatekeeper
				(== global418 1)
				50 ; Talk About Boris
				(== global418 3)
				52 ; Talk About Boris
				(== global418 5)
				54 ; Talk About Boris
				(== global418 7)
		)
	)

	(method (sayMessage &tmp temp0)
		(cond
			((OneOf iconValue 48 50 52 54) ; Tell About Gatekeeper, Talk About Boris, Talk About Boris, Talk About Boris
				(gEgo addHonor: 50)
				(++ global418)
			)
			((== iconValue 42) ; Introduce Yourself
				(SetFlag 84)
			)
			((== iconValue 58) ; Buy Equipment
				(self clean:)
				(if (not (IsFlag 148))
					(SetFlag 148)
					(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
				)
				(= temp0
					(gGlory
						setCursor:
							((gTheIconBar getCursor:)
								view: 999
								loop: 0
								cel: 0
								yourself:
							)
					)
				)
				(SetFlag 51)
				(SetFlag 148)
				(purchase init: show: dispose:)
				(ClearFlag 51)
				(gGlory setCursor: temp0)
				(return 1)
			)
		)
		(return (super sayMessage: &rest))
	)
)

(instance purchase of PuzzleBar
	(properties)

	(method (helpYou &tmp temp0)
		(= temp0 (Str new:))
		(Message msgGET 310 28 6 77 1 (temp0 data:)) ; "To purchase an item, first click on the name of the item, then on the "Buy" button. If you decide not to purchase anything right now, click on "Exit" instead."
		(Print addText: (temp0 data:) init:)
		(temp0 dispose:)
		(localproc_1)
	)

	(method (init &tmp temp0)
		(ClearFlag 6)
		(FrameOut)
		(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
		((ScriptID 0 21) doit: 100) ; statusCode
		(super init: &rest)
		(buyIcon x: 139 y: 12 priority: 100 fixPriority: 1)
		((ScriptID 34 3) x: 92 y: 12) ; pExit
		((ScriptID 34 2) x: 45 y: 12) ; pHelp
		(self
			add:
				buyIcon
				bLeft
				bRight
				bBag
				bCandy
				bFlask
				bGarlic
				bHandbroom
				bPiePan
				bRations
		)
	)

	(method (addIcons)
		(self add: (ScriptID 34 2) (ScriptID 34 3)) ; pHelp, pExit
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 40 30 280 170
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (resetPuzzle)
		(= local3 0)
	)

	(method (show &tmp [temp0 2])
		(= curIcon 0)
		(|= state $0020)
		(self eachElementDo: #init self)
		(UpdatePlane plane)
		(cond
			((not curIcon) 0)
			((HaveMouse)
				(self changeCursor: gTheCursor)
			)
			(else
				(self
					changeCursor: gTheCursor
					changeCursor:
						(+
							(curIcon nsLeft:)
							(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
						)
						(- (curIcon nsBottom:) 3)
				)
			)
		)
		(localproc_2)
		(self resetPuzzle:)
		(SetNowSeen buyIcon)
		(SetNowSeen (ScriptID 34 3)) ; pExit
		(SetNowSeen (ScriptID 34 2)) ; pHelp
		(self doit: hide:)
	)

	(method (dispose)
		(self changeCursor: 943)
		((gCurRoom plane:) drawPic: (gCurRoom picture:))
		(ClearFlag 51)
		(ClearFlag 147)
		(gTheIconBar curIcon: (gTheIconBar at: 3))
		(ClearFlag 148)
		(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
		((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
		(SetFlag 6)
		(super dispose: &rest)
	)
)

(class SHTextIcon of TextIcon
	(properties
		view 905
	)

	(method (init)
		(super init: purchase)
		(= x nsLeft)
		(= y nsTop)
		(if text
			(= value
				((myDText new:)
					posn: (+ nsLeft 21) (- nsTop 5)
					text: (text data:)
					font: 999
					fore: 0
					back: 254
					skip: 254
					setSize:
					setPri: 254
					init: (owner puzzleCast:)
					yourself:
				)
			)
		)
	)

	(method (onMe param1 param2)
		(return
			(and
				(< (- nsLeft 10) param1 (+ nsRight 45))
				(< (- nsTop 5) param2 (- nsBottom 13))
			)
		)
	)

	(method (select)
		(if (!= local3 self)
			(if local3
				(local3 highlight: 0 1)
			)
			(= local3 self)
			(self highlight: 1)
		else
			(= local3 0)
		)
	)

	(method (highlight param1)
		(value dispose:)
		(= value
			((myDText new:)
				posn: (+ nsLeft 21) (- nsTop 5)
				text: (text data:)
				font: 999
				fore:
					(cond
						((and (== local3 self) (<= argc 1)) 106)
						(param1 43)
						(else 0)
					)
				back: 254
				skip: 254
				setSize:
				setPri: 255
				init: (owner puzzleCast:)
				yourself:
			)
		)
		(UpdateScreenItem self)
		(FrameOut)
	)
)

(instance bLeft of SHTextIcon
	(properties
		nsLeft 19
		nsTop 34
		view 311
	)

	(method (onMe)
		(return 0)
	)
)

(instance bRight of SHTextIcon
	(properties
		nsLeft 118
		nsTop 34
		view 311
	)

	(method (onMe)
		(return 0)
	)
)

(instance bBag of SHTextIcon
	(properties
		nsLeft 133
		nsTop 69
		loop 2
		cel 0
		value 50
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 67 1 (text data:)) ; "Shopping Bag (50 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bCandy of SHTextIcon
	(properties
		nsLeft 36
		nsTop 56
		loop 8
		cel 4
		value 5
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 61 1 (text data:)) ; "Candy (5 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bFlask of SHTextIcon
	(properties
		nsLeft 35
		nsTop 77
		cel 9
		value 100
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 62 1 (text data:)) ; "Oil Flask (100 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bGarlic of SHTextIcon
	(properties
		nsLeft 35
		nsTop 40
		loop 2
		cel 1
		value 25
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 63 1 (text data:)) ; "Garlic (25 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bHandbroom of SHTextIcon
	(properties
		nsLeft 133
		nsTop 45
		loop 10
		cel 0
		value 350
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 64 1 (text data:)) ; "Hand Broom (350 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bPiePan of SHTextIcon
	(properties
		nsLeft 37
		nsTop 99
		loop 2
		cel 10
		value 250
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 65 1 (text data:)) ; "Pie Pan (250 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance bRations of SHTextIcon
	(properties
		nsLeft 133
		nsTop 93
		cel 8
		value 50
	)

	(method (init)
		(= text (Str new:))
		(Message msgGET 310 33 141 66 1 (text data:)) ; "Trail Rations (50 Kopeks)"
		(super init: &rest)
	)

	(method (dispose)
		(text dispose:)
		(super dispose:)
	)
)

(instance buyIcon of TextIcon
	(properties
		nsLeft 60
		nsTop 20
		view 936
		loop 3
	)

	(method (select)
		(if (super select: &rest)
			(if local3
				(local3 show:)
				(localproc_0 local3)
				(local3 highlight: 0 1)
				(= local3 0)
			else
				(gMessager say: 28 6 79) ; "First select the item you wish to purchase."
			)
		)
	)
)

(instance myDText of DText
	(properties)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

(instance olga of Prop
	(properties
		noun 25
		x 134
		y 116
		priority 64
		fixPriority 1
		view 315
		signal 16385
		cycleSpeed 20
	)

	(method (init)
		(super init: &rest)
		(olgaTeller
			init:
				olga
				310
				32
				141
				(cond
					((and (== global417 1) (not gNight)) 29)
					((and (== gDay (+ global421 1)) (== global417 2)) 30)
					(else 31)
				)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(15 ; thePurse
				(= temp0
					(gGlory
						setCursor:
							((gTheIconBar getCursor:)
								view: 999
								loop: 0
								cel: 0
								yourself:
							)
					)
				)
				(SetFlag 51)
				(SetFlag 148)
				(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
				(purchase init: show: dispose:)
				(ClearFlag 51)
				(gGlory setCursor: temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fire of Prop
	(properties
		noun 1
		x 189
		y 107
		fixPriority 1
		view 310
		signal 16385
		cycleSpeed 12
		detailLevel 3
	)
)

(instance catMantelLick of Prop
	(properties
		noun 34
		x 220
		y 55
		view 310
		loop 5
	)
)

(instance catJumpLedge of Prop
	(properties
		noun 34
		x 114
		y 137
		view 310
		loop 3
		signal 16385
	)
)

(instance catMantelTail of Prop
	(properties
		noun 34
		x 220
		y 55
		view 310
		loop 4
		signal 16385
		detailLevel 3
	)
)

(instance catOnTableButt of Prop
	(properties
		noun 34
		x 217
		y 124
		view 310
		loop 2
		cel 1
		signal 16385
		detailLevel 3
	)

	(method (setCycle)
		(= cel 1)
		(super setCycle: &rest)
	)
)

(instance catOnTable of View
	(properties
		noun 34
		x 217
		y 124
		view 310
		loop 2
		signal 16384
	)
)

(instance catByTable of View
	(properties
		noun 34
		x 214
		y 163
		view 310
		loop 1
		signal 16385
	)
)

(instance catByFire of View
	(properties
		noun 34
		x 132
		y 102
		priority 1
		fixPriority 1
		view 310
		loop 1
		cel 2
		signal 16384
	)
)

(instance catOnFire of View ; UNUSED
	(properties
		x 217
		y 124
		fixPriority 1
		view 310
		loop 1
		cel 3
	)
)

(instance catOnShelf of View ; UNUSED
	(properties
		x 259
		y 69
		fixPriority 1
		view 310
		loop 1
		cel 1
	)
)

(instance fireLogs of Feature
	(properties
		noun 1
		nsLeft 169
		nsTop 90
		nsRight 209
		nsBottom 102
		sightAngle 180
		x 189
		y 96
	)
)

(instance hearth of Feature
	(properties
		noun 2
		nsLeft 156
		nsTop 67
		nsRight 223
		nsBottom 106
		sightAngle 180
		x 189
		y 86
	)
)

(instance garlic1 of Feature
	(properties
		noun 3
		nsLeft 48
		nsTop 12
		nsRight 83
		nsBottom 38
		sightAngle 180
		x 65
		y 25
	)
)

(instance garlic2 of Feature
	(properties
		noun 3
		nsLeft 82
		nsTop 25
		nsRight 113
		nsBottom 45
		sightAngle 180
		x 97
		y 35
	)
)

(instance garlic3 of Feature
	(properties
		noun 3
		nsLeft 232
		nsTop -1
		nsRight 270
		nsBottom 48
		sightAngle 180
		x 251
		y 23
	)
)

(instance garlic4 of Feature
	(properties
		noun 3
		nsLeft 270
		nsTop 22
		nsRight 318
		nsBottom 55
		sightAngle 180
		x 294
		y 38
	)
)

(instance garlic5 of Feature
	(properties
		noun 3
		nsLeft 250
		nsTop 65
		nsRight 270
		nsBottom 73
		sightAngle 180
		x 260
		y 69
	)
)

(instance garlic6 of Feature
	(properties
		noun 3
		nsLeft 265
		nsTop 55
		nsRight 277
		nsBottom 65
		sightAngle 180
		x 271
		y 60
	)
)

(instance clocks of Feature
	(properties
		noun 4
		nsLeft 271
		nsTop 63
		nsRight 287
		nsBottom 117
		sightAngle 180
		x 279
		y 90
	)
)

(instance lamp of Feature
	(properties
		noun 5
		nsLeft 286
		nsTop 54
		nsRight 301
		nsBottom 75
		sightAngle 180
		x 293
		y 64
	)
)

(instance candelabra of Feature
	(properties
		noun 6
		nsLeft 147
		nsTop 37
		nsRight 158
		nsBottom 52
		sightAngle 180
		x 152
		y 44
	)
)

(instance plate1 of Feature
	(properties
		noun 7
		nsLeft 160
		nsTop 39
		nsRight 174
		nsBottom 52
		sightAngle 180
		x 167
		y 45
	)
)

(instance plate2 of Feature
	(properties
		noun 7
		nsLeft 199
		nsTop 37
		nsRight 216
		nsBottom 51
		sightAngle 180
		x 207
		y 44
	)
)

(instance temple of Feature
	(properties
		noun 8
		nsLeft 176
		nsTop 34
		nsRight 198
		nsBottom 51
		sightAngle 180
		x 187
		y 42
	)
)

(instance basketCat of Feature
	(properties
		noun 9
		nsLeft 20
		nsTop 98
		nsRight 57
		nsBottom 112
		sightAngle 180
		x 38
		y 105
	)
)

(instance basket of Feature
	(properties
		noun 10
		nsLeft 26
		nsTop 91
		nsRight 55
		nsBottom 121
		sightAngle 180
		x 40
		y 106
	)
)

(instance plates of Feature
	(properties
		noun 11
		nsLeft 61
		nsTop 1
		nsRight 118
		nsBottom 34
		sightAngle 180
		x 89
		y 17
	)
)

(instance frames of Feature
	(properties
		noun 12
		nsLeft 288
		nsTop 79
		nsRight 319
		nsBottom 92
		sightAngle 180
		x 303
		y 85
	)
)

(instance smallPot of Feature
	(properties
		noun 13
		nsLeft 300
		nsTop 53
		nsRight 314
		nsBottom 72
		sightAngle 180
		x 307
		y 62
	)
)

(instance bluePot of Feature
	(properties
		noun 14
		nsLeft 263
		nsTop 133
		nsRight 319
		nsBottom 178
		sightAngle 180
		x 291
		y 155
	)
)

(instance ewer1 of Feature
	(properties
		noun 16
		nsLeft 286
		nsTop 88
		nsRight 311
		nsBottom 113
		sightAngle 180
		x 298
		y 100
	)
)

(instance brownPot1 of Feature
	(properties
		noun 15
		nsLeft 279
		nsTop 117
		nsRight 319
		nsBottom 133
		sightAngle 180
		x 299
		y 125
	)
)

(instance brownPot2 of Feature
	(properties
		noun 15
		nsLeft 296
		nsTop 102
		nsRight 319
		nsBottom 118
		sightAngle 180
		x 307
		y 110
	)
)

(instance ewer2 of Feature
	(properties
		noun 16
		nsLeft 15
		nsTop 150
		nsRight 53
		nsBottom 182
		sightAngle 180
		x 34
		y 166
	)
)

(instance barrel1 of Feature
	(properties
		noun 17
		nsLeft 43
		nsTop 127
		nsRight 68
		nsBottom 148
		sightAngle 180
		x 55
		y 137
	)
)

(instance barrel2 of Feature
	(properties
		noun 18
		nsLeft 10
		nsTop 138
		nsRight 45
		nsBottom 151
		sightAngle 180
		x 27
		y 144
	)
)

(instance buckets of Feature
	(properties
		noun 19
		nsLeft 42
		nsTop 147
		nsRight 80
		nsBottom 170
		sightAngle 180
		x 61
		y 158
	)
)

(instance counterPot of Feature
	(properties
		noun 20
		nsLeft 62
		nsTop 97
		nsRight 78
		nsBottom 112
		sightAngle 180
		x 70
		y 104
	)
)

(instance crates1 of Feature
	(properties
		noun 21
		nsLeft 66
		nsTop 120
		nsRight 97
		nsBottom 145
		sightAngle 180
		x 81
		y 132
		z 10
	)
)

(instance crates2 of Feature
	(properties
		noun 21
		nsLeft 91
		nsTop 115
		nsRight 122
		nsBottom 138
		sightAngle 180
		x 106
		y 126
		z 15
	)
)

(instance vines1 of Feature
	(properties
		noun 22
		nsLeft 13
		nsTop 22
		nsRight 42
		nsBottom 82
		sightAngle 180
		x 27
		y 52
	)
)

(instance vines2 of Feature
	(properties
		noun 22
		nsLeft 78
		nsTop 43
		nsRight 104
		nsBottom 85
		sightAngle 180
		x 91
		y 64
	)
)

(instance shopWindow of Feature
	(properties
		noun 23
		nsLeft 12
		nsTop 19
		nsRight 107
		nsBottom 101
		sightAngle 180
		x 59
		y 60
	)
)

(instance counter of Feature
	(properties
		noun 24
		nsLeft 197
		nsTop 110
		nsRight 256
		nsBottom 168
		sightAngle 180
		x 226
		y 139
	)
)

