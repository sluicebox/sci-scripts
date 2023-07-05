;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use PolyPath)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	hotel 0
	_sEnterElevator 1
	sExitElevator 2
	elevatorDoor 3
	marie 4
	frankT 5
	Gene 6
	Otto 7
	Danny_Anglin 8
	proc151_9 9
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (proc151_9 &tmp [temp0 900])
	(Format
		@temp0
		{ fLobby51 %d fTTCWIU %d fTTCWID %d fTTCWISC %d fRangHotelBell %d fTalkedToAlex %d fGoingUpstairs %d fSawHoOutside50 %d fSawHoEnterElevator %d fAlexKnowsWhitney %d fGaveAlexTip %d fSawFax %d fKnowsJessesName %d fPlayedPoker %d fCalledJack %d fMarieHere %d fEnterDoorFrom153 %d fKnowsCabNumber %d fCalledMorgan1stTime %d fCalledMorgan2ndTime %d fMarieDone %d fCalledTaber %d}
		(IsFlag 2)
		(IsFlag 16)
		(IsFlag 17)
		(IsFlag 18)
		(IsFlag 25)
		(IsFlag 26)
		(IsFlag 27)
		(IsFlag 28)
		(IsFlag 29)
		(IsFlag 30)
		(IsFlag 31)
		(IsFlag 32)
		(IsFlag 33)
		(IsFlag 41)
		(IsFlag 42)
		(IsFlag 44)
		(IsFlag 46)
		(IsFlag 47)
		(IsFlag 48)
		(IsFlag 49)
		(IsFlag 50)
		(IsFlag 51)
	)
	(Prints @temp0)
)

(instance roomTimer of Timer ; UNUSED
	(properties)
)

(class Fool of Actor
	(properties
		approachDist 1
		cueCount 0
		lastTime -1
		fseconds -1
		ticksToDo -1
		maxLoop -1
		status 1
		talkCount 0
	)

	(method (init)
		(super init:)
		(= fseconds (Random 6 12))
	)

	(method (cue)
		(super cue:)
		(switch (++ cueCount)
			(1
				(cond
					((!= status 1) 0)
					((!= maxLoop -1)
						(self setLoop: (Random 0 maxLoop) setCycle: End self)
					)
					(else
						(self setCycle: End self)
					)
				)
			)
			(2
				(= fseconds 2)
				(self stopUpd:)
			)
			(3
				(if (== status 1)
					(self setCel: 0 stopUpd:)
					(= cueCount 0)
					(= fseconds (Random 4 12))
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((!= status 1) 0)
			((!= fseconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- fseconds))
						(self cue:)
					)
				)
			)
			(
				(or
					(u< (+ ticksToDo lastTime) (GetTime))
					(and
						(u> lastTime (GetTime))
						(u> (+ ticksToDo lastTime) lastTime)
					)
				)
				(self cue:)
			)
		)
	)
)

(instance elevatorSnd of Sound
	(properties
		flags -1
		number 922
	)
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(class hotel of Rgn
	(properties
		curMusic 0
		numTimes 0
		playMusic 1
		curVol 0
	)

	(method (init)
		(switch gCurRoomNum
			(51
				(= global205 1)
				(= local1 100)
				(= local2 109)
				(= local3 128)
				(= local4 125)
				(= local5 128)
				(= local6 125)
				((ScriptID 151 3) ; elevatorDoor
					view: 431
					init:
					posn: 85 14
					z: -100
					setLoop: 0
					setCel: 0
					setPri: 5
					approachX: 110
					approachY: 117
					approachVerbs: 4 ; Do
					stopUpd:
				)
				(elevatorLight
					x: 105
					y: 55
					nsLeft: 84
					nsTop: 39
					nsBottom: 58
					nsRight: 128
					setLoop: 1
					setCel: 1
					onMeCheck: 16384
					init:
					stopUpd:
				)
			)
			(53
				(= local1 104)
				(= local2 130)
				(= local3 104)
				(= local4 148)
				(= local5 99)
				(= local6 137)
				((ScriptID 151 3) ; elevatorDoor
					view: 461
					init:
					setLoop: 0
					setCel: 0
					posn: 73 130
					setPri: 5
					stopUpd:
				)
				(elevatorLight
					view: 431
					init:
					setLoop: 1
					setCel: (+ global205 1)
					posn: 99 72
					onMeCheck: 16384
					stopUpd:
				)
			)
		)
		(if (and (OneOf gCurRoomNum 51 52 55 56 57) (not curMusic))
			(= curMusic 520)
		)
		(super init:)
	)

	(method (cue)
		(= playMusic 1)
		(= numTimes 0)
		(gLongSong number: curMusic loop: -1 flags: -1 play: curVol)
	)

	(method (doit &tmp [temp0 20])
		(switch (gLongSong prevSignal:)
			(-1
				(gLongSong prevSignal: 0)
			)
			(10
				(gLongSong prevSignal: 0)
				(if (== (++ numTimes) 2)
					(= playMusic 0)
					(gLongSong fade: self)
					(= curMusic 521)
				)
			)
			(11
				(gLongSong prevSignal: 0)
				(if (== (++ numTimes) 3)
					(= playMusic 0)
					(gLongSong fade: self)
					(= curMusic 520)
				)
			)
		)
		(cond
			((gCurRoom script:) 0)
			((and (== gCurRoomNum 53) (& (gEgo onControl: 1) $0004))
				(gCurRoom setScript: (ScriptID 151 1)) ; _sEnterElevator
			)
		)
		(super doit:)
	)
)

(instance elevatorDoor of Prop
	(properties
		noun 1
		modNum 151
		view 0
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch global205
					(1
						(gMessager say: 1 1 0 0 0 151) ; "It's the Hotel elevator."
					)
					(2
						(gMessager say: 1 1 1 0 0 151) ; "It's the elevator."
					)
				)
			)
			(4 ; Do
				(switch global205
					(1
						(gMessager say: 1 4 0 0 0 151) ; "Try pressing the button, Bonds."
					)
					(else
						(gMessager say: 1 4 6 0 0 151) ; "Knocking on the elevator doors isn't going to make the elevator arrive any faster...and you're not strong enough to pry the doors apart."
					)
				)
			)
		)
	)
)

(instance keypad of View
	(properties
		view 431
		loop 3
		priority 14
		signal 18448
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(51
				(self x: 211 y: 82 z: 0)
			)
			(53
				(self x: 30 y: 173 z: 0)
			)
		)
	)
)

(instance button1 of View
	(properties
		view 431
		loop 4
		priority 15
		signal 18448
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(51
				(self x: 211 y: 270 z: 200)
			)
			(53
				(self x: 30 y: 260 z: 100)
			)
		)
	)

	(method (doVerb)
		(elevatorSnd number: 922 play:)
		(= local0 1)
		(self setCel: 1)
		((gCurRoom script:) ticks: 5)
	)
)

(instance button2 of View
	(properties
		view 431
		loop 5
		priority 15
		signal 18448
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(51
				(self x: 211 y: 256 z: 200)
			)
			(53
				(self x: 30 y: 246 z: 100)
			)
		)
	)

	(method (doVerb)
		(elevatorSnd number: 922 play:)
		(= local0 2)
		(self setCel: 1)
		((gCurRoom script:) ticks: 5)
	)
)

(instance button3 of View
	(properties
		view 431
		loop 6
		priority 15
		signal 18448
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(51
				(self x: 211 y: 241 z: 200)
			)
			(53
				(self x: 30 y: 232 z: 100)
			)
		)
	)

	(method (doVerb)
		(elevatorSnd number: 922 play:)
		(= local0 3)
		(self setCel: 1)
		((gCurRoom script:) ticks: 5)
	)
)

(instance P of View
	(properties
		view 431
		loop 7
		priority 15
		signal 18448
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(51
				(self x: 211 y: 227 z: 200)
			)
			(53
				(self x: 30 y: 219 z: 100)
			)
		)
	)

	(method (doVerb)
		(elevatorSnd number: 922 play:)
		(= local0 4)
		(self setCel: 1)
		((gCurRoom script:) ticks: 5)
	)
)

(instance keypadFeature of Feature
	(properties
		x 159
		y 194
		z 100
		nsBottom 189
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(HandsOff)
				(gEgo setMotion: 0)
				(= local0 5)
				((gCurRoom script:) ticks: 5)
			)
		)
	)
)

(instance elevatorLight of View
	(properties
		noun 4
		modNum 151
		view 431
		priority 6
		signal 26640
	)
)

(instance marie of Fool
	(properties
		view 435
		signal 18432
		status 0
	)
)

(instance Danny_Anglin of Narrator
	(properties
		name {Danny Anglin}
		x 30
		y 140
		talkWidth 150
		font 4
		showTitle 1
		back 10
	)
)

(instance frankT of Narrator
	(properties
		x 110
		talkWidth 160
		font 4
		showTitle 1
	)

	(method (init)
		(self
			y: (if (== gCurRoomNum 58) 100 else 140)
			name: (if (IsFlag 33) {Jesse Bains} else {Frank Magpie})
			back: (if (IsFlag 33) 12 else 26)
		)
		(super init: &rest)
	)
)

(instance Otto of Narrator
	(properties
		x 150
		y 20
		talkWidth 150
		font 4
		showTitle 1
		back 30
	)
)

(instance Gene of Narrator
	(properties
		x 10
		y 150
		talkWidth 150
		font 4
		showTitle 1
		back 15
	)
)

(instance _sEnterElevator of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 9) (gEgo mover:))
			(gEgo setMotion: 0)
			(keypadFeature doVerb: 3)
		)
	)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(if register
					(= cycles 2)
				else
					(gEgo setMotion: PolyPath local5 local6 self)
				)
			)
			(1
				(if (!= gCurRoomNum 51)
					(gEgo setHeading: 360 self)
				else
					(gEgo setHeading: 300 self)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(elevatorSnd play:)
				(= seconds 2)
			)
			(4
				(gLongSong2 number: 920 loop: 1 flags: 0 play:)
				((ScriptID 151 3) setCycle: End self) ; elevatorDoor
			)
			(5
				(cond
					((== register 1)
						(-- state)
						((ScriptID 151 4) ; marie
							setPri: 4
							setLoop: 7
							setMotion: MoveTo 86 107 self
						)
						(= register 2)
					)
					((== register 2)
						((ScriptID 151 4) setLoop: 8 setCel: 2) ; marie
						(-- state)
						(= ticks 10)
						(= register 3)
					)
					(else
						(gEgo setMotion: MoveTo local1 local2 self)
					)
				)
			)
			(6
				(if (== gCurRoom 51)
					(gEgo setHeading: 125 self)
				else
					(gEgo setHeading: 180 self)
				)
			)
			(7
				(= cycles 2)
			)
			(8
				(keypad init:)
				(button1 init:)
				(button2 init:)
				(button3 init:)
				(P init:)
				(keypadFeature init:)
				(= local0 0)
				(if (not register)
					(User canInput: 1)
					(gTheIconBar enable: 0 2)
					(User canControl: 1)
					(gGame setCursor: 609)
				)
				(= cycles 2)
			)
			(9
				(button1 setCel: 0)
				(button2 setCel: 0)
				(button3 setCel: 0)
				(P setCel: 0)
				(if register
					(button2 doVerb: 4)
				)
			)
			(10
				(switch local0
					(1
						(switch gCurRoomNum
							(51
								(gMessager say: 5 4 5 0 0 151) ; "You're already here!"
								(-= state 2)
								(= ticks 20)
							)
							(53
								(= cycles 2)
							)
						)
					)
					(2
						(switch gCurRoomNum
							(51
								(= cycles 2)
							)
							(53
								(if (== global205 2)
									(gMessager say: 5 4 2 0 0 151) ; "You're already here!"
									(-= state 2)
									(= ticks 20)
								else
									(= cycles 2)
								)
							)
						)
					)
					(3
						(switch gCurRoomNum
							(51
								(= cycles 2)
							)
							(53
								(if (== global205 3)
									(gMessager say: 5 4 3 0 0 151) ; "You're already here!"
									(-= state 2)
									(= ticks 20)
								else
									(= cycles 2)
								)
							)
						)
					)
					(4
						(gMessager say: 5 4 4 0 0 151) ; "The button doesn't respond. Either the button is broken--or the fourth floor is off limits."
						(-= state 2)
						(= ticks 20)
					)
					(5
						(gEgo setMotion: MoveTo local3 local4 self)
					)
				)
			)
			(11
				(HandsOff)
				(if (!= local0 5)
					(gEgo setPri: 4)
				)
				(gLongSong2 number: 921 loop: 1 flags: 0 play:)
				((ScriptID 151 3) setCycle: Beg) ; elevatorDoor
				(= ticks 60)
			)
			(12
				(button1 setCel: 0)
				(button3 setCel: 0)
				(= ticks 60)
			)
			(13
				(keypad dispose:)
				(button1 dispose:)
				(button2 dispose:)
				(button3 dispose:)
				(P dispose:)
				(keypadFeature dispose:)
				(= ticks 30)
			)
			(14
				(cond
					((== local0 5)
						(HandsOn)
						(NormalEgo)
						(self dispose:)
					)
					((== local0 1)
						(gCurRoom newRoom: 51)
					)
					((== gCurRoomNum 51)
						(= global205 local0)
						(gLongSong fade:)
						(gCurRoom newRoom: 53)
					)
					(else
						(gCast eachElementDo: #hide)
						(gCurRoom drawPic: 99)
						(= global205 local0)
						(elevatorLight setCel: (+ global205 1))
						(= seconds 4)
					)
				)
			)
			(15
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 53)
				(= cycles 2)
			)
			(16
				(switch global205
					(1
						(gMessager say: 6 0 8 1 0 151) ; "This is the first floor of the Hotel Delphoria."
					)
					(2
						(gMessager say: 6 0 6 1 0 151) ; "This is the second floor of the Hotel Delphoria."
					)
					(3
						(gMessager say: 6 0 7 1 0 151) ; "This is the third floor of the Hotel Delphoria."
					)
				)
				(gLongSong2 number: 920 loop: 1 flags: 0 play:)
				((ScriptID 151 3) setCycle: End self) ; elevatorDoor
			)
			(17
				(gEgo setMotion: MoveTo local3 local4 self)
			)
			(18
				(gEgo setPri: -1)
				(gLongSong2 number: 921 loop: 1 flags: 0 play:)
				((ScriptID 151 3) setCycle: Beg self) ; elevatorDoor
			)
			(19
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sExitElevator of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gEgo
					init:
					view: global206
					setLoop: (if (== gCurRoomNum 53) 2 else 4)
					posn: local1 local2
					setPri: 4
				)
				(elevatorSnd play:)
				(if register
					((ScriptID 151 4) ; marie
						init:
						setPri: 3
						setLoop: 8
						setCel: 2
						posn: 95 129
					)
				)
				(= seconds 2)
			)
			(2
				(switch global205
					(1
						(gMessager say: 6 0 8 1 self 151) ; "This is the first floor of the Hotel Delphoria."
					)
					(2
						(gMessager say: 6 0 6 1 self 151) ; "This is the second floor of the Hotel Delphoria."
					)
					(3
						(gMessager say: 6 0 7 1 self 151) ; "This is the third floor of the Hotel Delphoria."
					)
					(else
						(Printf
							@temp0
							{ERROR: floor %d not supported.}
							global205
						)
					)
				)
			)
			(3
				(if (== gCurRoomNum 51)
					(gLongSong fade: 50 15 5 0)
				)
				(gLongSong2 number: 920 flags: 0 play:)
				((ScriptID 151 3) setCycle: End self) ; elevatorDoor
			)
			(4
				(NormalEgo)
				(gEgo setMotion: MoveTo local3 local4 self)
			)
			(5
				(cond
					((== register 1)
						(-- state)
						(gEgo setMotion: MoveTo 206 145)
						((ScriptID 151 4) ; marie
							setLoop: 2
							setCycle: Walk
							setPri: -1
							setMotion: MoveTo 95 146 self
						)
						(= register 2)
					)
					((== register 2)
						(-- state)
						((ScriptID 151 4) setLoop: 8 setCel: 2) ; marie
						(= register 3)
						(= ticks 5)
					)
					(else
						(gLongSong2 number: 921 flags: 0 play:)
						((ScriptID 151 3) setCycle: Beg self) ; elevatorDoor
						(if register
							((ScriptID 151 4) ; marie
								setLoop: 0
								setMotion: MoveTo 206 145
							)
						)
					)
				)
			)
			(6
				(if (not register)
					(HandsOn)
					(NormalEgo)
				else
					(gCurRoom cue:)
				)
				(self dispose:)
			)
		)
	)
)

