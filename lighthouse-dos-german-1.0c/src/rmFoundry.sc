;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use rm400)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rmFoundry 0
)

(local
	local0 = 655
	local1 = 656
	local2 = 657
	local3 = 659
	local4 = 661
	local5 = 663
	local6 = 666
	local7
	local8
	local9
)

(procedure (localproc_0)
	(+= local0 4000)
	(+= local1 4000)
	(+= local2 4000)
	(+= local3 4000)
	(+= local4 4000)
	(+= local5 4000)
	(+= local6 4000)
)

(instance rmFoundry of LightRoom
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(gGame handsOn:)
		(if (IsFlag 208)
			(localproc_0)
		)
		(SetFlag 183)
		(= temp0 (if (Random 0 1) 60005 else 60100))
		(Load rsAUDIO temp0)
		(gBackMusic number: temp0 loop: -1 play: 0 0 fade: 127 25 10 0 0)
		(if 0
			((ScriptID 9 53) state: 1) ; invIngots
			((ScriptID 9 54) state: 1) ; invCoal
			((ScriptID 9 52) state: 1) ; invLogs
			(SetFlag 208)
			(localproc_0)
			(= local8 1)
			(gInventory addItem: (ScriptID 9 55)) ; invMold
			(self changeScene: local6)
			(return)
		)
		(if (== gPrevRoomNum 690)
			(self changeScene: 668)
		else
			(self changeScene: local0)
		)
	)

	(method (changeScene param1 &tmp temp0)
		(if (and (== scene local6) ((ScriptID 9 5) state:)) ; invLighter
			((ScriptID 9 5) state: 0 cel: 0) ; invLighter
		)
		(if local7
			(self setScript: forceCauldronOutScr 0 param1)
			(return)
		)
		(if (IsFlag 233)
			(self setScript: removeCoolMoldScr 0 param1)
			(return)
		)
		(if (== scene local6)
			(coolMoldRbt dispose:)
		)
		(if (IsFlag 247)
			(self setScript: closeMoldScr 0 param1)
			(return)
		)
		(if (and local8 (not (OneOf param1 local6 local5)))
			(= local8 0)
		)
		(forwardLeft dispose:)
		(forwardRight dispose:)
		(forward dispose:)
		(turnMe dispose:)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(super changeScene: param1 &rest)
		(forge loop: 0 x: -1 view: -1)
		(torch loop: 0)
		(if (fireSFX handle:)
			(cond
				((== param1 local5)
					(fireSFX setVol: 127)
				)
				((OneOf param1 local6 664 local3 667 668 660)
					(fireSFX setVol: 95)
				)
				(else
					(fireSFX setVol: 38)
				)
			)
		)
		(cond
			((OneOf param1 664 667)
				(= temp0 127)
			)
			((OneOf param1 local5 local6 local4 668)
				(= temp0 95)
			)
			((== param1 662)
				(= temp0 70)
			)
			(else
				(= temp0 0)
			)
		)
		(cond
			(temp0
				(if (not (torchSFX handle:))
					(torchSFX loop: -1 play: temp0 0)
				else
					(torchSFX setVol: temp0)
				)
			)
			((torchSFX handle:)
				(torchSFX dispose:)
			)
		)
		(switch param1
			(local0
				(proc400_1 3)
				((ScriptID 1 1) newPic: local1) ; exitForward
				((ScriptID 1 2) newRoom: 650) ; exitBack
				(forge x: 164 y: 197)
				(if (IsFlag 208)
					(cauldron655 init:)
				)
				(if
					(and
						(or
							(gInventory contains: (ScriptID 9 54)) ; invCoal
							((ScriptID 9 54) state:) ; invCoal
						)
						(IsFlag 208)
					)
					(coalGone655 init:)
				)
				(if (and ((ScriptID 9 55) state:) (IsFlag 208)) ; invMold
					(tableMold init:)
				)
			)
			(local1
				(proc400_1 3)
				((ScriptID 1 3) newPic: local2) ; exitLeft
				((ScriptID 1 4) newPic: 658) ; exitRight
				((ScriptID 1 2) newRoom: 650) ; exitBack
				(forwardLeft
					nsLeft: 70
					nsTop: 55
					nsRight: 220
					nsBottom: 236
					newPic: local3
				)
				(forwardRight
					nsLeft: 329
					nsTop: 46
					nsRight: 485
					nsBottom: 253
					newPic: local4
				)
				(cond
					((IsFlag 208)
						(cauldron656 init:)
					)
					(
						(or
							((ScriptID 9 52) state:) ; invLogs
							(gInventory contains: (ScriptID 9 52)) ; invLogs
						)
						(woodGone656 init:)
					)
				)
				(if
					(or
						((ScriptID 9 55) state:) ; invMold
						(gInventory contains: (ScriptID 9 55)) ; invMold
					)
					(moldGone656 init:)
				)
				(if
					(or
						((ScriptID 9 54) state:) ; invCoal
						(gInventory contains: (ScriptID 9 54)) ; invCoal
					)
					(coalGone656 init:)
				)
				(if ((ScriptID 9 55) state:) ; invMold
					(tableMold init:)
				)
				(forge x: 155 y: 204)
			)
			(local2
				(proc400_1 4)
				((ScriptID 1 1) newPic: local3) ; exitForward
				((ScriptID 1 4) newPic: local1) ; exitRight
				((ScriptID 1 2) newPic: 660) ; exitBack
				(forge x: 321 y: 207)
				(if
					(or
						((ScriptID 9 55) state:) ; invMold
						(gInventory contains: (ScriptID 9 55)) ; invMold
					)
					(moldGone657 init:)
				)
			)
			(658
				(proc400_1 2)
				((ScriptID 1 3) newPic: local2) ; exitLeft
				((ScriptID 1 1) newPic: local4) ; exitForward
				((ScriptID 1 4) newPic: 660) ; exitRight
				(torch view: 2658 x: 86 y: 168 init:)
				(if
					(or
						(gInventory contains: (ScriptID 9 53)) ; invIngots
						((ScriptID 9 53) state:) ; invIngots
					)
					(ingotsGone658 init:)
				else
					(ingots658 init:)
				)
				(if
					(or
						(gInventory contains: (ScriptID 9 52)) ; invLogs
						((ScriptID 9 52) state:) ; invLogs
					)
					(logsGone658 init:)
				)
				(if ((ScriptID 9 55) state:) ; invMold
					(tableMold init:)
				)
				(if
					(or
						(gInventory contains: (ScriptID 9 54)) ; invCoal
						((ScriptID 9 54) state:) ; invCoal
					)
					(coalGone658 init:)
				)
			)
			(local3
				(proc400_1 4)
				((ScriptID 1 2) newPic: 660) ; exitBack
				((ScriptID 1 4) newPic: 658) ; exitRight
				(forge x: 370 y: 241)
				(if
					(or
						((ScriptID 9 55) state:) ; invMold
						(gInventory contains: (ScriptID 9 55)) ; invMold
					)
					(moldGone659 init:)
				else
					(mold659 init:)
				)
			)
			(660
				(proc400_1 8)
				(forwardLeft
					nsLeft: 81
					nsTop: 92
					nsRight: 189
					nsBottom: 179
					newPic: 658
				)
				(forwardRight
					nsLeft: 324
					nsTop: 79
					nsRight: 392
					nsBottom: 242
					newRoom: 650
				)
				((ScriptID 1 2) newPic: local3) ; exitBack
				(if
					(or
						(gInventory contains: (ScriptID 9 53)) ; invIngots
						((ScriptID 9 53) state:) ; invIngots
					)
					(ingotsGone660 init:)
				)
			)
			(local4
				(proc400_1 4)
				((ScriptID 1 2) newPic: 662) ; exitBack
				((ScriptID 1 1) newPic: 664) ; exitForward
				(forwardLeft
					nsLeft: 7
					nsTop: 63
					nsRight: 149
					nsBottom: 268
					newPic: local5
				)
				(forwardRight
					nsLeft: 325
					nsTop: 86
					nsRight: 482
					nsBottom: 277
					newPic: 667
				)
				(torch view: 5661 x: 281 y: 174 init:)
				(forge loop: 3 x: 113 y: 213)
				(if
					(or
						(gInventory contains: (ScriptID 9 52)) ; invLogs
						((ScriptID 9 52) state:) ; invLogs
					)
					(logsGone661 init:)
				)
				(if
					(or
						(gInventory contains: (ScriptID 9 54)) ; invCoal
						((ScriptID 9 54) state:) ; invCoal
					)
					(coalGone661 init:)
				)
				(if ((ScriptID 9 55) state:) ; invMold
					(tableMold init:)
				)
			)
			(662
				(proc400_1 6)
				((ScriptID 1 4) newPic: local6) ; exitRight
				(forward
					nsLeft: 185
					nsTop: 82
					nsRight: 228
					nsBottom: 2208
					newRoom: 650
				)
				(forwardRight
					nsLeft: 234
					nsTop: 70
					nsRight: 388
					nsBottom: 242
					newPic: local2
				)
				(if ((ScriptID 9 55) state:) ; invMold
					(tableMold init:)
				)
				(if
					(or
						(gInventory contains: (ScriptID 9 53)) ; invIngots
						((ScriptID 9 53) state:) ; invIngots
					)
					(ingotsGone662 init:)
				else
					(ingots662 init:)
				)
			)
			(local5
				(proc400_1 5)
				((ScriptID 1 4) newPic: 664) ; exitRight
				((ScriptID 1 3) newPic: local6) ; exitLeft
				((ScriptID 1 2) newPic: 667) ; exitBack
				(leverFtr663 init:)
				(lever663 init:)
				(forge x: 222 y: 243)
				(forgeFtr663 init:)
				(cauldronFtr663 init:)
				(if (== scene 4663)
					(cauldron663 init:)
				)
				(if local9
					(leverFtr663 doVerb: 5)
					(= local9 0)
				)
			)
			(664
				(proc400_1 4)
				(forward
					nsLeft: 191
					nsTop: 20
					nsRight: 286
					nsBottom: 256
					newRoom: 690
				)
				((ScriptID 1 3) newPic: local5) ; exitLeft
				((ScriptID 1 4) newPic: 667) ; exitRight
				((ScriptID 1 2) newPic: 668) ; exitBack
				(if (IsFlag 208)
					(forge664 init:)
				)
				(torch view: 2664 loop: 1 posn: 314 212 init:)
				(torchFtr664 init:)
				(if
					(or
						(gInventory contains: (ScriptID 9 54)) ; invCoal
						((ScriptID 9 54) state:) ; invCoal
					)
					(coalGone664 init:)
				)
			)
			(local6
				(proc400_1 6)
				((ScriptID 1 3) newPic: 662) ; exitLeft
				(turnMe
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 27 299 26 203 196 239 195 296 373 296 384 246 498 259 498 299
							yourself:
						)
					newPic: 667
				)
				((ScriptID 1 4) ; exitRight
					newPic: local5
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 497 220 433 187 449 38 499 32
							yourself:
						)
				)
				(if (IsFlag 208)
					(cauldron666 init:)
					(if (IsFlag 233)
						(coolMoldRbt init: 5669 0 0 0 -1)
					else
						(coolArm666 init:)
					)
				)
				(coolLeverFtr666 init:)
				(coolLever666 init:)
				(btnFtr666 init:)
				(if ((ScriptID 9 55) state:) ; invMold
					(if (not (IsFlag 233))
						(if (IsFlag 247)
							(moldOpen666 init:)
						else
							(mold666 init:)
						)
					)
				else
					(moldFtr666 init:)
				)
				(cauldronFtr666 init:)
				(cauldronLeverFtr666 init:)
			)
			(667
				(proc400_1 9)
				((ScriptID 1 3) newPic: 664) ; exitLeft
				((ScriptID 1 4) newPic: 662) ; exitRight
				((ScriptID 1 2) newPic: local6) ; exitBack
				(coal667 init:)
				(logs667 init:)
				(torch view: 2667 posn: 9 178 init:)
				(torchFtr667 init:)
			)
			(668
				(proc400_1 8)
				(if
					(or
						(gInventory contains: (ScriptID 9 52)) ; invLogs
						((ScriptID 9 52) state:) ; invLogs
					)
					(logsGone668 init:)
				)
				(if
					(or
						(gInventory contains: (ScriptID 9 53)) ; invIngots
						((ScriptID 9 53) state:) ; invIngots
					)
					(ingotsGone668 init:)
				)
				((ScriptID 1 3) newPic: 667) ; exitLeft
				((ScriptID 1 4) newPic: local6) ; exitRight
				((ScriptID 1 2) newPic: 664) ; exitBack
				((ScriptID 1 1) newPic: 662) ; exitForward
			)
		)
		(if (and (!= (forge x:) -1) (IsFlag 208))
			(if (== (forge view:) -1)
				(forge view: (+ scene 1000))
			)
			(forge init: setCycle: Fwd)
		)
	)

	(method (cue)
		(= local8 1)
	)

	(method (dispose)
		(if (gInventory contains: (ScriptID 9 55)) ; invMold
			(gInventory deleteItem: (ScriptID 9 55)) ; invMold
		)
		(if (gInventory contains: (ScriptID 9 54)) ; invCoal
			(gInventory deleteItem: (ScriptID 9 54)) ; invCoal
		)
		(if (gInventory contains: (ScriptID 9 53)) ; invIngots
			(gInventory deleteItem: (ScriptID 9 53)) ; invIngots
		)
		(if (gInventory contains: (ScriptID 9 52)) ; invLogs
			(gInventory deleteItem: (ScriptID 9 52)) ; invLogs
		)
		(if (sndFX handle:)
			(sndFX dispose:)
		)
		(if (fireSFX handle:)
			(fireSFX dispose:)
		)
		(if (torchSFX handle:)
			(torchSFX dispose:)
		)
		(gBackMusic fade:)
		(super dispose: &rest)
	)
)

(instance forwardLeft of ExitFeature
	(properties
		arrowStyle 8
	)
)

(instance forwardRight of ExitFeature
	(properties
		arrowStyle 7
	)
)

(instance forward of ExitFeature
	(properties)
)

(instance turnMe of ExitFeature
	(properties
		arrowStyle 4
	)
)

(instance forge of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance moldGone657 of Prop
	(properties
		x 322
		y 202
		loop 1
		view 5657
	)

	(method (init)
		(if (< (gCurRoom scene:) 4000)
			(self view: 2657 loop: 0 posn: 131 134)
		else
			(self view: 5657 loop: 1 posn: 128 194)
		)
		(super init: &rest)
	)
)

(instance moldGone659 of Feature
	(properties
		nsBottom 250
		nsLeft 143
		nsRight 420
		nsTop 152
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; invMold
			(self dispose:)
			(gInventory deleteItem: (ScriptID 9 55)) ; invMold
			(mold659 init:)
			(sndFX number: 61306 loop: 0 play:)
		)
	)
)

(instance mold659 of Prop
	(properties)

	(method (init)
		(if (< (gCurRoom scene:) 4000)
			(self view: 2659 loop: 0 posn: 250 241)
		else
			(self view: 5659 loop: 1 posn: 250 238)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory addItem: (ScriptID 9 55)) ; invMold
			(self dispose:)
			(moldGone659 init:)
			(sndFX number: 453 loop: 0 play:)
		)
	)
)

(instance cauldron655 of View
	(properties
		x 152
		y 180
		loop 1
		view 5655
	)
)

(instance coalGone655 of View
	(properties
		x 308
		y 170
		loop 2
		view 5655
	)
)

(instance cauldronLeverFtr666 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 449 246 416 187 493 219 505 248
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(= local9 1)
			(gCurRoom changeScene: local5)
		)
	)
)

(instance logs667 of Feature
	(properties
		y 300
		nsBottom 287
		nsLeft 294
		nsRight 416
		nsTop 197
	)

	(method (init)
		(super init: &rest)
		(if (or (gInventory contains: (ScriptID 9 52)) ((ScriptID 9 52) state:)) ; invLogs, invLogs
			(logsGone667 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; invLogs
				(logsGone667 dispose:)
				(gInventory deleteItem: (ScriptID 9 52)) ; invLogs
			)
			(5 ; Do
				(if
					(not
						(or
							(gInventory contains: (ScriptID 9 52)) ; invLogs
							((ScriptID 9 52) state:) ; invLogs
						)
					)
					(logsGone667 init:)
					(gInventory addItem: (ScriptID 9 52)) ; invLogs
					(sndFX number: 60900 loop: 0 play:)
				)
			)
		)
	)
)

(instance logsGone667 of View
	(properties
		x 280
		y 299
		loop 2
		view 2667
	)
)

(instance coalGone667 of View
	(properties
		x 74
		y 297
		loop 1
		view 2667
	)
)

(instance coal667 of Feature
	(properties
		y 300
		nsBottom 204
		nsLeft 93
		nsRight 236
		nsTop 177
	)

	(method (init)
		(super init: &rest)
		(if (or (gInventory contains: (ScriptID 9 54)) ((ScriptID 9 54) state:)) ; invCoal, invCoal
			(coalGone667 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(not
						(or
							(gInventory contains: (ScriptID 9 54)) ; invCoal
							((ScriptID 9 54) state:) ; invCoal
						)
					)
					(gInventory addItem: (ScriptID 9 54)) ; invCoal
					(coalGone667 init:)
					(sndFX number: 452 loop: 0 play:)
				)
			)
			(63 ; invCoal
				(coalGone667 dispose:)
				(gInventory deleteItem: (ScriptID 9 54)) ; invCoal
			)
		)
	)
)

(instance ingotsGone660 of View
	(properties
		x 92
		y 233
		view 2660
	)
)

(instance forge664 of View
	(properties
		x 1
		y 298
		view 2664
	)
)

(instance coalGone664 of View
	(properties
		x 416
		y 243
		loop 2
		view 2664
	)
)

(instance logsGone661 of View
	(properties
		x 354
		y 297
		loop 1
		view 5661
	)
)

(instance coalGone661 of View
	(properties
		x 310
		y 202
		loop 2
		view 2661
	)
)

(instance woodGone656 of View
	(properties
		x 376
		y 216
		loop 1
		view 2656
	)
)

(instance moldGone656 of View
	(properties
		y 208
	)

	(method (init)
		(if (IsFlag 208)
			(self view: 5656 loop: 2)
		else
			(self view: 2656 loop: 0)
		)
		(super init: &rest)
	)
)

(instance coalGone656 of View
	(properties)

	(method (init)
		(if (IsFlag 208)
			(self view: 5656 loop: 3 posn: 326 173)
		else
			(self view: 2656 loop: 2 posn: 325 172)
		)
		(super init: &rest)
	)
)

(instance cauldron656 of View
	(properties
		x 155
		y 185
		loop 1
		view 5656
	)
)

(instance ingots658 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 324 245 330 187 479 201 428 296
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory addItem: (ScriptID 9 53)) ; invIngots
			(self dispose:)
			(ingotsGone658 init:)
			(sndFX loop: 0 number: 61303 play:)
		)
	)
)

(instance ingotsGone658 of View
	(properties
		x 317
		y 272
		loop 2
		view 2658
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; invIngots
			(gInventory deleteItem: (ScriptID 9 53)) ; invIngots
			(self dispose:)
			(ingots658 init:)
			(sndFX loop: 0 number: 61303 play:)
		)
	)
)

(instance ingotsGone662 of View
	(properties
		y 299
		view 2662
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; invIngots
			(gInventory deleteItem: (ScriptID 9 53)) ; invIngots
			(self dispose:)
			(ingots662 init:)
			(sndFX loop: 0 number: 61303 play:)
		)
	)
)

(instance ingots662 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 11 301 47 188 138 188 113 300
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory addItem: (ScriptID 9 53)) ; invIngots
			(self dispose:)
			(ingotsGone662 init:)
			(sndFX loop: 0 number: 61303 play:)
		)
	)
)

(instance logsGone658 of View
	(properties
		x 161
		y 224
		loop 1
		view 2658
	)
)

(instance coalGone658 of View
	(properties
		x 109
		y 191
		loop 3
		view 2658
	)
)

(instance torch of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance cauldron666 of View
	(properties
		x 344
		y 251
		loop 4
		view 5666
	)

	(method (init)
		(self setPri: 1)
		(= cel local8)
		(super init: &rest)
	)
)

(instance cauldronLever666 of View
	(properties
		x 463
		y 236
		loop 9
		view 5666
	)
)

(instance btn666 of Prop
	(properties
		x 322
		y 282
		loop 8
		view 5666
	)
)

(instance btnFtr666 of Feature
	(properties
		nsBottom 294
		nsLeft 320
		nsRight 360
		nsTop 245
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (and local8 ((ScriptID 9 55) state:) (not (IsFlag 247))) ; invMold
				(gCurRoom setScript: pourCauldronScr)
			else
				(gCurRoom setScript: pourFailScr)
			)
		)
	)
)

(instance moldFtr666 of Feature
	(properties
		nsBottom 245
		nsLeft 260
		nsRight 333
		nsTop 152
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; invMold
			(mold666 init:)
			(gInventory deleteItem: ((ScriptID 9 55) state: 1 yourself:)) ; invMold
			(self dispose:)
			(sndFX number: 61306 loop: 0 play:)
		)
	)
)

(instance moldOpen666 of View
	(properties
		x 234
		y 229
		loop 5
		view 5666
	)

	(method (init)
		(= cel (if (IsFlag 231) 1 else 0))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (IsFlag 231)
				(gMySoundFX do: 61304)
				(gInventory addItem: (ScriptID 9 47)) ; invOrnithopterPart
				(ClearFlag 231)
				(= cel 0)
			else
				(ClearFlag 247)
				(self dispose:)
				(mold666 init:)
			)
		)
	)
)

(instance mold666 of View
	(properties
		x 283
		y 229
		view 5666
	)

	(method (init)
		(= loop (if (IsFlag 231) 3 else 2))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 230))) ; Do
			(self dispose:)
			(moldOpen666 init:)
			(SetFlag 247)
		)
	)
)

(instance tableMold of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(662
				(self view: 2662 loop: 1 posn: 465 228)
			)
			(656
				(self view: 2656 loop: 3 posn: 240 189)
			)
			(4656
				(self view: 5656 loop: 4 posn: 240 190)
			)
			(4655
				(self view: 5655 loop: 3 posn: 239 183)
			)
			(658
				(self view: 2658 loop: 4 posn: 0 228)
			)
			(661
				(self view: 2661 loop: 0 posn: 69 217)
			)
			(4661
				(self view: 5661 loop: 4 posn: 69 227)
			)
		)
		(super init: &rest)
	)
)

(instance coolLever666 of Prop
	(properties
		view 5666
	)

	(method (init)
		(self view: 5666 loop: 7 posn: 250 274)
		(= cel
			(if (IsFlag 233)
				(self lastCel:)
			else
				0
			)
		)
		(super init: &rest)
	)
)

(instance coolLeverFtr666 of Feature
	(properties
		y 300
		nsBottom 301
		nsLeft 210
		nsRight 313
		nsTop 226
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((IsFlag 233)
					(gCurRoom setScript: removeCoolMoldScr)
				)
				((IsFlag 230)
					(gCurRoom setScript: coolMoldScr)
				)
				(else
					(gCurRoom setScript: coolFailScr)
				)
			)
		)
	)
)

(instance forge663 of View
	(properties
		x 232
		y 255
		view 2663
	)

	(method (cue)
		(self loop: 1 posn: 230 257)
	)
)

(instance lever663 of Prop
	(properties
		x 65
		y 216
		loop 2
		view 2663
	)

	(method (init)
		(if (IsFlag 208)
			(self
				view: 5663
				loop: 5
				posn: 104 216
				cel:
					(if local7
						(self lastCel:)
					else
						0
					)
			)
		else
			(self view: 2663 loop: 3 posn: 105 214 cel: 0)
		)
		(super init: &rest)
	)
)

(instance leverFtr663 of Feature
	(properties
		y 300
		nsBottom 222
		nsLeft 55
		nsRight 187
		nsTop 161
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (and (IsFlag 208) (not (IsFlag 248)))
				(cond
					(local7
						(gCurRoom setScript: cauldronOutScr)
					)
					((not local8)
						(gCurRoom setScript: cauldronInScr)
					)
					(else
						(gCurRoom setScript: failedCauldronScr)
					)
				)
			else
				(gCurRoom setScript: failedCauldronScr)
			)
		)
	)
)

(instance cauldron663 of View
	(properties
		view 5663
	)

	(method (init)
		(if local8
			(self loop: 4 posn: 10 208)
		else
			(self loop: 3 posn: 15 172)
		)
		(super init: &rest)
	)
)

(instance cauldronFtr663 of Feature
	(properties
		y 300
		nsBottom 159
		nsLeft 3
		nsRight 129
		nsTop 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; invIngots
				(gInventory deleteItem: ((ScriptID 9 53) state: 1 yourself:)) ; invIngots
				(sndFX loop: 0 number: 614 play:)
			)
			(5 ; Do
				(if local8
					(sndFX loop: 0 number: 61305 play:)
				)
			)
		)
	)
)

(instance cauldronFtr666 of Feature
	(properties
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 354 79 473 83 470 182 346 182
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; invIngots
			(gInventory deleteItem: ((ScriptID 9 53) state: 1 yourself:)) ; invIngots
			(sndFX loop: 0 number: 614 play:)
		)
	)
)

(instance cauldronCoolDown663 of Prop
	(properties
		x 10
		y 371
		view 665
		z 200
	)
)

(instance coolArm666 of View
	(properties
		x 94
		y 182
		loop 10
		view 5666
	)
)

(instance forgeFtr663 of Feature
	(properties
		nsBottom 248
		nsLeft 211
		nsRight 342
		nsTop 23
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 208) 0)
			((and ((ScriptID 9 52) state:) ((ScriptID 9 54) state:)) ; invLogs, invCoal
				(forge663 init: cue:)
			)
			(((ScriptID 9 52) state:) ; invLogs
				(forge663 init:)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 61) ; invLogs
				((ScriptID 9 52) state: 1) ; invLogs
				(gInventory deleteItem: (ScriptID 9 52)) ; invLogs
				(forge663 init:)
			)
			((== theVerb 63) ; invCoal
				(if ((ScriptID 9 52) state:) ; invLogs
					((ScriptID 9 54) state: 1) ; invCoal
					(gInventory deleteItem: (ScriptID 9 54)) ; invCoal
					(forge663 cue:)
				)
			)
			(
				(and
					(or
						(== theVerb 95) ; invTorch
						(and (== theVerb 11) (== ((ScriptID 9 5) state:) 2)) ; invLighter, invLighter
					)
					((ScriptID 9 54) state:) ; invCoal
					((ScriptID 9 52) state:) ; invLogs
					(not (IsFlag 208))
				)
				(Load rsAUDIO 613 617)
				(SetFlag 208)
				(localproc_0)
				(gCurRoom changeScene: local5)
				(sndFX number: 613 loop: 0 play:)
				(fireSFX loop: -1 play:)
				((ScriptID 9 5) state: 0 cel: 0) ; invLighter
			)
		)
	)
)

(instance logsGone668 of View
	(properties
		y 299
		view 2668
	)
)

(instance ingotsGone668 of View
	(properties
		x 308
		y 229
		loop 1
		view 2668
	)
)

(instance torchFtr664 of Feature
	(properties
		y 1000
		nsBottom 180
		nsLeft 352
		nsRight 455
		nsTop 85
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (gInventory contains: (ScriptID 9 86))) ; invTorch
						(not (gInventory contains: (ScriptID 9 5))) ; invLighter
					)
					(gInventory addItem: (ScriptID 9 86)) ; invTorch
				)
			)
			(95 ; invTorch
				(gInventory deleteItem: (ScriptID 9 86)) ; invTorch
			)
		)
	)
)

(instance torchFtr667 of Feature
	(properties
		y 1000
		nsBottom 183
		nsLeft 22
		nsRight 118
		nsTop 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (gInventory contains: (ScriptID 9 86))) ; invTorch
						(not (gInventory contains: (ScriptID 9 5))) ; invLighter
					)
					(gInventory addItem: (ScriptID 9 86)) ; invTorch
				)
			)
			(95 ; invTorch
				(gInventory deleteItem: (ScriptID 9 86)) ; invTorch
			)
		)
	)
)

(instance coolFailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(coolLever666 setCycle: End self)
				(sndFX number: 61302 play: 127 self)
			)
			(1)
			(2
				(coolLever666 setCycle: Beg self)
				(sndFX number: 61302 play: 127 self)
			)
			(3)
			(4
				(coolLever666 setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coolMoldScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sndFX number: 61302 play: 127 self)
				(coolLever666 setCycle: End self)
			)
			(1)
			(2
				(coolArm666 dispose:)
				(KillRobot 5668)
			)
			(3
				(mold666 dispose:)
			)
			(4
				(DoRobot 0)
				(coolMoldRbt init: 5669 0 0 0 -1)
				(ClearFlag 230)
				(SetFlag 233)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance removeCoolMoldScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(coolLever666 setCycle: Beg self)
				(sndFX number: 61302 play: 127 self)
			)
			(1)
			(2
				(coolMoldRbt dispose:)
				(KillRobot 5669)
			)
			(3
				(mold666 init:)
			)
			(4
				(coolArm666 init:)
				(ClearFlag 233)
				(gGame handsOn:)
				(self dispose:)
				(if register
					(gCurRoom changeScene: register)
					(= register 0)
				)
			)
		)
	)
)

(instance forceCauldronOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: cauldronOutScr self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom changeScene: register)
			)
		)
	)
)

(instance cauldronOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever663 dispose:)
				(KillRobot 5665)
				(if (gTimers contains: cauldronTimer)
					(cauldronTimer dispose:)
				)
			)
			(1
				(= local7 0)
				(lever663 init:)
			)
			(2
				(cauldron663 init:)
				(if (not local8)
					(cauldronCoolDown663 cel: 0 init:)
					(= ticks 60)
				else
					(self dispose:)
					(if (or (not client) (not (client isKindOf: Script)))
						(gGame handsOn:)
					)
				)
			)
			(3
				(cauldronCoolDown663 setCycle: End self)
			)
			(4
				(cauldronCoolDown663 dispose:)
				(= local7 0)
				(self dispose:)
				(if (or (not client) (not (client isKindOf: Script)))
					(gGame handsOn:)
				)
			)
		)
	)
)

(instance cauldronInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever663 dispose:)
				(cauldron663 dispose:)
				(KillRobot 5664)
			)
			(1
				(= local7 1)
				(lever663 init:)
			)
			(2
				(if ((ScriptID 9 53) state:) ; invIngots
					(cauldronTimer setReal: gCurRoom 15)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance failedCauldronScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever663 setCycle: End self)
				(sndFX number: 61302 play: 127 self)
			)
			(1)
			(2
				(lever663 setCycle: Beg self)
				(sndFX number: 61302 play: 127 self)
			)
			(3)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pourCauldronScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cauldronLever666 init:)
				(cauldron666 dispose:)
				(mold666 dispose:)
				(KillRobot 5667)
			)
			(1
				(= local8 0)
				(SetFlag 231)
				(SetFlag 230)
				(SetFlag 248)
				(cauldronLever666 dispose:)
				(cauldron666 init:)
				(mold666 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pourFailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(btn666 init: setCycle: CT 2 1 self)
			)
			(1
				(sndFX number: 61301 play: 127 self)
				(btn666 setCycle: End self)
			)
			(2)
			(3
				(btn666 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeMoldScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(moldOpen666 dispose:)
				(mold666 init:)
				(= ticks 30)
			)
			(1
				(ClearFlag 247)
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: register)
			)
		)
	)
)

(instance cauldronTimer of Timer
	(properties)
)

(instance coolMoldRbt of RobotPlayer
	(properties)
)

(instance sndFX of Sound
	(properties)
)

(instance torchSFX of Sound
	(properties
		number 61701
	)
)

(instance fireSFX of Sound
	(properties
		number 617
	)
)

