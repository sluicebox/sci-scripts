;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 927)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Feature)
(use File)
(use Game)
(use Actor)
(use System)

(public
	oldGame 0
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

(instance buttonCast of Cast
	(properties)
)

(instance oldSound of ShiversSound
	(properties)
)

(instance oldGame of Room
	(properties)

	(method (init &tmp temp0)
		(gGame handsOn:)
		(getSavedGames doit:)
		(= local6 (List new:))
		(= local0
			((Plane new:)
				picture: 927
				priority: 40
				init: 0 0 320 200
				addCast: buttonCast
				yourself:
			)
		)
		(buttonCast plane: local0)
		(buildNameSpots doit:)
		(autosaveBtn init:)
		(cancelBtn init:)
		(super init: &rest)
		(switch (Random 0 2)
			(0
				(proc951_9 35054)
				(gSounds play: 35054 0 92 0)
			)
			(1
				(proc951_9 35055)
				(gSounds play: 35055 0 92 0)
			)
			(2
				(proc951_9 35056)
				(gSounds play: 35056 0 92 0)
			)
		)
	)

	(method (dispose)
		(gSounds stop: 35054)
		(gSounds stop: 35055)
		(gSounds stop: 35056)
		(local3 dispose:)
		(local0 dispose:)
		(local6 dispose:)
		(super dispose: &rest)
	)
)

(class MyDText of DText
	(properties)

	(method (dispose)
		(buttonCast delete: self)
		(super dispose: 1)
	)
)

(class NameSpots of Feature
	(properties
		myNum 33
		laName 0
		laScore 0
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(local6 add: self)
		(super init: buttonCast &rest)
		(self writeName: (local3 at: myNum) (+ nsLeft 38) (+ nsBottom 2))
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
				(self onMe: event)
			)
			(event claimed: 1)
			(indicator init: show:)
			(deleteBtn init:)
			(playBtn init:)
			(self doVerb:)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb &tmp temp0)
		(indicator x: (+ nsLeft 27) y: (+ nsBottom 7) show:)
		(UpdateScreenItem indicator)
		(= local4 myNum)
	)

	(method (writeName param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (File new:))
		(= temp1 (Str new: 15))
		(= temp2 (Str new: 15))
		(= temp3 (Str format: {%s%d.SG} gCurSaveDir param1))
		(temp0 name: (temp3 data:))
		(temp0 open: 1 readString: temp1 15 readString: temp2 15 close:)
		(temp1 strip:)
		(temp2 strip:)
		(= laName
			((MyDText new:)
				font: 37
				setPri: 250
				text: (temp1 data:)
				fore: 47
				posn: param2 param3
				setSize: 250
				init: buttonCast
				yourself:
			)
		)
		(= laScore
			((MyDText new:)
				font: 37
				setPri: 254
				text: (temp2 data:)
				fore: 47
				posn: (+ param2 50) param3
				setSize: 250
				init: buttonCast
				yourself:
			)
		)
		(temp0 dispose:)
		(temp3 dispose:)
		(temp1 dispose:)
		(temp2 dispose:)
	)

	(method (dispose)
		(laName dispose:)
		(laScore dispose:)
		(gMouseDownHandler delete: self)
		(local6 delete: self)
		(super dispose: &rest)
	)
)

(instance name0 of NameSpots
	(properties
		nsLeft 2
		nsTop 16
		nsRight 109
		nsBottom 23
		myNum 0
	)
)

(instance name1 of NameSpots
	(properties
		nsLeft 2
		nsTop 24
		nsRight 109
		nsBottom 31
		myNum 1
	)
)

(instance name2 of NameSpots
	(properties
		nsLeft 2
		nsTop 32
		nsRight 109
		nsBottom 39
		myNum 2
	)
)

(instance name3 of NameSpots
	(properties
		nsLeft 2
		nsTop 40
		nsRight 109
		nsBottom 47
		myNum 3
	)
)

(instance name4 of NameSpots
	(properties
		nsLeft 2
		nsTop 48
		nsRight 109
		nsBottom 55
		myNum 4
	)
)

(instance name5 of NameSpots
	(properties
		nsLeft 2
		nsTop 56
		nsRight 109
		nsBottom 63
		myNum 5
	)
)

(instance name6 of NameSpots
	(properties
		nsLeft 2
		nsTop 64
		nsRight 109
		nsBottom 71
		myNum 6
	)
)

(instance name7 of NameSpots
	(properties
		nsLeft 2
		nsTop 72
		nsRight 109
		nsBottom 78
		myNum 7
	)
)

(instance name8 of NameSpots
	(properties
		nsLeft 2
		nsTop 79
		nsRight 109
		nsBottom 86
		myNum 8
	)
)

(instance name9 of NameSpots
	(properties
		nsLeft 2
		nsTop 87
		nsRight 109
		nsBottom 94
		myNum 9
	)
)

(instance name10 of NameSpots
	(properties
		nsLeft 2
		nsTop 95
		nsRight 109
		nsBottom 102
		myNum 10
	)
)

(instance name11 of NameSpots
	(properties
		nsLeft 2
		nsTop 103
		nsRight 109
		nsBottom 110
		myNum 11
	)
)

(instance name12 of NameSpots
	(properties
		nsLeft 2
		nsTop 111
		nsRight 109
		nsBottom 118
		myNum 12
	)
)

(instance name13 of NameSpots
	(properties
		nsLeft 2
		nsTop 119
		nsRight 109
		nsBottom 126
		myNum 13
	)
)

(instance name14 of NameSpots
	(properties
		nsLeft 2
		nsTop 127
		nsRight 109
		nsBottom 134
		myNum 14
	)
)

(instance name15 of NameSpots
	(properties
		nsLeft 2
		nsTop 135
		nsRight 109
		nsBottom 142
		myNum 15
	)
)

(instance name16 of NameSpots
	(properties
		nsLeft 158
		nsTop 16
		nsRight 265
		nsBottom 23
		myNum 16
	)
)

(instance name17 of NameSpots
	(properties
		nsLeft 158
		nsTop 24
		nsRight 265
		nsBottom 31
		myNum 17
	)
)

(instance name18 of NameSpots
	(properties
		nsLeft 158
		nsTop 32
		nsRight 265
		nsBottom 39
		myNum 18
	)
)

(instance name19 of NameSpots
	(properties
		nsLeft 158
		nsTop 40
		nsRight 265
		nsBottom 47
		myNum 19
	)
)

(instance name20 of NameSpots
	(properties
		nsLeft 158
		nsTop 48
		nsRight 265
		nsBottom 55
		myNum 20
	)
)

(instance name21 of NameSpots
	(properties
		nsLeft 158
		nsTop 56
		nsRight 265
		nsBottom 63
		myNum 21
	)
)

(instance name22 of NameSpots
	(properties
		nsLeft 158
		nsTop 64
		nsRight 265
		nsBottom 71
		myNum 22
	)
)

(instance name23 of NameSpots
	(properties
		nsLeft 158
		nsTop 72
		nsRight 265
		nsBottom 78
		myNum 23
	)
)

(instance name24 of NameSpots
	(properties
		nsLeft 158
		nsTop 79
		nsRight 265
		nsBottom 86
		myNum 24
	)
)

(instance name25 of NameSpots
	(properties
		nsLeft 158
		nsTop 87
		nsRight 265
		nsBottom 94
		myNum 25
	)
)

(instance name26 of NameSpots
	(properties
		nsLeft 158
		nsTop 95
		nsRight 265
		nsBottom 102
		myNum 26
	)
)

(instance name27 of NameSpots
	(properties
		nsLeft 158
		nsTop 103
		nsRight 265
		nsBottom 110
		myNum 27
	)
)

(instance name28 of NameSpots
	(properties
		nsLeft 158
		nsTop 111
		nsRight 265
		nsBottom 118
		myNum 28
	)
)

(instance name29 of NameSpots
	(properties
		nsLeft 158
		nsTop 119
		nsRight 265
		nsBottom 126
		myNum 29
	)
)

(instance name30 of NameSpots
	(properties
		nsLeft 158
		nsTop 127
		nsRight 265
		nsBottom 134
		myNum 30
	)
)

(instance name31 of NameSpots
	(properties
		nsLeft 158
		nsTop 135
		nsRight 265
		nsBottom 142
		myNum 31
	)
)

(instance indicator of View
	(properties
		view 927
		loop 41
	)

	(method (init)
		(super init: buttonCast)
	)
)

(instance autosaveBtn of Prop
	(properties
		x 115
		y 175
		view 927
		loop 36
	)

	(method (init)
		(if (IsFlag 60)
			(self loop: 37)
		else
			(self loop: 36)
		)
		(gMouseDownHandler add: self)
		(super init: buttonCast &rest)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance playBtn of Prop
	(properties
		x 30
		y 190
		view 927
		loop 39
	)

	(method (init)
		(super init: buttonCast)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance deleteBtn of Prop
	(properties
		x 115
		y 190
		view 927
		loop 38
	)

	(method (init)
		(super init: buttonCast)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance cancelBtn of Prop
	(properties
		x 245
		y 190
		view 927
		loop 40
	)

	(method (init)
		(super init: buttonCast)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: local0)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(buttonCast delete: self)
		(super dispose: &rest)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(client cel: 1)
				(UpdateScreenItem client)
				(oldSound number: 15026 play: 90 self)
			)
			(1
				(if (or (== (client loop:) 36) (== (client loop:) 37))
					(if (IsFlag 60)
						(ClearFlag 60)
						(client loop: 36)
					else
						(SetFlag 60)
						(client loop: 37)
					)
				)
				(if (== (client loop:) 38)
					(deleteAGame doit:)
					(local6 eachElementDo: #dispose)
					(getSavedGames doit:)
					(buildNameSpots doit:)
					(indicator hide:)
					(playBtn hide:)
					(deleteBtn hide:)
				)
				(if (== (client loop:) 39)
					(client cel: 0)
					(UpdateScreenItem client)
					(= temp1 (local3 at: local4))
					(local3 dispose:)
					(local0 dispose:)
					(gGame handsOn:)
					(gGame restore: temp1)
				)
				(if (== (client loop:) 40)
					(gCurRoom newRoom: gPrevRoomNum)
				)
				(client cel: 0)
				(if (!= (client loop:) 38)
					(UpdateScreenItem client)
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance deleteAGame of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(local3 dispose:)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(= local3 (IntArray new: 21))
		(= local1 (Save 5 {SHIVER} (temp0 data:) (local3 data:))) ; GetSaveFiles
		(Save 6 (temp1 data:) {SHIVER}) ; MakeSaveCatName
		((= temp2 (File new:)) name: (temp1 data:) open: 2)
		(for ((= temp4 0)) (< temp4 local1) ((++ temp4))
			(if (!= (local3 at: local4) (local3 at: temp4))
				(= temp3 (local3 at: temp4))
				(temp1
					at: 0 (& temp3 $00ff)
					at: 1 (& (>> temp3 $0008) $00ff)
					at: 2 0
				)
				(temp2 write: (temp1 data:) 2)
				(= temp6 (Str new: 36))
				(temp6 copyToFrom: 0 temp0 (* temp4 36) 36)
				(temp2 write: (temp6 data:) 36)
				(temp6 dispose:)
			)
		)
		(temp1 at: 0 255 at: 1 255)
		(temp2 write: (temp1 data:) 2 close: dispose:)
		(Save 7 (temp1 data:) {SHIVER} (local3 at: local4)) ; MakeSaveFileName
		(FileIO fiUNLINK (temp1 data:))
		(= temp6 (Str new: 200))
		(= temp6 (Str format: {%s%d.SG} gCurSaveDir (local3 at: local4)))
		(FileIO fiUNLINK (temp6 data:))
		(temp6 dispose:)
		(temp1 dispose:)
		(temp0 dispose:)
	)
)

(instance getSavedGames of Code
	(properties)

	(method (doit &tmp temp0)
		(= local3 (IntArray new: 21))
		(= temp0 (Str new:))
		(= local1 (Save 5 {SHIVER} (temp0 data:) (local3 data:))) ; GetSaveFiles
		(temp0 dispose:)
	)
)

(instance buildNameSpots of Code
	(properties)

	(method (doit)
		(if (> local1 0)
			(name0 init:)
		)
		(if (> local1 1)
			(name1 init:)
		)
		(if (> local1 2)
			(name2 init:)
		)
		(if (> local1 3)
			(name3 init:)
		)
		(if (> local1 4)
			(name4 init:)
		)
		(if (> local1 5)
			(name5 init:)
		)
		(if (> local1 6)
			(name6 init:)
		)
		(if (> local1 7)
			(name7 init:)
		)
		(if (> local1 8)
			(name8 init:)
		)
		(if (> local1 9)
			(name9 init:)
		)
		(if (> local1 10)
			(name10 init:)
		)
		(if (> local1 11)
			(name11 init:)
		)
		(if (> local1 12)
			(name12 init:)
		)
		(if (> local1 13)
			(name13 init:)
		)
		(if (> local1 14)
			(name14 init:)
		)
		(if (> local1 15)
			(name15 init:)
		)
		(if (> local1 16)
			(name16 init:)
		)
		(if (> local1 17)
			(name17 init:)
		)
		(if (> local1 18)
			(name18 init:)
		)
		(if (> local1 19)
			(name19 init:)
		)
		(if (> local1 20)
			(name20 init:)
		)
		(if (> local1 21)
			(name21 init:)
		)
		(if (> local1 22)
			(name22 init:)
		)
		(if (> local1 23)
			(name23 init:)
		)
		(if (> local1 24)
			(name24 init:)
		)
		(if (> local1 25)
			(name25 init:)
		)
		(if (> local1 26)
			(name26 init:)
		)
		(if (> local1 27)
			(name27 init:)
		)
		(if (> local1 28)
			(name28 init:)
		)
		(if (> local1 29)
			(name29 init:)
		)
		(if (> local1 30)
			(name30 init:)
		)
		(if (> local1 31)
			(name31 init:)
		)
	)
)

