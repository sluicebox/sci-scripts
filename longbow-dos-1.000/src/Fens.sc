;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Blk)
(use LoadMany)
(use SmoothLooper)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Fens 0
	rgnBoat 1
	monk 2
	robin 3
	monkBoat 4
	proc601_5 5
	boatLooper 6
	egoActions 7
	stepInBoatAsOutlaw 8
	outlawAfterWisps 9
	pole 10
	proc601_11 11
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 2]
	local13
	[local14 10]
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	[local31 208]
	[local239 12] = [0 0 0 0 0 0 0 0 1601 5 1 0]
	[local251 4] = [1601 98 1 0]
	[local255 4] = [1601 60 1 0]
	[local259 4] = [1601 65 1 0]
	[local263 4] = [1601 66 1 0]
	[local267 4] = [1601 67 1 0]
	[local271 4] = [1601 68 1 0]
	[local275 4] = [1601 69 1 0]
	[local279 4] = [1601 70 1 0]
	[local283 4] = [1601 71 1 0]
	[local287 4] = [1601 72 1 0]
	[local291 4] = [1601 73 1 0]
	[local295 4] = [1601 74 1 0]
	[local299 4] = [1601 7 1 0]
	[local303 4] = [1601 8 1 0]
	[local307 4] = [1601 77 1 0]
	[local311 6] = [1601 80 2 1 2 0]
	[local317 4] = [1601 83 1 0]
	[local321 5] = [1601 84 1 2 0]
	[local326 5] = [1601 95 1 0 0]
	[local331 5] = [1601 96 1 0 0]
	[local336 4] = [1601 79 1 0]
)

(procedure (proc601_5 param1)
	(if (and global132 (== local4 param1))
		(switch gCurRoomNum
			(590
				(rgnBoat
					view: 21
					loop: 2
					cel: 2
					posn: 84 112
					setPri: ((ScriptID 601 2) priority:) ; monk
					signal: 16384
					init:
				)
				(monk view: 585 setLoop: 1 setCel: 3 posn: 100 137 init:)
			)
			(600
				(rgnBoat view: 21 loop: 3 cel: 2 posn: 178 132 init:)
				(monk view: 585 loop: 2 cel: 3 posn: 151 159 init:)
			)
		)
		(= local24 1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc601_11 param1)
	(if (and (== gDay 13) (== local4 param1))
		(switch gCurRoomNum
			(590
				(rgnBoat
					view: 21
					loop: 2
					cel: 2
					posn: 96 114
					setPri: ((ScriptID 601 2) priority:) ; monk
					ignoreActors: 1
					init:
				)
				(pole cel: 3 posn: 128 137 init:)
			)
			(600
				(rgnBoat
					view: 21
					loop: 2
					cel: 2
					posn: 98 132
					setPri: ((ScriptID 601 2) priority:) ; monk
					ignoreActors: 1
					init:
				)
				(pole cel: 3 posn: 133 156 init:)
			)
		)
		(= local24 1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_0 &tmp temp0)
	(if (gCast contains: local31)
		(return)
	)
	(switch gHowFast
		(0
			(= local13 4)
		)
		(1
			(= local13 6)
		)
		(else
			(= local13 8)
		)
	)
	(if (and (== gCurRoomNum 610) (== gDay 13))
		(= local30 (ScriptID 610 1)) ; hiddenWisp
		(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
			(= [local31 temp0] (Wisp new:))
			([local31 temp0]
				setLoop: (Random 0 2)
				setStep: 10 10
				x: (+ (local30 x:) (Random 0 60))
				y: (+ (local30 y:) (Random 0 60))
				ignoreActors: 1
				init:
				setScript: (= [local239 temp0] (frenzy new:))
			)
		)
	else
		(wispCage init:)
		(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
			(= [local31 temp0] (Wisp new:))
			([local31 temp0]
				x: (Random 35 305)
				y: (Random 86 134)
				setLoop: (Random 0 2)
				setStep: 2 2
				init:
				ignoreActors: 1
				observeBlocks: wispCage
				setMotion: Wander 230
			)
		)
	)
	(gRgnMusic2 number: 582 loop: -1 play:)
)

(procedure (localproc_1)
	(switch gHowFast
		(0
			(gEgo setStep: 5 3)
		)
		(1
			(gEgo setStep: 3 2)
		)
		(else
			(gEgo setStep: 2 1)
		)
	)
)

(instance Fens of Rgn
	(properties
		keep 1
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 590 600 610))
			(self keep: 0)
			(if (and (!= newRoomNumber 700) (!= newRoomNumber 620))
				(gRgnMusic2 fade: 0 30 8 1)
				(gRgnMusic fade: 0 30 8 1)
				(gSFX fade: 0 30 8 1)
			)
		)
	)

	(method (notify param1)
		(= local4 param1)
	)

	(method (init)
		(= local29 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(super init:)
		(HandsOn)
		(if (== global115 1)
			(localproc_0)
		)
		(if (!= (gRgnMusic number:) 585)
			(gRgnMusic number: 585 loop: -1 play:)
		)
		(if (!= (gSFX number:) 581)
			(gSFX number: 581 loop: -1 play:)
		)
		(if (== gPrevRoomNum 700)
			(= local24 1)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (== global115 1) (!= gTheCursor 5))
				(if (and (== gCurRoomNum 610) local3)
					(= local3 0)
					(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
						([local31 temp0] show:)
					)
					(gRgnMusic2 number: 582 loop: -1 play:)
				else
					(localproc_0)
				)
			)
			((and (!= global115 1) (gCast contains: local31) (not local3))
				(if (== gCurRoomNum 610)
					(= local3 1)
					(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
						([local31 temp0] hide:)
					)
				else
					(wispCage dispose:)
					(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
						([local31 temp0] dispose:)
					)
				)
				(gRgnMusic2 stop:)
			)
			((gEgo script:))
			(
				(and
					local4
					(gCast contains: monk)
					(== local27 0)
					(not (< 15 (gEgo x:) 305))
				)
				(= local27 1)
				(Converse 1 @local255 11 0 0) ; "Where are you going, Brother?"
			)
			(
				(and
					local4
					(gCast contains: monk)
					(== local27 1)
					(< 20 (gEgo x:) 300)
				)
				(= local27 0)
			)
		)
		(if (gCast contains: local31)
			(gRgnMusic2 setVol: (- 127 (/ (gEgo distanceTo: local31) 3)))
		else
			(gRgnMusic2 stop:)
		)
		(super doit:)
	)

	(method (dispose)
		(if (!= (gSFX number:) 581)
			(gSFX stop:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(HandsOn)
		(= gUseSortedFeatures local29)
		(LoadMany 0 968 970 949)
		(gRgnMusic2 fade: 0 20 12 1)
		(super dispose:)
	)
)

(instance boatLooper of SmoothLooper
	(properties
		cycleSpeed 18
		vChangeDir 588
	)
)

(instance wispCage of Cage
	(properties)

	(method (init)
		(switch gCurRoomNum
			(590
				(self top: 85 bottom: 135 left: 10 right: 310)
			)
			(600
				(self top: 80 bottom: 145 left: 10 right: 310)
			)
			(610
				(self top: 15 bottom: 204 left: 10 right: 310)
			)
		)
		(super init:)
	)
)

(class Wisp of Actor
	(properties
		x 160
		y 100
		z 15
		view 610
		signal 24576
		cycCnt 0
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycCnt)) cycleSpeed)
				cel
			else
				(= cycCnt gGameTime)
				(+ cel 1)
			)
		)
	)

	(method (doit &tmp temp0)
		(= cel (if (> (= temp0 (self nextCel:)) (self lastCel:)) 0 else temp0))
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1601 0 0) ; "It makes me most uneasy to be so close to the spirits of those who drowned in these fens."
			)
			(10 ; Longbow
				(Say 1601 2 0) ; "The Will-o-th'Wisps cannot be touched."
			)
			(3 ; Do
				(Say 1601 1 0) ; "The Will-o-th'Wisps cannot be touched. As if one would want to touch a spirit of the dead!"
			)
			(5 ; Talk
				(cond
					((== gCurRoomNum 610)
						(gCurRoom setScript: naiadPrinter 0 4)
					)
					(local25
						(= local8 9)
						(gCurRoom setScript: naiadPrinter 0 8)
					)
					((!= (gEgo view:) 587)
						(if (or (gCast contains: rgnBoat) local24)
							(gCurRoom setScript: naiadPrinter 0 3)
						else
							(gCurRoom setScript: wispsOfferBoat)
						)
					)
					(else
						(gCurRoom setScript: naiadPrinter 0 4)
					)
				)
			)
			(4 ; Inventory
				(gEgo setScript: naiadPrinter 0 6)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robin of Actor
	(properties)

	(method (doVerb theVerb invItem)
		(if
			(not
				(and
					(IsObject (gEgo actions:))
					((gEgo actions:) doVerb: theVerb invItem &rest)
				)
			)
			(gEgo doVerb: theVerb invItem &rest)
		)
	)
)

(instance rgnBoat of Actor
	(properties
		view 21
		signal 28672
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1601 61 0) ; "A typical shallow draft boat pushed along by means of a pole."
			)
			(3 ; Do
				(if (and local24 (!= gCurRoomNum 610))
					(if (or (== gDisguiseNum 6) (gCast contains: local31)) ; fens monk
						(gCurRoom setScript: (ScriptID 603 4)) ; walkToBoat
					else
						(Say 1601 100 1) ; "I have a boat, but without the Will-o-th'Wisps, I could be lost in the fog."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pole of Actor
	(properties
		view 15
		loop 5
		cel 3
		signal 18432
		cycleSpeed 12
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1601 91) ; "The long pole is used to push these flat-bottomed boats across the water."
			)
			(3 ; Do
				(rgnBoat doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bow of Prop
	(properties
		view 15
		loop 6
		signal 18432
		cycleSpeed 12
	)
)

(instance monk of Actor
	(properties
		view 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== gCurRoomNum 610)
						(Say 1601 62 0) ; "He watches me suspiciously."
					)
					(local26
						(Say 1601 63 0) ; "Ah...a monk has answered the sound of the whistle."
					)
					(else
						(Say 1601 64 0) ; "They all look the same with a hood over their face."
					)
				)
			)
			(3 ; Do
				(cond
					((== gCurRoomNum 610)
						(Converse 1 @local259 11 0 0) ; "Remain where you are. I'm the one poling this boat."
					)
					((== (gEgo view:) 19)
						(Converse 1 @local259 11 0 0) ; "Remain where you are. I'm the one poling this boat."
					)
					(local24
						(Converse 1 @local263 11 0 0) ; "I will pole the boat, Brother. Get in and sit down."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(cond
					((== gCurRoomNum 610)
						(switch local6
							(0
								(Converse 1 @local267 11 0 0) ; "Shhhh. I must concentrate."
							)
							(1
								(Converse 1 @local271 11 0 0) ; "Silence! I must find my way by sound and feel. Disturb me again and you'll sleep at the bottom of the fens this day."
							)
							(2
								(gCurRoom setScript: (ScriptID 603 1)) ; knockItOff
							)
						)
						(++ local6)
					)
					(local24
						(Converse 1 @local275 11 0 0) ; "Please get in and sit down, Brother."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Converse 1 @local279 11 0 0) ; "I cannot take it. You must turn over all money to the Prior."
					)
					(2 ; halfHeart
						(Converse 1 @local283 11 0 0) ; "Something that precious must be given to the Prior as soon as you are admitted. IF you are admitted."
					)
					(10 ; fireRing
						(Converse 1 @local287 11 0 0) ; "Our vows require us to give up all earthly possessions. You must give this ring to the Prior."
					)
					(5 ; pipe
						(Converse 1 @local291 11 0 0) ; "Why should you give this to me?"
					)
					(6 ; gems
						(Converse 1 @local295 11 0 0) ; "How do you expect to enter without the gemstones?"
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wispsOfferBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 3)
				(= local8 11)
				(self setScript: naiadPrinter self 1)
			)
			(1
				(if (and (== gDay 13) (== gDisguiseNum 0)) ; outlaw
					(client setScript: toTheKnight)
				else
					(self cue:)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (AyeOrNay)
					(Converse 1 @local299 999 0 self) ; "Aye, how can you help me?"
				else
					(+= state 3)
					(self cue:)
				)
			)
			(3
				(= ticks 12)
			)
			(4
				(= local8 19)
				(self setScript: naiadPrinter self 2)
			)
			(5
				(client setScript: wispsGoGetBoat)
			)
			(6
				(Converse 1 @local251 999 0 self) ; "Nay, I've no wish to risk returning to the monastery without good cause."
			)
			(7
				(self setScript: naiadPrinter self 58)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wispsGoGetBoat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom notify: 1)
				(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
					([local31 temp0] ignoreBlocks: wispCage setStep: 10 10)
					(if (or (== gCurRoomNum 590) (== local4 3))
						([local31 temp0]
							setLoop: (Random 0 2)
							setMotion: MoveTo -10 90
						)
					else
						([local31 temp0]
							setLoop: (Random 0 2)
							setMotion: MoveTo 330 95
						)
					)
				)
				(= ticks 320)
			)
			(1
				(if (and (== gDisguiseNum 0) (== gDay 13)) ; outlaw
					(switch gCurRoomNum
						(590
							(rgnBoat
								setLoop: 2
								setCel: 2
								posn: 0 96
								init:
								setMotion: MoveTo 96 114 self
							)
							(pole posn: 32 123 init: setMotion: MoveTo 128 137)
						)
						(600
							(if (== local4 3)
								(rgnBoat
									setLoop: 2
									setCel: 2
									posn: -60 116
									init:
									setMotion: MoveTo 98 132 self
								)
								(pole
									posn: -28 143
									init:
									setMotion: MoveTo 133 156
								)
							else
								(rgnBoat
									setLoop: 2
									setCel: 2
									posn: 349 98
									init:
									setMotion: MoveTo 98 132 self
								)
								(pole
									posn: 371 120
									init:
									setMotion: MoveTo 133 156
								)
							)
						)
					)
					(= local30 rgnBoat)
					(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
						([local31 temp0]
							setStep: 10 10
							setScript: (= [local239 temp0] (frenzy new:))
						)
					)
				else
					(= local4 0)
					(+= state 3)
					(self cue:)
				)
			)
			(2
				(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
					(if (== gCurRoomNum 600)
						([local31 temp0]
							setScript: 0
							setMotion: MoveTo (Random 15 305) (Random 95 135)
						)
					else
						([local31 temp0]
							setScript: 0
							setMotion: MoveTo (Random 35 305) (Random 95 120)
						)
					)
				)
				(= ticks 180)
			)
			(3
				(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
					([local31 temp0]
						setStep: 1 1
						observeBlocks: wispCage
						setMotion: Wander 230
					)
				)
				(= ticks 30)
			)
			(4
				(= local24 1)
				(if (!= client toTheKnight)
					(HandsOn)
				)
				(self dispose:)
			)
			(5
				(= local25 1)
				(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
					([local31 temp0]
						x:
							(if (== gCurRoomNum 590)
								(- (Random 0 50) 60)
							else
								(Random 330 370)
							)
						setMotion:
							MoveTo
							(if (== gCurRoomNum 590)
								(Random 50 305)
							else
								(Random 15 305)
							)
							(Random 86 134)
					)
				)
				(= ticks 180)
			)
			(6
				(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
					([local31 temp0]
						setStep: 1 1
						observeBlocks: wispCage
						setMotion: Wander 230
					)
				)
				(= local8 44)
				(self setScript: naiadPrinter self 5)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance frenzy of Script
	(properties)

	(method (doit)
		(if (> (local30 x:) 390)
			(client setMotion: MoveTo 330 (client y:) setScript: 0)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= temp0 (if (== gCurRoomNum 610) 60 else 100))
				(= temp1 (if (== gCurRoomNum 610) 60 else 75))
				(= temp2 (+ (local30 x:) (Random 0 temp0)))
				(= temp3 (+ (local30 y:) (Random 0 temp1)))
				(client setMotion: MoveTo temp2 temp3 self)
			)
			(1
				(-= state 2)
				(self cue:)
			)
		)
	)
)

(instance toTheKnight of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Converse 1 @local303 999 0 self) ; "I seek a missing knight and suspect these monks of treachery. Can you help me?"
			)
			(1
				(= seconds 2)
			)
			(2
				(= local8 21)
				(self setScript: naiadPrinter self 3)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (or (IsFlag 62) (IsFlag 51))
					(= local8 19)
					(self setScript: naiadPrinter self 2)
				else
					(+= state 3)
					(self cue:)
				)
			)
			(5
				(self setScript: wispsGoGetBoat self)
			)
			(6
				(= local8 50)
				(self setScript: naiadPrinter self 6)
			)
			(7
				(gCurRoom east: 620 west: 620)
				(HandsOn)
				(self dispose:)
			)
			(8
				(= local8 31)
				(self setScript: naiadPrinter self 4)
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outlawAfterWisps of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (gCast contains: local31) (== gDay 13))
					(= local8 54)
					(self setScript: naiadPrinter self 7)
				else
					(self cue:)
				)
			)
			(1
				(localproc_1)
				(gEgo
					view: 587
					setLoop: 0
					cycleSpeed: 24
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (gEgo x:) 125)
						(- (gEgo y:) 40)
						self
				)
				(if (and (gCast contains: local31) (== gDay 13))
					(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
						([local31 temp0]
							ignoreBlocks: wispCage
							setStep: 5 5
							setLoop: (Random 0 2)
							setMotion: MoveTo 330 95
						)
					)
				)
			)
			(2
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance stepInBoatAsOutlaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gCurRoomNum 600)
					(gEgo
						setPri: (- (gEgo priority:) 1)
						setMotion: MoveTo 133 156 self
					)
				else
					(gEgo
						setPri: (- (gEgo priority:) 1)
						setMotion: PolyPath 128 141 self
					)
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 15
					loop: 2
					cel: 0
					cycleSpeed: 12
					y: (+ (gEgo y:) 2)
					setCycle: End self
				)
				(bow
					posn: (gEgo x:) (gEgo y:)
					setPri: (gEgo priority:)
					init:
					setCycle: End
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(bow dispose:)
				(gEgo y: (+ (gEgo y:) 2) setCycle: Beg self)
				(pole
					posn: (gEgo x:) (gEgo y:)
					setPri: (gEgo priority:)
					setCycle: Beg
				)
			)
			(5
				(rgnBoat dispose:)
				(pole dispose:)
				(gEgo
					view: 587
					setPri: -1
					loop: 0
					cel: 0
					x: (if (== gCurRoomNum 590) 134 else 137)
					y: (if (== gCurRoomNum 590) 136 else 154)
				)
				(= ticks 6)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance monkBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((gCast contains: monk)
						(Converse 1 @local336 11 0 self) ; "There is no point giving the signal again, Brother. I am here."
					)
					(local4
						(Say 1601 78 self) ; "I have already called the monk. He waits further down the shore."
					)
					(else
						(LoadMany rsVIEW 57 21)
						(self setScript: (ScriptID 3 0) self) ; pipeIt
					)
				)
			)
			(1
				(cond
					((or (gCast contains: monk) local4)
						(HandsOn)
						(self dispose:)
					)
					(local4
						(Converse 1 @local307 11 0 self) ; "Step in, then, and be seated. I'll take you across."
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if local4
					(HandsOn)
					(self dispose:)
				else
					(= seconds 3)
				)
			)
			(3
				(if (== global136 0)
					(SetScore 25 85)
				)
				(if (not local2)
					(= local2 1)
					(Say 1601 59 self) ; "I hear something coming through the fog."
				else
					(self cue:)
				)
			)
			(4
				(= seconds 3)
			)
			(5
				(= local26 1)
				(gCurRoom notify: 1)
				(if (== gCurRoomNum 600)
					(self setScript: (ScriptID 603 2) self) ; incoming600
				else
					(self setScript: (ScriptID 603 3) self) ; incoming590
				)
			)
			(6
				(= ticks 12)
			)
			(7
				(= local26 0)
				(= local24 1)
				(switch global136
					(0
						(Converse 2 @local311 999 0 11 3 self) ; "I heard your signal, Brother, but I don't know your face. Have you newly joined our order?"
					)
					(1
						(Converse 1 @local317 11 0 self) ; "I grow mighty weary of your indecision, Brother. I may not answer a third time."
					)
					(2
						(Converse 2 @local321 999 0 11 3 self) ; "Sorry, Brother. I'm ready this time."
					)
				)
			)
			(8
				(if (== global136 2)
					(client setScript: (ScriptID 603 4)) ; walkToBoat
				else
					(HandsOn)
					(++ global136)
					(Fens setScript: monkWaitTimer)
					(self dispose:)
				)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(3 ; Do
					(if (== (gEgo view:) 587)
						(Say 1601 99 1) ; "That would serve no purpose."
						1
					)
				)
				(4 ; Inventory
					(switch invItem
						(1 ; horn
							(cond
								((OneOf gCurRoomNum 590 600)
									(gEgo setScript: (ScriptID 603 0)) ; blewIt
									(= global129 (GetTime 1)) ; SysTime12
									1
								)
								((== gCurRoomNum 610)
									(Say 1601 89 0) ; "That would be a staggeringly stupid thing to do here."
									1
								)
							)
						)
						(12 ; puzzleBox
							(Say 1601 90 0) ; "The box can wait until I'm in a safer place."
							1
						)
						(5 ; pipe
							(if (== gDisguiseNum 6) ; fens monk
								(cond
									((OneOf gCurRoomNum 590 600)
										(gCurRoom setScript: monkBoat)
										1
									)
									((and (== gCurRoomNum 610) (< (robin x:) 250))
										(robin setScript: flutePlayer)
										1
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance flutePlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 (rgnBoat xStep:))
				(= local10 (rgnBoat yStep:))
				(rgnBoat setStep: 0 0)
				(monk setCycle: 0)
				(self setScript: (ScriptID 3 0) self) ; pipeIt
			)
			(1
				(if local5
					(Converse 1 @local326 11 0 self) ; "That does it."
				else
					(Converse 1 @local331 11 0 self) ; "Stop that you fool! I won't warn you again!"
				)
			)
			(2
				(if local5
					(gCurRoom setScript: (ScriptID 603 1) 0 1) ; knockItOff
				else
					(rgnBoat setStep: local9 local10)
					(monk setCycle: Fwd)
					(= local5 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance monkWaitTimer of Script
	(properties)

	(method (dispose)
		(= local4 (= global132 0))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global132 1)
				(= seconds
					(switch gHowFast
						(0 180)
						(1 120)
						(2 90)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance naiadPrinter of TScript
	(properties)

	(method (cue)
		(if (not notKilled)
			(SetMessageColor 0)
			(if (not local1)
				(HandsOn)
			)
			(gTheIconBar enable: 8)
			(= local8 0)
			(self dispose:)
		)
		(super cue: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 global143)
				(HandsOff)
				(gTheIconBar disable: 8)
				(= cycles 1)
			)
			(1
				(SetMessageColor 30)
				(Say
					1601
					(if local8 local8 else register)
					self
					67
					(Random 15 200)
					(Random 5 100)
					80
					{Will-o-th'Wisps}
				)
				(if local8
					(++ local8)
				)
			)
			(2
				(if
					(and
						local8
						(<=
							local8
							(switch register
								(1 18)
								(2 20)
								(3 24)
								(4 43)
								(5 49)
								(6 53)
								(7 57)
								(8 10)
								(else
									(Print 601 0) ; "Oops!"
								)
							)
						)
					)
					(-= state 2)
				)
				(self cue:)
			)
			(3
				(= local8 0)
				(if (not local1)
					(HandsOn)
				)
				(gTheIconBar enable: 8)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

