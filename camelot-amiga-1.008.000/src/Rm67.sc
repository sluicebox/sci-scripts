;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use MoveForward)
(use runningRats)
(use bitingRat)
(use trappedByDoors)
(use RatBlink)
(use Interface)
(use CPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm67 0
)

(local
	[local0 13] = [76 167 71 148 142 161 240 170 253 147 281 143 -32768]
	[local13 13] = [181 189 240 173 130 167 158 147 116 132 167 131 -32768]
)

(instance leftDoor of Prop
	(properties
		y 146
		x 34
		view 167
		loop 3
		priority 10
		signal 16400
	)
)

(instance rightDoor of Act
	(properties
		y 20
		x 250
		yStep 9
		view 167
		priority 1
		signal 16400
		illegalBits 0
	)
)

(instance frontDoor of Act
	(properties
		y 82
		x 122
		yStep 9
		view 167
		loop 1
		priority 6
		signal 16400
		illegalBits 0
	)
)

(instance bottomBlock of Blk
	(properties
		top 195
		left -10
		bottom 210
		right 330
	)
)

(instance leftBlock of Blk
	(properties
		top 165
		left -10
		bottom 210
		right -5
	)
)

(instance rightBlock of Blk
	(properties
		left 325
		bottom 210
		right 330
	)
)

(instance leftDoorBlock of Blk ; UNUSED
	(properties
		top 135
		left 30
		bottom 146
		right 60
	)
)

(instance rat1Path of CPath
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rat2Path of CPath
	(properties)

	(method (at param1)
		(return [local13 param1])
	)
)

(instance mummy of Prop
	(properties
		y 118
		x 72
		view 167
		loop 1
		cel 1
		priority 10
		signal 16
	)
)

(instance bone1 of View
	(properties
		y 174
		x 257
		view 267
		priority 13
	)
)

(instance bone2 of View
	(properties
		y 182
		x 263
		view 267
		cel 2
		priority 14
	)
)

(instance fragments of PV
	(properties
		y 182
		x 279
		view 267
		cel 3
	)
)

(instance Rm67 of Rm
	(properties
		picture 67
	)

	(method (init)
		(super init:)
		(= global112 1)
		(runningRats rPath1: rat1Path rPath2: rat2Path)
		(self setRegions: 125 127 174) ; Catacombs, runningRats, RatBlink
		(switch gPrevRoomNum
			(70
				(gEgo posn: 265 152 loop: 1 setMotion: MoveForward 30)
			)
			(else
				(gEgo posn: 120 136 loop: 2 setMotion: MoveForward 6)
			)
		)
		(gEgo observeBlocks: bottomBlock leftBlock rightBlock)
		(RatBlink addEyes: 185 106 10 addEyes: 159 112 10 addEyes: 278 165 10)
		(if (IsItemAt 8) ; boar_spear | grain | medallion
			(mummy init: stopUpd:)
		else
			(mummy setLoop: 2 setCel: 255)
			(gAddToPics add: mummy)
		)
		(leftDoor init: stopUpd:)
		(if (IsFlag 184)
			(bone1 init: stopUpd:)
		)
		(if (IsFlag 185)
			(bone2 init: stopUpd:)
		)
		(cond
			((IsFlag 171)
				(ClearFlag 171)
				(gCurRoom setScript: closeDoors)
			)
			((gEgo has: 10) ; lamb | dove
				(leftDoor setCel: 255)
			)
		)
		(gAddToPics add: fragments)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: LeaveRoom 68 3 5)
			)
			((& (gEgo onControl:) $0040)
				(gEgo setMotion: LeaveRoom 70 0 30)
			)
			((& (gEgo onControl:) $0020)
				(gEgo setScript: BlackenedPassage)
			)
		)
		(if (IsFlag 179)
			(RatBite
				gotoX1: (+ (gEgo x:) 35)
				gotoY1: 158
				gotoX2: 320
				gotoY2: 148
			)
			(if (> (gEgo x:) 148)
				(RatBite midPointX: 190)
				((ScriptID 172 0) y: 108 init:) ; bitingRat
			else
				(RatBite midPointX: 63 optCel: 2 spread: 3)
				((ScriptID 172 0) y: 113 init:) ; bitingRat
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(cond
							((gEgo has: 10) ; lamb | dove
								(Print 67 0) ; "There are three doorways."
							)
							((IsItemAt 8) ; boar_spear | grain | medallion
								(Print 67 1) ; "There are two doorways, mummies, urns and symbols upon one wall."
							)
							(else
								(Print 67 2) ; "There are two doorways, a mummy, urns and symbols upon one wall."
							)
						)
					)
					(
						(or
							(Said 'look[<at,!*]/body<(little,child)')
							(OnButton event 60 89 81 118)
						)
						(if (IsItemAt 8) ; boar_spear | grain | medallion
							(Print 67 3) ; "There is a round copper medallion around the neck of what may be the mummy of a child."
						else
							(Print 67 4) ; "There is nothing left but a pile of dust."
						)
					)
					(
						(or
							(and
								(gEgo inRect: 160 0 320 200)
								(or (Said '[<at,!*]/body') (Said '//body'))
							)
							(OnButton event 160 103 216 112)
							(OnButton event 166 112 181 134)
						)
						(Print 67 5) ; "The mummy in this niche is unremarkable."
					)
					((or (Said '[<at,!*]/body') (Said '//body'))
						(if (IsItemAt 8) ; boar_spear | grain | medallion
							(Print 67 6) ; "The mummy beneath the pentacle is quite small and has a medallion hanging around its neck."
						else
							(Print 67 7) ; "The child's mummy has disintegrated, leaving only a pile of dust."
						)
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 67 8) ; "Three of the walls are barren, but upon one wall there are two symbols painted."
					)
					((or (Said '/niche') (Said '//niche'))
						(if (IsItemAt 8) ; boar_spear | grain | medallion
							(Print 67 9) ; "Two of the niches hold mummies, and two smaller niches are empty."
						else
							(Print 67 10) ; "One niche holds a mummy, and three others are empty."
						)
					)
					((or (Said '/design') (Said '//design'))
						(Print 67 11) ; "One symbol is a pentacle. The other is a labarum."
					)
					(
						(or
							(Said '/pentacle,star')
							(Said '//pentacle,star')
							(OnButton event 60 64 80 80)
						)
						(Print 67 12) ; "The pentacle, apples and the Goddess are often associated together because if one cuts an apple open lengthwise, he can find a five-pointed star hidden within."
					)
					(
						(or
							(Said '/labarum')
							(Said '//labarum')
							(OnButton event 108 50 135 73)
						)
						(Print 67 13) ; "It is the symbol of Mithras, so we might assume that Roman soldiers once used these catacombs."
					)
					(
						(or
							(and (not (gEgo has: 9)) (Said '/bone')) ; herbs | bone
							(Said '//bone')
							(and
								(gCast contains: bone1)
								(MouseClaimed bone1 event)
							)
							(and
								(gCast contains: bone2)
								(MouseClaimed bone2 event)
							)
						)
						(Print 67 14) ; "There are a great many bones around, as might be expected in catacombs."
					)
					(
						(or
							(Said '[<at,!*]/pot,jar,pot')
							(Said '//pot,jar,pot')
							(OnButton event 57 152 102 171)
							(OnButton event 198 122 210 137)
							(OnButton event 267 125 288 162)
							(OnButton event 281 147 302 172)
						)
						(Print 67 15) ; "The funereal urns within these sepulchers are designed to hold the ashes of the deceased, or their mummified organs."
					)
					((and (IsItemAt 8) (Said 'look,read/carving')) ; boar_spear | grain | medallion
						(Print 67 16) ; "You cannot see it from here."
					)
					((Said 'look,read/carving')
						(if (gEgo has: 8) ; boar_spear | grain | medallion
							((gInventory at: 8) showSelf:) ; boar_spear | grain | medallion
						else
							(event claimed: 0)
						)
					)
					((and (IsItemAt 8) (Said 'look/medal')) ; boar_spear | grain | medallion
						(Print 67 17) ; "It is round, made of copper as best I can tell, and seems to have engraving upon it, but it is heavily coated with dust which obscures it."
					)
					((Said 'ask//medal')
						(if (IsItemAt 8) ; boar_spear | grain | medallion
							(Print 67 18) ; "I can tell you little about it until it can be clearly and closely seen."
						else
							(Print 67 19) ; "It is engraved with a pentacle and is imbued with a warding spell."
						)
					)
				)
			)
			((Said 'get,(pick<up)/bone')
				(cond
					((gEgo has: 9) ; herbs | bone
						(event claimed: 0)
					)
					(
						(and
							(gCast contains: bone1)
							(< (gEgo distanceTo: bone1) 40)
						)
						(proc173_4 bone1 184)
					)
					(
						(and
							(gCast contains: bone2)
							(< (gEgo distanceTo: bone2) 40)
						)
						(proc173_4 bone2 185)
					)
					(
						(and
							(not (gCast contains: bone1))
							(not (gCast contains: bone2))
						)
						(event claimed: 0)
					)
					(else
						(NotClose) ; "Perhaps you should move closer."
					)
				)
			)
			(
				(or
					(Said 'get,lift,pick,lift,remove/medal/blade<with')
					(Said '<(get,lift,pick,lift,remove)<medal/body/blade<with')
					(Said '(get,lift,pick,lift,remove)<use<blade/medal/')
				)
				(cond
					((IsItemAt 8) ; boar_spear | grain | medallion
						(SetScore 0 0 5)
						(gEgo setScript: getMedallion)
					)
					((gEgo has: 8) ; boar_spear | grain | medallion
						(Print 67 20) ; "The medallion hangs around your neck beneath your tunic."
					)
					(else
						(Print 67 21) ; "There is no medallion here."
					)
				)
			)
			((Said 'get/medal')
				(if (IsItemAt 8) ; boar_spear | grain | medallion
					(Print 67 22) ; "Aye, but how, without risking a rat bite?"
				else
					(Print 67 23) ; "But you already took it."
				)
			)
			((Said 'rob/medal')
				(if (IsItemAt 8) ; boar_spear | grain | medallion
					(Print 67 24) ; "The trick is how to lift the medallion without risking a poisonous rat bite."
				else
					(Print 67 25) ; "What ARE you blathering about?"
				)
			)
			((Said 'get/pentacle,star,labarum')
				(Print 67 26) ; "It is painted upon the wall."
			)
			(
				(or
					(Said 'get,remove/medal/bone')
					(Said 'lift,pick,lift,remove/medal/bone<with')
				)
				(if (gEgo has: 9) ; herbs | bone
					(Print 67 27) ; "It is too short and too blunt to do what you need."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
		)
	)
)

(instance closeDoors of Script
	(properties)

	(method (init)
		(super init: &rest)
		(leftDoor setCel: 0)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not global80))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: -2)
				(frontDoor
					setLoop: 1
					init:
					setMotion: MoveTo (frontDoor x:) 137 self
				)
				(rightDoor setLoop: 0 init: setMotion: MoveTo (rightDoor x:) 85)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(client setScript: 0)
			)
		)
	)
)

(instance getMedallion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0)
				(= register (gEgo view:))
				(= cycles 1)
			)
			(1
				(cond
					((gEgo inRect: 25 165 124 200)
						(gEgo setMotion: MoveTo 120 180 self)
					)
					((gEgo inRect: 0 165 26 200)
						(-- state)
						(gEgo setMotion: MoveTo 40 160 self)
					)
					((< (gEgo x:) 105)
						(gEgo setMotion: MoveTo 105 150 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 105 140 self)
			)
			(3
				(gEgo
					view: 85
					loop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
				(mummy setLoop: 2 setCel: 0)
			)
			(4
				(gEgo setCel: 4)
				(= cycles 4)
			)
			(5
				(gEgo setCel: 5)
				(= cycles 8)
			)
			(6
				(gEgo setCel: 6)
				(= cycles 4)
			)
			(7
				(gEgo setCycle: CT 8 1)
				(mummy setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(gEgo cycleSpeed: 0 setCycle: End self)
			)
			(9
				(gEgo get: 8) ; boar_spear | grain | medallion
				(Print 67 28) ; "Very clever, Arthur! You have safely taken possession of the medallion."
				(gEgo
					view: register
					cycleSpeed: 0
					setCycle: Walk
					setLoop: -1
					loop: 1
					ignoreActors: 0
					illegalBits: -32768
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance BlackenedPassage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setPri: 11 setMotion: MoveTo 0 153 self)
				(leftDoor setPri: 10)
			)
			(1
				(leftDoor setPri: 12 setCycle: Beg self)
			)
			(2
				(= seconds 4)
			)
			(3
				(gCurRoom style: 8 drawPic: 112)
				(gCast eachElementDo: #hide)
				(= seconds 2)
			)
			(4
				(Print 67 29) ; "Once more you are forced into a pitch black tunnel that leads in but one direction."
				(= seconds 1)
			)
			(5
				(Print 67 30) ; "It seems an eternity before the tunnel takes a turning and brings you to yet another hidden door."
				(= seconds 1)
			)
			(6
				(Print 67 31) ; "Push harder, Arthur! Aye, it opens as did the other one and returns you to the catacombs."
				(= seconds 3)
			)
			(7
				(gCurRoom newRoom: 69)
			)
		)
	)
)

