;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm870 0
)

(local
	local0
	local1
)

(instance rm870 of CastleRoom
	(properties
		noun 3
		picture 870
		style 10
		east 860
		west 850
		vanishingY -400
		minScaleSize 70
		minScaleY 138
	)

	(method (init)
		(Load rsVIEW 723)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 -10 319 -10 319 140 298 140 288 143 219 143 202 140 90 140 80 144 0 144
					yourself:
				)
		)
		(gFeatures add: roomStuff cassima_door horse bench eachElementDo: #init)
		(= spotEgoScr walkGuardOn)
		(super init: &rest)
		(gEgo
			init:
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(860
				(gEgo posn: 305 168)
			)
			(else
				(gEgo posn: 13 167)
				(cond
					((not ((ScriptID 80 0) tstFlag: #rFlag2 64)) ; rgCastle
						(self setScript: firstTime)
					)
					((not ((ScriptID 80 0) tstFlag: #rFlag2 32)) ; rgCastle
						(self setScript: stillCrying)
					)
					((and (not ((ScriptID 80 0) tstFlag: #rFlag3 256)) (Random 0 1)) ; rgCastle
						(gCurRoom spotEgo: (ScriptID 80 5)) ; guard1
					)
					(else
						((ScriptID 80 0) guard2Timer: 15) ; rgCastle
					)
				)
			)
		)
		((gEgo scaler:) doit:)
		(if (not script)
			(gGame handsOn:)
		)
		(if
			(and
				(!= (gGlobalSound2 number:) 710)
				((ScriptID 80 0) tstFlag: #rFlag2 4) ; rgCastle
				(not ((ScriptID 80 0) tstFlag: #rFlag2 8)) ; rgCastle
			)
			(gGlobalSound fadeTo: 703 -1)
		)
	)

	(method (doit &tmp temp0)
		(if (& (= temp0 (gEgo onControl: 1)) $6000)
			(gCurRoom newRoom: east)
		)
		(super doit: &rest)
	)

	(method (warnUser param1 param2)
		(switch param1
			(3
				(if (and (> argc 1) param2)
					(gCurRoom spotEgo: (ScriptID 80 5)) ; guard1
				else
					(self setScript: warnAboutGuard)
				)
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)
)

(instance firstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 0) setFlag: #rFlag2 64) ; rgCastle
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 1 0 self) ; "The crying is louder here."
			)
			(2
				((ScriptID 80 0) guard2Timer: 31) ; rgCastle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stillCrying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register ((ScriptID 80 0) guard2Timer:)) ; rgCastle
				((ScriptID 80 0) guard2Timer: 0) ; rgCastle
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 6 0 self) ; "The soft crying sounds are still coming from behind the door."
			)
			(2
				(gGame handsOn:)
				((ScriptID 80 0) guard2Timer: (+ register 1)) ; rgCastle
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance bendOverToDoor of Script
	(properties)

	(method (dispose)
		(if (and (== client gCurRoom) (not next))
			((ScriptID 80 0) guardTimer: local0 guard2Timer: local1) ; rgCastle
			(= local0 (= local1 0))
			(gGame handsOn:)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local1)
					(= local0 ((ScriptID 80 0) guardTimer:)) ; rgCastle
					(= local1 ((ScriptID 80 0) guard2Timer:)) ; rgCastle
				)
				((ScriptID 80 0) guardTimer: 0 guard2Timer: 0) ; rgCastle
				(gEgo
					view: 723
					normal: 0
					loop: 0
					cel: 0
					posn: 32 154
					setScale: 0
					scaler: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(1
				(gEgo
					reset: 3
					posn: (cassima_door approachX:) (cassima_door approachY:)
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
				)
				((gEgo scaler:) doit:)
				(= cycles 2)
			)
			(2
				(if next
					(next next: self)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 6 8 11 0 self) ; "Cassima, take this small dagger. It's not much, but perhaps it will prove useful to you."
				(gGame givePoints: 3)
				(gEgo put: 8 870) ; dagger
				(= next 0)
			)
			(1
				(gGame handsOn:)
				((ScriptID 80 0) guardTimer: local0 guard2Timer: local1) ; rgCastle
				(= local0 (= local1 0))
				(self dispose:)
			)
		)
	)
)

(instance showLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 6 61 12 1 self) ; "I found this letter in the vizier's bedroom."
			)
			(1
				(gMessager say: 6 61 12 2 self) ; "I...I think you should know what it says."
			)
			(2
				(= seconds 6)
			)
			(3
				(gMessager say: 6 61 12 3 self oneOnly: 0) ; "(HORRIFIED)<Gasp!> I can't believe it! I had my suspicions, but this confirms everything!"
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance walkGuardOn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound4 number: 702 loop: 1 play:)
				((ScriptID 80 5) ; guard1
					init:
					loop: 3
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 336 172
					setMotion: MoveTo 314 150 self
				)
			)
			(1
				(Face register gEgo self)
			)
			(2
				(gMessager say: 1 0 3 1 self) ; "Good gravy, a strange man! And by the princess's door, yet! JOWELS! COME QUICK!"
			)
			(3
				(gMessager say: 1 0 3 2 self) ; "I can explain...I think. I was looking for the kitchen, you see...."
			)
			(4
				((ScriptID 80 5) setScript: (ScriptID 80 4) self 1) ; guard1, guardsGetEgo
			)
			(5
				(gMessager say: 1 0 3 3 self) ; "Sure, you were! JOWELS!"
			)
			(6
				(= temp0 (Max 160 (Min 185 ((ScriptID 80 5) y:)))) ; guard1
				((ScriptID 80 6) ; guard2
					init:
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 336 172
					setSpeed: ((ScriptID 80 5) cycleSpeed:) ; guard1
					setMotion: MoveTo 300 temp0 self
				)
			)
			(7
				((ScriptID 80 6) ; guard2
					setMotion:
						PolyPath
						(+ ((ScriptID 80 5) x:) 10) ; guard1
						(gEgo y:)
						self
				)
			)
			(8
				(gMessager say: 1 0 3 4 self oneOnly: 0) ; "Sniffed out an intruder, did ya? Good for you, Mite! Let's get 'em!"
			)
			(9
				(= cycles 2)
			)
			(10
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance warnAboutGuard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 2 0 self) ; "Alexander hears the sounds of guard dogs approaching from the east."
			)
			(1
				((ScriptID 80 0) guard2Timer: 6) ; rgCastle
				(self dispose:)
			)
		)
	)
)

(instance cassima_door of Feature
	(properties
		x 44
		y 141
		z 21
		noun 6
		nsTop 100
		nsLeft 32
		nsBottom 141
		nsRight 57
		sightAngle 40
		approachX 35
		approachY 144
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 2) ; dagger, Talk
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 1) ; Do, Look
			(super doVerb: theVerb &rest)
		else
			(switch theVerb
				(2 ; Talk
					(if ((ScriptID 80 0) tstFlag: #rFlag2 4) ; rgCastle
						(if (== ((gInventory at: 8) owner:) 870) ; dagger
							(gMessager say: noun theVerb 15) ; "Cassima, is there anything else I can do for you before I go?"
						else
							(gMessager say: noun theVerb 9) ; "Cassima, is there anything I can do for you before I go?"
						)
					else
						(gGame givePoints: 1)
						(gGlobalSound fadeTo: 703 -1)
						(roomConv
							add: -1 noun theVerb 7 1 ; "Hello? Is there someone in there?"
							add: -1 noun theVerb 7 2 ; "Who--who's there?"
							add: -1 noun theVerb 7 3 ; "Cassima, is that you? It's Alexander!"
						)
						(if (not (OneOf ((gInventory at: 39) owner:) 140 210)) ; royalRing
							(roomConv
								add: -1 noun theVerb 7 4 ; "Alexander? Prince Alexander? I...I don't believe you."
								add: -1 noun theVerb 7 5 ; "It IS Alexander, Cassima! I sailed here to see you, and the ship sank, and.... Cassima, just tell me what to do. How can I help you? Do you want me to get you out of there?"
								add: -1 noun theVerb 7 6 ; "If you really are Alexander, please--you must get away from here! There are guards everywhere, and the vizier would have you killed if he found you here!"
							)
						else
							(roomConv
								add: -1 noun theVerb 8 1 ; "ALEXANDER! Is it really you? When Sing Sing brought me your ring I could scarcely believe it! How did you get inside the castle?"
								add: -1 noun theVerb 8 2 ; "Never mind that now, princess. It isn't important. What can I do to help you? Do you want me to get you out of there? There's a padlock on the door, but I think...."
								add: -1 noun theVerb 8 3 ; "No, please--don't even think about that! There are guards everywhere, and the vizier would have you killed if he found you! You shouldn't even risk being outside my door. Please go now, Alexander."
							)
						)
						(roomConv
							add: -1 noun theVerb 7 7 ; "But, what about you? I can't just leave you locked up like this!"
							add: -1 noun theVerb 7 8 ; "The only way out for me is to stop the vizier. See what you can do out there. In the meantime, I should be safe enough. He hasn't harmed me yet."
							add: -1 noun theVerb 7 9 ; "Besides, if I can only get my hands on something to defend myself with, I'm pretty sure I'll get a chance to use it. The vizier feels safe around me. No one else can get that close."
							add: -1 noun theVerb 7 10 ; "You're so brave, princess. But it's too dangerous."
							add: -1 noun theVerb 7 11 ; "Have you forgotten where we met? What is Abdul compared to Mordack? I'll be fine. Now GO."
							add: -1 noun theVerb 7 12 ; "Alexander hesitates...."
							add: -1 noun theVerb 7 13 ; "I'll do as you say. I WILL find some way to help you, Cassima. I swear it."
							add: -1 noun theVerb 7 14 ; "I believe you, Alexander. Please, be careful!"
							init:
						)
					)
					((ScriptID 80 0) setFlag: #rFlag2 4) ; rgCastle
				)
				(8 ; dagger
					(if ((ScriptID 80 0) tstFlag: #rFlag2 4) ; rgCastle
						(bendOverToDoor next: giveDagger)
						(gCurRoom setScript: bendOverToDoor)
					else
						(gMessager say: noun 0 10 0) ; "Alexander has no reason to use that on the padlocked door."
					)
				)
				(64 ; nail
					(gMessager say: noun theVerb) ; "The padlock on the door is too substantial to be picked with that nail."
				)
				(16 ; scythe
					(gMessager say: noun theVerb) ; "Alexander would be sure to attract unwanted attention if he started hacking at that door."
				)
				(61 ; letter
					(cond
						(((ScriptID 80 0) tstFlag: #rFlag2 8) ; rgCastle
							(gMessager say: noun theVerb 14) ; "Cassima has already been upset enough by that letter."
						)
						(((ScriptID 80 0) tstFlag: #rFlag2 4) ; rgCastle
							((ScriptID 80 0) setFlag: #rFlag2 8) ; rgCastle
							(bendOverToDoor next: showLetter)
							(gCurRoom setScript: bendOverToDoor)
						)
						(else
							(gMessager say: noun 0 10 0) ; "Alexander has no reason to use that on the padlocked door."
						)
					)
				)
				(else
					(if ((ScriptID 80 0) tstFlag: #rFlag2 4) ; rgCastle
						(gMessager say: noun 0 11 0) ; "Alexander would like to do something for Cassima, but there's no way to help her with that."
					else
						(gMessager say: noun 0 10 0) ; "Alexander has no reason to use that on the padlocked door."
					)
				)
			)
		)
	)
)

(instance bench of Feature
	(properties
		y 1
		noun 11
		onMeCheck 128
	)
)

(instance horse of Feature
	(properties
		y 1
		noun 12
		onMeCheck 256
	)
)

(instance roomStuff of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(return
			(or
				(and (& $2002 temp0) (= noun 9))
				(and (<= 0 (param1 y:) 137) (= noun 10))
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

