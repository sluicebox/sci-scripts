;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use LightRoom)
(use VMDPlayer)
(use Array)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm225 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm225 of LightRoom
	(properties
		picture 218
	)

	(method (init)
		(if (== gPrevRoomNum 220)
			(= picture 219)
			((ScriptID 1 3) newPic: 221) ; exitLeft
			((ScriptID 1 4) newPic: 222) ; exitRight
			((ScriptID 1 2) newPic: 218) ; exitBack
			((ScriptID 1 1) newRoom: 212) ; exitForward
		else
			(leftForward init: newPic: 220)
			((ScriptID 1 1) newRoom: 220) ; exitForward
			((ScriptID 1 4) newPic: 221) ; exitRight
			((ScriptID 1 3) newPic: 222) ; exitLeft
			((ScriptID 1 2) newPic: 219) ; exitBack
		)
		(gMySoundFX setVol: 75)
		(if (== (gBackMusic number:) 2011)
			(gBackMusic setVol: 100)
		)
		(super init: &rest)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(roostStar dispose:)
		(fortStar dispose:)
		(wreckStar dispose:)
		(domainStar dispose:)
		(powerLight222 dispose:)
		(powerLight218 dispose:)
		(switch param1
			(218
				(if (gCast contains: consoleProp)
					(consoleProp dispose:)
				)
				(if (gCast contains: openDoor)
					(openDoor dispose:)
				)
				(if (gCast contains: chartTube)
					(chartTube dispose:)
					(otherChartTube dispose:)
				)
				(if (and (IsFlag 105) (IsFlag 106))
					(powerLight218 init:)
				)
				((ScriptID 1 4) newPic: 221) ; exitRight
				((ScriptID 1 3) newPic: 222) ; exitLeft
				((ScriptID 1 2) newPic: 219) ; exitBack
				(leftForward init: newPic: 220)
				((ScriptID 1 1) newRoom: 220) ; exitForward
			)
			(219
				(if (gCast contains: chartTube)
					(chartTube dispose:)
					(otherChartTube dispose:)
				)
				((ScriptID 1 3) newPic: 221) ; exitLeft
				((ScriptID 1 4) newPic: 222) ; exitRight
				((ScriptID 1 2) newPic: 218) ; exitBack
				((ScriptID 1 1) newRoom: 212) ; exitForward
			)
			(220
				(Load rsAUDIO 2027 2028)
				(consoleProp init:)
				(if (not (and (IsFlag 106) (IsFlag 105)))
					(deadKeys init:)
				else
					(Load rsAUDIO 2005 2006)
				)
				(if (gCast contains: chartTube)
					(chartTube dispose:)
					(otherChartTube dispose:)
				)
				(if (and (IsFlag 106) (IsFlag 105))
					(powerLight init:)
				)
				(leftSwitch init:)
				(rightSwitch init:)
				((ScriptID 1 4) init: resetProps: exitCode: exitRightCode) ; exitRight
				((ScriptID 1 3) init: resetProps: exitCode: exitLeftCode) ; exitLeft
			)
			(221
				(if (gCast contains: openDoor)
					(openDoor dispose:)
				)
				(if (gCast contains: chartTube)
					(chartTube dispose:)
					(otherChartTube dispose:)
				)
				((ScriptID 1 4) newPic: 219) ; exitRight
				((ScriptID 1 3) newPic: 218) ; exitLeft
				((ScriptID 1 2) newPic: 222) ; exitBack
			)
			(222
				(Load rsAUDIO 20271 20272)
				(if (and (IsFlag 106) (IsFlag 105))
					(powerLight222 init:)
				)
				(if (gCast contains: consoleProp)
					(consoleProp dispose:)
				)
				(if (gCast contains: openDoor)
					(openDoor dispose:)
				)
				(chartTube init:)
				(otherChartTube init:)
				((ScriptID 1 4) newPic: 220) ; exitRight
				((ScriptID 1 3) newPic: 219) ; exitLeft
				((ScriptID 1 2) newPic: 221) ; exitBack
			)
		)
	)
)

(instance goThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gGame setCursor: gTheInvisCursor 1)
				(gCurRoom drawPic: 0)
				(Sounds eachElementDo: #pause)
				(gGlobalVMD
					number: 4489
					stretch: 1
					holdLastFrame: 1
					init:
					play: self
					close:
				)
			)
			(2
				(switch global227
					(4
						(gGlobalVMD
							number: 235
							stretch: 1
							holdLastFrame: 0
							init:
							play:
							close:
						)
						(SetFlag 204)
					)
					(2
						(gGlobalVMD
							number: 4429
							stretch: 1
							holdLastFrame: 0
							boostRGB: -40
							init:
							play:
							close:
						)
						(SetFlag 204)
					)
					(1
						(if (IsFlag 427)
							(gGlobalVMD
								number: 801
								stretch: 0
								doubled: 1
								holdLastFrame: 0
								play:
								stretch: 1
								close:
							)
						else
							(gGlobalVMD
								number: 800
								stretch: 0
								doubled: 1
								holdLastFrame: 0
								play:
								stretch: 1
								close:
							)
							(SetFlag 427)
						)
						(gGlobalVMD doubled: 0 stretch: 1)
						(ClearFlag 204)
					)
					(3
						(gGlobalVMD
							number: 600
							stretch: 1
							holdLastFrame: 0
							init:
							play:
							close:
						)
						(ClearFlag 204)
					)
				)
				(Sounds eachElementDo: #pause 0)
				(gGame normalizeCursor:)
				(= global226 global227)
				(ClearFlag 106)
				(if (!= global226 4)
					(ClearFlag 229)
					(ClearFlag 108)
				)
				(SetFlag 383)
				(ClearFlag 206)
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance flashIndicator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(indicator hide:)
				(= ticks 15)
			)
			(1
				(indicator show:)
				(= ticks 15)
			)
			(2
				(indicator hide:)
				(= ticks 15)
			)
			(3
				(indicator show:)
				(= ticks 15)
			)
			(4
				(indicator hide:)
				(= ticks 15)
			)
			(5
				(indicator show:)
				(initStars doit:)
				(if (and (IsFlag 384) (IsFlag 229) global227 local3)
					(gCurRoom setScript: goThere)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance closeConsoleLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roostStar dispose:)
				(fortStar dispose:)
				(wreckStar dispose:)
				(domainStar dispose:)
				(local1 dispose:)
				(local2 dispose:)
				(latList dispose:)
				(lonList dispose:)
				(indicator dispose:)
				(consoleSound play:)
				(consoleProp init: setCycle: Beg self)
				(keyPadSet dispose:)
			)
			(1
				(leftSwitch dispose:)
				(rightSwitch dispose:)
				(powerLight dispose:)
				(ClearFlag 206)
				(gGame handsOn:)
				(gCurRoom changeScene: 222)
				(self dispose:)
			)
		)
	)
)

(instance closeConsoleRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roostStar dispose:)
				(fortStar dispose:)
				(wreckStar dispose:)
				(domainStar dispose:)
				(local1 dispose:)
				(local2 dispose:)
				(latList dispose:)
				(lonList dispose:)
				(gGame handsOff:)
				(indicator dispose:)
				(consoleSound play:)
				(consoleProp init: setCycle: Beg self)
				(keyPadSet dispose:)
			)
			(1
				(leftSwitch dispose:)
				(rightSwitch dispose:)
				(powerLight dispose:)
				(ClearFlag 206)
				(gGame handsOn:)
				(gCurRoom changeScene: 218)
				(self dispose:)
			)
		)
	)
)

(instance initStars of Code
	(properties)

	(method (doit)
		(fortStar init:)
		(roostStar init:)
		(if (IsFlag 410)
			(wreckStar init:)
		)
		(if (IsFlag 411)
			(domainStar init:)
		)
	)
)

(instance findNextSpot of Code
	(properties)

	(method (doit param1 param2)
		(if (== param1 leftSwitch)
			(cond
				((== (local2 at: 0) -1)
					(local2 at: 0 (param2 value:))
					(param2 posn: 32 188)
				)
				((== (local2 at: 1) -1)
					(local2 at: 1 (param2 value:))
					(param2 posn: 39 188)
				)
				((== (local2 at: 3) -1)
					(local2 at: 3 (param2 value:))
					(param2 posn: 54 188)
				)
				((== (local2 at: 4) -1)
					(local2 at: 4 (param2 value:))
					(param2 posn: 63 188)
				)
				(else
					(lonList dispose:)
					(lonList
						add:
							((View new:)
								view: 2217
								loop: 15
								cel: 6
								x: 134
								y: 188
								init:
								yourself:
							)
					)
					(local2 at: 0 (param2 value:))
					(local2 at: 1 -1)
					(local2 at: 3 -1)
					(local2 at: 4 -1)
					(param2 posn: 32 188)
				)
			)
		)
		(if (== param1 rightSwitch)
			(cond
				((== (local1 at: 0) -1)
					(local1 at: 0 (param2 value:))
					(param2 posn: 113 188)
				)
				((== (local1 at: 1) -1)
					(local1 at: 1 (param2 value:))
					(param2 posn: 121 188)
				)
				((== (local1 at: 2) -1)
					(local1 at: 2 (param2 value:))
					(param2 posn: 129 188)
				)
				((== (local1 at: 4) -1)
					(local1 at: 4 (param2 value:))
					(param2 posn: 140 188)
				)
				((== (local1 at: 5) -1)
					(local1 at: 5 (param2 value:))
					(param2 posn: 148 188)
				)
				(else
					(latList dispose:)
					(latList
						add:
							((View new:)
								view: 2217
								loop: 15
								cel: 6
								x: 47
								y: 188
								init:
								yourself:
							)
					)
					(local1 at: 0 (param2 value:))
					(local1 at: 1 -1)
					(local1 at: 2 -1)
					(local1 at: 4 -1)
					(local1 at: 5 -1)
					(param2 posn: 113 188)
				)
			)
		)
	)
)

(instance setNav of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(cond
			((and param1 argc)
				(= temp0 param1)
			)
			((!= global226 global227)
				(= temp0 global227)
			)
			(else
				(= temp0 global226)
			)
		)
		(switch temp0
			(1
				(SetFlag 411)
				(domainStar dispose:)
				(indicator init: setCel: 1)
				(if (not local4)
					(indicator setScript: flashIndicator)
				else
					(= local4 0)
				)
				(local1 at: 0 -1)
				(local1 at: 1 -1)
				(local1 at: 2 -1)
				(local1 at: 4 -1)
				(local1 at: 5 -1)
				(local2 at: 0 -1)
				(local2 at: 1 -1)
				(local2 at: 3 -1)
				(local2 at: 4 -1)
				(latList dispose:)
				(lonList dispose:)
				(latList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 47
							y: 188
							init:
							yourself:
						)
				)
				(lonList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 134
							y: 188
							init:
							yourself:
						)
				)
				(= temp1 local0)
				(= local0 rightSwitch)
				(oneButton doVerb: 5 doVerb: 5)
				(nineButton doVerb: 5)
				(oneButton doVerb: 5 doVerb: 5)
				(= local0 leftSwitch)
				(twoButton doVerb: 5 doVerb: 5)
				(zeroButton doVerb: 5)
				(oneButton doVerb: 5)
				(= local0 temp1)
			)
			(2
				(roostStar dispose:)
				(indicator init: setCel: 3)
				(if (not local4)
					(indicator setScript: flashIndicator)
				else
					(= local4 0)
				)
				(local1 at: 0 -1)
				(local1 at: 1 -1)
				(local1 at: 2 -1)
				(local1 at: 4 -1)
				(local1 at: 5 -1)
				(local2 at: 0 -1)
				(local2 at: 1 -1)
				(local2 at: 3 -1)
				(local2 at: 4 -1)
				(latList dispose:)
				(lonList dispose:)
				(latList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 47
							y: 188
							init:
							yourself:
						)
				)
				(= temp1 local0)
				(= local0 rightSwitch)
				(oneButton doVerb: 5 doVerb: 5)
				(eightButton doVerb: 5 doVerb: 5)
				(twoButton doVerb: 5)
				(lonList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 134
							y: 188
							init:
							yourself:
						)
				)
				(= local0 leftSwitch)
				(twoButton doVerb: 5)
				(zeroButton doVerb: 5)
				(eightButton doVerb: 5 doVerb: 5)
				(= local0 temp1)
			)
			(3
				(fortStar dispose:)
				(indicator init: setCel: 0)
				(if (not local4)
					(indicator setScript: flashIndicator)
				else
					(= local4 0)
				)
				(local1 at: 0 -1)
				(local1 at: 1 -1)
				(local1 at: 2 -1)
				(local1 at: 4 -1)
				(local1 at: 5 -1)
				(local2 at: 0 -1)
				(local2 at: 1 -1)
				(local2 at: 3 -1)
				(local2 at: 4 -1)
				(latList dispose:)
				(lonList dispose:)
				(latList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 47
							y: 188
							init:
							yourself:
						)
				)
				(= temp1 local0)
				(= local0 rightSwitch)
				(oneButton doVerb: 5 doVerb: 5)
				(eightButton doVerb: 5 doVerb: 5)
				(sevenButton doVerb: 5)
				(lonList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 134
							y: 188
							init:
							yourself:
						)
				)
				(= local0 leftSwitch)
				(twoButton doVerb: 5)
				(oneButton doVerb: 5)
				(sixButton doVerb: 5)
				(fiveButton doVerb: 5)
				(= local0 temp1)
			)
			(4
				(wreckStar dispose:)
				(SetFlag 410)
				(indicator init: setCel: 2)
				(if (not local4)
					(indicator setScript: flashIndicator)
				else
					(= local4 0)
				)
				(local1 at: 0 -1)
				(local1 at: 1 -1)
				(local1 at: 2 -1)
				(local1 at: 4 -1)
				(local1 at: 5 -1)
				(local2 at: 0 -1)
				(local2 at: 1 -1)
				(local2 at: 3 -1)
				(local2 at: 4 -1)
				(latList dispose:)
				(lonList dispose:)
				(latList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 47
							y: 188
							init:
							yourself:
						)
				)
				(lonList
					add:
						((View new:)
							view: 2217
							loop: 15
							cel: 6
							x: 134
							y: 188
							init:
							yourself:
						)
				)
				(= temp1 local0)
				(= local0 rightSwitch)
				(oneButton doVerb: 5 doVerb: 5)
				(eightButton doVerb: 5)
				(nineButton doVerb: 5)
				(sixButton doVerb: 5)
				(= local0 leftSwitch)
				(twoButton doVerb: 5)
				(zeroButton doVerb: 5)
				(sixButton doVerb: 5)
				(sevenButton doVerb: 5)
			)
			(else
				(indicator dispose:)
			)
		)
	)
)

(instance exitLeftCode of Code
	(properties)

	(method (doit)
		(if (IsFlag 206)
			(gCurRoom setScript: closeConsoleLeft)
		else
			(if (gCast contains: powerLight)
				(powerLight dispose:)
			)
			(if (gCast contains: deadKeys)
				(deadKeys dispose:)
			)
			(leftSwitch dispose:)
			(rightSwitch dispose:)
			(gCurRoom changeScene: 222)
		)
	)
)

(instance exitRightCode of Code
	(properties)

	(method (doit)
		(if (IsFlag 206)
			(gCurRoom setScript: closeConsoleRight)
		else
			(if (gCast contains: powerLight)
				(powerLight dispose:)
			)
			(if (gCast contains: deadKeys)
				(deadKeys dispose:)
			)
			(leftSwitch dispose:)
			(rightSwitch dispose:)
			(gCurRoom changeScene: 218)
		)
	)
)

(instance chartExitBack of ExitCode ; UNUSED
	(properties)

	(method (cue)
		(chartTube dispose:)
		(otherChartTube dispose:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 221)
		(if (!= (otherChartTube cel:) 0)
			(otherChartTube setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance chartExitLeft of ExitCode ; UNUSED
	(properties)

	(method (cue)
		(chartTube dispose:)
		(otherChartTube dispose:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 219)
		(if (!= (otherChartTube cel:) 0)
			(otherChartTube setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance chartExitRight of ExitCode ; UNUSED
	(properties)

	(method (cue)
		(chartTube dispose:)
		(otherChartTube dispose:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 218)
		(if (!= (otherChartTube cel:) 0)
			(otherChartTube setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance checkCoords of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(== (local1 at: 0) 1)
					(== (local1 at: 1) 1)
					(== (local1 at: 2) 9)
					(== (local1 at: 4) 1)
					(== (local1 at: 5) 1)
					(== (local2 at: 0) 2)
					(== (local2 at: 1) 2)
					(== (local2 at: 3) 0)
					(== (local2 at: 4) 1)
					(IsFlag 426)
				)
				(= temp0 1)
			)
			(
				(and
					(== (local1 at: 0) 1)
					(== (local1 at: 1) 1)
					(== (local1 at: 2) 8)
					(== (local1 at: 4) 8)
					(== (local1 at: 5) 2)
					(== (local2 at: 0) 2)
					(== (local2 at: 1) 0)
					(== (local2 at: 3) 8)
					(== (local2 at: 4) 8)
				)
				(= temp0 2)
			)
			(
				(and
					(== (local1 at: 0) 1)
					(== (local1 at: 1) 1)
					(== (local1 at: 2) 8)
					(== (local1 at: 4) 8)
					(== (local1 at: 5) 7)
					(== (local2 at: 0) 2)
					(== (local2 at: 1) 1)
					(== (local2 at: 3) 6)
					(== (local2 at: 4) 5)
				)
				(= temp0 3)
			)
			(
				(and
					(== (local1 at: 0) 1)
					(== (local1 at: 1) 1)
					(== (local1 at: 2) 8)
					(== (local1 at: 4) 9)
					(== (local1 at: 5) 6)
					(== (local2 at: 0) 2)
					(== (local2 at: 1) 0)
					(== (local2 at: 3) 6)
					(== (local2 at: 4) 7)
				)
				(= temp0 4)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(class NumberView of View
	(properties
		value -1
	)

	(method (init)
		(findNextSpot doit: local0 self)
		(super init: &rest)
	)
)

(instance chartTube of Prop
	(properties
		x 194
		y 155
		view 2218
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if (== cel 0)
				(chartOpen play:)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance otherChartTube of Prop
	(properties
		x 406
		y 257
		loop 1
		view 2218
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
		(setUpChart doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if (== cel 0)
				(chartUnroll play:)
				(self setCycle: CT 24 1 self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance setUpChart of Code
	(properties)

	(method (doit)
		(otherChartTube cel: 0)
		(chartPanel init:)
	)
)

(instance consoleProp of Prop
	(properties
		x 159
		y 13
		view 2215
	)

	(method (cue)
		(SetFlag 206)
		(keyPadSet
			add:
				zeroButton
				oneButton
				twoButton
				threeButton
				fourButton
				fiveButton
				sixButton
				sevenButton
				eightButton
				nineButton
				enterButton
			eachElementDo: #init
		)
		(latList
			add:
				((View new:)
					view: 2217
					loop: 15
					cel: 6
					x: 47
					y: 188
					init:
					yourself:
				)
		)
		(lonList
			add:
				((View new:)
					view: 2217
					loop: 15
					cel: 6
					x: 134
					y: 188
					init:
					yourself:
				)
		)
		(initStars doit:)
		(= local2 (IntArray with: -1 -1 10 -1 -1))
		(= local1 (IntArray with: -1 -1 -1 10 -1 -1))
		(setNav doit:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (IsFlag 105) (IsFlag 106)) ; Do
			(gGame handsOff:)
			(consoleSound play:)
			(self setCycle: End self)
		)
	)
)

(instance indicator of Prop
	(properties
		x 158
		y 17
		loop 1
		view 2215
	)
)

(instance openDoor of Prop
	(properties
		x 224
		y 211
		loop 1
		view 2221
	)
)

(instance powerLight of Prop
	(properties
		x 15
		y 83
		view 2216
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance powerLight222 of Prop
	(properties
		x 398
		y 176
		loop 2
		view 2218
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance powerLight218 of Prop
	(properties
		x 12
		y 183
		view 218
	)

	(method (init)
		(super init: &rest)
		(self setPri: 600 setCycle: Fwd)
	)
)

(instance deadKeys of View
	(properties
		x 71
		y 210
		loop 3
		view 2217
	)
)

(instance leftSwitch of Prop
	(properties
		x 16
		y 84
		loop 1
		view 2217
	)

	(method (cue)
		(if (== local0 self)
			(= local0 0)
		else
			(= local0 self)
		)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(leftSwitchSound play:)
			(if (== local0 self)
				(self setCycle: Beg self)
			else
				(self setCycle: End self)
				(rightSwitch setCycle: Beg)
			)
		)
	)
)

(instance rightSwitch of Prop
	(properties
		x 16
		y 84
		loop 2
		view 2217
	)

	(method (cue)
		(if (== local0 self)
			(= local0 0)
		else
			(= local0 self)
		)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(rightSwitchSound play:)
			(if (== local0 self)
				(self setCycle: Beg self)
			else
				(self setCycle: End self)
				(leftSwitch setCycle: Beg)
			)
		)
	)
)

(instance latList of List
	(properties)
)

(instance lonList of List
	(properties)
)

(instance keyPadSet of Set
	(properties)
)

(instance consoleSound of Sound
	(properties
		number 2027
		flags 1
	)
)

(instance buttonSound of Sound
	(properties
		number 2028
		flags 1
	)
)

(class ButtonFeature of Feature
	(properties
		pressView -1
		pressLoop 0
		pressCel 0
		pressViewX -1
		pressViewY -1
		whoToKill 0
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (self onMe: event) (& (event type:) evMOUSEBUTTON))
				(= whoToKill
					(View
						new:
						view: pressView
						loop: pressLoop
						cel: pressCel
						x: pressViewX
						y: pressViewY
						init:
						yourself:
					)
				)
				(global206 add: self)
				(buttonSound play:)
				(event claimed: 1)
				(return)
			)
			((and (self onMe: event) (& (event type:) evMOUSERELEASE) whoToKill)
				(whoToKill dispose:)
				(global206 delete: self)
				(= whoToKill 0)
				(self doVerb: (event message:))
				(event claimed: 1)
				(return)
			)
			((and whoToKill (not (self onMe: event)))
				(whoToKill dispose:)
				(global206 delete: self)
				(= whoToKill 0)
				(event claimed: 1)
				(return)
			)
			((and whoToKill (self onMe: event))
				(event claimed: 1)
				(return)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance zeroButton of ButtonFeature
	(properties
		nsBottom 265
		nsLeft 71
		nsRight 81
		nsTop 255
		pressView 2217
		pressLoop 13
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 0
								loop: 15
								cel: 0
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 0
								loop: 15
								cel: 0
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance oneButton of ButtonFeature
	(properties
		nsBottom 250
		nsLeft 71
		nsRight 81
		nsTop 240
		pressView 2217
		pressLoop 10
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 1
								loop: 15
								cel: 1
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 1
								loop: 15
								cel: 1
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance twoButton of ButtonFeature
	(properties
		nsBottom 250
		nsLeft 85
		nsRight 95
		nsTop 240
		pressView 2217
		pressLoop 11
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 2
								loop: 15
								cel: 2
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 2
								loop: 15
								cel: 2
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance threeButton of ButtonFeature
	(properties
		nsBottom 250
		nsLeft 97
		nsRight 107
		nsTop 240
		pressView 2217
		pressLoop 12
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 3
								loop: 15
								cel: 3
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 3
								loop: 15
								cel: 3
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance fourButton of ButtonFeature
	(properties
		nsBottom 235
		nsLeft 71
		nsRight 81
		nsTop 225
		pressView 2217
		pressLoop 7
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 4
								loop: 15
								cel: 4
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 4
								loop: 15
								cel: 4
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance fiveButton of ButtonFeature
	(properties
		nsBottom 235
		nsLeft 85
		nsRight 95
		nsTop 225
		pressView 2217
		pressLoop 8
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 5
								loop: 15
								cel: 5
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 5
								loop: 15
								cel: 5
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance sixButton of ButtonFeature
	(properties
		nsBottom 235
		nsLeft 97
		nsRight 107
		nsTop 225
		pressView 2217
		pressLoop 9
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 6
								loop: 15
								cel: 7
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 6
								loop: 15
								cel: 7
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance sevenButton of ButtonFeature
	(properties
		nsBottom 220
		nsLeft 71
		nsRight 81
		nsTop 210
		pressView 2217
		pressLoop 4
		pressCel 1
		pressViewX 16
		pressViewY 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 7
								loop: 15
								cel: 8
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 7
								loop: 15
								cel: 8
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance eightButton of ButtonFeature
	(properties
		nsBottom 220
		nsLeft 85
		nsRight 95
		nsTop 210
		pressView 2217
		pressLoop 5
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 8
								loop: 15
								cel: 9
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 8
								loop: 15
								cel: 9
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance nineButton of ButtonFeature
	(properties
		nsBottom 220
		nsLeft 97
		nsRight 107
		nsTop 210
		pressView 2217
		pressLoop 6
		pressCel 1
		pressViewX 16
		pressViewY 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((== local0 leftSwitch)
					(lonList
						add:
							((NumberView new:)
								view: 2217
								value: 9
								loop: 15
								cel: 10
								init:
								yourself:
							)
					)
				)
				((== local0 rightSwitch)
					(latList
						add:
							((NumberView new:)
								view: 2217
								value: 9
								loop: 15
								cel: 10
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance enterButton of ButtonFeature
	(properties
		nsBottom 265
		nsLeft 85
		nsRight 107
		nsTop 255
		pressView 2217
		pressLoop 14
		pressCel 1
		pressViewX 16
		pressViewY 82
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb &tmp temp0)
		(cond
			((= global227 (= temp0 (checkCoords doit:)))
				(= local3 1)
				(setNav doit: global227)
			)
			((gCast contains: indicator)
				(indicator dispose:)
			)
		)
	)
)

(instance leftForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(= nsLeft 29)
		(= nsTop 87)
		(= nsRight 179)
		(= nsBottom 202)
		(super init: &rest)
	)
)

(instance myVMD of VMDPlayer ; UNUSED
	(properties
		x 70
		y 75
		buffSize 1024
		palStart 0
		palEnd 201
	)
)

(instance chartPanel of PanelPlane
	(properties)

	(method (init)
		(self priority: (+ (GetHighPlanePri) 1))
		(super init: 0 0 639 479)
		(chartInset init: self 1 1)
	)
)

(instance chartInset of PanelView
	(properties
		x 430
		y 275
		loop 1
		cel 25
		view 2218
	)

	(method (doVerb)
		(chartPanel dispose:)
	)
)

(instance roostStar of View
	(properties
		x 158
		y 17
		loop 1
		cel 3
		view 2215
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(initStars doit:)
			(= local4 1)
			(setNav doit: 2)
			(self dispose:)
		)
	)
)

(instance fortStar of View
	(properties
		x 158
		y 17
		loop 1
		view 2215
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(initStars doit:)
			(= local4 1)
			(setNav doit: 3)
			(self dispose:)
		)
	)
)

(instance wreckStar of View
	(properties
		x 158
		y 17
		loop 1
		cel 2
		view 2215
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(initStars doit:)
			(= local4 1)
			(setNav doit: 4)
			(self dispose:)
		)
	)
)

(instance domainStar of View
	(properties
		x 158
		y 17
		loop 1
		cel 1
		view 2215
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(initStars doit:)
			(= local4 1)
			(setNav doit: 1)
			(self dispose:)
		)
	)
)

(instance chartOpen of Sound
	(properties
		number 20271
		flags 1
	)
)

(instance chartUnroll of Sound
	(properties
		number 20272
		flags 1
	)
)

(instance leftSwitchSound of Sound
	(properties
		number 2005
		flags 1
	)
)

(instance rightSwitchSound of Sound
	(properties
		number 2006
		flags 1
	)
)

