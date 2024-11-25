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

(procedure (localproc_4)
	(cond
		((Said 'look,look,read/sign,sign,note,message')
			(HighPrint 94 36) ; "There are two notes."
			(HighPrint 94 37) ; "There is a sign on the blue carpet which reads, "Step Here"."
			(HighPrint 94 38) ; "There is a sign on the right bridge which reads, "Cross Here"."
		)
		((Said 'look,look>')
			(cond
				((Said '[<at,around][/place,place,area]')
					(HighPrint 94 39) ; "This is not what you expected the brigands' fortress to look like in your imagination. The barracks with the open half-doors to the east and west are fairly normal looking. The carpet lying near the gate, however, is a bit odd. The small chasm in the middle of this yard with the bridge across it seems strange, too. There are two blockades near the gate and some barriers near the north."
				)
				((Said '<below/carpet,carpet')
					(HighPrint 94 40) ; "That's interesting. There seems to be a pit trap under the carpet."
				)
				((Said '[<at]/carpet,carpet')
					(HighPrint 94 41) ; "The carpets look rather new, perhaps recently stolen from the merchant in town. There is a sign on the blue carpet which reads, "Step Here"."
				)
				((Said '[<at]/wall')
					(HighPrint 94 42) ; "The barracks have open half-doors and you can hear noise behind them."
				)
				((Said '[<at]/chasm,pit,chasm')
					(HighPrint 94 43) ; "The chasm is about six feet across and ten feet deep."
				)
				((Said '[<at]/string,rope,string,line')
					(HighPrint 94 44) ; "There is a dark rope stretched tautly across the path. It can easily be avoided by stepping over it."
				)
				((Said '[<at]/jack,box')
					(HighPrint 94 45) ; "It looks like a plain, simple, harmless box to you."
				)
				((Said '[<at]/bridge[<left]')
					(HighPrint 94 46) ; "The bridge looks sturdy resting on its pole across the chasm."
				)
				((Said '[<at]/bridge,plank[<right]')
					(HighPrint 94 47) ; "The bridge looks sturdy resting on its poles across the chasm. There is a sign on it which reads, "Cross Here"."
				)
				((Said '[<at]/bridge,plank')
					(cond
						((gEgo inRect: 204 97 245 123)
							(HighPrint 94 48) ; "Sturdy looking bridge with two support poles across the chasm. A sign that reads: "Cross Here" is atop the bridge."
						)
						((gEgo inRect: 90 98 112 124)
							(HighPrint 94 20) ; "Sturdy looking bridge with one support pole across the chasm."
						)
						(else
							(HighPrint 94 49) ; "There are two bridges which cross the chasm."
						)
					)
				)
				((Said '[<at]/bag,bag')
					(HighPrint 94 50) ; "The sacks seem to be full of grain."
				)
				((Said '[<at]/barrel,barrel')
					(HighPrint 94 51) ; "The barrels look like empty wine casks."
				)
				((Said '<up')
					(HighPrint 94 52) ; "Nothing but cobwebs."
				)
				((or (Said '<down') (Said '/ground'))
					(cond
						(
							(or
								(gEgo inRect: 145 72 175 100)
								(gEgo inRect: 275 152 298 170)
							)
							(HighPrint 94 53) ; "You see a rope tautly strung about 6 inches off the floor."
						)
						((gEgo inRect: 128 125 193 184)
							(HighPrint 94 54) ; "The carpets look rather new, perhaps recently stolenfrom the merchant in town. There is a sign on the blue carpet which reads, "Step Here"."
						)
						((gEgo inRect: 204 97 245 123)
							(HighPrint 94 48) ; "Sturdy looking bridge with two support poles across the chasm. A sign that reads: "Cross Here" is atop the bridge."
						)
						((gEgo inRect: 90 98 112 124)
							(HighPrint 94 20) ; "Sturdy looking bridge with one support pole across the chasm."
						)
						(else
							(HighPrint 94 55) ; "Don't -- you'll ge t dizzy."
						)
					)
				)
				((Said '/east,west')
					(HighPrint 94 42) ; "The barracks have open half-doors and you can hear noise behind them."
				)
				((Said '/north')
					(HighPrint 94 56) ; "The building to the north has a window and a single door."
				)
				((Said '/south,gate,door')
					(if (IsFlag 238)
						(HighPrint 94 57) ; "You can see the fortress wall and the open gate."
					else
						(HighPrint 94 58) ; "You can see the fortress wall and the closed gate."
					)
				)
				((Said '/window')
					(cond
						((gEgo inRect: 156 65 207 76)
							(HighPrint 94 59) ; "All that can be seen through the window are vague shapes and outlines."
						)
						((not (< 59 (gEgo x:) 240))
							(if (rm94 notify: 0)
								(archer1 setScript: archer1Start)
								(archer2 setScript: archer2Start)
								(archer3 setScript: archer3Start)
								(archer4 setScript: archer4Start)
								(HighPrint 94 60) ; "You see a group of brigands playing cards. One looks back at you in surprise and starts yelling."
							)
						)
						(else
							(HighPrint 94 61) ; "You're not near any window"
						)
					)
				)
				((Said '/door')
					(HighPrint 94 62) ; "Yep, it's a door all right"
				)
				((Said '/cabinet,box,table')
					(cond
						((gEgo inRect: 0 129 37 190)
							(HighPrint 94 63) ; "An empty cabinet."
						)
						((not (gEgo inRect: 276 143 320 177))
							(HighPrint 94 64) ; "Get close for a good look."
						)
						((rm94 notify: 1)
							(HighPrint 94 65) ; "You don't have much time to look at toys."
						)
						(else
							(HighPrint 94 66) ; "The cabinet seems to have some kind of hasp."
						)
					)
				)
			)
		)
		((Said 'get,get,get,grab,move,move>')
			(cond
				((Said '/carpet,carpet')
					(HighPrint 94 67) ; "The rugs are too big to put into your backpack and too heavy to carry around. You do notice a pit trap under the spread-out carpet."
				)
				((Said '/string,rope,string')
					(HighPrint 94 68) ; "The rope is securely fastened and is pretty useless anyway."
				)
				((Said '/jack,box')
					(HighPrint 94 69) ; "Your life is in grave danger and you want to play with toys? What kind of hero are you?."
				)
				((Said '/bag,barrel')
					(HighPrint 94 70) ; "They're too heavy to carry."
				)
			)
		)
		((Said 'get,get/boulder')
			(HighPrint 94 71) ; "There are no rocks in here."
		)
		((Said 'open,open,open/jack,box,toy,hasp,hasp,cabinet')
			(cond
				((not (gEgo inRect: 276 143 320 177))
					(HighPrint 94 72) ; "You're not close enough."
				)
				((rm94 notify: 1)
					(HighPrint 94 73) ; "It's already open."
				)
				(else
					(JackCycle setScript: jackJumps)
				)
			)
		)
		((Said 'close,close,close,close[/gate,door]')
			(cond
				((and (gEgo inRect: 193 0 320 74) (rm94 notify: 3))
					(door setScript: closeGate)
				)
				((rm94 notify: 3)
					(HighPrint 94 74) ; "You must get closer."
				)
				(else
					(HighPrint 94 75) ; "The door is closed."
				)
			)
		)
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

	(method (changeState newState)
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
		(Rug ignoreActors: 1 setPri: 11 init: stopUpd:)
		(rugs ignoreActors: 1 setPri: 11 init: stopUpd:)
		(unSafeBridge ignoreActors: 1 setPri: 6 init: stopUpd:)
		(safeBridge ignoreActors: 1 setPri: 6 init: addToPic:)
		(JackCycle init: hide:)
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
				(gEgo setScript: fallBridge)
			)
			(
				(and
					(not local5)
					(not (<= 215 (gEgo x:) 235))
					(<= 108 (gEgo y:) 111)
				)
				(= local5 1)
				(gEgo setScript: fallChasm)
			)
			(
				(and
					(gEgo inRect: 154 76 167 83)
					(== (gEgo loop:) 3)
					(not local4)
					(not local5)
				)
				(= local5 1)
				(gEgo setScript: egoTripsNorth)
			)
			(
				(and
					(gEgo inRect: 282 156 293 162)
					(== (gEgo loop:) 3)
					(not local4)
					(!= (gEgo script:) egoTripsSouth)
				)
				(gEgo setScript: egoTripsSouth)
			)
			((and (gEgo inRect: 139 145 169 152) (not local5))
				(= local5 1)
				(gEgo setPri: 11 setScript: fallRug)
			)
			((and (gEgo inRect: 140 145 187 152) (not local5))
				(= local5 1)
				(gEgo setScript: fallRugs)
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
					((Said 'rest,rest,nap,nap')
						(EgoDead ; "The Brigands oblige you by making your pleasant rest permanent!"
							94
							1
							80
							{Z-Z-Z-Z-Z-Z-Z-Z-Z-Z}
							82
							800
							0
							0
						)
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
											(JackCycle setScript: jackJumps)
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
					(
						(Said
							'step,step,hop,climb,climb[/above,rope,string,string,line]'
						)
						(cond
							((gEgo inRect: 145 72 175 100)
								(gEgo setScript: stepOverN)
							)
							((gEgo inRect: 275 152 298 170)
								(gEgo setScript: stepOverS)
							)
							(else
								(HighPrint 94 6) ; "There is nothing near that you can get over."
							)
						)
					)
					((Said 'open,open,open[/gate,door]')
						(cond
							(local3
								(HighPrint 94 7) ; "The door is open."
							)
							((gEgo inRect: 193 0 320 74)
								(door setScript: openGate)
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
						(localproc_4 event)
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

(instance Rug of Prop
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

(instance JackCycle of Prop
	(properties
		y 151
		x 307
		view 94
		loop 6
		priority 13
	)
)

(instance JackSound of Sound
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

(instance fallBridge of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 3
					setLoop: 0
					setCel: 0
					illegalBits: 0
					setPri: 7
					posn: (+ (gEgo x:) 7) (+ (gEgo y:) 1)
				)
				(unSafeBridge setCel: 1)
				(= cycles 3)
			)
			(2
				(gEgo setCel: 1 posn: (+ (gEgo x:) 7) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(3
				(gEgo setCel: 2 posn: (+ (gEgo x:) 12) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(4
				(gEgo setCel: 3 posn: (+ (gEgo x:) 15) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(5
				(gEgo setCel: 4 posn: (+ (gEgo x:) 1) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(6
				(gEgo posn: (+ (gEgo x:) 2) (+ (gEgo y:) 5))
				(= cycles 3)
			)
			(7
				(gEgo posn: (+ (gEgo x:) 0) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(8
				(gEgo posn: (+ (gEgo x:) 0) (+ (gEgo y:) 7))
				(= cycles 3)
			)
			(9
				(gEgo hide:)
				(unSafeBridge setCel: 0)
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= cycles 20)
			)
			(10
				(EgoDead ; "I score that about a 3. Those diving lessons were a complete waste. Maybe you should have taken up bowling."
					94
					31
					82
					536
					0
					2
					80
					{I wasn't ready.}
				)
				(self dispose:)
			)
		)
	)
)

(instance fallChasm of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= cycles 5)
			)
			(1
				(gEgo setLoop: 2)
				(= cycles 5)
			)
			(2
				(gEgo
					view: 537
					setLoop: 0
					cel: 0
					setPri: 7
					illegalBits: 0
					yStep: 8
					cycleSpeed: 5
					posn: (gEgo x:) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(4
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= cycles 20)
			)
			(5
				(EgoDead ; "You see a sign that reads, "Beware of Porcupine". That's odd, you don't see a ... You do, however, see many archers leaning over the chasm edge with arrows pointed toward you. You now have a funny feeling you know who the porcupine is going to be in a few minutes."
					94
					32
					82
					536
					0
					2
					80
					{The thought sends quills up your spine.}
				)
				(self dispose:)
			)
		)
	)
)

(instance egoTripsNorth of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 536
					setLoop: 0
					cel: 0
					setPri: 3
					cycleSpeed: 0
					illegalBits: 0
					ignoreActors:
					setCycle: End
					setMotion: MoveTo (- (gEgo x:) 3) (+ (gEgo y:) 2) self
				)
			)
			(1
				(antwerp
					view: 590
					setLoop: 2
					setCel: 2
					setPri: 4
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					x: (+ (gEgo x:) 3)
					y: 20
					yStep: 4
					init:
				)
				(antwerp setMotion: MoveTo (antwerp x:) (- (gEgo y:) 8) self)
			)
			(2
				(antwerp moveSpeed: 1 cycleSpeed: 1 setCycle: Fwd)
				(= cycles 20)
			)
			(3
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= cycles 20)
			)
			(4
				(EgoDead ; "How embarrassing, to get this far and then fail to see the trip rope. How did they get that Antwerp up there?"
					94
					33
					82
					536
					0
					6
					80
					{This is a ridiculous way to die}
				)
				(self dispose:)
			)
		)
	)
)

(instance egoTripsSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 536
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					illegalBits: 0
					setCycle: End
					setMotion:
						MoveTo
						(- (gEgo x:) 3)
						(- (gEgo y:) 12)
						self
				)
				(if (not (rm94 notify: 1))
					(JackCycle setScript: jackJumps)
				)
			)
			(1
				(gEgo
					view: 515
					setLoop: 1
					setCel: 4
					cycleSpeed: 3
					setCycle: Beg self
				)
			)
			(2
				(NormalEgo)
				(gEgo loop: 3)
				(= cycles 2)
			)
			(3
				(NormalEgo)
				(gEgo loop: 1)
				(= cycles 2)
			)
			(4
				(NormalEgo)
				(gEgo loop: 2)
				(= cycles 2)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallRug of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= cycles 5)
			)
			(1
				(gEgo setLoop: 2)
				(= cycles 5)
			)
			(2
				(gEgo
					view: 537
					setLoop: 0
					cel: 0
					setPri: 9
					yStep: 6
					posn: (gEgo x:) (+ (gEgo y:) 3)
				)
				(Rug setCel: 1)
				(= cycles 5)
			)
			(3
				(Rug dispose:)
				(rm94 notify: 8)
				(gEgo
					setPri: 9
					cycleSpeed: 5
					posn: (gEgo x:) (+ (gEgo y:) 3)
					setCycle: End self
				)
			)
			(4
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				(= cycles 1)
			)
			(5
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 8))
				(= cycles 1)
			)
			(6
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 12))
				(= cycles 1)
			)
			(7
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 13))
				(= cycles 1)
			)
			(8
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 13))
				(= cycles 1)
			)
			(9
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= cycles 20)
			)
			(10
				(EgoDead ; "There is a small sign which reads "Booby Trap". You are now in a pitiful situation as you hear the brigands approach to see the booby they've caught. You think to yourself, "If it looks like a trap, and it feels like a trap, then maybe it IS a trap"."
					94
					34
					82
					536
					0
					2
					80
					{The old "rug over the pit" trick.}
				)
				(self dispose:)
			)
		)
	)
)

(instance fallRugs of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 3
					setLoop: 1
					setCel: 0
					illegalBits: 0
					setPri: 10
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 1)
				)
				(rugs setCel: 1)
				(= cycles 3)
			)
			(2
				(gEgo setCel: 1 posn: (- (gEgo x:) 7) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(3
				(gEgo setCel: 2 posn: (- (gEgo x:) 10) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(4
				(Rug setCel: 1)
				(gEgo setCel: 3 posn: (- (gEgo x:) 13) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(5
				(gEgo setCel: 4 posn: (- (gEgo x:) 0) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(6
				(Rug dispose:)
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 5))
				(= cycles 3)
			)
			(7
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(8
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 7))
				(= cycles 3)
			)
			(9
				(gEgo hide:)
				(unSafeBridge setCel: 0)
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= cycles 20)
			)
			(10
				(EgoDead ; "You seem to be having a rugged time of it. You've had a terrible ca-tapestry."
					94
					35
					82
					536
					0
					2
					80
					{A travelling man.}
				)
				(self dispose:)
			)
		)
	)
)

(instance jackJumps of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(jack1 init: setPri: 13)
				(rm94 notify: 1)
				(= cycles 5)
			)
			(2
				(jack1 dispose:)
				(JackCycle init: show: setPri: 13 setCycle: CT 1 1 self)
				(JackSound number: (SoundFX 81) init: loop: 1 play:)
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
			)
			(3
				(JackCycle setCel: 2 setCycle: End self)
				(JackSound play:)
			)
			(4
				(JackCycle cycleSpeed: 1 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(5
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(6
				(JackCycle cycleSpeed: 2 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(7
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(8
				(JackCycle cycleSpeed: 3 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(9
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(10
				(JackCycle cycleSpeed: 4 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(11
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(12
				(JackCycle cycleSpeed: 5 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(13
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(14
				(JackCycle cycleSpeed: 6 setCycle: End self)
				(JackSound play:)
			)
			(15
				(JackSound dispose:)
				(self dispose:)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door cycleSpeed: 2 setCycle: End self)
			)
			(1
				(rm94 notify: 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeGate of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door cycleSpeed: 2 setCycle: Beg self)
			)
			(1
				(rm94 notify: 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stepOverN of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rm94 notify: 6)
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo y:) 77)
					(gEgo setMotion: MoveTo (gEgo x:) 90 self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 69 self)
				)
			)
			(1
				(rm94 notify: 7)
				(if (< (gEgo y:) 77)
					(gEgo setMotion: MoveTo 214 67 self)
				else
					(gEgo illegalBits: $8000)
					(self changeState: 3)
				)
			)
			(2
				(door setCel: 2 setPri: 1 init:)
				(= cycles 1)
			)
			(3
				(rm94 notify: 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stepOverS of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rm94 notify: 6)
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo y:) 156)
					(gEgo setMotion: MoveTo (gEgo x:) 168 self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 150 self)
				)
			)
			(1
				(rm94 notify: 7)
				(gEgo illegalBits: $8000)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

