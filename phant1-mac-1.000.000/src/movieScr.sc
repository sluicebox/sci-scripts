;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Array)
(use Window)
(use System)

(public
	proc26_0 0
	movieScr 1
	myHotSet 2
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
)

(procedure (proc26_0 param1 param2 param3)
	(= local3 0)
	(if (and (> argc 1) param2)
		(= local0 param2)
	else
		(= local0 0)
	)
	(if (and (> argc 2) param3)
		(= local3 1)
	)
	(= local2 param1)
	((ScriptID 0 9) enable: 0) ; lookIcon
	(if (IsFlag 121)
		(= local7 0)
	else
		(= local7 1)
	)
	(gGame setScript: (ScriptID 26 1)) ; movieScr
)

(instance movieScr of Script
	(properties)

	(method (init)
		(if local0
			(= caller local0)
		)
		(= cycles (= register 0))
		(SetFlag 248)
		(if local3
			(cond
				((not global192) 0)
				((!= global192 gTheCursor) 0)
				((== global192 gNormalCursor)
					(global192 loop: 0 cel: 1)
					(global192 init:)
				)
				(global161
					(global192
						view: (global161 loliteView:)
						loop: (global161 loop:)
						cel: (global161 cel:)
					)
					(global192 init:)
				)
			)
			(= global192 0)
			(= global118 0)
			(= global193 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (global114 mySound:)
					(= local8 ((global114 mySound:) number:))
				else
					(= local8 -1)
				)
				(global114 stop: 1)
				(if (gGDacSound handle:)
					(= local9 (gGDacSound number:))
					(gGDacSound stop:)
				else
					(= local9 -1)
				)
				(= temp0 16)
				(if (and (not (IsFlag 145)) (not (= scratch (IsFlag 121))))
					(SetFlag 121)
				)
				(if (IsFlag 236)
					(|= temp0 $0004)
				)
				(if local3
					(PlayVMD 23 55 235) ; RestrictPalette
				)
				(if (IsFlag 127)
					(PlayVMD 1 26 28 (| temp0 $0001) global189 55 236) ; Put
					(PlayVMD 21 13 11 305 140) ; Black
				else
					(if (!= gCurRoomNum 100) ; introRoom
						((ScriptID 0 11) priority: 5000) ; overlayPlane
						(UpdatePlane (ScriptID 0 11)) ; overlayPlane
					)
					(PlayVMD 21 86 41 235 106) ; Black
					(PlayVMD 1 174 95 temp0 global189 55 236) ; Put
				)
				(= global206 1)
				(= cycles 1)
			)
			(1
				((gUser curEvent:) new:)
				(while ((gUser curEvent:) type:)
					((gUser curEvent:) new:)
				)
				(if (IsFlag 135)
					(= local3 0)
				)
				(if (not local3)
					(if (IsFlag 63)
						(if (IsFlag 135)
							(PlayVMD 16 1) ; ShowCursor
						else
							(PlayVMD 16 0) ; ShowCursor
						)
						(if
							(and
								(IsFlag 135)
								(== local2 1010)
								(!= global179 3)
							)
							(PlayVMD 14 19 131) ; WaitEvent
						else
							(PlayVMD 14 3) ; WaitEvent
						)
						(self dispose:)
					else
						(if
							(and
								(IsFlag 135)
								(== local2 1010)
								(!= global179 3)
							)
							(PlayVMD 14 19 131) ; WaitEvent
						else
							(myList init:)
							(PlayVMD 17) ; StartBlob
							(if (IsFlag 135)
								(PlayVMD 16 1) ; ShowCursor
							else
								(PlayVMD 16 0) ; ShowCursor
							)
							(= local4 0)
							(= local5 0)
							(while
								(==
									(PlayVMD 14 19 ((myList at: local4) at: 1)) ; WaitEvent
									1
								)
								((gUser curEvent:) new:)
								(while ((gUser curEvent:) type:)
									((gUser curEvent:) new:)
								)
								(PlayVMD 18) ; StopBlobs
								(PlayVMD 17) ; StartBlob
								(if (== ((myList at: local4) at: 2) -1)
									(break)
								)
								(while (!= ((myList at: (++ local4)) at: 0) -1)
									(= local6
										(PlayVMD
											19 ; AddBlob
											10
											((myList at: local4) at: 1)
											((myList at: local4) at: 0)
											((myList at: local4) at: 3)
											((myList at: local4) at: 2)
										)
									)
								)
							)
							(PlayVMD 18) ; StopBlobs
							(myList dispose:)
						)
						(self dispose:)
					)
				else
					(= global206 2)
					(PlayVMD 16 1) ; ShowCursor
					(= temp0 45)
					(while (not (OneOf (PlayVMD 14 temp0 2) 1 64)) ; WaitEvent
						(myHotSet check:)
						(gTheDoits doit:)
						(FrameOut)
						(if register
							(break)
						)
					)
					(self dispose:)
					(PlayVMD 23 0 255) ; RestrictPalette
				)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= cycles 0)
		(= register 1)
		(if
			(and
				(not (OneOf gCurRoomNum 46790 46780 40100))
				(not (IsFlag 418))
			)
			((ScriptID 0 11) priority: (- ((gCurRoom plane:) priority:) 1)) ; overlayPlane
			(UpdatePlane (ScriptID 0 11)) ; overlayPlane
		)
		(PlayVMD 6) ; Close
		((gUser curEvent:) new:)
		(while ((gUser curEvent:) type:)
			((gUser curEvent:) new:)
		)
		(= local2 0)
		(if (and (not scratch) local7)
			(ClearFlag 121)
		)
		(if (global116 contains: gTextHelp)
			(gTextHelp dispose:)
		)
		(if (!= local8 -1)
			(global114 play: local8)
		)
		(if (!= local9 -1)
			(gGDacSound play: local9)
		)
		(gGDacSound play:)
		(= global206 0)
		(ClearFlag 248)
		((ScriptID 0 9) enable: 1) ; lookIcon
		(FrameOut)
		(super dispose:)
	)
)

(instance myHotSet of HotRectangleSet
	(properties)
)

(instance myList of List
	(properties)

	(method (init)
		(super init: &rest)
		(switch local2
			(10
				(self
					add: (IntArray with: -1 1396 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 1442 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1014
				(self
					add: (IntArray with: -1 47 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1020
				(self
					add: (IntArray with: -1 202 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1030
				(self
					add: (IntArray with: -1 161 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1040
				(self
					add: (IntArray with: -1 222 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1050
				(self
					add: (IntArray with: -1 246 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1060
				(self
					add: (IntArray with: -1 130 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1102
				(self
					add: (IntArray with: -1 159 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1111
				(self
					add: (IntArray with: -1 160 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1120
				(self
					add: (IntArray with: -1 190 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1130
				(self
					add: (IntArray with: -1 164 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1140
				(self
					add: (IntArray with: -1 193 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1150
				(self
					add: (IntArray with: -1 476 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1200
				(self
					add: (IntArray with: -1 86 0 0)
					add: (IntArray with: 110 32 210 136)
					add: (IntArray with: -1 89 0 0)
					add: (IntArray with: -1 191 0 0)
					add: (IntArray with: 166 22 238 88)
					add: (IntArray with: -1 236 0 0)
					add: (IntArray with: -1 286 0 0)
					add: (IntArray with: 150 38 238 105)
					add: (IntArray with: -1 374 0 0)
					add: (IntArray with: -1 802 0 0)
					add: (IntArray with: 216 90 287 143)
					add: (IntArray with: -1 822 0 0)
					add: (IntArray with: -1 1460 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 1464 0 0)
					add: (IntArray with: -1 1490 0 0)
					add: (IntArray with: 80 36 220 143)
					add: (IntArray with: -1 1516 0 0)
					add: (IntArray with: -1 1572 0 0)
					add: (IntArray with: 54 0 210 143)
					add: (IntArray with: -1 1585 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1400
				(self
					add: (IntArray with: -1 292 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 296 0 0)
					add: (IntArray with: -1 322 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 347 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1502
				(self
					add: (IntArray with: -1 99 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 101 0 0)
					add: (IntArray with: -1 115 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 125 0 0)
					add: (IntArray with: -1 180 -1 -1)
				)
			)
			(1520
				(self
					add: (IntArray with: -1 141 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 143 0 0)
					add: (IntArray with: -1 156 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 167 0 0)
					add: (IntArray with: -1 221 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 227 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1600
				(self
					add: (IntArray with: -1 250 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 253 0 0)
					add: (IntArray with: -1 266 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 277 0 0)
					add: (IntArray with: -1 331 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 338 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1720
				(self
					add: (IntArray with: -1 133 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 135 0 0)
					add: (IntArray with: -1 149 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 159 0 0)
					add: (IntArray with: -1 214 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 219 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1920
				(self
					add: (IntArray with: -1 221 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 225 0 0)
					add: (IntArray with: -1 251 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 279 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(1930
				(self
					add: (IntArray with: -1 179 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 182 0 0)
					add: (IntArray with: -1 199 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 216 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(2020
				(self
					add: (IntArray with: -1 335 0 0)
					add: (IntArray with: 144 18 287 120)
					add: (IntArray with: -1 339 0 0)
					add: (IntArray with: -1 352 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 362 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(2120
				(self
					add: (IntArray with: -1 198 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 200 0 0)
					add: (IntArray with: -1 218 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 234 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(2320
				(self
					add: (IntArray with: -1 194 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 196 0 0)
					add: (IntArray with: -1 214 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 231 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(2420
				(self
					add: (IntArray with: -1 158 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 160 0 0)
					add: (IntArray with: -1 178 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 195 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(3980
				(self
					add: (IntArray with: -1 600 0 0)
					add: (IntArray with: 100 76 184 143)
					add: (IntArray with: -1 815 0 0)
					add: (IntArray with: -1 1155 0 0)
					add: (IntArray with: 10 0 287 143)
					add: (IntArray with: -1 1177 0 0)
					add: (IntArray with: 120 20 184 143)
					add: (IntArray with: -1 1297 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 1372 0 0)
					add: (IntArray with: 120 20 184 143)
					add: (IntArray with: -1 1406 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 1527 0 0)
					add: (IntArray with: 120 20 184 143)
					add: (IntArray with: -1 1597 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(4010
				(self
					add: (IntArray with: -1 239 0 0)
					add: (IntArray with: 0 0 287 80)
					add: (IntArray with: -1 264 0 0)
					add: (IntArray with: -1 287 0 0)
					add: (IntArray with: 128 46 180 90)
					add: (IntArray with: -1 314 0 0)
					add: (IntArray with: -1 315 0 0)
					add: (IntArray with: 40 80 230 143)
					add: (IntArray with: -1 347 0 0)
					add: (IntArray with: -1 383 0 0)
					add: (IntArray with: 56 0 248 143)
					add: (IntArray with: -1 434 0 0)
					add: (IntArray with: -1 435 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 471 0 0)
					add: (IntArray with: -1 497 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 577 0 0)
					add: (IntArray with: -1 578 0 0)
					add: (IntArray with: 50 24 130 130)
					add: (IntArray with: 162 100 246 134)
					add: (IntArray with: -1 613 0 0)
					add: (IntArray with: -1 643 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 742 0 0)
					add: (IntArray with: -1 743 0 0)
					add: (IntArray with: 50 24 130 130)
					add: (IntArray with: 162 100 246 134)
					add: (IntArray with: -1 765 0 0)
					add: (IntArray with: -1 766 0 0)
					add: (IntArray with: 0 0 287 143)
					add: (IntArray with: -1 853 0 0)
					add: (IntArray with: -1 854 0 0)
					add: (IntArray with: 50 24 150 130)
					add: (IntArray with: 162 100 246 134)
					add: (IntArray with: -1 882 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(4550
				(self
					add: (IntArray with: -1 797 0 0)
					add: (IntArray with: 85 90 195 143)
					add: (IntArray with: -1 801 0 0)
					add: (IntArray with: -1 868 0 0)
					add: (IntArray with: 105 25 287 143)
					add: (IntArray with: -1 877 0 0)
					add: (IntArray with: -1 938 0 0)
					add: (IntArray with: 65 35 251 143)
					add: (IntArray with: -1 953 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(4860
				(self
					add: (IntArray with: -1 574 0 0)
					add: (IntArray with: 70 10 170 140)
					add: (IntArray with: -1 581 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(4950
				(self
					add: (IntArray with: -1 534 0 0)
					add: (IntArray with: 170 46 216 106)
					add: (IntArray with: -1 561 0 0)
					add: (IntArray with: -1 587 0 0)
					add: (IntArray with: 186 68 287 143)
					add: (IntArray with: -1 595 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(5710
				(self
					add: (IntArray with: -1 2473 0 0)
					add: (IntArray with: 86 50 186 112)
					add: (IntArray with: -1 2493 0 0)
					add: (IntArray with: -1 2513 0 0)
					add: (IntArray with: 86 50 186 112)
					add: (IntArray with: -1 2522 0 0)
					add: (IntArray with: -1 2537 0 0)
					add: (IntArray with: 38 0 228 110)
					add: (IntArray with: -1 2546 0 0)
					add: (IntArray with: -1 2561 0 0)
					add: (IntArray with: 24 50 200 130)
					add: (IntArray with: -1 2566 0 0)
					add: (IntArray with: -1 2689 0 0)
					add: (IntArray with: 10 0 220 136)
					add: (IntArray with: -1 2716 0 0)
					add: (IntArray with: -1 3085 0 0)
					add: (IntArray with: 0 0 150 120)
					add: (IntArray with: -1 3197 0 0)
					add: (IntArray with: -1 3229 0 0)
					add: (IntArray with: 108 2 200 38)
					add: (IntArray with: 80 92 170 134)
					add: (IntArray with: -1 3233 0 0)
					add: (IntArray with: 108 2 200 38)
					add: (IntArray with: 80 92 170 134)
					add: (IntArray with: 126 36 170 100)
					add: (IntArray with: -1 3280 0 0)
					add: (IntArray with: -1 3342 0 0)
					add: (IntArray with: 14 4 188 143)
					add: (IntArray with: -1 3401 0 0)
					add: (IntArray with: -1 3420 0 0)
					add: (IntArray with: 88 30 108 46)
					add: (IntArray with: 176 122 208 143)
					add: (IntArray with: -1 3667 0 0)
					add: (IntArray with: -1 3835 0 0)
					add: (IntArray with: 66 50 160 143)
					add: (IntArray with: -1 4068 0 0)
					add: (IntArray with: -1 4069 0 0)
					add: (IntArray with: 44 16 150 96)
					add: (IntArray with: -1 4177 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(9020
				(self
					add: (IntArray with: -1 109 0 0)
					add: (IntArray with: 40 38 287 143)
					add: (IntArray with: -1 113 0 0)
					add: (IntArray with: -1 139 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 165 0 0)
					add: (IntArray with: -1 221 0 0)
					add: (IntArray with: 60 10 200 143)
					add: (IntArray with: -1 235 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(9080
				(self
					add: (IntArray with: -1 160 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 165 0 0)
					add: (IntArray with: -1 190 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 217 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(9090
				(self
					add: (IntArray with: -1 57 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 62 0 0)
					add: (IntArray with: -1 87 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 116 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(9100
				(self
					add: (IntArray with: -1 117 0 0)
					add: (IntArray with: 66 18 287 120)
					add: (IntArray with: -1 122 0 0)
					add: (IntArray with: -1 148 0 0)
					add: (IntArray with: 80 30 220 143)
					add: (IntArray with: -1 176 0 0)
					add: (IntArray with: -1 0 -1 -1)
				)
			)
			(else
				(self add: (IntArray with: -1 0 -1 -1))
			)
		)
	)
)

