;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3430)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use RobotDoVerb)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	s2_3430 0
)

(local
	local0
)

(instance s2_3430 of PQRoom
	(properties
		picture 3430
	)

	(method (init)
		(Load rsAUDIO 29807)
		(super init: &rest)
		(robotFeat init:)
		(if (!= (gBackMusic number:) 29807)
			(gBackMusic number: 29807 loop: -1 play:)
		)
		(Load rsVIEW 10)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Lock rsVIEW 10 50 51 1)
		(self setScript: roomScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if local0
					(self setScript: allenKillsPlayer)
				else
					0
				)
			)
			(6
				(if local0
					(self setScript: allenKillsPlayer)
				else
					0
				)
			)
			(16
				(flashObj
					view: 34302
					loop: 0
					cel: 0
					posn: 285 285
					init:
					setScript: throwFlash
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(Lock rsVIEW 10 50 51 0)
		(proc4_5)
		(gBackMusic fade: 0 50 5 1)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hector
					view: 34311
					loop: 0
					cel: 0
					posn: 331 186
					setPri: 1
					init:
				)
				(proc4_6 34300 29 86 0 0 500 1)
			)
			(1
				(gAutoRobot setPri: -1 caller: 0)
				(hector setCycle: End self)
			)
			(2
				(allen
					view: 34306
					loop: 0
					cel: 0
					posn: 439 198
					init:
					setPri: 100
					setCycle: CT 15 1 self
				)
			)
			(3
				(allen cel: 16 setCycle: CT 35 1 self)
				(= local0 1)
				(gGame handsOn:)
			)
			(4
				(allen setCycle: CT 40 1 self)
			)
			(5
				(gFxSound number: 50 loop: 1 play:)
				(allen setCycle: CT 44 1 self)
			)
			(6
				(getKilledTimer setReal: getKilledTimer 4)
			)
		)
	)
)

(instance allenKillsPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 50 loop: 1 play:)
				(allen cel: 44 setCycle: CT 46 1 self)
			)
			(1
				(gFxSound number: 50 loop: 1 play:)
				(allen setCycle: CT 48 1 self)
			)
			(2
				(gFxSound number: 50 loop: 1 play:)
				(allen setCycle: CT 52 1 self)
			)
			(3
				(gFxSound number: 50 loop: 1 play:)
				(allen setCycle: CT 54 1 self)
			)
			(4
				(gFxSound number: 50 loop: 1 play:)
				(allen cel: 55 setCycle: End self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance hitAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: getKilledTimer)
					(getKilledTimer dispose: delete:)
				)
				(gGame showCloseUp: 34303 180 66 self)
			)
			(1
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gFxSound number: 3450 play: self)
			)
			(2
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance actorTakesHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: getKilledTimer)
					(getKilledTimer dispose: delete:)
				)
				(gGame showCloseUp: 34304 180 66 self)
			)
			(1
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gFxSound number: 3450 play: self)
			)
			(2
				(SetFlag 98)
				(SetFlag 93)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance officerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: getKilledTimer)
					(getKilledTimer dispose: delete:)
				)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gGame showCloseUp: 9012 180 66 self)
			)
			(1
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance throwFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: getKilledTimer)
					(getKilledTimer dispose: delete:)
				)
				(flashObj setCycle: CT 5 1 self)
			)
			(1
				(if
					(and
						(gCast contains: allen)
						(== (gCurRoom script:) roomScript)
					)
					(self cue:)
				else
					(flashObj setCycle: End)
				)
			)
			(2
				(Palette 2 42 254 1000) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 play:)
				(flashObj hide:)
				(= cycles 3)
			)
			(3
				(whiteScreen init:)
				(proc4_5)
				(denton view: 34301 loop: 0 cel: 0 posn: 173 274 init:)
				(allen view: 34307 loop: 0 cel: 0 posn: 181 263 setCycle: 0)
				(hector view: 34310 loop: 0 cel: 0 posn: 344 215 setCycle: 0)
				(UpdateScreenItem allen)
				(UpdateScreenItem hector)
				(= ticks 20)
			)
			(4
				(whiteScreen dispose:)
				(gunShot number: 14101 loop: 0 play:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(denton setCycle: End self)
			)
			(7
				(gunShot stop:)
				(= cycles 1)
			)
			(8
				(gMessager say: 0 0 2 0 self) ; "Pacmeyer to Ten David. We have shots fired. Two down. I need an EMT now."
			)
			(9
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allen of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: hitAllen)
			)
			(6
				(gCurRoom setScript: hitAllen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: actorTakesHit)
			)
			(6
				(gCurRoom setScript: actorTakesHit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(return (and (super onMe: param1) (< (param1 x:) 252)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot)
			)
			(10
				(gCurRoom setScript: officerShot)
			)
			(180
				(super doVerb: theVerb)
			)
			(179
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance flashObj of Prop
	(properties)
)

(instance denton of Prop
	(properties)
)

(instance gunShot of Sound
	(properties)
)

(instance getKilledTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: allenKillsPlayer)
	)
)

