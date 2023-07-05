;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Osc)
(use MoveFwd)
(use ScaleTo)
(use Motion)
(use Actor)
(use System)

(public
	blob 0
	sFireOnBlob 1
	sBlowUpGoliath 2
	sSuckBlob 3
	sEurekaBlobbed 4
	sGoliathShoots 5
	sFoundGoliath 6
	sFindGoliath 7
)

(instance sBlobCharging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(blob setScale: ScaleTo 180 1 self)
			)
			(2
				(blob moveSpeed: 10 heading: 50 setMotion: MoveFwd 150 self)
			)
			(3
				(blob stopUpd:)
				(eureka setScript: (ScriptID 210 5) 0 5 warnings: 1) ; sBlobTimer
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sEurekaBlobbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(blob
					setLoop: 7
					setCel: 0
					x: 88
					y: -5
					heading: 180
					scaleX: 128
					scaleY: 128
					maxScale: 128
				)
				(ShakeScreen 5 ssFULL_SHAKE)
				(blobPart2 init:)
				(= seconds 1)
			)
			(2
				(blob setMotion: MoveFwd 45 self)
				(blobPart2 setMotion: MoveFwd 45)
			)
			(3
				(EgoDead 7) ; "Due to your inability to perform under pressure, the Eureka has been munched by the blob. Nice going!"
				(self dispose:)
			)
		)
	)
)

(instance sBlobSucked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(blob setMotion: MoveFwd 60 self)
				(blobPart2 setMotion: MoveFwd 50 self)
				(gSq5Music1 fade:)
			)
			(2
				(eureka puke: 4)
				((ScriptID 202 13) init:) ; monitor1
				((ScriptID 202 14) init:) ; monitor2
				((ScriptID 202 15) init:) ; monitor3
				(= cycles 1)
			)
			(3
				(proc201_7 self)
			)
			(4
				(gMessager say: 11 0 16 0 self) ; "We've got the blob aboard, sir. Containment fields are holding at 200 percent capacity--but they won't last long."
			)
			(5
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
				(eureka timer: 0 setScript: (ScriptID 210 5) 0 300) ; sBlobTimer
			)
			(6
				(gGame handsOn:)
				(blob dispose:)
				(blobPart2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance blob of Actor
	(properties
		x 92
		y 56
		view 227
		loop 2
		priority 7
		signal 24592
	)

	(method (init)
		(switch (eureka puke:)
			(1
				(blobPart init:)
				(blobPart2 init:)
				(blobPart3 init:)
				(self loop: 2 cel: 0 x: 92 y: 56)
				(super init: &rest)
			)
			(2
				(self setLoop: 1 cel: 0 x: 100 y: 41 setScript: sBlobCharging)
				(super init: &rest)
			)
			(3
				(self
					setLoop: 6
					setCel: 0
					x: 54
					y: 90
					heading: 180
					setScript: sBlobSucked
				)
				(blobPart2 init:)
				(blobPart3 init: addToPic:)
				(blobPart4 init: addToPic:)
				(super init: &rest)
			)
		)
	)
)

(instance sBlowUpGoliath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(crack init: setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(client setScript: (ScriptID 210 3) 0 43) ; sBlowUpEureka
				(self dispose:)
			)
		)
	)
)

(instance sFindGoliath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 37)
				(eureka destination: 14)
				((ScriptID 201 9) ; bigPlanet
					init:
					x: 48
					y: 58
					setCel: 0
					setScale: ScaleTo 127 5 self
				)
			)
			(1
				((ScriptID 201 9) addToPic:) ; bigPlanet
				(= global113 14)
				(eureka state: 3 destination: 0 curLocation: 14 timer: 0)
				(= cycles 1)
			)
			(2
				(= seconds 2)
			)
			(3
				(if (not (IsFlag 39))
					(= next sGoliathShoots)
					(self dispose:)
				else
					(= next sCliffyAppears)
					(self dispose:)
				)
			)
		)
	)
)

(instance sCliffyAppears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				((ScriptID 202 13) init:) ; monitor1
				(= seconds 1)
			)
			(2
				(gMessager say: 3 0 14 0 self 202) ; "Hey cap'n, get your tail down here to the lab. I got somethin' you might wanna take a look at."
			)
			(3
				((ScriptID 202 13) dispose:) ; monitor1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFoundGoliath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
				((ScriptID 202 14) init:) ; monitor2
				(SetFlag 37)
				((ScriptID 1887 24) disposeWhenDone: 0) ; tkrWD40
			)
			(1
				(gMessager say: 3 0 0 0 self 202) ; "We're approaching planet Gingivitis. Sensors have detected the presence of the Goliath in the area, Captain Wilco."
			)
			(2
				((ScriptID 1887 24) disposeWhenDone: 1) ; tkrWD40
				((ScriptID 202 14) dispose:) ; monitor2
				(self dispose:)
			)
		)
	)
)

(instance sFireOnBlob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
				(proc201_27 0)
			)
			(1
				(gMessager say: 15 0 15 0 self) ; "De-cloaking, sir. Locking weapons..."
			)
			(2
				(proc201_27 1)
				(gCurRoom newRoom: 212)
				(self dispose:)
			)
		)
	)
)

(instance sGoliathShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gun init: setCycle: End self)
			)
			(1
				(gun cel: 0 setLoop: 2 setCycle: End self)
			)
			(2
				(gun cel: 0 setLoop: 3 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(client setScript: (ScriptID 210 3) 0 12) ; sBlowUpEureka
				(self dispose:)
			)
		)
	)
)

(instance sSuckBlob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 225 loop: -1 play:)
				(= seconds 3)
			)
			(1
				(eureka timer: 0 warnings: 0 setScript: 0)
				(gCurRoom newRoom: 213)
				(self dispose:)
			)
		)
	)
)

(instance blobPart of Prop
	(properties
		x 104
		y 66
		view 227
		loop 3
		cel 2
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(switch (eureka puke:)
			(1
				(super init: &rest)
				(self loop: 3 x: 104 y: 66 setCycle: Osc)
			)
		)
	)
)

(instance blobPart2 of Actor
	(properties
		x 161
		y 69
		view 227
		loop 4
		cel 2
		priority 7
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(switch (eureka puke:)
			(1
				(self loop: 4 x: 161 y: 69 setCycle: Osc)
			)
			(2
				(self
					setLoop: 7
					setCel: 1
					x: 186
					y: -5
					heading: 180
					ignoreActors: 1
				)
			)
			(3
				(self setLoop: 6 setCel: 1 x: 194 y: 82 heading: 180)
			)
		)
	)
)

(instance blobPart3 of Prop
	(properties
		x 134
		y 58
		view 227
		loop 5
		cel 2
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(switch (eureka puke:)
			(1
				(self loop: 5 cel: 2 x: 134 y: 58 setCycle: Osc)
			)
			(3
				(self setLoop: 6 setCel: 2 x: 53 y: 73)
			)
		)
	)
)

(instance blobPart4 of Prop
	(properties
		x 134
		y 58
		view 227
		loop 5
		cel 2
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(switch (eureka puke:)
			(3
				(self setLoop: 6 setCel: 3 x: 198 y: 74)
			)
		)
	)
)

(instance crack of Prop
	(properties
		x 148
		y 85
		view 227
		loop 9
	)
)

(instance gun of Prop
	(properties
		x 137
		y 75
		view 2272
		loop 1
		priority 6
		signal 24592
	)
)

