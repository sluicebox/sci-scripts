;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use LightRoom)
(use LightInv)
(use VMDPlayer)
(use Array)
(use PanelPlane)
(use WalkieTalkie)
(use System)

(public
	rm5 0
)

(instance rm5 of LightRoom
	(properties
		picture -2
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(Lock rsAUDIO 5 1)
		(Lock rsAUDIO 16 1)
		(Lock rsVIEW 12 1)
		(Lock rsVIEW 14 1)
		(if (not (OneOf gPrevRoomNum 6 5 380)) ; whereTo
			(if global215
				(global215 dispose:)
			)
			(= global221 0)
			(= gInventory ((ScriptID 9 0) new:)) ; LightInv
			(gGame hideCursor:)
			(if ((ScriptID 0 11) casts:) ; blackPlane
				((ScriptID 0 11) dispose:) ; blackPlane
			)
			(FrameOut)
			(DisposeScript 3)
			(DisposeScript 20)
			(DisposeScript 22)
			(DisposeScript 24)
			(gCurRoom setScript: sPlayMovie2)
		else
			(if (== gPrevRoomNum 380)
				(if (IsFlag 394)
					((ScriptID 19 0) dispose:) ; BombTimer
				)
				(if gInsetPanelPlane
					(gInsetPanelPlane dispose:)
				)
				(for ((= temp0 10)) (<= temp0 1423) ((++ temp0))
					(ClearFlag temp0)
				)
				(if (gInventory contains: (ScriptID 9 3)) ; PlCompass
					(gInventory deleteItem: (ScriptID 9 3)) ; PlCompass
				)
				(= temp1 (gInventory size:))
				(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
					(if (gInventory contains: (gInventory at: temp0))
						(gInventory deleteItem: (gInventory at: temp0))
					)
				)
				(gInventory dispose:)
				(= temp1 (- (gPanels size:) 1))
				(for ((= temp0 temp1)) (>= temp0 0) ((-- temp0))
					(if (!= (gPanels at: temp0) global215)
						((gPanels at: temp0) dispose:)
					)
				)
				(if global105
					(global105 release:)
				)
				(global206 release:)
				((ScriptID 9 53) state: 0) ; invIngots
				((ScriptID 9 54) state: 0) ; invCoal
				((ScriptID 9 52) state: 0) ; invLogs
				((ScriptID 9 55) state: 0) ; invMold
				(= global102 0)
				(= global109 0)
				(= global110 0)
				(= global111 0)
				(= global112 0)
				(= global113 0)
				(= global114 0)
				(= global115 0)
				(= global202 0)
				(= global203 0)
				(= global204 0)
				(= global205 0)
				(= global207 3)
				(= global208 0)
				(= global209 3)
				(= global210 0)
				(= global211 0)
				(= global212 0)
				(= global213 0)
				(= global216
					(IntArray with: 4485 0 0 0 12 1 1 4483 3 2 384 201 0)
				)
				(= gPortal 0)
				(= global222 0)
				(= global223 0)
				(= global226 2)
				(= global227 2)
				(= global228 0)
				(= global229 0)
				(= global230 0)
				(= global231 0)
				(= global232 500)
				(= global233 0)
				(= global235 0)
				(= global236 0)
				(= global237 2)
				(= global238 -1)
				(= global239 0)
				(= global240 0)
				(= global241 0)
				(= global242 16)
				(= global243 0)
				(= global244 0)
				(= global245 0)
				(= global246 0)
				(= global247 0)
				(= global248 0)
				(= global250 0)
				(= global251 0)
				(= global252 0)
				(= global253 0)
				(= gPplFullLetterPlane 0)
				(= global256 0)
				(SetFlag 269)
				(SetFlag 361)
				(SetFlag 358)
				(SetFlag 270)
				(SetFlag 272)
				(SetFlag 273)
				(SetFlag 277)
				(SetFlag 278)
				(SetFlag 281)
				(SetFlag 282)
				(SetFlag 335)
				(SetFlag 336)
				(SetFlag 338)
				(SetFlag 340)
				(SetFlag 341)
				(SetFlag 342)
				(SetFlag 348)
				(SetFlag 250)
				(SetFlag 301)
				(gSounds eachElementDo: #client 0)
				(gSounds eachElementDo: #stop)
				(gTimers eachElementDo: #dispose)
				(if global215
					(global215 dispose:)
				)
				(= global221 0)
				(= gInventory ((ScriptID 9 0) new:)) ; LightInv
			)
			(gGame hideCursor:)
			(FrameOut)
			(gCurRoom setScript: sPlayMovie)
		)
	)

	(method (newRoom newRoomNumber)
		(WalkieTalkie plane: gThePlane)
		(newGamePP dispose:)
		(loadGamePP dispose:)
		(quitGamePP dispose:)
		(creditsPP dispose:)
		(if (gPanels contains: menuPanel)
			(menuPanel dispose:)
		)
		(Lock rsAUDIO 5 0)
		(Lock rsAUDIO 14 0)
		(Lock rsAUDIO 16 0)
		(Lock rsVIEW 12 0)
		(Lock rsVIEW 14 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gBackMusic fade: 0 5 3 1 0)
		(super dispose: &rest)
	)
)

(instance menuPanel of PanelPlane
	(properties
		disposeNotOnMe 0
	)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 639 479)
		(self setBitmap: 12 0 0)
		(newGamePP setPri: (+ (self priority:) 1) init: self 1 1 ignoreActors:)
		(loadGamePP setPri: (+ (self priority:) 1) init: self 1 1 ignoreActors:)
		(quitGamePP setPri: (+ (self priority:) 1) init: self 1 1 ignoreActors:)
		(creditsPP setPri: (+ (self priority:) 1) init: self 1 1 ignoreActors:)
	)
)

(instance newGamePP of PanelProp
	(properties
		x 374
		y 209
		cycleSpeed 12
		view 14
	)

	(method (doVerb)
		(if (gGame isHandsOn:)
			(gGame handsOff: setCursor: gTheControlWaitCursor 1)
			(self setScript: (ScriptID 0 3) self) ; sDepress
		)
	)

	(method (cue)
		(if (if (== gPrevRoomNum 380) global258)
			(gGame restart:)
		else
			(gCurRoom setScript: sDoOptions 0 loop)
		)
	)
)

(instance loadGamePP of PanelProp
	(properties
		x 333
		y 277
		cycleSpeed 4
		loop 1
		view 14
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue)
		(gBackMusic fade: 0 5 3 1 0)
		(gCurRoom setScript: sDoOptions 0 loop)
	)
)

(instance quitGamePP of PanelProp
	(properties
		x 288
		y 343
		cycleSpeed 4
		loop 2
		view 14
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue)
		(= gQuit 1)
	)
)

(instance creditsPP of PanelProp
	(properties
		x 460
		y 400
		cycleSpeed 4
		loop 3
		view 14
	)

	(method (doVerb)
		(self setScript: (ScriptID 0 3) self) ; sDepress
	)

	(method (cue)
		(gCurRoom setScript: creditScr)
	)
)

(instance creditScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(DoRobot)
				(if (gPanels contains: menuPanel)
					(menuPanel dispose:)
				)
				(FrameOut)
				(gCurRoom drawPic: 0)
				(FrameOut)
				(gBackMusic stop:)
				(Palette 2 0 255 100) ; PalIntensity
				(= cycles 2)
			)
			(2
				(self dispose:)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance sPlayMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gTheInvisCursor 1)
				(gGlobalVMD number: 5 stretch: 1 dir: 1 myBlackLines: 1 init:)
				(gMySoundFX number: 5 setLoop: 0 play:)
				(gGame setCursor: gTheInvisCursor 1)
				(gGlobalVMD play: close:)
				(menuPanel init:)
				(gGame setCursor: gTheInvisCursor 1)
				(WalkieTalkie plane: menuPanel)
				(proc0_9 16 0 10)
				(gBackMusic init: number: 16 setLoop: -1 play:)
				(= cycles 3)
			)
			(1
				(gGame isHandsOn: 1)
				(gUser canControl: 1 canInput: 1)
				(self dispose:)
				(gGame cursHidden: 0 setCursor: gTheControlNormalCursor 1)
			)
		)
	)
)

(instance sPlayMovie2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoRobot)
				(if (OneOf gPrevRoomNum 6 5 380) ; whereTo
					(gCurRoom fade: 2 1 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame hideCursor:)
				(if (gPanels contains: PlInterface)
					(PlInterface dispose:)
				)
				(if (gPanels contains: menuPanel)
					(menuPanel dispose:)
				)
				(FrameOut)
				(gCurRoom drawPic: 0)
				(FrameOut)
				(gBackMusic stop:)
				(Palette 2 0 255 100) ; PalIntensity
				(FrameOut)
				(if
					(or
						(<= (GetSierraProfileInt {Config} {CDROM} 0) 2)
						(!= (Platform 0) 2)
					)
					(myVMD
						number: 16
						doubled: 1
						x: 70
						y: 75
						myBlackLines: 1
						init:
						play:
					)
				else
					(myVMD
						number: 15
						stretch: 1
						x: 70
						y: 75
						myBlackLines: 1
						init:
						play:
					)
				)
				(gGame hideCursor:)
				(myVMD close:)
				(= cycles 1)
			)
			(2
				(gGame getDisc: 1)
				(gCurRoom newRoom: 20)
			)
		)
	)
)

(instance sDoOptions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(switch register
					(0
						(DoRobot)
						(gCurRoom setScript: sPlayMovie2)
					)
					(1
						(gGame restore:)
						(gBackMusic number: 16 setLoop: -1 play:)
						(gGame handsOn: setCursor: gTheControlNormalCursor 1)
					)
					(else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance myVMD of VMDPlayer
	(properties
		buffSize 1024
	)
)

