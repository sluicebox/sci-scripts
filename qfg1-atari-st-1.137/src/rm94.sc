;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n105)
(use n106)
(use n193)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm94 0
	archer1 1
	archer2 2
	archer3 3
	archer4 4
	archer1Start 5
	archer2Start 6
	archer3Start 7
	archer4Start 8
	unSafeBridge 9
	antwerp 10
	jackCycle 11
	rug 12
	rugs 13
	jack1 14
	jackCycle 15
	jackSound 16
	door 17
	openMess 18
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
	[local9 28]
	local37
	local38
	local39
	local40 = 1
)

(procedure (localproc_0 param1 param2 param3)
	(= local38 0)
	(if local5
		(= local37 6)
	else
		(switch param1
			(0
				(switch param2
					(0
						(if param3
							(= local37 0)
							(= local38 6)
						else
							(= local37 3)
						)
					)
					(1
						(if param3
							(= local38 -6)
							(= local37 3)
						else
							(= local37 0)
						)
					)
					(else
						(= local37 6)
					)
				)
			)
			(1
				(switch param2
					(0
						(if param3
							(= local37 3)
						else
							(= local38 6)
							(= local37 0)
						)
					)
					(1
						(if param3
							(= local37 0)
						else
							(= local38 -6)
							(= local37 3)
						)
					)
					(else
						(= local37 6)
					)
				)
			)
			(2
				(switch param2
					(2
						(if param3
							(= local37 0)
						else
							(= local37 3)
						)
					)
					(3
						(if param3
							(= local37 3)
						else
							(= local37 0)
						)
					)
					(else
						(= local37 6)
					)
				)
			)
			(else
				(switch param2
					(2
						(if param3
							(= local37 3)
						else
							(= local37 0)
						)
					)
					(3
						(if param3
							(= local37 0)
						else
							(= local37 3)
						)
					)
					(else
						(= local37 6)
					)
				)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_2
			param1
			param2
			(gEgo x:)
			(- (gEgo y:) 30)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(= temp1
		(localproc_2
			param3
			param4
			(gEgo x:)
			(- (gEgo y:) 30)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_2
			(gEgo x:)
			(- (gEgo y:) 30)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_2
			(gEgo x:)
			(- (gEgo y:) 15)
			param1
			param2
			param3
			param4
		)
	)
	(if (== temp0 temp1)
		(return 0)
	else
		(= local6
			(-
				(/
					(+
						(* param4 (gEgo x:))
						(- (* param4 param1))
						(- (* param2 (gEgo x:)))
						(* param2 param3)
					)
					(- param3 param1)
				)
				(gEgo y:)
			)
		)
		(= local7 (gEgo loop:))
		(if (< (gEgo x:) param1)
			(= local8 1)
		else
			(= local8 0)
		)
		(return 1)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 param6)
	(if
		(>
			(+
				(* param6 param3)
				(- (* param5 param4))
				(* param1 (- param4 param6))
				(* param2 (- param5 param3))
			)
			0
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_3 param1)
	(if (or param1 (rm94 notify: 0))
		(archer1 setScript: archer1Start)
		(archer2 setScript: archer2Start)
		(archer3 setScript: archer3Start)
		(archer4 setScript: archer4Start)
	)
)

(class Archer of Script
	(properties
		archerStop 0
		fequencyA 3
		fequencyB 10
		arrowsShot 0
		maxArrows 30
		minArrows 15
		clientP 0
		startCel 0
		shootX 0
		shootY 0
		hideX 0
		hideY 0
		arrowV 0
		arrowL 0
		arrowC 0
		arrowP 0
		startX 0
		startY 0
		A1 0
		B1 0
		X1 0
		Y1 0
		A2 0
		B2 0
		X2 0
		Y2 0
		A3 0
		B3 0
		X3 0
		Y3 0
		A4 0
		B4 0
		X4 0
		Y4 0
		A5 0
		B5 0
		X5 0
		Y5 0
		A6 0
		B6 0
		X6 0
		Y6 0
		begX 0
		begY 0
		endX 0
		endY 0
		archDeltaX 0
		archDeltaY 0
	)

	(method (doit)
		(if archerStop
			(-- archerStop)
		)
		(cond
			(
				(and
					(< state 3)
					(or
						(> arrowsShot maxArrows)
						(and archerStop (!= state 10))
						(and
							(< -20 (- startX (gEgo x:)) 20)
							(!= state 10)
							(< -20 (- startY (gEgo y:)) 20)
						)
					)
				)
				(self changeState: 10)
			)
			(
				(and
					(<= arrowsShot maxArrows)
					(not archerStop)
					(not (< -50 (- startX (gEgo x:)) 50))
					(== state 11)
				)
				(self changeState: 0)
			)
		)
		(super doit:)
	)

	(method (archerShoot)
		(cond
			((and (<= 90 (gEgo y:) 100) (< A1 (gEgo x:) B1))
				(= endX (- X1 (Random 2 8)))
				(= endY (- Y1 (Random 4 16)))
				(return 1)
			)
			((and (<= 100 (gEgo y:) 110) (< A2 (gEgo x:) B2))
				(= endX (- X2 (Random 2 8)))
				(= endY (- Y2 (Random 4 16)))
				(return 1)
			)
			((and (<= 110 (gEgo y:) 120) (< A3 (gEgo x:) B3))
				(= endX (- X3 (Random 2 8)))
				(= endY (- Y3 (Random 4 16)))
				(return 1)
			)
			((and (<= 120 (gEgo y:) 130) (< A4 (gEgo x:) B4))
				(= endX (- X4 (Random 2 8)))
				(= endY (- Y4 (Random 4 16)))
				(return 1)
			)
			((and (<= 130 (gEgo y:) 140) (< A5 (gEgo x:) B5))
				(= endX (- X5 (Random 2 8)))
				(= endY (- Y5 (Random 4 16)))
				(return 1)
			)
			((and (<= 140 (gEgo y:) 150) (< A6 (gEgo x:) B6))
				(= endX (- X6 (Random 2 8)))
				(= endY (- Y6 (Random 4 16)))
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (arrowPath)
		(= archDeltaX (- endX startX))
		(/= archDeltaX 5)
		(= archDeltaY (- endY startY))
		(/= archDeltaY 5)
		(= endX startX)
		(= endY startY)
		(= begX startX)
		(= begY startY)
	)

	(method (nextPath)
		(= endX (+ (= begX endX) archDeltaX))
		(= endY (+ (= begY endY) archDeltaY))
	)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(client
					setCel: startCel
					illegalBits: 0
					ignoreActors:
					setPri: clientP
					setMotion: MoveTo shootX shootY self
				)
			)
			(1
				(= cycles (Random fequencyA fequencyB))
			)
			(2
				(if (self archerShoot:)
					(self arrowPath:)
					((= arrowP (Prop new:))
						view: arrowV
						setLoop: arrowL
						setCel: arrowC
						setPri: 15
						ignoreActors:
						hide:
						init:
					)
					(client setCel: 0 setCycle: CT startCel 1 self)
				else
					(self changeState: 1)
				)
			)
			(3
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP show: posn: endX endY)
				)
				(client stopUpd:)
				(= cycles 2)
			)
			(4
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= cycles 2)
				)
			)
			(5
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= cycles 2)
				)
			)
			(6
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= cycles 2)
				)
			)
			(7
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= cycles 2)
				)
			)
			(8
				(++ arrowsShot)
				(if (< arrowsShot minArrows)
					(arrowP addToPic:)
				else
					(arrowP dispose:)
				)
				(self changeState: 1)
			)
			(10
				(client setCel: startCel setMotion: MoveTo hideX hideY self)
			)
			(11
				(client stopUpd:)
			)
		)
	)
)

(instance rm94 of Rm
	(properties
		picture 94
		style 8
	)

	(method (dispose)
		(super dispose:)
		(LoadMany 0 186 187 188 189 190 191 192 193 194 195)
	)

	(method (notify param1)
		(switch param1
			(0
				(if (== local2 1)
					(= local2 0)
					(return 1)
				else
					(return 0)
				)
			)
			(1
				(if (== local1 1)
					(return 1)
				else
					(= local1 1)
					(return 0)
				)
			)
			(2
				(archer1Start archerStop: 100)
				(archer2Start archerStop: 100)
				(archer3Start archerStop: 100)
				(archer4Start archerStop: 100)
			)
			(3
				(if (== local3 1)
					(return 1)
				else
					(return 0)
				)
			)
			(4
				(= local3 1)
			)
			(5
				(= local3 0)
			)
			(6
				(= local4 1)
			)
			(7
				(= local4 0)
			)
			(8
				(= local40 0)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 94 194 590 3 515 536 537)
		(LoadMany rsSOUND (SoundFX 73) (SoundFX 35) (SoundFX 81))
		(LoadMany rsSCRIPT 186 187 188 189 190 191 192 193 194 195 103 102)
		(gContMusic number: (SoundFX 73) loop: -1 play:)
		(super init:)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onSacks
				onKegs
				onRug
				onRugs
				onWire1
				onUnSafeBridge
				onSafeBridge
				onChasm
				onDoor
				onWindow
				onRCabinet
				onLCabinet
				onLumber1
				onLitter1
		)
		(SolvePuzzle 705 8)
		(SL enable:)
		(NormalEgo)
		(rug ignoreActors: 1 setPri: 11 init: stopUpd:)
		(rugs ignoreActors: 1 setPri: 11 init: stopUpd:)
		(unSafeBridge ignoreActors: 1 setPri: 6 init: stopUpd:)
		(safeBridge ignoreActors: 1 setPri: 6 init: addToPic:)
		(jackCycle init: hide:)
		(archer1 init: stopUpd:)
		(archer2 init: stopUpd:)
		(archer3 init: stopUpd:)
		(archer4 init: stopUpd:)
		(= local2 1)
		(if (and (not (IsFlag 348)) (IsFlag 237))
			(SetFlag 84)
			(= local2 0)
			(localproc_3 1)
		)
		(switch gPrevRoomNum
			(95
				(door setCel: 2 setPri: 1 init:)
				(= local3 1)
				(gEgo posn: 223 76 init: setMotion: MoveTo 190 76)
			)
			(else
				(door setPri: 1 init:)
				(gEgo posn: 157 188 init: setMotion: MoveTo 157 172)
			)
		)
	)

	(method (doit)
		(cond
			((and (not local5) (gEgo inRect: 90 106 116 112))
				(= local5 1)
				(gEgo setScript: (ScriptID 186 0)) ; fallBridge
			)
			(
				(and
					(not local5)
					(not (<= 215 (gEgo x:) 235))
					(<= 108 (gEgo y:) 111)
				)
				(= local5 1)
				(gEgo setScript: (ScriptID 187 0)) ; fallChasm
			)
			(
				(and
					(gEgo inRect: 154 76 167 83)
					(== (gEgo loop:) 3)
					(not local4)
					(not local5)
				)
				(= local5 1)
				(gEgo setScript: (ScriptID 188 0)) ; egoTripsNorth
			)
			(
				(and
					(gEgo inRect: 282 156 293 162)
					(== (gEgo loop:) 3)
					(not local4)
					(!= (gEgo script:) (ScriptID 189 0)) ; egoTripsSouth
				)
				(gEgo setScript: (ScriptID 189 0)) ; egoTripsSouth
			)
			((and (gEgo inRect: 139 145 169 152) (not local5))
				(= local5 1)
				(gEgo setPri: 11 setScript: (ScriptID 190 0)) ; fallRug
			)
			((and (gEgo inRect: 140 145 187 152) (not local5))
				(= local5 1)
				(gEgo setScript: (ScriptID 191 0)) ; fallRugs
			)
		)
		(cond
			((and local3 (& (gEgo onControl: 1) $0002))
				(gCurRoom newRoom: 95)
			)
			((and (== (gEgo edgeHit:) EDGE_BOTTOM) (not local5))
				(gCurRoom newRoom: 93)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint 94 0) ; "You get the feeling that you're not alone."
					)
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'rest,nap')
						(EgoDead 94 1 80 {Z-Z-Z-Z-Z-Z-Z-Z-Z-Z} 82 800 0 0) ; "The Brigands oblige you by making your pleasant rest permanent!"
					)
					((Said 'cast>')
						(= local0 (SaidSpell event))
						(if (CastSpell local0)
							(switch local0
								(18
									(HighPrint 94 2) ; "No spells are active here."
								)
								(20
									(if (not (rm94 notify: 0))
										(if (CastDazzle)
											(rm94 notify: 2)
										)
									else
										(HighPrint 94 3) ; "That was a useless gesture."
									)
								)
								(23
									(CastDart 0)
									(localproc_3 0)
								)
								(22
									(if (rm94 notify: 0)
										(HighPrint 94 3) ; "That was a useless gesture."
									else
										(HighPrint 94 4) ; "None of the brigands notices your Calm spell. There is too much negative thought energy here."
									)
								)
								(17
									(if (rm94 notify: 1)
										(HighPrint 94 5) ; "That was a useless spell."
									else
										(rm94 setScript: openMess)
										(if (CastOpen gEgo openMess)
											(jackCycle
												setScript: (ScriptID 192 0) ; jackJumps
											)
										else
											(openMess changeState: 2)
										)
									)
								)
								(else
									(HighPrint 94 5) ; "That was a useless spell."
								)
							)
						)
					)
					((Said 'throw/boulder')
						(if (ThrowRock 0)
							(localproc_3 0)
						)
					)
					((Said 'throw/dagger')
						(if (ThrowKnife 0)
							(localproc_3 0)
						)
					)
					((Said 'step,hop,climb[/above,rope,string,string]')
						(cond
							((gEgo inRect: 145 72 175 100)
								(gEgo setScript: (ScriptID 195 0)) ; stepOverN
							)
							((gEgo inRect: 275 152 298 170)
								(gEgo setScript: (ScriptID 195 1)) ; stepOverS
							)
							(else
								(HighPrint 94 6) ; "There is nothing near that you can get over."
							)
						)
					)
					((Said 'open[/gate,door]')
						(cond
							(local3
								(HighPrint 94 7) ; "The door is open."
							)
							((gEgo inRect: 193 0 320 74)
								(door setScript: (ScriptID 194 0)) ; openGate
							)
							(else
								(HighPrint 94 8) ; "You must get closer."
							)
						)
					)
					((Said 'say,ask')
						(HighPrint 94 9) ; "This is no time for casual conversation."
					)
					(local2
						(proc193_0 event)
					)
					(else
						(event claimed: 1)
						(HighPrint 94 10) ; "You're too busy trying not to become a human pincushion."
					)
				)
			)
		)
	)
)

(instance rug of Prop
	(properties
		y 163
		x 153
		view 94
		priority 9
	)
)

(instance rugs of Prop
	(properties
		y 163
		x 180
		view 94
		loop 1
		priority 12
	)
)

(instance unSafeBridge of Prop
	(properties
		y 118
		x 101
		view 94
		loop 2
		priority 8
	)
)

(instance safeBridge of Prop
	(properties
		y 118
		x 227
		view 94
		loop 3
		priority 8
	)
)

(instance door of Prop
	(properties
		y 59
		x 208
		view 94
		loop 4
		priority 1
	)
)

(instance jack1 of View
	(properties
		y 149
		x 307
		view 94
		loop 5
		priority 13
	)
)

(instance jackCycle of Prop
	(properties
		y 151
		x 307
		view 94
		loop 6
		priority 13
	)
)

(instance jackSound of Sound
	(properties
		number 81
		priority 3
	)
)

(instance archer1 of Act
	(properties
		y 78
		x 16
		view 194
		priority 4
	)

	(method (doit)
		(for ((= local39 0)) (<= local39 24) ((+= local39 4))
			(if (!= [local9 local39] 0)
				(localproc_0
					[local9 (+ local39 1)]
					(gEgo loop:)
					[local9 (+ local39 2)]
				)
				([local9 (+ local39 3)]
					setCel: local37
					setPri: (gEgo priority:)
					posn:
						(+ (gEgo x:) local38)
						(+ (gEgo y:) [local9 local39])
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed archer1 event 3)
				(HighPrint 94 11) ; "His aim in life is to make shish kebab. I hope you're not skewered."
			)
		)
	)
)

(instance archer2 of Act
	(properties
		y 80
		x 296
		view 194
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed archer1 event 3)
				(HighPrint 94 12) ; "Life as an archer is not dull or pointless."
			)
		)
	)
)

(instance archer3 of Act
	(properties
		y 106
		x -23
		view 194
		priority 7
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed archer1 event 3)
				(HighPrint 94 13) ; "He has an arrow with your name on it."
			)
		)
	)
)

(instance archer4 of Act
	(properties
		y 110
		x 343
		view 194
		priority 7
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed archer1 event 3)
				(HighPrint 94 14) ; "He has an IQ so low he can't spell IQ."
			)
		)
	)
)

(instance antwerp of Act
	(properties
		view 590
		loop 7
		priority 4
	)
)

(instance onSacks of RFeature
	(properties
		nsTop 61
		nsLeft 72
		nsBottom 84
		nsRight 140
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSacks event 3)
				(HighPrint 94 15) ; "Sacks of grain. Stored for the winter."
			)
		)
	)
)

(instance onKegs of RFeature
	(properties
		nsTop 61
		nsLeft 179
		nsBottom 84
		nsRight 243
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKegs event 3)
				(HighPrint 94 16) ; "Empty wine barrels. The winters here are very cold."
			)
		)
	)
)

(instance onRug of RFeature
	(properties
		nsTop 139
		nsLeft 130
		nsBottom 159
		nsRight 174
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRug event 3)
				(HighPrint 94 17) ; "Rug with message "Step Here"."
			)
		)
	)
)

(instance onRugs of RFeature
	(properties
		nsTop 139
		nsLeft 175
		nsBottom 161
		nsRight 197
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRugs event 3)
				(HighPrint 94 18) ; "These rolled-up rugs are spares for use when the rug at the left is lost."
			)
		)
	)
)

(instance onWire1 of RFeature
	(properties
		nsTop 156
		nsLeft 278
		nsBottom 156
		nsRight 297
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed onWire1 event 3) (MouseClaimed onWire2 event 3))
				(HighPrint 94 19) ; "A rope tautly strung."
			)
		)
	)
)

(instance onWire2 of RFeature
	(properties
		nsTop 77
		nsLeft 142
		nsBottom 77
		nsRight 176
	)
)

(instance onUnSafeBridge of RFeature
	(properties
		nsTop 104
		nsLeft 89
		nsBottom 116
		nsRight 110
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onUnSafeBridge event 3)
				(HighPrint 94 20) ; "Sturdy looking bridge with one support pole across the chasm."
			)
		)
	)
)

(instance onSafeBridge of RFeature
	(properties
		nsTop 104
		nsLeft 213
		nsBottom 116
		nsRight 240
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSafeBridge event 3)
				(HighPrint 94 21) ; "Sturdy looking bridge with two support poles across the chasm. A message reading "Cross Here" is on this bridge."
			)
		)
	)
)

(instance onChasm of RFeature
	(properties
		nsTop 104
		nsLeft 36
		nsBottom 116
		nsRight 291
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(not (MouseClaimed onSafeBridge event 3))
					(not (MouseClaimed onUnSafeBridge event 3))
					(MouseClaimed onChasm event 3)
				)
				(HighPrint 94 22) ; "Chasm across the room. The only safe passage is across the bridges."
			)
		)
	)
)

(instance onDoor of RFeature
	(properties
		nsTop 29
		nsLeft 208
		nsBottom 58
		nsRight 237
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDoor event 3)
				(HighPrint 94 23) ; "Door to some other room."
			)
		)
	)
)

(instance onWindow of RFeature
	(properties
		nsTop 29
		nsLeft 167
		nsBottom 47
		nsRight 197
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onWindow event 3)
				(HighPrint 94 24) ; "Window showing vague outlines and shapes."
			)
		)
	)
)

(instance onRCabinet of RFeature
	(properties
		nsTop 141
		nsLeft 299
		nsBottom 175
		nsRight 318
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRCabinet event 3)
				(HighPrint 94 25) ; "Some kind of cabinet showing a flip top secured by a hasp."
			)
		)
	)
)

(instance onLCabinet of RFeature
	(properties
		nsTop 143
		nsBottom 178
		nsRight 12
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onLCabinet event 3)
				(HighPrint 94 26) ; "Some kind of cabinet."
			)
		)
	)
)

(instance onLumber1 of RFeature
	(properties
		nsTop 129
		nsLeft 44
		nsBottom 157
		nsRight 124
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed onLumber1 event 3) (MouseClaimed onLumber2 event 3))
				(HighPrint 94 27) ; "Fortification for archers to stand behind."
			)
		)
	)
)

(instance onLumber2 of RFeature
	(properties
		nsTop 131
		nsLeft 200
		nsBottom 157
		nsRight 276
	)
)

(instance onLitter1 of RFeature
	(properties
		nsTop 170
		nsLeft 274
		nsBottom 175
		nsRight 287
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(MouseClaimed onLitter1 event 3)
					(MouseClaimed onLitter2 event 3)
					(MouseClaimed onLitter3 event 3)
					(MouseClaimed onLitter4 event 3)
					(MouseClaimed onLitter5 event 3)
				)
				(HighPrint 94 28) ; "The stuff that dreams are made of. Left here by some somnambulistic brigand."
			)
		)
	)
)

(instance onLitter2 of RFeature
	(properties
		nsTop 122
		nsLeft 275
		nsBottom 128
		nsRight 287
	)
)

(instance onLitter3 of RFeature
	(properties
		nsTop 73
		nsLeft 244
		nsBottom 79
		nsRight 251
	)
)

(instance onLitter4 of RFeature
	(properties
		nsTop 83
		nsLeft 53
		nsBottom 92
		nsRight 63
	)
)

(instance onLitter5 of RFeature
	(properties
		nsTop 116
		nsLeft 18
		nsBottom 124
		nsRight 27
	)
)

(instance archer1Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 4
		startCel 4
		shootX 49
		shootY 78
		hideX 16
		hideY 78
		arrowV 194
		arrowL 6
		arrowC 3
		startX 84
		startY 65
		B1 320
		X1 260
		Y1 84
		B2 320
		X2 276
		Y2 97
		B3 320
		X3 294
		Y3 113
		A4 160
		B4 320
		X4 315
		Y4 133
		A5 240
		B5 320
		X5 321
		Y5 141
		A6 1
	)
)

(instance archer2Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 4
		startCel 4
		shootX 275
		shootY 80
		hideX 296
		hideY 80
		arrowV 194
		arrowL 6
		startX 250
		startY 67
		B1 320
		X1 67
		Y1 77
		B2 320
		X2 47
		Y2 97
		B3 170
		X3 25
		Y3 116
		B4 150
		X4 9
		Y4 132
		B5 145
		X5 5
		Y5 142
		A6 1
	)
)

(instance archer3Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 7
		startCel 4
		shootX 10
		shootY 106
		hideX -23
		hideY 106
		arrowV 194
		arrowL 6
		arrowC 3
		startX 35
		startY 93
		A1 200
		B1 320
		X1 262
		Y1 85
		A2 200
		B2 320
		X2 273
		Y2 95
		B3 320
		X3 287
		Y3 105
		B4 320
		X4 296
		Y4 111
		B5 320
		X5 306
		Y5 130
		A6 200
		B6 320
		X6 320
		Y6 142
	)
)

(instance archer4Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 7
		startCel 4
		shootX 313
		shootY 110
		hideX 343
		hideY 110
		arrowV 194
		arrowL 6
		startX 288
		startY 97
		B1 120
		X1 75
		Y1 67
		B2 140
		X2 68
		Y2 86
		B3 200
		X3 36
		Y3 104
		B4 320
		X4 23
		Y4 120
		B5 320
		X5 16
		Y5 123
		B6 320
		X6 7
		Y6 135
	)
)

(instance egoHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register show:)
				(cond
					((gEgo has: 33) ; chainmail
						(TakeDamage 15)
					)
					((gEgo has: 8) ; leather
						(TakeDamage 30)
					)
					(else
						(TakeDamage 45)
					)
				)
				(cond
					((== [local9 0] 0)
						(= [local9 0] local6)
						(= [local9 1] local7)
						(= [local9 2] local8)
						(= [local9 3] register)
					)
					((== [local9 4] 0)
						(= [local9 4] local6)
						(= [local9 5] local7)
						(= [local9 6] local8)
						(= [local9 7] register)
					)
					((== [local9 8] 0)
						(= [local9 8] local6)
						(= [local9 9] local7)
						(= [local9 10] local8)
						(= [local9 11] register)
					)
					((== [local9 12] 0)
						(= [local9 12] local6)
						(= [local9 13] local7)
						(= [local9 14] local8)
						(= [local9 15] register)
					)
					((== [local9 16] 0)
						(= [local9 16] local6)
						(= [local9 17] local7)
						(= [local9 18] local8)
						(= [local9 19] register)
					)
					((== [local9 20] 0)
						(= [local9 20] local6)
						(= [local9 21] local7)
						(= [local9 22] local8)
						(= [local9 23] register)
					)
					((== [local9 24] 0)
						(= [local9 24] local6)
						(= [local9 25] local7)
						(= [local9 26] local8)
						(= [local9 27] register)
					)
					(else
						(register dispose:)
					)
				)
				(if (<= [gEgoStats 14] 0) ; health
					(= cycles 3)
				else
					(self dispose:)
				)
			)
			(1
				(EgoDead ; "This was not the ending you had in mind when you read the manual on "How to be a Hero". Either you just aren't ready to take on this situation, or there's got to be a better way to accomplish your mission."
					94
					29
					82
					516
					0
					9
					80
					{You knew this job was dangerous....}
				)
			)
		)
	)
)

(instance openMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HighPrint 94 30) ; "You hear a snick as the hasp on the Jack in the Box is released."
				(lockSound number: (SoundFX 35) init: play:)
				(= cycles 8)
			)
			(2
				(lockSound dispose:)
				(self dispose:)
			)
		)
	)
)

(instance lockSound of Sound
	(properties
		number 35
		priority 3
	)
)

