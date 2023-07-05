;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Array)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	local0
	local1
)

(instance rm690 of LightRoom
	(properties
		picture 698
	)

	(method (init)
		(super init: &rest)
		(if (and (IsFlag 265) (not (IsFlag 291)))
			(= local1 60011)
		else
			(= local1 (Random 60101 60103))
		)
		(Load rsAUDIO local1)
		(gBackMusic stop: number: local1 loop: -1 play:)
		(self changeScene: 696 16)
	)

	(method (newRoom)
		(gBackMusic fade:)
		(gBackMusic2 fade:)
		(super newRoom: &rest)
	)

	(method (changeScene param1)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(cannonView dispose:)
		(moveLeftBack696 dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(694
				(setUp694 doit:)
				((ScriptID 1 5) init: newPic: 698 8) ; exitDown
				(if
					(or
						(and
							(not (IsFlag 314))
							(not (IsFlag 291))
							(not script)
							(IsFlag 265)
						)
						(and
							(not (IsFlag 314))
							(not (IsFlag 291))
							(not script)
							(Random 0 1)
						)
					)
					(gCurRoom setScript: monsterEnters)
				)
				(if (and (IsFlag 265) (not local0))
					(swingingFish x: 235 y: 118 init: setCycle: Fwd)
				)
			)
			(695
				((ScriptID 1 5) init: newPic: 698 8) ; exitDown
			)
			(696
				(volcano init:)
				(proc0_9 3697)
				((ScriptID 1 1) ; exitForward
					newPic: 699 8
					arrowStyle: 7
					nsLeft: 274
					nsTop: 61
					nsRight: 487
					nsBottom: 292
				)
				((ScriptID 1 5) ; exitDown
					init:
					newRoom: 660 ; rmFoundry
					nsLeft: 24
					nsTop: 176
					nsRight: 212
					nsBottom: 297
				)
			)
			(698
				((ScriptID 1 6) ; exitUp
					init:
					nsBottom: 50
					nsRight: 310
					exitCode: upExitCode
				)
				((ScriptID 1 7) init: newPic: 699 8 nsLeft: 200 nsRight: 290) ; exitBackUp
				(telescope698 init:)
				(Load rsAUDIO 620)
				(setUpCannon doit:)
			)
			(699
				(if local0
					(monster699
						x: (if (IsFlag 265) 198 else 192)
						y: 102
						loop: (if (IsFlag 265) 1 else 0)
						init:
						setScript: monsterScript
					)
				)
				(if (IsFlag 305)
					(aimedCannon init:)
				)
				(if (IsFlag 249)
					(fanProp699 init:)
				)
				(if (and (not local0) (IsFlag 265))
					(fish699 init:)
				)
				((ScriptID 1 1) newPic: 698 8 nsLeft: 100 nsBottom: 250) ; exitForward
				(moveLeftBack696 init: newPic: 696 16)
			)
			(700
				(if
					(or
						(and
							(not (IsFlag 314))
							(not (IsFlag 291))
							(not script)
							(IsFlag 265)
						)
						(and
							(not (IsFlag 314))
							(not (IsFlag 291))
							(not script)
							(Random 0 1)
						)
					)
					(gCurRoom setScript: monsterEnters700)
				)
				((ScriptID 1 5) init: newPic: 698 8) ; exitDown
				(setUp700 doit:)
				(if (and (IsFlag 265) (not local0))
					(swingingFish x: 336 y: 115 init: setCycle: Fwd)
				)
			)
		)
	)

	(method (dispose)
		(if (gInventory contains: (ScriptID 9 76)) ; invCannonBall
			(gInventory deleteItem: (ScriptID 9 76)) ; invCannonBall
		)
		(if (gInventory contains: (ScriptID 9 78)) ; invCannonFuse
			(gInventory deleteItem: (ScriptID 9 78)) ; invCannonFuse
		)
		(if (gInventory contains: (ScriptID 9 77)) ; invCannonPowder
			(gInventory deleteItem: (ScriptID 9 77)) ; invCannonPowder
		)
		(ClearFlag 314)
		(super dispose: &rest)
	)
)

(instance gameBreakingNewScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom changeScene: 694)
				(= cycles 2)
			)
			(1
				(gCurRoom setScript: lookThruScope)
			)
		)
	)
)

(instance bringUpSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic fade: 0 5 10 1 self)
			)
			(1
				(gBackMusic number: 60008 loop: -1 play: setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance bringUpMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic fade: 0 5 10 1 self)
			)
			(1
				(gBackMusic number: local1 loop: -1 play: setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance monsterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCel: 0)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance monsterEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 314)
				(KillRobot 186 213 99)
			)
			(1
				(swingingFish dispose:)
				(= local0 1)
				(gGame handsOn:)
				(monster694
					view: (if (IsFlag 265) 2184 else 2187)
					x: (if (IsFlag 265) 235 else 227)
					y: (if (IsFlag 265) 148 else 149)
					loop: (if (IsFlag 265) 0 else 1)
					init:
					setScript: monsterScript
				)
				(self dispose:)
			)
		)
	)
)

(instance monsterEnters700 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 314)
				(KillRobot 186 319 97)
			)
			(1
				(swingingFish dispose:)
				(= local0 1)
				(gGame handsOn:)
				(monster700
					view: (if (IsFlag 265) 2184 else 2187)
					loop: (if (IsFlag 265) 0 else 1)
					x: (if (IsFlag 265) 336 else 332)
					y: (if (IsFlag 265) 146 else 146)
					init:
					setScript: monsterScript
				)
				(self dispose:)
			)
		)
	)
)

(instance lookThruScope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60008)
				(scopeSound play:)
				(telescopeProp setCycle: End self)
			)
			(1
				(gBackMusic stop: number: 60008 play:)
				((ScriptID 1 5) dispose:) ; exitDown
				(gCast eachElementDo: #hide)
				(cond
					((and (not (IsFlag 291)) local0 (IsFlag 265))
						(proc0_9 184)
					)
					((and local0 (not (IsFlag 291)))
						(proc0_9 2186)
					)
				)
				(gCurRoom drawPic: 695 compassDir: 8)
				(if (gGame compassFace:)
					((gGame compassFace:) setLoop: 8 setCel: 0)
				)
				(self setScript: bringUpSound self)
			)
			(2
				(gGame handsOn:)
				((ScriptID 1 7) init: exitCode: fromScope) ; exitBackUp
			)
			(3
				(DoRobot)
				((ScriptID 1 5) init:) ; exitDown
				((ScriptID 1 7) dispose:) ; exitBackUp
				(gCurRoom drawPic: 694 compassDir: 8)
				(if (gGame compassFace:)
					((gGame compassFace:) setLoop: 8 setCel: 0)
				)
				(gCast eachElementDo: #show)
				(scopeSound play:)
				(gBackMusic stop: number: local1 play:)
				(telescopeProp setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dropTheBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dropBall play:)
				(hatchPanelProp setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lightFuse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 305)
					(gCurRoom changeScene: 694 8)
				else
					(gCurRoom changeScene: 700 8)
				)
				(ClearFlag 309)
				(fuse694 init: setCycle: End self)
				(fuseSound play:)
			)
			(1
				(fuse694 dispose:)
				(gCurRoom changeScene: 698 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance outToSea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom changeScene: 700 8)
				(cannon700 dispose:)
				(KillRobot 3696 0 0 0 1)
			)
			(1
				(ClearFlag 309)
				(ClearFlag 313)
				(ClearFlag 307)
				(ClearFlag 315)
				(gCurRoom changeScene: 698 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fireCannon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCast eachElementDo: #hide)
				(telescopeProp init:)
				(cond
					(local0
						(monster694
							view: 2187
							loop: 1
							x: 227
							y: 149
							init:
							setScript: monsterScript
						)
					)
					((IsFlag 265)
						(swingingFish x: 235 y: 118 init: setCycle: Fwd)
					)
				)
				(if (IsFlag 249)
					(fanProp694 init:)
				)
				(gCurRoom drawPic: 694)
				(KillRobot 3692)
			)
			(1
				(if (gCast contains: swingingFish)
					(swingingFish dispose:)
				)
				(telescopeProp dispose:)
				(if (gCast contains: monster694)
					(monster694 dispose:)
				)
				(if (gCast contains: fanProp694)
					(fanProp694 dispose:)
				)
				(ClearFlag 315)
				(ClearFlag 309)
				(ClearFlag 307)
				(ClearFlag 313)
				(gCast eachElementDo: #show)
				(gCurRoom changeScene: 698 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance killMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gCurRoom changeScene: 694 8)
				(Load rsAUDIO 622)
				(fuseSound play:)
				(fuse694 init: setCycle: End self)
			)
			(1
				(fuseProp dispose:)
				(gCast eachElementDo: #hide)
				(earthShatteringKaboom play:)
				(KillRobot 178)
				(gCurRoom drawPic: 653)
			)
			(2
				(ClearFlag 315)
				(ClearFlag 309)
				(ClearFlag 313)
				(ClearFlag 307)
				(SetFlag 291)
				(= local0 0)
				(gCurRoom changeScene: 694 8)
				(gBackMusic fade:)
				(Load rsAUDIO 60101)
				(gBackMusic2 number: 60101 play:)
				(gGame handsOn:)
			)
		)
	)
)

(instance closeHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(breachClose play:)
				(hatch setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveCannonLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatch dispose:)
				(cannonSound play:)
				(cannonView caller: self start: 2 10 0)
				(ClearFlag 305)
			)
			(1
				(cannonView caller: 0)
				(ringFeature nsLeft: 275 nsRight: 347 nsTop: 235 nsBottom: 286)
				(hatch init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveCannonRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatch dispose:)
				(cannonSound play:)
				(SetFlag 305)
				(cannonView caller: self start: 1 10 0)
			)
			(1
				(cannonView caller: 0)
				(ringFeature nsLeft: 331 nsRight: 403 nsTop: 220 nsBottom: 269)
				(hatch init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fish699 of Prop
	(properties
		x 195
		y 104
		view 699
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance fanProp699 of Prop
	(properties
		view 4699
	)

	(method (init)
		(if (IsFlag 250)
			(= loop 1)
			(= x 334)
			(= y 63)
		else
			(= loop 2)
			(= x 343)
			(= y 146)
		)
		(super init: &rest)
		(if (not (IsFlag 250))
			(self setCycle: Fwd)
		)
	)
)

(instance swingingFish of Prop
	(properties
		view 2187
		loop 4
	)
)

(instance volcano of Prop
	(properties
		x 370
		y 60
		view 3698
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance monster699 of Prop
	(properties
		view 699
	)
)

(instance fanProp700 of Prop
	(properties
		x 474
		y 185
		view 700
	)

	(method (init)
		(if (IsFlag 250)
			(= loop 1)
		else
			(= loop 0)
		)
		(super init:)
		(if (not (IsFlag 250))
			(self setCycle: Fwd)
		)
	)
)

(instance fanProp694 of Prop
	(properties
		x 349
		y 198
		view 4698
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 250))
			(self setCycle: Fwd)
		)
	)
)

(instance cannon694 of View
	(properties
		x 215
		y 192
		view 2187
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 11)
	)

	(method (doVerb theVerb)
		(if
			(and
				(or
					(and (== theVerb 11) (== ((ScriptID 9 5) state:) 2)) ; invLighter, invLighter
					(== theVerb 95) ; invTorch
				)
				(IsFlag 309)
			)
			(fuseProp doVerb: theVerb)
		)
	)
)

(instance cannon700 of View
	(properties
		x 208
		y 300
		view 700
		loop 2
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 11)
	)

	(method (doVerb theVerb)
		(if
			(and
				(or
					(and (== theVerb 11) (== ((ScriptID 9 5) state:) 2)) ; invLighter, invLighter
					(== theVerb 95) ; invTorch
				)
				(IsFlag 309)
			)
			(fuseProp doVerb: theVerb)
		)
	)
)

(instance monster694 of Prop
	(properties
		x 227
		y 149
		view 2187
		loop 1
	)
)

(instance monster700 of Prop
	(properties
		x 332
		y 146
		view 2187
		loop 1
	)
)

(instance fuse694 of Prop
	(properties
		x 274
		y 300
		view 2187
		loop 2
	)

	(method (init)
		(= cel 0)
		(if (IsFlag 305)
			(= x 276)
			(= y 300)
		else
			(= x 274)
			(= y 300)
		)
		(super init: &rest)
	)
)

(instance telescopeProp of Prop
	(properties
		x 359
		y 299
		view 2187
		loop 3
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 291)) local0) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: lookThruScope)
		)
	)
)

(instance cannonBalls of Prop
	(properties
		x 2
		y 294
		view 3680
		loop 2
	)

	(method (cue)
		(gInventory addItem: (ScriptID 9 76)) ; invCannonBall
		(self setCel: 0)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(not (gInventory contains: (ScriptID 9 76))) ; invCannonBall
				(not (IsFlag 307))
				(not (IsFlag 291))
			)
			(gGame handsOff:)
			(ballRolling play:)
			(self setCycle: End self)
		)
	)
)

(instance powder of Prop
	(properties
		x 406
		y 161
		view 3680
		loop 4
	)

	(method (cue)
		(gInventory addItem: (ScriptID 9 77)) ; invCannonPowder
		(self setCel: 0)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(not (gInventory contains: (ScriptID 9 77))) ; invCannonPowder
				(not (IsFlag 313))
				(not (IsFlag 291))
			)
			(gGame handsOff:)
			(powderSound play:)
			(self setCycle: End self)
		)
	)
)

(instance ringFeature of Feature
	(properties)

	(method (init)
		(if (IsFlag 305)
			(= nsLeft 331)
			(= nsRight 403)
			(= nsTop 220)
			(= nsBottom 269)
		else
			(= nsLeft 275)
			(= nsRight 347)
			(= nsTop 235)
			(= nsBottom 286)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (IsFlag 305)
				(gCurRoom setScript: moveCannonLeft)
			else
				(gCurRoom setScript: moveCannonRight)
			)
		)
	)
)

(instance fuse of Feature
	(properties
		nsLeft 124
		nsTop 242
		nsRight 195
		nsBottom 292
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(not (gInventory contains: (ScriptID 9 78))) ; invCannonFuse
				(not (IsFlag 309))
				(not (IsFlag 291))
			)
			(fuseClip play:)
			(gInventory addItem: (ScriptID 9 78)) ; invCannonFuse
		)
	)
)

(instance aimedCannon of View
	(properties
		x 139
		y 183
		view 4699
	)
)

(instance fuseProp of Prop
	(properties
		x 241
		y 114
		view 3680
		loop 1
	)

	(method (init)
		(gCast addToFront: self)
		(if (IsFlag 305)
			(= cel 30)
		else
			(= cel 0)
		)
		(super init: &rest)
		(self setPri: 401)
		(approachX hotVerbs: 11 95)
	)

	(method (doit)
		(super doit: &rest)
		(self setCel: (cannonView curFrame:))
	)

	(method (doVerb theVerb)
		(if
			(or
				(and (== theVerb 11) (== ((ScriptID 9 5) state:) 2)) ; invLighter, invLighter
				(== theVerb 95) ; invTorch
			)
			(ClearFlag 309)
			((ScriptID 9 5) state: 0 cel: 0) ; invLighter
			(cond
				(
					(and
						(IsFlag 315)
						(IsFlag 265)
						(not (IsFlag 291))
						(IsFlag 305)
						local0
					)
					(gCurRoom setScript: killMonster)
				)
				((and (IsFlag 315) (not (IsFlag 305)))
					(gCurRoom setScript: outToSea)
				)
				((IsFlag 315)
					(gCurRoom setScript: fireCannon)
				)
				(else
					(gCurRoom setScript: lightFuse)
				)
			)
		)
	)
)

(instance hatch of Prop
	(properties
		view 3680
	)

	(method (cue)
		(hatchInset init:)
		(gGame handsOn:)
	)

	(method (init)
		(gCast addToFront: self)
		(if (IsFlag 305)
			(= loop 3)
			(= x 257)
			(= y 106)
		else
			(= loop 5)
			(= x 156)
			(= y 108)
		)
		(super init: &rest)
		(self setPri: 400)
		(approachX hotVerbs: 5 11 95 85)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; invLighter
				(if (IsFlag 309)
					(fuseProp doVerb: theVerb)
				)
			)
			(95 ; invTorch
				(if (IsFlag 309)
					(fuseProp doVerb: theVerb)
				)
			)
			(85 ; invCannonFuse
				(cannonView doVerb: theVerb)
			)
			(5 ; Do
				(gGame handsOff:)
				(breachOpen play:)
				(self setCycle: End self)
			)
		)
	)
)

(instance noFuse of PanelView
	(properties
		x 186
		y 149
		view 693
		loop 2
	)
)

(instance hatchInset of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(hatchPanelProp init: self 1 1)
		(if (not (IsFlag 309))
			(noFuse init: self 0 0)
		)
	)

	(method (dispose)
		(gCurRoom setScript: closeHatch)
		(super dispose: &rest)
	)
)

(instance hatchPanelProp of PanelProp
	(properties
		view 693
	)

	(method (init)
		(cond
			((IsFlag 315)
				(= loop 0)
				(= cel 1)
			)
			((and (IsFlag 307) (IsFlag 313))
				(= loop 0)
				(= cel 2)
			)
			((IsFlag 307)
				(= loop 1)
				(= cel 7)
			)
			((IsFlag 313)
				(= loop 0)
				(= cel 3)
			)
			(else
				(= cel (= loop 0))
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 85 83 84)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((IsFlag 315)
						(ClearFlag 315)
						(ClearFlag 307)
						(gInventory addItem: (ScriptID 9 76)) ; invCannonBall
						(self setLoop: 0 setCel: 3)
					)
					((and (IsFlag 307) (IsFlag 313))
						(ClearFlag 313)
						(gInventory addItem: (ScriptID 9 77)) ; invCannonPowder
						(self setLoop: 1 setCel: 7)
					)
					((IsFlag 307)
						(ClearFlag 307)
						(gInventory addItem: (ScriptID 9 76)) ; invCannonBall
						(self setLoop: 0 setCel: 0)
					)
					((IsFlag 313)
						(ClearFlag 313)
						(gInventory addItem: (ScriptID 9 77)) ; invCannonPowder
						(self setLoop: 0 setCel: 0)
					)
				)
			)
			(85 ; invCannonFuse
				(gInventory deleteItem: (ScriptID 9 78)) ; invCannonFuse
				(SetFlag 309)
				(fuseProp init:)
				(noFuse dispose:)
			)
			(83 ; invCannonBall
				(gInventory deleteItem: (ScriptID 9 76)) ; invCannonBall
				(SetFlag 307)
				(if (IsFlag 313)
					(SetFlag 315)
					(newBallSound play:)
					(self setLoop: 0 setCel: 1)
				else
					(gCurRoom setScript: dropTheBall)
				)
			)
			(84 ; invCannonPowder
				(gInventory deleteItem: (ScriptID 9 77)) ; invCannonPowder
				(SetFlag 313)
				(newPowderSound play:)
				(if (IsFlag 307)
					(self setLoop: 0 setCel: 2)
				else
					(self setLoop: 0 setCel: 3)
				)
			)
		)
	)
)

(instance upExitCode of ExitCode
	(properties)

	(method (doit)
		(if (IsFlag 305)
			(= nextScene 694)
		else
			(= nextScene 700)
		)
		(self cue:)
	)
)

(instance fromScope of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(lookThruScope setScript: bringUpMusic lookThruScope)
	)
)

(instance setUpCannon of Code
	(properties)

	(method (doit)
		(ringFeature init:)
		(cannonView init:)
		(cannonBalls init:)
		(powder init:)
		(hatch init:)
		(if (IsFlag 309)
			(fuseProp init:)
		)
		(Load rsAUDIO 61805)
		(fuse init:)
	)
)

(instance setUp694 of Code
	(properties)

	(method (doit)
		(cannon694 init:)
		(telescopeProp init:)
		(if (IsFlag 309)
			(fuse694 init:)
		)
		(if (IsFlag 249)
			(fanProp694 init:)
		)
		(if
			(or
				(and (IsFlag 314) (IsFlag 265) (not (IsFlag 291)))
				(and (not (IsFlag 291)) (IsFlag 314) local0)
			)
			(monster694
				view: (if (IsFlag 265) 2184 else 2187)
				x: (if (IsFlag 265) 235 else 227)
				y: (if (IsFlag 265) 148 else 149)
				loop: (if (IsFlag 265) 0 else 1)
				init:
				setScript: monsterScript
			)
		)
	)
)

(instance setUp700 of Code
	(properties)

	(method (doit)
		(if (IsFlag 249)
			(fanProp700 init:)
		)
		(cannon700 init:)
		(if local0
			(monster700
				view: (if (IsFlag 265) 2184 else 2187)
				loop: (if (IsFlag 265) 0 else 1)
				x: (if (IsFlag 265) 336 else 332)
				y: (if (IsFlag 265) 146 else 146)
				init:
				setScript: monsterScript
			)
		)
	)
)

(instance earthShatteringKaboom of Sound
	(properties
		flags 1
		number 622
	)
)

(instance ballRolling of Sound
	(properties
		flags 1
		number 62104
	)
)

(instance fuseSound of Sound
	(properties
		flags 1
		number 61800
	)
)

(instance scopeSound of Sound
	(properties
		flags 1
		number 61802
	)
)

(instance powderSound of Sound
	(properties
		flags 1
		number 618
	)
)

(instance cannonSound of Sound
	(properties
		flags 1
		number 620
	)
)

(instance breachOpen of Sound
	(properties
		flags 1
		number 621
	)
)

(instance breachClose of Sound
	(properties
		flags 1
		number 62101
	)
)

(instance dropBall of Sound
	(properties
		flags 1
		number 62103
	)
)

(instance cannonView of RobotPlayer
	(properties
		x 36
		y 9
		number 693
	)

	(method (init &tmp temp0 temp1)
		(if (IsFlag 305)
			(= curFrame (= temp0 30))
		else
			(= curFrame (= temp0 0))
		)
		(Robot 0 number gThePlane -1 x y) ; Open
		(Robot 1 temp0) ; DisplayFrame
		(= temp1 (IntArray new: 14))
		(= end (= maxFrame (- (Robot 2 (temp1 data:)) 1))) ; FrameInfo
		(temp1 dispose:)
		(= global208 self)
		(if (not approachX)
			((= approachX (Hiliter new:)) client: self hotVerbs: 5)
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: approachX)
		)
		(approachX hotVerbs: 11 95 85 5)
	)

	(method (doVerb theVerb)
		(if
			(and
				(or
					(and (== theVerb 11) (== ((ScriptID 9 5) state:) 2)) ; invLighter, invLighter
					(== theVerb 95) ; invTorch
				)
				(IsFlag 309)
			)
			(fuseProp doVerb: theVerb)
		)
		(if (== theVerb 85) ; invCannonFuse
			(gInventory deleteItem: (ScriptID 9 78)) ; invCannonFuse
			(SetFlag 309)
			(fuseProp init:)
		)
		(if (== theVerb 5) ; Do
			(upExitCode doit:)
		)
	)
)

(instance telescope698 of Feature
	(properties
		nsLeft 302
		nsTop 1
		nsRight 350
		nsBottom 37
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 291)) (IsFlag 305) local0) ; Do
			(gCurRoom setScript: gameBreakingNewScript)
		)
	)
)

(instance moveLeftBack696 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 9)
		(= nsLeft 0)
		(= nsTop 176)
		(= nsRight 276)
		(= nsBottom 300)
		(super init: &rest)
	)
)

(instance newBallSound of Sound
	(properties
		flags 1
		number 61804
	)
)

(instance newPowderSound of Sound
	(properties
		flags 1
		number 61803
	)
)

(instance fuseClip of Sound
	(properties
		flags 1
		number 61805
	)
)

