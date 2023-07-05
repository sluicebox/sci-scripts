;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use TPSound)
(use oHandsOnWhenCued)
(use CueMe)
(use NewUser)
(use PushButton)
(use soFlashCyberSniff)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	ro150 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(oCredits hide: setString: param1)
	(= temp2 (MulDiv (oCredits nWidth:) local3 local4))
	(= temp3 (MulDiv (oCredits nHeight:) local3 local4))
	(cond
		((> temp2 560)
			(= temp0 (/ (- 640 temp2) 2))
		)
		((> (+ (= temp0 (Random 0 560)) temp2) 600)
			(= temp0 (- 600 temp2))
		)
		((< temp0 40)
			(= temp0 40)
		)
	)
	(cond
		((> (+ (= temp1 (Random 0 400)) temp3) 440)
			(= temp1 (- 440 temp3))
		)
		((< temp1 40)
			(= temp1 40)
		)
	)
	(oCredits posn: temp0 temp1 setScalePercent: local5 show:)
	(oCreditBL
		hide:
		setString: param1
		posn: (- temp0 2) temp1
		setScalePercent: local5
		show:
	)
	(oCreditBT
		hide:
		setString: param1
		posn: temp0 (- temp1 2)
		setScalePercent: local5
		show:
	)
	(oCreditBR
		hide:
		setString: param1
		posn: (+ temp0 2) temp1
		setScalePercent: local5
		show:
	)
	(oCreditBB
		hide:
		setString: param1
		posn: temp0 (+ temp1 2)
		setScalePercent: local5
		show:
	)
)

(procedure (localproc_1)
	(oCredits setString:)
	(oCreditBL setString:)
	(oCreditBT setString:)
	(oCreditBR setString:)
	(oCreditBB setString:)
)

(instance ro150 of L7Room
	(properties
		picture 15000
	)

	(method (init)
		(gGame handsOff:)
		(super init:)
		(Palette 1 150) ; PalLoad
		(gOMusic1 fade: 127 6 3 0)
		(aoBoat init:)
		(oCredits init: setString:)
		(oCreditBL init: setString:)
		(oCreditBT init: setString:)
		(oCreditBR init: setString:)
		(oCreditBB init: setString:)
		(= local3 3)
		(= local4 2)
		(= local5 150)
	)

	(method (doit)
		(super doit:)
		(if (and local7 (not (gOMusic1 isPlaying:)))
			(= local7 0)
			(proc64031_0 100)
			(gOMusic1 setMusic: 13000)
			(self setScript: soEndCredits)
		)
	)

	(method (dispose)
		(gOMusic1 client: 0 stop:)
		(super dispose:)
	)
)

(instance soEndCredits of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsMESSAGE 15)
				(= local2 3)
				(= cycles 3)
			)
			(1
				(gOEventHandler registerGlobalHandler: oEventHandler)
				(++ local0)
				(cond
					((= temp0 (MakeMessageText 0 0 local2 local0 15 1))
						(localproc_0 temp0)
						(switch local2
							(3
								(= ticks 120)
							)
							(1
								(= ticks
									(Max
										120
										(MulDiv 20 (temp0 size:) 10)
									)
								)
							)
							(4
								(= ticks
									(Max
										120
										(MulDiv 20 (temp0 size:) 10)
									)
								)
							)
							(5
								(= ticks
									(Max
										120
										(MulDiv 15 (temp0 size:) 10)
									)
								)
							)
							(else
								(= ticks 120)
							)
						)
						(temp0 dispose:)
						(= temp0 0)
					)
					((!= local2 6)
						(= local0 0)
						(switch local2
							(3
								(= local2 1)
								(= local3 4)
								(= local4 3)
								(= local5 133)
							)
							(1
								(= local2 4)
								(= local3 5)
								(= local4 4)
								(= local5 125)
							)
							(4
								(= local2 5)
							)
							(5
								(= local2 6)
								(= local3 1)
								(= local4 1)
								(= local5 100)
							)
						)
						(-- state)
						(= cycles 1)
					)
					(else
						(gOEventHandler unregisterGlobalHandler: oEventHandler)
						(gOMusic1 stop:)
						(if
							(and
								(>= global201 1000)
								(>= global264 32)
								((ScriptID 64017 0) test: 302) ; oFlags
								((ScriptID 64017 0) test: 303) ; oFlags
								((ScriptID 64017 0) test: 300) ; oFlags
								((ScriptID 64017 0) test: 301) ; oFlags
								((ScriptID 64017 0) test: 307) ; oFlags
								((ScriptID 64017 0) test: 281) ; oFlags
								((ScriptID 64017 0) test: 249) ; oFlags
							)
							(self setScript: soEaster)
						else
							(gCurRoom newRoom: 151) ; ro151
						)
					)
				)
			)
			(2
				(localproc_1)
				(= ticks 20)
			)
			(3
				(self changeState: (- state 2))
			)
		)
	)
)

(instance soEaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShowEasterEgg)
				(= ticks 180)
			)
			(1
				(gCurRoom newRoom: 152) ; ro152
				(self dispose:)
			)
		)
	)
)

(instance soSailAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(client setMotion: MoveTo 490 383 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEndGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: -1)
				(Palette 1 999) ; PalLoad
				((ScriptID 64000 6) doSelect:) ; moScore
				(= cycles 1)
			)
			(1
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance aoBoat of Actor
	(properties
		x 179
		y 486
		view 15005
		cycleSpeed 15
		moveSpeed 25
	)

	(method (init)
		(super init:)
		(self
			setScaler: Scaler 256 7 486 389
			setCycle: Fwd
			setScript: soSailAway
		)
	)
)

(instance oCredits of TextItem
	(properties
		priority 600
		fixPriority 1
		fore 72
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBL of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBT of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBR of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBB of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oEndIt of CueMe
	(properties)

	(method (cue)
		(gCast eachElementDo: #dispose)
		(gCurRoom setScript: soEndGame)
	)
)

(instance oEventHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(event claimed: 1)
			(gOEventHandler unregisterGlobalHandler: self)
			(if local6
				(soEndGame ticks: 0 cue:)
			else
				(gCurRoom setScript: 0)
				(localproc_1)
				(gOMusic1 fadeOut: oEndIt 6 2)
			)
		)
		(event claimed:)
	)
)

