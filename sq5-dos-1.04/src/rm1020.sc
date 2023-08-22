;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1020)
(include sci.sh)
(use Main)
(use Scaler)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1020 0
)

(local
	[local0 36]
	local36
	local37
	[local38 12] = [67 63 112 239 125 125 172 236 190 172 188 188]
	[local50 12] = [43 110 77 66 80 100 96 43 74 87 88 109]
	[local62 284] = [4 3 2 155 108 3 0 155 109 1 0 156 109 1 2 155 109 1 4 0 154 110 3 2 2 156 109 2 1 157 109 2 0 158 109 3 3 2 157 109 3 1 156 109 3 0 155 109 1 5 0 154 110 4 0 1 154 110 0 0 155 110 2 0 157 110 2 1 156 110 5 0 4 153 110 0 3 154 110 0 2 157 110 0 1 158 109 0 0 159 110 5 1 4 159 109 1 3 158 110 1 2 156 109 1 1 155 109 1 0 154 109 5 1 0 165 109 1 1 162 107 1 2 163 108 1 3 163 108 1 4 163 108 5 3 0 161 110 3 1 159 109 3 2 159 109 3 3 159 109 3 4 159 109 6 3 0 160 109 3 2 157 109 3 4 157 109 4 0 152 110 2 2 151 109 2 0 152 109 4 10 2 162 110 10 3 158 110 10 4 153 110 10 0 151 110 5 0 0 147 109 0 1 150 107 0 2 149 108 0 3 149 108 0 4 149 108 5 2 0 150 109 2 1 155 107 2 2 155 107 2 3 155 107 2 4 155 107 5 11 1 145 110 11 2 150 110 11 3 154 110 11 5 159 110 11 0 161 110 6 2 0 147 110 2 2 151 110 2 4 151 110 4 0 151 111 3 2 156 110 3 0 154 111]
)

(procedure (localproc_0 param1 param2)
	(return (& param1 (<< $0001 (mod param2 16))))
)

(instance rm1020 of Rm
	(properties
		noun 5
		picture 123
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 675 677 680 676)
		(if (!= (gSq5Music1 number:) 101)
			(gSq5Music1 number: 101 setLoop: -1 play: setVol: 100)
		else
			(gSq5Music1 setVol: 100)
		)
		(gSq5Music2 number: 41 setLoop: -1 play:)
		(grate init: setOnMeCheck: 1 2)
		(NormalEgo 0)
		(gEgo init: posn: 100 100 setScale: Scaler 100 12 146 98 hide:)
		(switch gPrevRoomNum
			(1025
				(if (IsFlag 248)
					(gEgo
						view: 677
						setLoop: -1
						setLoop: 0
						cel: (gEgo lastCel:)
						setCycle: 0
						x: 156
						y: 147
						show:
						setScript: sRogYanked
					)
				else
					(gEgo
						view: 675
						setLoop: -1
						setLoop: 5
						cel: 0
						x: 155
						y: 147
						setCycle: 0
						show:
					)
					(= local37 1)
				)
			)
			(1010
				(gEgo
					view: 675
					cel: 0
					x: 155
					y: 110
					setCycle: Walk
					setLoop: -1
					setLoop: 4
					show:
				)
			)
			(else
				(switch gGoliathFloorNum
					(1
						(= global135 7)
					)
					(2
						(= global135 2)
					)
					(3
						(= global135 1)
					)
					(4
						(if (== global134 2)
							(= global135 15)
						else
							(= global135 0)
						)
					)
					(5
						(= global135 0)
					)
					(6
						(if (== global134 2)
							(= global135 2)
						else
							(= global135 14)
						)
					)
					(7
						(cond
							((== global134 1)
								(= global135 0)
							)
							((== global134 2)
								(= global135 7)
							)
							(else
								(= global135 2)
							)
						)
					)
					(8
						(if (== global134 1)
							(= global135 2)
						else
							(= global135 0)
						)
					)
					(9
						(= global135 0)
					)
				)
			)
		)
		(switch gGoliathFloorNum
			(1
				(eView1 cel: 0)
			)
			(2
				(eView1 cel: 1)
			)
			(3
				(eView1 cel: 3)
			)
			(4
				(eView1 cel: 4)
			)
			(5
				(eView1 cel: 5)
			)
			(6
				(eView1 cel: 6)
			)
			(7
				(if (== global134 1)
					(eView1 cel: 7)
				else
					(eView1 cel: 8)
				)
			)
			(8
				(if (== global134 1)
					(eView1 cel: 9)
				else
					(eView1 cel: 10)
				)
			)
			(9
				(eView1 cel: 11)
			)
		)
		(eView1
			x: [local38 (eView1 cel:)]
			y: [local50 (eView1 cel:)]
			init:
			setPri: 8
			ignoreActors:
		)
		(switch gGoliathFloorNum
			(1
				(= [local0 0] 6)
				(= [local0 1] 10)
				(= [local0 2] 12)
				(= [local0 6] 5)
				(= [local0 7] 21)
				(= [local0 8] 5)
				(= [local0 12] 3)
				(= [local0 13] 11)
				(= [local0 14] 9)
			)
			(2
				(= [local0 2] 21)
				(= [local0 6] 2)
				(= [local0 7] 14)
				(= [local0 8] 15)
				(= [local0 9] 12)
				(= [local0 12] 6)
				(= [local0 13] 15)
				(= [local0 14] 9)
				(= [local0 15] 1)
				(= [local0 18] 3)
				(= [local0 19] 11)
				(= [local0 20] 12)
				(= [local0 26] 33)
			)
			(3
				(= [local0 1] 21)
				(= [local0 6] 2)
				(= [local0 7] 15)
				(= [local0 8] 8)
				(= [local0 12] 6)
				(= [local0 13] 15)
				(= [local0 14] 12)
				(= [local0 18] 3)
				(= [local0 19] 11)
				(= [local0 20] 9)
			)
			(4
				(= [local0 0] 21)
				(= [local0 2] 4)
				(= [local0 6] 3)
				(= [local0 7] 14)
				(= [local0 8] 15)
				(= [local0 9] 8)
				(= [local0 13] 3)
				(= [local0 14] 13)
				(= [local0 15] 21)
				(= [local0 16] 4)
				(= [local0 19] 2)
				(= [local0 20] 15)
				(= [local0 21] 15)
				(= [local0 22] 15)
				(= [local0 23] 8)
				(= [local0 26] 1)
				(= [local0 27] 3)
				(= [local0 28] 9)
			)
			(5
				(= [local0 0] 21)
				(= [local0 6] 5)
				(= [local0 12] 5)
				(= [local0 18] 5)
				(= [local0 24] 5)
				(= [local0 30] 1)
			)
			(6
				(= [local0 1] 4)
				(= [local0 2] 21)
				(= [local0 6] 6)
				(= [local0 7] 15)
				(= [local0 8] 9)
				(= [local0 12] 3)
				(= [local0 13] 13)
				(= [local0 14] 21)
				(= [local0 15] 4)
				(= [local0 18] 2)
				(= [local0 19] 15)
				(= [local0 20] 15)
				(= [local0 21] 9)
				(= [local0 25] 7)
				(= [local0 26] 9)
				(= [local0 31] 1)
			)
			(7
				(if (== global134 1)
					(= [local0 0] 21)
					(= [local0 1] 6)
					(= [local0 2] 12)
					(= [local0 6] 5)
					(= [local0 7] 1)
					(= [local0 8] 5)
					(= [local0 12] 3)
					(= [local0 13] 10)
					(= [local0 14] 9)
				else
					(= [local0 2] 21)
					(= [local0 7] 21)
					(= [local0 8] 5)
					(= [local0 12] 2)
					(= [local0 13] 15)
					(= [local0 14] 15)
					(= [local0 15] 8)
					(= [local0 19] 1)
					(= [local0 20] 1)
				)
			)
			(8
				(if (== global134 1)
					(= [local0 1] 4)
					(= [local0 2] 21)
					(= [local0 6] 2)
					(= [local0 7] 15)
					(= [local0 8] 9)
					(= [local0 13] 5)
					(= [local0 19] 1)
				else
					(= [local0 0] 21)
					(= [local0 6] 5)
					(= [local0 12] 1)
				)
			)
			(9
				(= [local0 0] 21)
				(= [local0 6] 5)
				(= [local0 12] 1)
			)
		)
		(super init:)
		(arrowBase init:)
		(gDirectionHandler addToFront: arrowBase)
		(gWalkHandler addToFront: arrowBase)
		(gCurRoom setScript: sUpdateRoom 0 1)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 0 (Random 1 3))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSq5Music2 fade: 0 20 20 1)
		(theMusic3 dispose:)
		(gDirectionHandler delete: arrowBase)
		(gWalkHandler delete: arrowBase)
		(super dispose: &rest)
	)
)

(instance sChangeDir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local36 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 675
					loop: [local62 (+ register 1 (* 4 local36))]
					cel: [local62 (+ register 2 (* 4 local36))]
					x: [local62 (+ register 3 (* 4 local36))]
					y: [local62 (+ register 4 (* 4 local36))]
				)
				(if (< (++ local36) [local62 register])
					(-- state)
				)
				(= cycles 3)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sUpdateRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(gCurRoom drawPic: 123)
				)
				(eView2
					cel: (mod global135 6)
					x: [local38 (mod global135 6)]
					y: [local50 (mod global135 6)]
					init:
					setPri: 8
					ignoreActors:
				)
				(eView3
					cel: (+ 6 (/ global135 6))
					x: [local38 (+ 6 (/ global135 6))]
					y: [local50 (+ 6 (/ global135 6))]
					init:
					setPri: 8
					ignoreActors:
				)
				(if (localproc_0 [local0 global135] 5)
					(shieldSwitch init:)
					(SetScore 247 350)
				else
					(shieldSwitch dispose:)
				)
				(if (localproc_0 [local0 global135] 4)
					(northBlocked loop: 15 x: 147 y: 88 setPri: 6 init:)
					(if
						(and
							(or (== gPrevRoomNum 1030) (== gPrevRoomNum 1035))
							(== local37 0)
						)
						(northBlocked cel: (northBlocked lastCel:))
					else
						(northBlocked cel: 0)
					)
					(floorNumber cel: (- gGoliathFloorNum 1) init:)
				else
					(floorNumber dispose:)
					(if (localproc_0 [local0 global135] 0)
						(northBlocked dispose:)
					else
						(northBlocked loop: 5 cel: 0 x: 147 y: 88 init:)
					)
				)
				(if (localproc_0 [local0 global135] 3)
					(westBlocked dispose:)
				else
					(westBlocked init:)
				)
				(if (localproc_0 [local0 global135] 1)
					(eastBlocked dispose:)
				else
					(eastBlocked init:)
				)
				(upArrow init: setCel: 0)
				(downArrow init: setCel: 0)
				(leftArrow init: setCel: 0)
				(rightArrow init: setCel: 0)
				(if (and (== gPrevRoomNum 1025) (== local37 0))
					(self dispose:)
				)
				(= cycles 1)
			)
			(1
				(switch local37
					(4
						(sEnterNorth register: 0)
						(= next sEnterNorth)
					)
					(8
						(= next sEnterEast)
					)
					(1
						(= next sEnterSouth)
					)
					(2
						(= next sEnterWest)
					)
					(0
						(sEnterNorth register: 1)
						(= next sEnterNorth)
					)
				)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 151
					y: 110
					setCycle: Fwd
					setLoop: -1
					setLoop: 10
					setMotion: MoveTo 95 110 self
				)
			)
			(1
				(if (and (== gGoliathFloorNum 8) (== global135 7) (not (IsFlag 124)))
					(= next sPacman)
					(self dispose:)
				else
					(-= global135 1)
					(gEgo hide:)
					(= next sUpdateRoom)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 161
					y: 110
					setCycle: Fwd
					setLoop: -1
					setLoop: 11
					setMotion: MoveTo 185 110 self
				)
			)
			(1
				(+= global135 1)
				(gEgo hide:)
				(= next sUpdateRoom)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (localproc_0 [local0 global135] 4)
					(gCurRoom setScript: sEnterTurbo)
				else
					(gGame handsOff:)
					(gEgo
						view: 675
						cel: 0
						x: 154
						y: 109
						setCycle: Fwd
						setLoop: -1
						setLoop: 5
						setMotion: MoveTo 155 99 self
					)
				)
			)
			(1
				(-= global135 6)
				(gEgo hide:)
				(= next sUpdateRoom)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 154
					y: 109
					setCycle: Fwd
					setLoop: -1
					setLoop: 4
					show:
					setMotion: MoveTo 155 147 self
				)
			)
			(1
				(+= global135 6)
				(gEgo hide:)
				(= next sUpdateRoom)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 100
					y: 110
					setCycle: Fwd
					setLoop: -1
					setLoop: 11
					show:
					setMotion: MoveTo 140 110 self
				)
			)
			(1
				(gEgo setCycle: 0)
				(gGame handsOn:)
			)
			(2
				(switch local37
					(1
						(self setScript: sChangeDir self 196)
						(= next sExitNorth)
					)
					(2
						(self setScript: sChangeDir self 238)
						(= next sExitEast)
					)
					(4
						(self setScript: sChangeDir self 217)
						(= next sExitSouth)
					)
					(8
						(self setScript: sChangeDir self 259)
						(= next sExitWest)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 175
					y: 110
					setCycle: Fwd
					setLoop: -1
					setLoop: 10
					show:
					setMotion: MoveTo 165 110 self
				)
			)
			(1
				(gEgo setCycle: 0)
				(gGame handsOn:)
			)
			(2
				(switch local37
					(1
						(self setScript: sChangeDir self 112)
						(= next sExitNorth)
					)
					(2
						(self setScript: sChangeDir self 154)
						(= next sExitEast)
					)
					(4
						(self setScript: sChangeDir self 133)
						(= next sExitSouth)
					)
					(8
						(self setScript: sChangeDir self 179)
						(= next sExitWest)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo
						view: 675
						cel: 0
						x: 155
						y: 110
						setCycle: Walk
						setLoop: -1
						setLoop: 4
						show:
					)
					(if
						(and
							(localproc_0 [local0 global135] 4)
							(!= gPrevRoomNum 1010)
						)
						(theMusic3 number: 103 setLoop: 1 play:)
						(northBlocked setCycle: Beg self)
					else
						(northBlocked cel: 0)
						(= cycles 1)
					)
				else
					(gEgo
						view: 675
						cel: 0
						x: 155
						y: 99
						setCycle: Walk
						setLoop: -1
						setLoop: 4
						show:
						setMotion: MoveTo 155 110 self
					)
				)
			)
			(1
				(gGame handsOn:)
			)
			(2
				(switch local37
					(1
						(self setScript: sChangeDir self 0)
						(= next sExitNorth)
					)
					(2
						(self setScript: sChangeDir self 22)
						(= next sExitEast)
					)
					(4
						(self setScript: sChangeDir self 17)
						(= next sExitSouth)
					)
					(8
						(self setScript: sChangeDir self 35)
						(= next sExitWest)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 675
					cel: 0
					x: 155
					y: 147
					setCycle: Fwd
					setLoop: -1
					setLoop: 5
					show:
					setMotion: MoveTo 155 111 self
				)
			)
			(1
				(gEgo setCycle: 0)
				(gGame handsOn:)
			)
			(2
				(switch local37
					(1
						(self setScript: sChangeDir self 48)
						(= next sExitNorth)
					)
					(2
						(self setScript: sChangeDir self 70)
						(= next sExitEast)
					)
					(4
						(self setScript: sChangeDir self 53)
						(= next sExitSouth)
					)
					(8
						(self setScript: sChangeDir self 91)
						(= next sExitWest)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEnterTurbo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 103 setLoop: 1 play:)
				(northBlocked setCycle: End self)
			)
			(1
				(switch gGoliathFloorNum
					(1
						(gCurRoom newRoom: 1035)
					)
					(2
						(gCurRoom newRoom: 1035)
					)
					(3
						(gCurRoom newRoom: 1030)
					)
					(4
						(if (== global135 0)
							(= global134 3)
							(gCurRoom newRoom: 1030)
						else
							(= global134 2)
							(gCurRoom newRoom: 1035)
						)
					)
					(5
						(gCurRoom newRoom: 1035)
					)
					(6
						(if (== global135 2)
							(= global134 2)
							(gCurRoom newRoom: 1030)
						else
							(= global134 1)
							(gCurRoom newRoom: 1035)
						)
					)
					(7
						(cond
							((== global134 1)
								(gCurRoom newRoom: 1035)
							)
							((== global135 2)
								(= global134 3)
								(gCurRoom newRoom: 1030)
							)
							(else
								(= global134 2)
								(gCurRoom newRoom: 1030)
							)
						)
					)
					(8
						(gCurRoom newRoom: 1030)
					)
					(9
						(gCurRoom newRoom: 1030)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sTouchSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gEgo loop:) 5)
					(self setScript: sChangeDir self 17)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setCycle: Fwd setMotion: MoveTo 156 147 self)
			)
			(2
				(gEgo
					view: 677
					loop: 0
					cel: 0
					x: 156
					y: 147
					setScale: Scaler 100 12 146 98
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: 1025)
				(self dispose:)
			)
		)
	)
)

(instance sRogYanked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard
					view: 676
					loop: 7
					cel: 0
					x: 115
					y: 52
					init:
					setCycle: End self
				)
				(gSq5Music1 number: 10 setLoop: -1 play:)
			)
			(1
				(gCurRoom newRoom: 1040)
				(self dispose:)
			)
		)
	)
)

(instance sPacman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 675
					cel: 0
					x: 130
					setCycle: Fwd
					setLoop: -1
					setLoop: 11
					setMotion: MoveTo 190 110 self
				)
			)
			(1
				(pacman
					init:
					setCycle: Fwd
					setMotion: MoveTo 185 (pacman y:) self
				)
			)
			(2
				(= local37 2)
				(SetFlag 124)
				(+= global135 1)
				(gEgo hide:)
				(pacman dispose:)
				(= next sUpdateRoom)
				(self dispose:)
			)
		)
	)
)

(instance guard of Prop
	(properties
		x 157
		y 52
		noun 4
		view 676
	)
)

(instance pacman of Actor
	(properties
		x 135
		y 100
		view 3000
	)
)

(instance eastBlocked of View
	(properties
		x 166
		y 89
		view 676
		loop 10
		signal 16384
	)
)

(instance westBlocked of View
	(properties
		x 140
		y 89
		view 676
		loop 9
		signal 16384
	)
)

(instance northBlocked of Prop
	(properties
		x 147
		y 88
		view 676
		loop 5
		signal 16384
	)
)

(instance floorNumber of View
	(properties
		x 220
		y 70
		view 676
		loop 4
		priority 9
		signal 16400
	)
)

(instance eView1 of View
	(properties
		view 676
		loop 2
		priority 7
		signal 16400
	)
)

(instance eView2 of View
	(properties
		view 676
		loop 2
		priority 7
		signal 16400
	)
)

(instance eView3 of View
	(properties
		view 676
		loop 2
		priority 7
		signal 16400
	)
)

(instance arrowBase of View
	(properties
		x 255
		z -76
		view 680
		priority 14
		signal 20496
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(gUser canControl:)
					(& (event type:) $0040) ; direction
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(switch (event message:)
					(JOY_UP
						(upArrow doVerb: 4)
					)
					(JOY_UPRIGHT
						(upArrow doVerb: 4)
					)
					(JOY_RIGHT
						(rightArrow doVerb: 4)
					)
					(JOY_DOWNRIGHT
						(downArrow doVerb: 4)
					)
					(JOY_DOWN
						(downArrow doVerb: 4)
					)
					(JOY_DOWNLEFT
						(downArrow doVerb: 4)
					)
					(JOY_LEFT
						(leftArrow doVerb: 4)
					)
					(JOY_UPLEFT
						(upArrow doVerb: 4)
					)
				)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(gUser canControl:)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(event claimed: 1)
				(return 0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance leftArrow of View
	(properties
		x 258
		y 94
		view 680
		loop 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (localproc_0 [local0 global135] 3)
					(= local37 8)
					((gCurRoom script:) cue:)
					(self setCel: 1)
				else
					(gMessager say: 2 0 0 0) ; "You can't go that way."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightArrow of View
	(properties
		x 303
		y 94
		view 680
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (localproc_0 [local0 global135] 1)
					(= local37 2)
					((gCurRoom script:) cue:)
					(self setCel: 1)
				else
					(gMessager say: 2 0 0 0) ; "You can't go that way."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upArrow of View
	(properties
		x 278
		y 77
		view 680
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (localproc_0 [local0 global135] 0)
					(= local37 1)
					((gCurRoom script:) cue:)
					(self setCel: 1)
				else
					(gMessager say: 2 0 0 0) ; "You can't go that way."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance downArrow of View
	(properties
		x 278
		y 115
		view 680
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (localproc_0 [local0 global135] 2)
					(= local37 4)
					((gCurRoom script:) cue:)
					(self setCel: 1)
				else
					(gMessager say: 2 0 0 0) ; "You can't go that way."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shieldSwitch of View
	(properties
		x 84
		y 69
		view 677
		loop 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTouchSwitch)
			)
			(1 ; Look
				(gCurRoom setScript: sTouchSwitch)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grate of Feature
	(properties
		x 160
		y 100
		noun 3
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (== gGoliathFloorNum 2) (== global135 26))
					(gMessager say: 1 0 0 0) ; "You're directly below the bridge. It probably wouldn't be wise to pop up for a quick visit."
				else
					(gCurRoom newRoom: 1010)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

