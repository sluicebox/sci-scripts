;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use foEExit)
(use Styler)
(use Plane)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roBog 0
)

(local
	bRopeDangling
	bOnRoot
	treeDiveType
	swingAmt
	swingDir
	swingPos = 8
	swingTime
	bWentForBag
)

(instance foExitToForest of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1 280 31 295 166 299 165 312 165 317 1 318
				yourself:
			)
		)
	)

	(method (doVerb)
		(gEgo setScript: soWalkOut)
	)
)

(instance soWalkIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 78 437 setMotion: MoveTo 100 280 self)
				((ScriptID 64018 0) setScript: soBoogleWalkIn) ; oBoogle
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 78 457
					setMotion: MoveTo 100 300 self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soWalkOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 100 280 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 78 437 self)
				((ScriptID 64018 0) setScript: soBoogleWalkOut) ; oBoogle
			)
			(2
				(gCurRoom newRoom: 10100) ; roForestScroll
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) setWander: 0 setMotion: MoveTo 78 437 self) ; oBoogle
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance foBranch of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= y (= x 200))
		(= approachX 171)
		(= approachY 271)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 71 231 38 283 29 338 44 370 43 390 29 399 42 427 48 443 57 450 56 467 74 501 69 546 73 548 79 508 85 490 81 475 90 462 86 449 74 426 68 416 59 390 52 385 47 374 55 348 55 348 67 322 87 317 82 319 55 294 45 262 45 235 57 207 99 201 126
					yourself:
				)
		)
	)

	(method (doVerb)
		(if bOnRoot
			(gEgo setScript: soClimbBranchFromRoot)
		else
			(gEgo setScript: soClimbBranch)
		)
	)
)

(instance foGround of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 144 314 213 256 130 238 2 309
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: soJumpDownFromRoot)
	)
)

(instance foRoot of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 173 266 179 295 161 338 151 357 174 426 213 428 236 377 241 351 282 312 250 294 262
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: soClimbToRoot)
	)
)

(instance soClimbToRoot of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 171 271 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 13007)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 13011
					loop: 0
					cel: 0
					posn: 167 273
					init:
					setCycle: CT 33 1 self
				)
			)
			(3
				(goSound1 playSound: 13007)
				(poTorin setCycle: CT 60 1 self)
			)
			(4
				(if (not ((ScriptID 64017 0) test: 24)) ; oFlags
					((ScriptID 64017 0) set: 24) ; oFlags
					(gMessager say: 3 1 0 0 self) ; "(CONSIDERING) A peat bog, eh? But it's obviously too soft to walk on..."
				else
					(= cycles 1)
				)
			)
			(5
				(poTorin setCycle: End self)
			)
			(6
				(= bOnRoot 1)
				(foGround init:)
				(foRoot dispose:)
				(foBog dispose:)
				(foExitToForest dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpDownFromRoot of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13017)
				(poTorin
					view: 13013
					loop: 0
					cel: 0
					posn: 410 204
					setCycle: CT 32 1 self
				)
			)
			(1
				(goSound1 playSound: 13017)
				(poTorin setCycle: End self)
			)
			(2
				(poTorin dispose:)
				(gEgo
					posn: 171 271
					setScalePercent: 80
					normalize: 1 60100 5
					show:
				)
				(gGame handsOn:)
				(foGround dispose:)
				(if (not ((ScriptID 64017 0) test: 10)) ; oFlags
					(foRoot init:)
					(foBog init:)
				)
				(foExitToForest init:)
				(= bOnRoot 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foBranchWhileHanging of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 71 231 38 283 29 338 44 370 43 390 29 399 42 427 48 443 57 450 56 467 74 501 69 546 73 548 79 508 85 490 81 475 90 462 86 449 74 426 68 416 59 390 52 385 47 374 55 348 55 348 67 322 87 317 82 319 55 294 45 262 45 235 57 207 99 201 126
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soClimbRope)
	)
)

(instance soClimbBranchFromRoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13008)
				(poTorin
					view: 13012
					posn: 410 204
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 0 hide:) ; oBoogle
				(poTorin dispose:)
				(foRoot init:)
				(foBog init:)
				(foGround dispose:)
				(foExitToForest init:)
				(gCurRoom addRoomPlane: oBranchPlane)
				(poEgoOnBranch
					view: 13001
					loop: 0
					cel: 0
					init:
					setCycle: CT 5 1 self
				)
			)
			(2
				(goSound1 playSound: 13008)
				(poEgoOnBranch setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soClimbBranch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foBranch self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 13008)
				(gEgo hide:)
				(poClimbsTree
					view: 13000
					posn: 167 273
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
			)
			(2
				((ScriptID 64018 0) setWander: 0 hide:) ; oBoogle
				(poClimbsTree dispose:)
				(gCurRoom addRoomPlane: oBranchPlane)
				(poEgoOnBranch
					view: 13001
					loop: 0
					cel: 0
					init:
					setCycle: CT 5 1 self
				)
			)
			(3
				(goSound1 playSound: 13008)
				(poEgoOnBranch setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poClimbsTree of Prop
	(properties
		view 13000
	)
)

(instance foBog of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= x 384)
		(= y 252)
		(= approachX 188)
		(= approachY 268)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 364 262 631 266 631 313 352 315 366 300 356 279
					yourself:
				)
		)
	)

	(method (doVerb)
		(foRoot doVerb: &rest)
	)
)

(instance foClimbDown of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 0 252 200 316)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soClimbBackDown)
	)
)

(instance soClimbBackDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soUntieSelf self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 13017)
				(poEgoOnBranch
					view: 13020
					loop: 0
					cel: 0
					posn: 340 170
					setCycle: End self
				)
			)
			(2
				(gCurRoom deleteRoomPlane: oBranchPlane)
				((ScriptID 64018 0) setWander: 1 show:) ; oBoogle
				(poClimbsTree
					view: 13010
					posn: 167 273
					loop: 0
					cel: 0
					init:
					setCycle: CT 14 1 self
				)
			)
			(3
				(goSound1 playSound: 13017)
				(poClimbsTree setCycle: End self)
			)
			(4
				(poClimbsTree dispose:)
				(= bOnRoot 0)
				(gEgo posn: 169 272 normalize: 1 60100 5 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTieLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(PrintDebug {Error in call of soTieLeg})
					(self dispose:)
					(return)
				)
				(if (not ((ScriptID 64017 0) test: 20)) ; oFlags
					(self setScript: soTieLegFromZero self)
				else
					(self setScript: soTieLegFromBranch self)
				)
			)
			(1
				((ScriptID 64017 0) set: 21) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soTieLegFromZero of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(poEgoOnBranch
					view: 13030
					loop: 0
					cel: 0
					posn: 340 170
					setCycle: End self
				)
			)
			(1
				(poEgoOnBranch view: 13031 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTieLegFromBranch of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(if bRopeDangling
					(poEgoOnBranch
						view: 13037
						loop: 0
						cel: 0
						posn: 340 170
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(if bRopeDangling
					(poEgoOnBranch
						view: 13032
						loop: 0
						cel: 16
						setCycle: CT 19 1 self
					)
				else
					(poEgoOnBranch
						view: 13032
						loop: 0
						cel: 0
						setCycle: CT 19 1 self
					)
				)
			)
			(2
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: End self)
			)
			(3
				(= bRopeDangling 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTieBranch of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(PrintDebug {Error in call of soTieBranch})
					(self dispose:)
					(return)
				)
				(if (not ((ScriptID 64017 0) test: 21)) ; oFlags
					(self setScript: soTieBranchFromZero self)
				else
					(self setScript: soTieBranchFromLeg self)
				)
			)
			(1
				((ScriptID 64017 0) set: 20) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soTieBranchFromZero of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010 13012)
				(poEgoOnBranch
					view: 13030
					loop: 0
					cel: 0
					posn: 340 170
					setCycle: End self
				)
			)
			(1
				(poEgoOnBranch view: 13033 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: CT 28 1 self)
			)
			(3
				(goSound1 playSound: 13012)
				(poEgoOnBranch setCycle: End self)
				(= bRopeDangling 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTieBranchFromLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(poEgoOnBranch view: 13034 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(1
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soUntieLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(self setScript: soUntieLegLeaveBranch self)
				else
					(self setScript: soUntieLegAndPutAway self)
				)
			)
			(1
				((ScriptID 64017 0) clear: 21) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soUntieLegLeaveBranch of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(poEgoOnBranch view: 13032 loop: 0)
				(poEgoOnBranch
					cel: (poEgoOnBranch lastCel:)
					setCycle: CT 35 -1 self
				)
			)
			(1
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soUntieLegAndPutAway of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(poEgoOnBranch view: 13036 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(1
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soUntieBranch of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(self setScript: soUntieBranchLeaveLeg self)
				else
					(self setScript: soUntieBranchAndPutAway self)
				)
			)
			(1
				((ScriptID 64017 0) clear: 20) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soUntieBranchAndPutAway of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(if bRopeDangling
					(self setScript: soPullUpRope self)
				else
					(self cue:)
				)
			)
			(1
				(poEgoOnBranch view: 13035 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPullUpRope of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poEgoOnBranch view: 13037 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(poEgoOnBranch
					view: 13032
					loop: 0
					cel: 16
					doit:
					setCycle: Beg self
				)
			)
			(2
				(= bRopeDangling 0)
				(self dispose:)
			)
		)
	)
)

(instance soUntieBranchLeaveLeg of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13010)
				(poEgoOnBranch view: 13034 loop: 0)
				(poEgoOnBranch
					cel: (poEgoOnBranch lastCel:)
					setCycle: CT 22 -1 self
				)
			)
			(1
				(goSound1 playSound: 13010)
				(poEgoOnBranch setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soUntieSelf of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(self setScript: soUntieBranch self)
				else
					(self cue:)
				)
			)
			(1
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(self setScript: soUntieLeg self)
				else
					(self cue:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance foBranchCU of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 184 231 202 245 195 267 168 288 158 331 170 362 159 377 164 422 146 413 154 379 172 327 182 294 177 245 216 239 241 220 253 208 247 206 224 178 219
					yourself:
				)
		)
		(self addHotspotVerb: 4)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 20) ; oFlags
			(gCurRoom setScript: soUntieBranch)
		else
			(gCurRoom setScript: soTieBranch)
		)
	)
)

(instance foBogBelow of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Set new:)
				add:
					((Polygon new:)
						type: PTotalAccess
						init: 62 194 34 82 71 42 121 82 182 78 406 140 315 152 267 154 233 188 183 166
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 426 155 371 191 292 194 244 248 212 266 192 233 167 227 109 272 112 302 120 310 626 311 626 243
						yourself:
					)
			)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(cond
			(((ScriptID 64017 0) test: 21) ; oFlags
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(gCurRoom setScript: soBungieIntoBog)
				else
					(gCurRoom setScript: soDiveIntoBog)
				)
			)
			(((ScriptID 64017 0) test: 20) ; oFlags
				(if bRopeDangling
					(gCurRoom setScript: soClimbDownRope)
				else
					(gCurRoom setScript: soDiveIntoBog)
				)
			)
			(else
				(gCurRoom setScript: soDiveIntoBog)
			)
		)
	)
)

(instance oBungie of TPSound ; UNUSED
	(properties)
)

(instance oSpeech of TPSound
	(properties
		type 2
	)
)

(instance soBungieIntoBog of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13002 13019)
				(gMessager say: 5 1 9 0 self) ; "Hope this works!"
			)
			(1
				(poEgoOnBranch
					view: 13004
					loop: 0
					cel: 0
					posn: 340 170
					setCycle: End self
				)
			)
			(2
				(gCurRoom deleteRoomPlane: oBranchPlane)
				(gCurRoom addRoomPlane: oDanglePlane)
				(poEgoBungies
					view: 13004
					loop: 1
					cel: 0
					posn: 432 44
					init:
					setCycle: CT 13 1 self
				)
			)
			(3
				(poEgoBungies setCycle: CT 36 1 self)
				(goSound1 playSound: 13002)
				(oSpeech playSound: 13019)
				(gEgo get: ((ScriptID 64001 0) get: 11)) ; oInvHandler, ioPeat
			)
			(4
				(poEgoBungies setCycle: CT 49 1 self)
			)
			(5
				(poEgoBungies setCycle: End self)
			)
			(6
				(poEgoBungies dispose:)
				(poEgoHangingFromBranch
					view: 13005
					loop: 0
					cel: 8
					posn: 432 44
					init:
				)
				(voBigBag init:)
				((ScriptID 64017 0) set: 10) ; oFlags
				(foRope init:)
				(foSwingLeft init:)
				(foSwingRight init:)
				(foCurlyBranch init:)
				(foRope init:)
				(foBranchOverhead init:)
				(foBogInScreen3 init:)
				((ScriptID 64017 0) set: 22) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDiveIntoBog of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13002)
				(cond
					(((ScriptID 64017 0) test: 21) ; oFlags
						(= nLoop 0)
					)
					(((ScriptID 64017 0) test: 20) ; oFlags
						(= nLoop 1)
					)
					(else
						(= nLoop 2)
					)
				)
				(poEgoOnBranch hide:)
				(poTorin
					view: 13006
					loop: nLoop
					cel: 0
					posn: 340 170
					init:
					setCycle: End self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(goSound1 playSound: 13002 self)
				(ShakePlane oBranchPlane 2 5 2)
			)
			(3
				(= ticks 10)
			)
			(4
				(poTorin dispose:)
				(gCurRoom picture: 13000)
				(gCurRoom drawPic: 13000)
				(poBoogleHoldsCard cel: 0 init:)
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(= nLoop 3)
				else
					(= nLoop 4)
				)
				(voTorinInMuck loop: nLoop init:)
				(= ticks 60)
			)
			(5
				(poBoogleHoldsCard setCycle: End self)
			)
			(6
				((ScriptID 64019 0) show: 0 42 8) ; DeathDialog
				(poBoogleHoldsCard dispose:)
				(voTorinInMuck dispose:)
				(gCurRoom picture: 13001)
				(gCurRoom drawPic: 13001)
				(poEgoOnBranch show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soClimbDownRope of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poEgoOnBranch view: 13003 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(poEgoOnBranch hide:)
				(gCurRoom picture: 13000)
				(gCurRoom drawPic: 13000)
				(poBoogleHoldsCard cel: 0 init:)
				(poEgoHangs loop: 1 cel: 0 init: setCycle: End self)
			)
			(2
				(foBogBelow dispose:)
				(foClimbDown dispose:)
				(foBranchCU dispose:)
				(foBranchWhileHanging init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance soClimbRope of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 10111 13017)
				(poEgoHangs loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(poEgoHangs dispose:)
				(poBoogleHoldsCard dispose:)
				(foBranchWhileHanging dispose:)
				(gCurRoom picture: 13001)
				(gCurRoom drawPic: 13001)
				(foBogBelow init:)
				(foClimbDown init:)
				(foBranchCU init:)
				(poEgoOnBranch show: loop: 3 cel: 0 setCycle: CT 14 1 self)
			)
			(2
				(goSound1 playSound: 10111)
				(poEgoOnBranch setCycle: CT 21 1 self)
			)
			(3
				(goSound1 playSound: 13017)
				(poEgoOnBranch setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poEgoHangs of Prop
	(properties
		x 461
		y 75
		view 13003
	)
)

(instance poBoogleHoldsCard of Prop
	(properties
		x 345
		y 167
		view 13050
	)
)

(instance voTorinInMuck of View
	(properties
		x 463
		y 275
		view 13006
		loop 3
	)
)

(instance poTorin of Prop
	(properties)
)

(instance poEgoOnBranch of Prop
	(properties
		x 340
		y 170
		view 13001
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 4)
		(|= signal $1000)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 21) ; oFlags
			(self setScript: soUntieLeg)
		else
			(self setScript: soTieLeg)
		)
	)
)

(instance oBranchPlane of Plane
	(properties
		picture 13001
		priority 20
	)

	(method (init)
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(gGame handsOff:)
		(foClimbDown init: oBranchPlane)
		(foBranchCU init: oBranchPlane)
		(foBogBelow init: oBranchPlane)
	)

	(method (dispose)
		(gThePlane drawPic: 13000)
		(super dispose: &rest)
	)
)

(instance poEgoBungies of Prop
	(properties)
)

(instance oSwingSound of TPSound
	(properties)
)

(class poEgoHangingFromBranch of Prop
	(properties
		x 432
		y 44
		view 13005
		cel 8
		bSwing 1
	)

	(method (doit &tmp nSwingDist newX timeMultiplier newCel)
		(if (and bSwing (self isNotHidden:) swingDir)
			(if (> gGameTime swingTime)
				(+= swingPos swingDir)
				(if (> (= nSwingDist (Abs (- swingPos 8))) swingAmt)
					(cond
						((== (= swingDir (- 0 swingDir)) 1)
							(oSwingSound playSound: 13005)
						)
						((> swingAmt 3)
							(oSwingSound playSound: 13006)
						)
					)
					(= nSwingDist swingAmt)
					(if (> swingPos 8)
						(= swingPos (+ 8 swingAmt))
					else
						(= swingPos (- 8 swingAmt))
					)
				)
				(= timeMultiplier (- 9 swingAmt))
				(= swingTime (+ gGameTime (* (Max 1 nSwingDist) timeMultiplier)))
			)
			(if (!= (= newCel swingPos) cel)
				(= cel newCel)
			)
		)
		(super doit: &rest)
	)
)

(instance voBigBag of View
	(properties
		x 368
		y 280
		view 13008
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(= bWentForBag 1)
		(if (<= swingAmt 2)
			(gCurRoom setScript: soUntieWhileStationary)
		else
			(gCurRoom setScript: soUntieWhileSwinging)
		)
	)
)

(instance voLittleBag of View
	(properties
		x 455
		y 290
		view 13008
		loop 1
	)
)

(instance foSwingRight of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 65 563 43 543 79 576 156 586 196 480 224 457 148
					yourself:
				)
		)
	)

	(method (doVerb)
		(switch swingDir
			(0
				(= swingDir 1)
				(= swingAmt 1)
				(= swingTime gGameTime)
				(= swingPos 8)
				(foRope dispose:)
			)
			(1
				(if (>= swingAmt 8)
					(= swingAmt 8)
				else
					(+= swingAmt 1)
				)
			)
			(-1
				(if (<= swingAmt 1)
					(= swingAmt 0)
					(= swingDir 0)
					(= swingPos 8)
					(poEgoHangingFromBranch cel: 8)
					(oSwingSound stop:)
					(foRope init: oDanglePlane)
				else
					(-= swingAmt 1)
				)
			)
		)
	)
)

(instance foSwingLeft of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 424 68 417 128 385 231 329 227 319 194 339 151 346 98
					yourself:
				)
		)
	)

	(method (doVerb)
		(switch swingDir
			(0
				(= swingDir -1)
				(= swingAmt 1)
				(= swingTime gGameTime)
				(= swingPos 8)
				(foRope dispose:)
			)
			(1
				(if (<= swingAmt 1)
					(= swingAmt 0)
					(= swingDir 0)
					(= swingPos 8)
					(poEgoHangingFromBranch cel: 8)
					(oSwingSound stop:)
					(foRope init: oDanglePlane)
				else
					(-= swingAmt 1)
				)
			)
			(-1
				(if (>= swingAmt 8)
					(= swingAmt 8)
				else
					(+= swingAmt 1)
				)
			)
		)
	)
)

(instance foBogInScreen3 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 2 280 26 284 123 256 208 257 318 239 387 238 407 247 438 236 466 238 605 200 628 203 630 310 515 314 255 313 2 314
				yourself:
			)
		)
	)

	(method (doVerb)
		(= bWentForBag 0)
		(if (<= swingAmt 2)
			(gCurRoom setScript: soUntieWhileStationary)
		else
			(gCurRoom setScript: soUntieWhileSwinging)
		)
	)
)

(instance foBranchOverhead of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 65 293 49 358 61 385 37 407 49 458 45 521 26 523 36 436 60 405 60 379 61 367 76 362 87 346 88 332 73 293 67 250 93
					yourself:
				)
		)
	)

	(method (doVerb)
		(= bWentForBag 0)
		(cond
			((== swingAmt 0)
				(gCurRoom setScript: soTryToClimbRope)
			)
			((<= swingAmt 2)
				(gCurRoom setScript: soUntieWhileStationary)
			)
			(else
				(gCurRoom setScript: soUntieWhileSwinging)
			)
		)
	)
)

(instance foRope of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(if (== treeDiveType 1)
			(self addHotspotVerb: 4)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 427 63 439 63 442 130 430 131
					yourself:
				)
		)
	)

	(method (testHotspotVerb)
		(if (== swingAmt 0)
			(return (super testHotspotVerb: &rest))
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(= bWentForBag 0)
		(switch theVerb
			(4 ; ioRope
				(gCurRoom setScript: soUntieWhileStationary)
			)
			(1 ; Do
				(gCurRoom setScript: soUntieWhileStationary)
			)
		)
	)
)

(instance foCurlyBranch of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 557 89 583 58 605 86 611 108 630 86 630 125 621 143 592 151 575 138 569 106
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (>= swingPos 15)
			(gCurRoom setScript: soGrabBranch)
		else
			(gMessager say: 4 0 2 0) ; "If I could only reach that branch..."
		)
	)
)

(instance soUntieWhileSwinging of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13004 13010)
				(oSwingSound stop:)
				(poEgoHangingFromBranch hide:)
				(voBigBag dispose:)
				(gCurRoom picture: 13000)
				(gCurRoom drawPic: 13000)
				(voLittleBag init:)
				(poBoogleHoldsCard cel: 0 init:)
				(goSound1 playSound: 13010)
				(poTorin
					view: 13005
					loop: 2
					cel: 0
					posn: 469 63
					init:
					setCycle: CT 36 1 self
				)
			)
			(1
				(poBoogleHoldsCard setCycle: End self)
			)
			(2
				(goSound1 playSound: 13004)
				(poTorin setCycle: End self)
			)
			(3
				(if bWentForBag
					((ScriptID 64019 0) show: 0 42 12) ; DeathDialog
				else
					((ScriptID 64019 0) show: 0 42 7) ; DeathDialog
				)
				(poBoogleHoldsCard dispose:)
				(poTorin dispose:)
				(voLittleBag dispose:)
				(gCurRoom picture: 13002)
				(gCurRoom drawPic: 13002)
				(voBigBag init:)
				(poEgoHangingFromBranch show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(if bWentForBag
			((ScriptID 64019 0) show: 0 42 12) ; DeathDialog
		else
			((ScriptID 64019 0) show: 0 42 7) ; DeathDialog
		)
		(goSound1 stop:)
		(poBoogleHoldsCard dispose:)
		(poTorin dispose:)
		(voLittleBag dispose:)
		(gCurRoom picture: 13002)
		(gCurRoom drawPic: 13002)
		(voBigBag init:)
		(poEgoHangingFromBranch show:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soUntieWhileStationary of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 13002 13010)
				(poEgoHangingFromBranch hide:)
				(voBigBag dispose:)
				(gCurRoom picture: 13000)
				(gCurRoom drawPic: 13000)
				(voLittleBag init:)
				(poBoogleHoldsCard cel: 0 init:)
				(goSound1 playSound: 13010)
				(poTorin
					view: 13005
					loop: 4
					cel: 0
					posn: 469 63
					init:
					setCycle: CT 13 1 self
				)
			)
			(1
				(goSound1 playSound: 13002)
				(poTorin setCycle: End self)
			)
			(2
				(if bWentForBag
					((ScriptID 64019 0) show: 0 42 12) ; DeathDialog
				else
					((ScriptID 64019 0) show: 0 42 10) ; DeathDialog
				)
				(poBoogleHoldsCard dispose:)
				(poTorin dispose:)
				(voLittleBag dispose:)
				(gCurRoom picture: 13002)
				(gCurRoom drawPic: 13002)
				(voBigBag init:)
				(poEgoHangingFromBranch show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryToClimbRope of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 10126)
				(poEgoHangingFromBranch hide:)
				(voBigBag dispose:)
				(gCurRoom picture: 13000)
				(gCurRoom drawPic: 13000)
				(voLittleBag init:)
				(poBoogleHoldsCard cel: 0 init:)
				(poTorin
					view: 13005
					loop: 3
					cel: 0
					posn: 469 63
					init:
					setCycle: CT 10 1 self
				)
			)
			(1
				(goSound1 playSound: 10126)
				(poTorin setCycle: End self)
			)
			(2
				(poBoogleHoldsCard dispose:)
				(poTorin dispose:)
				(voLittleBag dispose:)
				(gCurRoom picture: 13002)
				(gCurRoom drawPic: 13002)
				(voBigBag init:)
				(poEgoHangingFromBranch show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poBoogle of Prop
	(properties
		x 406
		y 203
		view 13007
	)
)

(instance toTorinBog of Talker
	(properties
		x 406
		y 203
		view 13007
		loop 2
		priority 200
	)

	(method (init)
		(poTorin hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poTorin show:)
		(super dispose: &rest)
	)
)

(instance soBoogleGetBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBoogleHoldsCard dispose:)
				(voLittleBag dispose:)
				(goSound1 preload: 13014 13015 13016)
				(poBoogle
					view: 13007
					loop: 0
					cel: 0
					posn: 406 203
					init:
					setCycle: CT 23 1 self
				)
				(poTorin view: 13007 loop: 1 cel: 0 posn: 406 203 init:)
			)
			(1
				(goSound1 playSound: 13014)
				(poBoogle setCycle: CT 28 1 self)
			)
			(2
				(gMessager say: 4 1 2 3 self) ; "Boogle! Stop!"
				(poBoogle setCycle: CT 36 1 self)
			)
			(3)
			(4
				(poTorin setCycle: CT 1 1 self)
			)
			(5
				(poTorin setCycle: CT 0 -1 self)
			)
			(6
				(gMessager say: 4 1 2 4 self) ; "What?"
			)
			(7
				(poTorin setCycle: End)
				(= gtTorin 0)
				(poBoogle setCycle: CT 58 1 self)
			)
			(8
				(goSound1 playSound: 13015)
				(poBoogle setCycle: CT 80 1 self)
			)
			(9
				(goSound1 playSound: 13016)
				(poBoogle setCycle: CT 82 1 self)
			)
			(10
				(poTorin dispose:)
				(poBoogle setCycle: End self)
			)
			(11
				(poBoogle dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGrabBranch of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSwingSound stop:)
				(goSound1 preload: 13013 13017)
				(poEgoHangingFromBranch bSwing: 0 setCycle: End self)
			)
			(1
				(poEgoHangingFromBranch loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(poEgoHangingFromBranch dispose:)
				(gCurRoom deleteRoomPlane: oDanglePlane)
				(poBoogleHoldsCard cel: 0 init:)
				(voLittleBag init:)
				(poTorin
					view: 13051
					loop: 0
					cel: 0
					posn: 590 175
					init:
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo put: ((ScriptID 64001 0) get: 1)) ; oInvHandler, ioRope
				(goSound1 playSound: 13013)
				(poTorin setCycle: CT 21 1 self)
			)
			(4
				(goMusic1 fadeOut: 6 10 self)
			)
			(5
				(poTorin setCycle: CT 28 1 self)
			)
			(6
				(goSound1 playSound: 13018)
				(poTorin setCycle: CT 85 1 self)
			)
			(7
				(poTorin setCycle: End self)
			)
			(8
				(= gtTorin toTorinBog)
				(gMessager say: 4 1 2 2 self) ; "Now, how am I gonna get my bag?"
			)
			(9
				(goMusic1 fadeIn: 13000 12 10)
				(poTorin dispose:)
				(self setScript: soBoogleGetBag self)
			)
			(10
				(gEgo
					posn: 411 207
					setLoop: 5
					heading: 215
					stopwalk:
					setScaler: 0
					setScalePercent: 70
					show:
				)
				(gEgo setHeading: 180 self)
			)
			(11
				(gMessager say: 4 1 2 5 self) ; "Boogle! You mean this whole time you could have walked right out on that bog!?!"
			)
			(12
				(gEgo hide:)
				(poTorin
					view: 20206
					loop: 1
					cel: 0
					posn: 411 207
					setScalePercent: 70
					init:
				)
				(poBoogle
					view: 20206
					loop: 0
					cel: 0
					posn: 411 207
					setScalePercent: 70
					init:
					setCycle: CT 10 1 self
				)
			)
			(13
				(gMessager say: 4 1 2 6 self) ; "(NO. ONLY WHEN IT WAS FUNNY) Bwark!"
			)
			(14
				(poBoogle setCycle: Beg self)
			)
			(15
				(poTorin dispose:)
				(poBoogle setScale: 0 dispose:)
				(gEgo show:)
				(gMessager say: 4 1 2 7 self) ; ""Only when it's funny" huh? I'll "Only when it's funny" YOU!"
			)
			(16
				(gEgo setHeading: 225 self)
			)
			(17
				(gEgo hide:)
				(poTorin
					view: 13013
					loop: 0
					cel: 0
					posn: 410 204
					setScale: 0
					init:
				)
				(= bOnRoot 1)
				(foGround init:)
				(foRoot dispose:)
				(foBog dispose:)
				(foBranch dispose:)
				(foExitToForest dispose:)
				((ScriptID 64017 0) set: 23) ; oFlags
				((ScriptID 64017 0) clear: 22) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(poTorin dispose:)
		(self setScript: 0)
		(gEgo get: ((ScriptID 64001 0) get: 1)) ; oInvHandler, ioRope
		(gEgo hide:)
		(voLittleBag dispose:)
		(poBoogle dispose:)
		(poBoogleHoldsCard dispose:)
		(if (!= (gCurRoom plane:) oDanglePlane)
			(gCurRoom addRoomPlane: oDanglePlane)
		)
		(goSound1 stop:)
		(goMusic1 setMusic: 13000)
		(poEgoHangingFromBranch loop: 0 cel: 10 init:)
		(voBigBag init:)
		((ScriptID 64017 0) unSet: 23) ; oFlags
		((ScriptID 64017 0) set: 22) ; oFlags
		(gCurRoom setScript: soGrabBranch)
	)

	(method (ff)
		(poEgoHangingFromBranch dispose:)
		(self setScript: 0)
		(gEgo put: ((ScriptID 64001 0) get: 1)) ; oInvHandler, ioRope
		(gEgo hide:)
		(if (== (gCurRoom plane:) oDanglePlane)
			(gCurRoom deleteRoomPlane: oDanglePlane)
		)
		(poTorin view: 13013 loop: 4 cel: 0 posn: 410 204 setCycle: 0 init:)
		(goSound1 stop:)
		(goMusic1 setMusic: 13000)
		(poBoogle dispose:)
		(poBoogleHoldsCard dispose:)
		(voLittleBag dispose:)
		(= bOnRoot 1)
		(foRoot dispose:)
		(foBog dispose:)
		(foBranch dispose:)
		(foExitToForest dispose:)
		((ScriptID 64017 0) set: 23) ; oFlags
		((ScriptID 64017 0) clear: 22) ; oFlags
		(foGround init:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance oDanglePlane of Plane
	(properties
		picture 13002
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance roBog of TPRoom
	(properties
		picture 13000
		south 10100
	)

	(method (init)
		(super init: &rest)
		(gEgo init: normalize: posn: 76 295 loop: 3 setScalePercent: 80)
		((ScriptID 64018 0) posn: 72 290 init: normalize: setScalePercent: 80) ; oBoogle
		(if (not ((ScriptID 64017 0) test: 10)) ; oFlags
			(foBranch init:)
		)
		(foBog init:)
		(foRoot init:)
		(foExitToForest init:)
		(goMusic1 setMusic: 13000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 145 317 213 256 130 238 -2 317
					yourself:
				)
		)
		(gGame handsOn:)
		(gEgo setScript: soWalkIn)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 1)) ; oInvHandler, ioRope
	)
)

