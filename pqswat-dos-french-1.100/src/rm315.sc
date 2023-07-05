;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Osc)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm315 0
	goToGallery 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm315 of PQRoom
	(properties
		picture 315
		infoRoomSignal 72
	)

	(method (init)
		(= global108 1)
		(SetFlag 15)
		(SetFlag 12)
		(if (IsFlag 54)
			(= picture 0)
		)
		(super init: &rest)
		(Load rsVIEW 23)
		(Load rsVIEW 38)
		(Load rsVIEW 46)
		(rightTables init:)
		(if (IsFlag 21)
			(= local3 6)
		else
			(= local3 10)
		)
		(= global114 myShootCode)
		(SetFlag 110)
		(cond
			((IsFlag 54)
				(self setScript: backFromGallery)
			)
			((IsFlag 23)
				(sniperGuy init: setCycle: Fwd)
				(self setScript: doQualify)
			)
			((IsFlag 21)
				(sniperGuy init: setCycle: Fwd)
				(self setScript: enterAfterFirst)
			)
			(else
				(Load rsVIEW 3151)
				(self setScript: meetGuys)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if (IsFlag 21)
					(gGame showCloseUp: 3165)
				else
					(gGame showCloseUp: 3169)
				)
			)
			(25
				(if (IsFlag 21)
					(gGame showCloseUp: 3185)
				else
					(gGame showCloseUp: 3171)
				)
			)
			(else
				(if local4
					(gGame showCloseUp: 3186 180 66 0)
				else
					(gGame showCloseUp: 3186 180 66 0)
					(= local4 1)
				)
			)
		)
	)

	(method (dispose &tmp temp0)
		(myTimer dispose: delete:)
		(switch gNewRoomNum
			(320
				(for ((= temp0 0)) (< temp0 (gInventoryCast size:)) ((++ temp0))
					(if (== (gSwatInterface curInvItem:) (gInventoryCast at: temp0))
						(gSwatInterface replaceInvItem: (gInventoryCast at: temp0))
					)
				)
			)
			(100
				(SetFlag 54)
				(ClearFlag 110)
				(ClearFlag 15)
				(ClearFlag 12)
			)
			(300
				(SetFlag 54)
				(ClearFlag 110)
				(ClearFlag 15)
				(ClearFlag 12)
			)
			(else
				(ClearFlag 110)
				(ClearFlag 15)
				(ClearFlag 12)
			)
		)
		(= global114 0)
		(if (not (OneOf gNewRoomNum 310 320))
			(Lock rsAUDIO 31001 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(super dispose: &rest)
	)
)

(instance meetGuys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 112)
					(proc4_6 3151 402 116)
				else
					(proc4_6 3150 390 118)
				)
			)
			(1
				(if (IsFlag 112)
					(saunders
						view: 3151
						setLoop: 0
						setCel: 1
						posn: 406 118
						setPri: 250
						init:
					)
					(pruett
						view: 3151
						setLoop: 0
						setCel: 0
						posn: 406 118
						setPri: 300
						init:
					)
					(egoProp
						view: 3151
						setLoop: 1
						setCel: 0
						posn: 476 122
						init:
					)
					(tello init: posn: 460 150 setCycle: Osc -1)
				else
					(saunders view: 3150 posn: 407 116 init: setPri: 250)
					(pruett view: 3150 posn: 407 116 init: setPri: 300)
					(egoProp view: 3150 setCel: 9 posn: 507 120 init:)
					(tello init: setCycle: Osc -1)
				)
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((IsFlag 23)
						(gGame showCloseUp: 3190 180 66 self 1)
					)
					((IsFlag 21)
						(gGame showCloseUp: 3190 180 66 self 1)
					)
					(else
						(Palette 2 42 254 0) ; PalIntensity
						(FrameOut)
						(gMessager say: 0 0 18 0 self) ; "We'll set up down here."
					)
				)
			)
			(1
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance goToGallery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myTimer client: 0 delete: dispose:)
				(gMessager say: 6 29 0 0 self) ; "Don't be gone long, Officer. Saunders is anxious to get started."
			)
			(1
				(SetFlag 54)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance backFromGallery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette 2 0 254 100) ; PalIntensity
				(FrameOut)
				(cond
					((== gPrevRoomNum 100)
						(gGame showCloseUp: 3160 180 66 self)
					)
					((IsFlag 55)
						(gGame showCloseUp: 3158 180 66 self)
					)
					(else
						(gGame showCloseUp: 3157 180 66 self)
					)
				)
			)
			(1
				(gCurRoom drawPic: 315)
				(sniperGuy init: setCycle: Fwd)
				(tello init: setCycle: Osc -1)
				(saunders init: setPri: 250)
				(pruett init: setPri: 300)
				(egoProp init:)
				(ClearFlag 54)
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToActor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(tello
						(cond
							((IsFlag 23)
								(if local2
									(gGame showCloseUp: 31555 180 66 self)
								else
									(++ local2)
									(gGame showCloseUp: 31560 180 66 self)
								)
							)
							((IsFlag 21)
								(gGame showCloseUp: 31560 180 66 self)
							)
							((not (IsFlag 56))
								(SetFlag 56)
								(++ local2)
								(gGame showCloseUp: 31550 180 66 self)
							)
							((and (not local2) (IsFlag 56) (not (IsFlag 127)))
								(SetFlag 127)
								(++ local2)
								(gGame showCloseUp: 31549 180 66 self)
							)
							(else
								(gGame showCloseUp: 31551 180 66 self)
							)
						)
					)
					(saunders
						(if (IsFlag 57)
							(gGame showCloseUp: 31543 180 66 self)
						else
							(SetFlag 57)
							(gGame showCloseUp: 31542 180 66 self)
						)
					)
					(pruett
						(cond
							((IsFlag 23)
								(switch local1
									(0
										(gGame showCloseUp: 3189 180 66 self)
									)
									(1
										(gGame showCloseUp: 3188 180 66 self)
									)
									(2
										(gGame showCloseUp: 3193 180 66 self)
									)
									(else
										(gGame showCloseUp: 3194 180 66 self)
									)
								)
								(++ local1)
							)
							((IsFlag 21)
								(switch local1
									(0
										(gGame showCloseUp: 3189 180 66 self)
									)
									(1
										(gGame showCloseUp: 3195 180 66 self)
									)
									(else
										(gGame showCloseUp: 3187 180 66 self)
									)
								)
								(++ local1)
							)
							((IsFlag 58)
								(gGame showCloseUp: 3164 180 66 self)
							)
							(else
								(SetFlag 58)
								(gGame showCloseUp: 3163 180 66 self)
							)
						)
					)
					(mountains
						(cond
							((IsFlag 23)
								(if local0
									(gMessager say: 13 29 30 0 self) ; "Quit fooling around. Drills are starting soon. Go get set up."
								else
									(= local0 1)
									(gMessager say: 13 29 27 0 self) ; "You're wasting time, Officer. Drills are going to start and you won't be ready. Why don't you go get set up on that rifle of yours?"
								)
							)
							((IsFlag 21)
								(if local0
									(gMessager say: 13 0 14 0 self) ; "Your behavior makes me think that you might need to be evaluated by the Department's shrink. Now knock that off! Go set up!"
								else
									(= local0 1)
									(gMessager say: 13 0 13 0 self) ; "Are you changing your mind about this? Is this some kind of stall tactic? Come on, lead the way and we'll set up."
								)
							)
							(local0
								(gMessager say: 13 29 20 0 self) ; "What are you waiting for, Officer? Head on down the range and get set up."
							)
							(else
								(= local0 1)
								(gMessager say: 13 29 21 0 self) ; "It's beautiful country out here. You know, the Angeles Range is part of the Angeles National Forest. Due to budget constraints, LAPD unfortunately doesn't have its own long rifle range. Lucky for us, the Angeles Range is willing to accommodate our training schedules."
							)
						)
					)
				)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance robarOnActor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(tello
						(if (IsFlag 21)
							(gGame showCloseUp: 31556 180 66 self)
						else
							(gGame showCloseUp: 31552 180 66 self)
						)
					)
					(saunders
						(gGame showCloseUp: 31544 180 66 self)
					)
					(pruett
						(cond
							((IsFlag 23)
								(gGame showCloseUp: 3176 180 66 self)
							)
							((IsFlag 21)
								(gGame showCloseUp: 3191 180 66 self)
							)
							(else
								(gGame showCloseUp: 3167 180 66 self)
							)
						)
					)
					(mountains
						(if (IsFlag 21)
							(gMessager say: 13 54 14 0 self) ; "She's a thing of beauty, and that's no way to treat her. Get your butt down range."
						else
							(gMessager say: 13 54 13 0 self) ; "Out here we shoot at designated targets, Officer. If that's what you'd like to do, I suggest you and Officer Saunders head down range and set up that SR60."
						)
					)
				)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coltOnActor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(tello
						(if (IsFlag 21)
							(gGame showCloseUp: 31558 180 66 self)
						else
							(gGame showCloseUp: 31554 180 66 self)
						)
					)
					(saunders
						(gGame showCloseUp: 31561 180 66 self)
					)
					(pruett
						(cond
							((IsFlag 23)
								(gGame showCloseUp: 3178 180 66 self)
							)
							((IsFlag 21)
								(gGame showCloseUp: 3175 180 66 self)
							)
							(else
								(gGame showCloseUp: 3162 180 66 self)
							)
						)
					)
					(mountains
						(if (IsFlag 21)
							(gMessager say: 13 6 14 0 self) ; "Recklessly brandishing a firearm is against Department regulations... not to mention Federal and State laws. Now if you don't want me to elaborate further on the consequences of such an action, I'd put the piece away."
						else
							(gMessager say: 13 6 13 0 self) ; "What do you think you're doing? As LAPD SWAT we abide by safety rules on this range. If you want to go plink, go plink on your time off. Understand?"
						)
					)
				)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance otherInvOnActor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(tello
						(if (IsFlag 21)
							(gGame showCloseUp: 31557 180 66 self)
						else
							(gGame showCloseUp: 31553 180 66 self)
						)
					)
					(saunders
						(gGame showCloseUp: 31545 180 66 self)
					)
					(pruett
						(cond
							((IsFlag 23)
								(gGame showCloseUp: 3177 180 66 self)
							)
							((IsFlag 21)
								(gGame showCloseUp: 3168 180 66 self)
							)
							(else
								(gGame showCloseUp: 3168 180 66 self)
							)
						)
					)
					(mountains
						(if (IsFlag 21)
							(gMessager say: 13 0 14 0 self) ; "Your behavior makes me think that you might need to be evaluated by the Department's shrink. Now knock that off! Go set up!"
						else
							(gMessager say: 13 0 13 0 self) ; "Are you changing your mind about this? Is this some kind of stall tactic? Come on, lead the way and we'll set up."
						)
					)
				)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance otherInvOnTables of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 21)
					(gGame showCloseUp: 31548 180 66 self)
				else
					(gGame showCloseUp: 3166 180 66 self)
				)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coltOnTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: showCloseUp: 31559 180 66 self)
			)
			(1
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterAfterFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 3152 394 125)
			)
			(1
				(tello init: setCycle: Osc -1)
				(pruett
					view: 3152
					setLoop: 0
					setCel: 0
					init:
					setPri: 300
					posn: 401 123
				)
				(egoProp view: 3152 setLoop: 0 setCel: 1 init: posn: 401 123)
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doQualify of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 3153 402 124)
			)
			(1
				(tello init: setCycle: Osc -1)
				(egoProp view: 3153 setLoop: 0 setCel: 1 init: posn: 399 124)
				(pruett
					view: 3153
					setLoop: 0
					setCel: 0
					init:
					setPri: 300
					posn: 399 124
				)
				(myTimer setReal: myTimer local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance robarOnTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(cond
					((IsFlag 23)
						(gMessager say: 4 54 26 0 self) ; "If you'll excuse me, sir, I think I'll go get prepared."
					)
					((IsFlag 21)
						(gMessager say: 4 54 14 0 self) ; "If you'll excuse me, sir, I'll go set up."
					)
					(else
						(gMessager say: 0 0 18 0 self) ; "We'll set up down here."
					)
				)
			)
			(1
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance tello of Actor
	(properties
		x 460
		y 150
		view 3152
		loop 1
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToActor 0 self)
			)
			(25
				(gCurRoom setScript: robarOnActor 0 self)
			)
			(6
				(gCurRoom setScript: coltOnActor 0 self)
			)
			(else
				(gCurRoom setScript: otherInvOnActor 0 self)
			)
		)
	)
)

(instance egoProp of Prop
	(properties
		x 471
		y 122
		view 3151
		loop 1
	)
)

(instance pruett of Prop
	(properties
		x 401
		y 118
		view 3151
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToActor 0 self)
			)
			(25
				(gCurRoom setScript: robarOnActor 0 self)
			)
			(6
				(gCurRoom setScript: coltOnActor 0 self)
			)
			(else
				(gCurRoom setScript: otherInvOnActor 0 self)
			)
		)
	)
)

(instance saunders of Prop
	(properties
		x 401
		y 118
		view 3151
		cel 1
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToActor 0 self)
			)
			(25
				(gCurRoom setScript: robarOnActor 0 self)
			)
			(6
				(gCurRoom setScript: coltOnActor 0 self)
			)
			(else
				(gCurRoom setScript: otherInvOnActor 0 self)
			)
		)
	)
)

(instance sniperGuy of Prop
	(properties
		x 186
		y 195
		view 31564
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: goToDrill)
			)
			(25
				(gCurRoom setScript: robarOnTable)
			)
			(6
				(gCurRoom setScript: coltOnTable)
			)
			(else
				(gCurRoom setScript: otherInvOnTables)
			)
		)
	)
)

(instance mountains of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 114 637 0 0 0 0 312 214 297 214 269 236 249 178 183 181 170 401 159 401 255 415 255 415 158 579 154 579 108
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToActor 0 self)
			)
			(25
				(gCurRoom setScript: robarOnActor 0 self)
			)
			(6
				(gCurRoom setScript: coltOnActor 0 self)
			)
			(else
				(gCurRoom setScript: otherInvOnActor 0 self)
			)
		)
	)
)

(instance rightTables of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 555 79 440 141 436 228 239 245 81 175 87 165 122 130
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(myTimer client: 0 delete: dispose:)
		(switch theVerb
			(29
				(gCurRoom setScript: goToDrill)
			)
			(25
				(gCurRoom setScript: robarOnTable)
			)
			(6
				(gCurRoom setScript: coltOnTable)
			)
			(else
				(gCurRoom setScript: otherInvOnTables)
			)
		)
	)
)

(instance myTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: goToDrill)
		(self dispose: delete:)
	)
)

(instance myShootCode of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

