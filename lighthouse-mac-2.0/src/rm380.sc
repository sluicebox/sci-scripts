;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use LightRoom)
(use Portal)
(use Str)
(use Array)
(use Talker)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
	krickTalker 1
)

(local
	local0
	local1
	local2
	local3 = -1
	local4
	local5
	local6
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(= temp0 (IntArray new:))
	(Text 0 (temp0 data:) param1 param2 param3) ; TextSize
	(= temp1 (- (temp0 at: 3) (temp0 at: 0)))
	(temp0 dispose:)
	(return temp1)
)

(instance krickTalker of Talker
	(properties)

	(method (init)
		(self view: 202 loop: 1 x: 0 y: 54 blinkSpeed: 200)
		(krickMouth view: 202 loop: 1 x: 0 y: 54)
		(krickEyes view: 202 loop: 2 x: 0 y: 54)
		(super init: krickMouth 0 krickEyes &rest)
		(krickMouth setPri: -1)
		(krickEyes setPri: 56)
	)
)

(instance krickMouth of Prop
	(properties)
)

(instance krickEyes of Prop
	(properties)
)

(instance rm380 of LightRoom
	(properties)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(gBackMusic stop:)
		(gBackMusic2 stop:)
		(Portal kill:)
		(gInventory dispose:)
		(= gInventory ((ScriptID 9 0) new:)) ; LightInv
		(gPanels eachElementDo: #dispose)
		(gGame handsOff:)
		(Font 1 640 480) ; SetFontRes
		(= local1 (Str newWith: 25))
		(self changeScene: -1)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(fire380 dispose:)
		(body380 dispose:)
		(legs380 dispose:)
		(volcano dispose:)
		(ocean dispose:)
		(door615 dispose:)
		(switch param1
			(-1
				(if local6
					(self setScript: sSeeBeing)
				else
					(self setScript: sBlowUp)
				)
			)
			(291
				(= local2
					(IntArray
						newWith:
							10
							43
							1
							30
							40
							0
							43
							2
							30
							8
							5
							1
							1
							30
							40
							0
							1
							2
							30
							8
							5
							2
							1
							30
							40
							0
							2
							2
							30
							8
							5
							41
							1
							30
							40
							0
							41
							2
							30
							8
							5
							3
							1
							30
							40
							0
							3
							2
							30
							8
							0
							3
							3
							30
							8
							0
							3
							4
							30
							8
							0
							3
							5
							30
							8
							0
							3
							6
							30
							8
							0
							3
							7
							30
							8
							0
							3
							8
							30
							8
							7
							4
							1
							30
							40
							0
							4
							2
							30
							8
							0
							4
							3
							30
							8
							5
							46
							1
							30
							40
							0
							46
							2
							30
							8
							5
							45
							1
							30
							40
							0
							45
							2
							30
							8
							0
							45
							3
							30
							8
							0
							45
							4
							30
							8
							0
							45
							5
							30
							8
							0
							45
							6
							30
							8
							0
							45
							7
							30
							8
							0
							45
							8
							30
							8
							0
							45
							9
							30
							8
							0
							45
							10
							30
							8
							0
							45
							11
							30
							8
							7
							50
							1
							30
							40
							0
							50
							2
							30
							8
							0
							50
							3
							30
							8
							5
							5
							1
							30
							40
							0
							6
							1
							30
							8
							0
							6
							2
							40
							8
							5
							7
							1
							30
							40
							0
							8
							1
							30
							16
							0
							8
							2
							40
							8
							0
							9
							1
							30
							16
							0
							9
							2
							40
							8
							0
							10
							1
							30
							16
							0
							10
							2
							40
							8
							0
							11
							1
							30
							16
							0
							11
							2
							40
							8
							10
							7
							1
							30
							40
							0
							12
							1
							30
							16
							0
							12
							2
							40
							8
							0
							13
							1
							30
							16
							0
							13
							2
							40
							8
							0
							14
							1
							30
							16
							0
							14
							2
							40
							8
							0
							15
							1
							30
							16
							0
							15
							2
							40
							8
							10
							7
							1
							30
							40
							0
							16
							1
							30
							16
							0
							16
							2
							40
							8
							0
							17
							1
							30
							16
							0
							17
							2
							40
							8
							0
							18
							1
							30
							16
							0
							18
							2
							40
							8
							0
							19
							1
							30
							16
							0
							19
							2
							40
							8
							10
							7
							1
							30
							40
							0
							20
							1
							30
							16
							0
							20
							2
							40
							8
							0
							22
							1
							30
							16
							0
							22
							2
							40
							8
							10
							21
							1
							30
							40
							0
							23
							1
							30
							16
							0
							23
							2
							40
							8
							5
							24
							1
							30
							40
							0
							25
							1
							30
							16
							0
							25
							2
							40
							8
							0
							26
							1
							30
							16
							0
							26
							2
							40
							8
							0
							27
							1
							30
							16
							0
							27
							2
							40
							8
							10
							24
							1
							30
							40
							0
							28
							1
							30
							16
							0
							28
							2
							40
							8
							0
							29
							1
							30
							16
							0
							29
							2
							40
							8
							0
							30
							1
							30
							16
							10
							31
							1
							30
							40
							0
							31
							2
							30
							8
							0
							32
							1
							30
							16
							0
							32
							2
							30
							8
							0
							33
							1
							30
							16
							0
							33
							2
							30
							8
							0
							34
							1
							30
							16
							0
							34
							2
							30
							8
							7
							35
							1
							30
							40
							0
							35
							2
							30
							8
							0
							35
							3
							30
							8
							0
							35
							4
							30
							8
							5
							36
							1
							30
							40
							0
							36
							2
							30
							8
							0
							36
							3
							30
							8
							0
							36
							4
							30
							8
							0
							36
							5
							30
							8
							0
							36
							6
							30
							8
							0
							36
							7
							30
							8
							0
							36
							8
							30
							8
							5
							37
							1
							30
							40
							0
							37
							2
							30
							8
							0
							37
							3
							30
							8
							0
							37
							4
							30
							8
							5
							40
							1
							30
							40
							0
							40
							2
							30
							8
							5
							47
							1
							30
							40
							0
							47
							2
							30
							8
							5
							38
							1
							30
							40
							0
							38
							2
							30
							8
							0
							38
							3
							30
							8
							0
							38
							4
							30
							8
							5
							39
							1
							30
							40
							0
							39
							2
							30
							8
							5
							42
							1
							30
							40
							0
							42
							2
							30
							8
							0
							42
							3
							30
							8
							0
							42
							4
							30
							8
							0
							42
							5
							30
							8
							0
							42
							6
							30
							8
							0
							42
							7
							30
							8
							0
							42
							8
							30
							8
							0
							42
							9
							30
							8
							0
							42
							10
							30
							8
							0
							42
							11
							30
							8
							0
							42
							12
							30
							8
							7
							42
							1
							30
							40
							0
							48
							1
							30
							8
							0
							48
							2
							30
							8
							0
							48
							3
							30
							8
							0
							48
							4
							30
							8
							0
							48
							5
							30
							8
							0
							48
							6
							30
							8
							0
							48
							7
							30
							8
							0
							48
							8
							30
							8
							0
							48
							9
							30
							8
							0
							48
							10
							30
							8
							7
							49
							1
							30
							40
							7
					)
				)
				(self setScript: sCredits)
			)
			(300
				(gBackMusic number: 9101 play:)
				(= local5 1)
				(self setScript: sPreCredits)
			)
			(380
				(gGame handsOn:)
				(Load rsVIEW 201)
				(Load rsMESSAGE 330)
				(Lock rsAUDIO 150 1)
				(fireFX play:)
				(fire380 init: setCycle: Fwd setScript: sMusic)
				(legs380 init:)
				(body380 init:)
				(gCurRoom setScript: sFadeUp380)
			)
			(292
				(volcano init: cycleSpeed: 60 setCycle: Fwd)
				(gBackMusic number: 9103 play:)
				(= local5 1)
				(self setScript: sPreCredits)
			)
			(615
				(door615 init:)
				(gBackMusic number: 9103 play:)
				(= local5 1)
				(self setScript: sPreCredits)
			)
			(4655
				(gBackMusic number: 9103 play:)
				(= local5 1)
				(self setScript: sPreCredits)
			)
		)
	)
)

(instance sSeeBeing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom fade: 1 1 self)
			)
			(1
				(proc0_8 145)
				(self cue:)
			)
			(2
				(gCurRoom fade: 2 1 self)
			)
			(3
				(self dispose:)
				(gCurRoom changeScene: 291)
			)
		)
	)
)

(instance sBlowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (IsFlag 399)
					(proc0_8 995)
				)
				(gCurRoom fade: 2 1 self)
			)
			(2
				(self dispose:)
				(cond
					((== gPrevRoomNum 5)
						(gCurRoom changeScene: 291)
					)
					((IsFlag 220)
						(= local4 8)
						(gCurRoom changeScene: 615)
					)
					((IsFlag 203)
						(= local4 8)
						(gCurRoom changeScene: 4655)
					)
					((and (or (IsFlag 349) (IsFlag 350)) (IsFlag 400))
						(= local4 6)
						(gCurRoom changeScene: 300)
					)
					((and (not (IsFlag 349)) (not (IsFlag 350)) (IsFlag 400))
						(= local4 5)
						(gCurRoom changeScene: 300)
					)
					((and (not (IsFlag 349)) (IsFlag 350) (IsFlag 400))
						(= local4 6)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(IsFlag 397)
							(not (IsFlag 399))
							(not (IsFlag 427))
							(not (IsFlag 350))
						)
						(= local4 7)
						(gCurRoom changeScene: 300)
					)
					((and (IsFlag 398) (not (IsFlag 399)))
						(= local4 8)
						(gCurRoom changeScene: 292)
					)
					(
						(and
							(IsFlag 349)
							(IsFlag 351)
							(IsFlag 399)
							(not (IsFlag 400))
						)
						(= local4 1)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(IsFlag 349)
							(not (IsFlag 351))
							(IsFlag 399)
							(not (IsFlag 400))
						)
						(= local4 2)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(not (IsFlag 350))
							(IsFlag 351)
							(IsFlag 399)
							(not (IsFlag 400))
						)
						(= local4 3)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(not (IsFlag 350))
							(not (IsFlag 351))
							(IsFlag 399)
							(not (IsFlag 400))
						)
						(= local4 4)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(IsFlag 350)
							(IsFlag 399)
							(not (IsFlag 400))
							(not (IsFlag 351))
						)
						(= local4 9)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(IsFlag 350)
							(IsFlag 399)
							(not (IsFlag 400))
							(IsFlag 351)
						)
						(= local4 10)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(IsFlag 349)
							(IsFlag 350)
							(IsFlag 351)
							(not (IsFlag 399))
						)
						(gCurRoom changeScene: 380)
					)
					(
						(and
							(IsFlag 349)
							(IsFlag 350)
							(not (IsFlag 351))
							(not (IsFlag 399))
						)
						(gCurRoom changeScene: 380)
					)
					(
						(and
							(not (IsFlag 349))
							(IsFlag 350)
							(not (IsFlag 351))
							(not (IsFlag 399))
						)
						(= local4 11)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(IsFlag 350)
							(IsFlag 351)
							(not (IsFlag 399))
						)
						(= local4 12)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(not (IsFlag 350))
							(not (IsFlag 351))
							(not (IsFlag 399))
						)
						(= local4 13)
						(gCurRoom changeScene: 300)
					)
					(
						(and
							(not (IsFlag 349))
							(not (IsFlag 350))
							(IsFlag 351)
							(not (IsFlag 399))
						)
						(= local4 14)
						(gCurRoom changeScene: 300)
					)
					(else
						(gCurRoom changeScene: 291)
					)
				)
			)
		)
	)
)

(instance ocean of Prop
	(properties
		y 161
		view 291
	)
)

(instance sCredits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (dispose)
		(gBackMusic fade: 0 10 7 0)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((or (& (event type:) evKEYBOARD) (& (event type:) evMOUSEBUTTON))
				(if (< state 3)
					(= local3 10000)
					(self seconds: 0 state: 2 cue:)
					(event claimed: 1)
					(return)
				else
					(return 0)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gCurRoom fade: 1 1 self)
			)
			(1
				(ocean init: cycleSpeed: 60 setCycle: Fwd)
				(if (not local5)
					(gBackMusic number: 9103 play:)
				)
				(krickMusic stop:)
				(= start (= seconds 2))
				(= register 0)
			)
			(2
				(if (== (gGame printLang:) 1)
					(= temp0 (local2 at: (++ local3)))
					(= temp1 (local2 at: (++ local3)))
					(= temp2 (local2 at: (++ local3)))
					(= temp3 (local2 at: (++ local3)))
					(= temp4 (local2 at: (++ local3)))
					(if (== register 0)
						(= register 40)
					else
						(+=
							register
							(+ temp3 (localproc_0 (local1 data:) 998 400))
						)
					)
					(Message msgGET 380 0 0 temp0 temp1 (local1 data:))
					(gGame makeText: (local1 data:) temp2 register 998)
					(if (not temp4)
						(-- state)
						(self cue:)
					else
						(= seconds temp4)
					)
				else
					(++ state)
					(= seconds 6)
				)
			)
			(3
				(= register 0)
				(gGame disposeText:)
				(if (>= local3 (- (local2 size:) 1))
					(self cue:)
				else
					(self init:)
				)
			)
			(4
				(gCurRoom fade: 2 1 self)
			)
			(5
				(ocean dispose:)
				(gCurRoom drawPic: -1)
				(= cycles 1)
			)
			(6
				(gBackMusic fade:)
				(= seconds 3)
			)
			(7
				(gBackMusic stop:)
				(= cycles 1)
			)
			(8
				(gCurRoom fade: 1 1 self)
			)
			(9
				(local1 dispose:)
				(local2 dispose:)
				(self dispose:)
				(gCurRoom newRoom: 5)
			)
		)
	)
)

(instance volcano of Prop
	(properties
		y 299
		view 292
	)
)

(instance sPreCredits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((not (& (event type:) evMOUSEBUTTON))
				(return 0)
			)
			(else
				(gMouseDownHandler delete: self)
				(self cue:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom fade: 1 1 self)
			)
			(1
				(= register 1)
				(gGame handsOn:)
				(switch local4
					(1
						(Message msgGET 380 1 0 0 2 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. You have captured the Dark Being in the crystal bottle."
					)
					(2
						(Message msgGET 380 1 0 0 3 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. Lava bursting forth from the volcano's core scours the mountain clean of any trace of the Dark Being and it's fortress."
					)
					(3
						(Message msgGET 380 1 0 0 4 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. You have captured the Dark Being in the crystal bottle, but Doctor Krick and Amanda are consumed in the fiery blast. Dr. Krick's secrets are lost with him. The portal between the worlds is closed forever. You have failed in your mission."
					)
					(4
						(Message msgGET 380 1 0 0 5 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. Lava bursting forth from the volcano's core scours the mountain clean of any trace of the dark being and it's fortress. Doctor Krick and Amanda are consumed in the fiery blast. The portal between the worlds is closed forever. You have failed in your mission."
					)
					(5
						(Message msgGET 380 1 0 0 8 (local1 data:)) ; "The time bomb has exploded. You are killed in the fiery blast. The Dark Domain is destroyed. Lava bursting forth from the volcano's core scours the mountain clean of any trace of the dark being and it's fortress. Doctor Krick and Amanda are never rescued. You have failed in your mission."
					)
					(6
						(Message msgGET 380 1 0 0 9 (local1 data:)) ; "The time bomb has exploded. You are killed in the fiery blast. The Dark Domain is destroyed. Lava bursting forth from the volcano's core scours the mountain clean of any trace of the Dark Being and it's fortress. You have failed in your mission."
					)
					(7
						(Message msgGET 380 1 0 0 6 (local1 data:)) ; "You have used all the Power Modulation Tubes. You cannot return to the Parallel World. You have failed in your mission."
					)
					(8
						(Message msgGET 380 1 0 0 7 (local1 data:)) ; "You are permanently trapped in the parallel world. You live like a hermit on fish and seaweed. You have failed in your mission."
					)
					(9
						(Message msgGET 380 1 0 0 10 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. Lava bursting forth from the volcano's core scours the mountain clean of any trace of the dark being and it's fortress. You have rescued Amanda, but Doctor Krick is consumed in the fiery blast. The portal between the worlds is closed forever. You have failed in your mission."
					)
					(10
						(Message msgGET 380 1 0 0 11 (local1 data:)) ; "The time bomb has exploded. The Dark Domain is destroyed. You have captured the Dark Being in the crystal bottle. You have rescued Amanda, but Doctor Krick is consumed in the fiery blast. You have failed in your mission."
					)
					(11
						(Message msgGET 380 1 0 0 12 (local1 data:)) ; "You have returned to the Lighthouse with Amanda, but Dr. Krick is not rescued. His fate remains a mystery. As the years go by, you wonder what happened to him. Did he ever escape from the Dark Being? Will there ultimately be consequences? Will the Dark Being return to earth? Is the sky a little yellow? Is that a sulfur smell?"
					)
					(12
						(Message msgGET 380 1 0 0 13 (local1 data:)) ; "You have captured the Dark Being, and have returned to the Lighthouse with Amanda. Dr. Krick is not rescued. His fate remains a mystery. You have failed in your mission."
					)
					(13
						(Message msgGET 380 1 0 0 1 (local1 data:)) ; "You have returned to the Lighthouse without Amanda or Dr. Krick. Their fate remains a mystery. Dr. Krick's secrets are lost with him. As the years go by, you wonder what happened to them. Did they ever escape from the Dark Being? Will there ultimately be consequences? Will the Dark Being return to earth? Is the sky a little yellow? Is that a sulfur smell?"
					)
					(14
						(Message msgGET 380 1 0 0 14 (local1 data:)) ; "You have captured the Dark Being, but you have returned to the Lighthouse without Amanda or Dr. Krick. Their fate remains a mystery. Dr. Krick's secrets are lost with him. You have failed in your mission."
					)
					(else
						(if
							(and
								(IsFlag 351)
								(not (IsFlag 397))
								(not (IsFlag 398))
								(not (IsFlag 400))
							)
							(= local6 1)
							(gCurRoom changeScene: -1)
						else
							(gCurRoom changeScene: 291)
						)
						(= register 0)
						(self dispose:)
					)
				)
				(if register
					(gGame makeText: (local1 data:) 30 30 998)
				)
			)
			(2
				(gGame disposeText:)
				(if (== (gBackMusic number:) 9101)
					(= local5 0)
					(gBackMusic fade:)
					(= seconds 3)
				else
					(= cycles 2)
				)
			)
			(3
				(if (== (gBackMusic number:) 9101)
					(= local5 0)
					(gBackMusic stop:)
				)
				(gCurRoom fade: 2 1 self)
			)
			(4
				(self dispose:)
				(switch local4
					(1
						(gCurRoom changeScene: 380)
					)
					(2
						(gCurRoom changeScene: 380)
					)
					(else
						(if
							(and
								(IsFlag 351)
								(not (IsFlag 397))
								(not (IsFlag 398))
								(not (IsFlag 400))
							)
							(= local6 1)
							(gCurRoom changeScene: -1)
						else
							(gCurRoom changeScene: 291)
						)
					)
				)
			)
		)
	)
)

(instance sFadeUp380 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom fade: 1 1 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance krickMusic of Sound
	(properties)
)

(instance sMusic of Script
	(properties)

	(method (dispose)
		(krickMusic stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf (gCurRoom script:) sNotAsBad sGoodJob)
					(krickMusic play: self)
				else
					(krickMusic number: 9102 loop: 1 play: self)
				)
			)
			(1
				(if (OneOf (gCurRoom script:) sNotAsBad sGoodJob)
					(krickMusic play: self)
				else
					(krickMusic number: 9104 loop: 1 play: self)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance fireFX of Sound
	(properties
		number 150
		loop -1
	)
)

(instance fire380 of Prop
	(properties
		x 288
		y 151
		view 380
	)

	(method (dispose)
		(super dispose:)
		(Lock rsAUDIO 150 0)
		(fireFX stop:)
	)
)

(instance legs380 of View
	(properties
		y 54
		view 202
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(body380 doVerb: theVerb)
	)
)

(instance head380 of View
	(properties
		y 54
		view 202
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 50)
		(approachX hotVerbs: 5)
	)
)

(instance body380 of Prop
	(properties
		y 54
		view 200
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(self setPri: 20)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 351))
					(gGame handsOff:)
					(gCurRoom setScript: sNotAsBad)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sGoodJob)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 360))
			)
			(1
				(body380 setCycle: End self)
			)
			(2
				(body380 setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sNotAsBad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body380 setCycle: End self)
			)
			(1
				(head380 init:)
				(body380 view: 201 setScript: sFidget)
				(= cycles 2)
			)
			(2
				(switch (++ local0)
					(1
						(gMessager say: 39 0 0 1 self 330) ; "Thank you for saving us! I was a fool to work alone on such a dangerous experiment. Please.... Don't tell anyone. They would think you were mad, I know! They have laughed at me before! I thought I was a genius, but my experiments almost destroyed my own family! I have done far more harm than good."
					)
					(2
						(gMessager say: 39 0 0 2 self 330) ; "Thank god Amanda is safe! If I lost her, I know I would go mad!! I should destroy the device! ....but .... the creature is still free! I think it will return some day! If it were to build a permanent portal, it could cause great harm to the earth! I will always be waiting. If it returns, I will be ready!"
					)
					(else
						(gMessager say: 39 0 0 3 self 330) ; "You should go now, Amanda needs some rest. Thank you again!"
					)
				)
			)
			(3
				(if (> local0 2)
					((ScriptID 1 2) newPic: 291 exitCode: cExit380) ; exitBack
				)
				(head380 dispose:)
				(body380 setScript: 0 setCycle: 0 view: 200)
				(body380 cel: (body380 lastCel:) setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoodJob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body380 setCycle: End self)
			)
			(1
				(head380 init:)
				(body380 view: 201 setScript: sFidget)
				(= cycles 2)
			)
			(2
				(switch (++ local0)
					(1
						(gMessager say: 40 0 0 1 self 330) ; "Thank you for saving us! I couldn't have defeated the dark being without your help. I will be more careful in the future! My experiments have risked the life of my only daughter!"
					)
					(2
						(gMessager say: 40 0 0 2 self 330) ; "Please.... Don't tell anyone. They would think you were mad, I know! The Dark Being should never be set free! It tortured to get my calculations....but I didn't tell it anything! Throw the bottle into the sea! I will destroy my notes! The world will be a better place."
					)
					(else
						(gMessager say: 40 0 0 3 self 330) ; "You should go now, Amanda needs some rest. Thank you again!"
					)
				)
			)
			(3
				(if (> local0 2)
					((ScriptID 1 2) newPic: 291 exitCode: cExit380) ; exitBack
				)
				(head380 dispose:)
				(body380 setScript: 0 setCycle: 0 view: 200)
				(body380 cel: (body380 lastCel:) setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cExit380 of Code
	(properties)

	(method (doit)
		(sMusic dispose:)
		(gCurRoom fade: 2 1)
		(if
			(and
				(IsFlag 351)
				(not (IsFlag 397))
				(not (IsFlag 398))
				(not (IsFlag 400))
			)
			(= local6 1)
			(gCurRoom changeScene: -1)
		else
			(gCurRoom changeScene: 291)
		)
	)
)

(instance door615 of View
	(properties
		x 248
		y 231
		view 615
	)
)

