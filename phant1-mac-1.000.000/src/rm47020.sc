;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47020)
(include sci.sh)
(use Main)
(use n1111)
(use chap7Timer)
(use Str)
(use Sound)
(use Actor)
(use System)

(public
	rm47020 0
)

(instance rm47020 of ScaryRoom
	(properties
		picture 35160
	)

	(method (init &tmp temp0)
		(Load rsVIEW 35110)
		(Load rsAUDIO 22055)
		(= temp0 (Str newWith: 2 {18}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 150)
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(roomSnd number: 22055 setLoop: -1 play:)
		(cond
			((IsFlag 135)
				(cond
					((== gPrevRoomNum 47180)
						(deadCyrus init: setPri: 10)
						(= picture 35110)
					)
					((not (IsFlag 154))
						(= picture 35160)
					)
					(else
						(= picture 35130)
					)
				)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 47180)
				(if (IsFlag 154)
					(deadCyrus init: setPri: 10)
				)
				(= picture 35110)
				(gCurRoom setScript: toChapel)
			)
			((IsFlag 154)
				(= global165 17)
				(= picture 35130)
				(gCurRoom setScript: toCrypt)
			)
			(else
				(SetFlag 154)
				(= global165 17)
				(gCurRoom setScript: seeCyrus)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(roomSnd stop:)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((not (IsFlag 135))
				(= temp0 (Str newWith: 3 {99\0d\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc45951_3)
				(switch global179
					(1
						(self setScript: toCrypt self)
					)
					(2
						(self setScript: seeCyrus self)
					)
					(3
						(self setScript: caughtScript self)
					)
					(4
						(self setScript: toChapel self)
					)
					(99
						(gCurRoom setScript: playNextRoom)
					)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance playNextRoom of Script
	(properties)

	(method (changeState)
		(proc45951_3)
		(proc45951_3)
		(switch global179
			(19
				(gCurRoom newRoom: 47180)
			)
			(17
				(gCurRoom newRoom: 46980)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance toCrypt of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 7164 -5 38 0)
				)
				(1
					(DoRobot 7150 -9 -29 0 -1 1)
					(gCurRoom drawPic: 35160)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 47180)
					)
				)
			)
		)
	)
)

(instance seeCyrus of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 7151 73 33 0)
				)
				(1
					(DoRobot 7152 -39 -42 0)
					(gCurRoom drawPic: 35180)
				)
				(2
					(roomSnd stop:)
					(sfxSound number: 22070 play:)
					(gGDacSound stop:)
					(DoRobot 7153 -24 -39 0)
					(gCurRoom drawPic: 35170)
				)
				(3
					(DoRobot 7154 -9 -41 0)
					(gCurRoom drawPic: 35180)
				)
				(4
					(gGDacSound number: 10671 play:)
					(DoRobot 7155 -9 -40 0 -1 1)
					(gCurRoom drawPic: 35160)
				)
				(5
					(sfxSound stop:)
					(roomSnd play:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 47180)
					)
				)
			)
		)
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 46980)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp2 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp2) ; chase_dat
						(temp2 dispose:)
					)
					(SetFlag 150)
					(= global159 46980)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance toChapel of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 7156 14 19 0)
				)
				(1
					(deadCyrus dispose:)
					(DoRobot 7163 -7 40 0)
					(gCurRoom drawPic: 35130)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46980)
					)
				)
			)
		)
	)
)

(instance deadCyrus of View
	(properties
		x 93
		y 150
		view 35110
	)
)

(instance roomSnd of Sound
	(properties)
)

(instance sfxSound of Sound
	(properties)
)

