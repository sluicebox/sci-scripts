;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use rm800)
(use n913)
(use Scaler)
(use Feature)
(use StopWalk)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	cassimaScript 0
)

(instance cassimaScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 801)
	)

	(method (handleEvent event)
		(if
			(and
				(User input:)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (cassimaFeature onMe: event))
			)
			(gMessager say: 1 1) ; "Alexander stands in the secret passage way--so close, yet so far, from his heart's desire."
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCast eachElementDo: #startUpd)
				(gAddToPics eachElementDo: #dispose)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
					(gGame givePoints: 1)
				)
				(= cycles 2)
			)
			(1
				(cond
					((not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
						(gMessager say: 1 0 7 1 self) ; "Alexander peers through the chinks in the wall, trying to locate the source of the crying sounds."
					)
					(((ScriptID 80 0) tstFlag: #rFlag3 16384) ; rgCastle
						(gMessager say: 4 1 21 1 self) ; "Alexander looks through the chinks in the wall to see if Cassima might have returned to her room."
					)
					(else
						(gMessager say: 4 1 20 1 self) ; "Alexander looks through the chinks in the wall, anxious to see what the commotion was about."
					)
				)
			)
			(2
				(gEgo
					normal: 0
					view: 802
					loop: 0
					cel: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 267 165
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(gTheIconBar disable:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 802 10)
				(chinkOverlay addToPic:)
				(background addToPic:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
					(gGlobalSound fadeTo: 703 -1)
					(cassima init: stopUpd:)
				)
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(= cycles 4)
			)
			(4
				(gTheIconBar enable:)
				(cond
					((not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
						(gFeatures add: cassimaFeature)
						(if (OneOf ((gInventory at: 39) owner:) 140 210) ; royalRing
							(self
								setScript:
									(sentRing
										start: -1
										next: (endDialog caller: self yourself:)
										yourself:
									)
									0
							)
						else
							(self
								setScript:
									(noRing
										start: -1
										next: (endDialog caller: self yourself:)
										yourself:
									)
									0
							)
						)
						((ScriptID 800 2) ; roomConv
							add: -1 1 0 7 2 ; "Alexander's palms begin to sweat and his heart to race. It's Cassima! He's found her!"
							add: convScr
							add: -1 1 0 7 3 ; "(WHISPERING URGENTLY) Psst! Princess Cassima!"
							add: -1 1 0 7 4 ; "What? Who's there?"
							add: -1 1 0 7 5 ; "It is I, Alexander! I'm here--behind this wall!"
							add: -1 1 0 7 6 ; "My, how suave THAT sounds!"
							init: script
						)
					)
					(((ScriptID 80 0) tstFlag: #rFlag3 16384) ; rgCastle
						(gMessager say: 4 1 21 2 self oneOnly: 0) ; "But alas, Cassima is still gone."
					)
					(else
						((ScriptID 80 0) setFlag: #rFlag3 16384) ; rgCastle
						(gMessager say: 4 1 20 2 self oneOnly: 0) ; "Cassima is gone! Where could they have taken her? How could he have LET them take her?"
					)
				)
			)
			(5
				(chinkOverlay dispose:)
				(background dispose:)
				(cassArm dispose: delete:)
				(alexArm dispose: delete:)
				(cassimaInset dispose: delete:)
				(alexHead dispose: delete:)
				(cassHead dispose: delete:)
				(if (!= (gGlobalSound number:) 810)
					(gGlobalSound fadeTo: 810 -1)
				)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(proc800_1)
				(= cycles 2)
			)
			(6
				(gTheIconBar enable:)
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo posn: 228 157 reset: 0)
				(= cycles 4)
			)
			(8
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag2 256) ; rgCastle
					(gMessager say: 1 0 13 4 self) ; "Alexander hears scuffling and a woman's brief cry from the other side of the wall, then silence."
				else
					(self cue:)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sentRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 8 1 self) ; "(EXCITED) Alexander?"
			)
			(1
				(self setScript: cassimaStands self)
			)
			(2
				(self setScript: ringScr self 1)
			)
			(3
				((ScriptID 800 2) add: -1 1 0 8 2 add: -1 1 0 8 3 init: self) ; roomConv, "(MELTING INTO BELIEF AND RELIEF, SOFTLY) It really IS you! I knew you were close by, but how did you get inside the castle WALLS?", "It's a long story and not important now. You did get my ring?"
			)
			(4
				(self setScript: ringScr self)
			)
			(5
				((ScriptID 800 2) add: -1 1 0 8 4 add: -1 1 0 8 5 init: self) ; roomConv, "Oh, yes! It has brought me such comfort, Alexander, to know you were close by and had not forgotten....", "But you shouldn't be here! You're only endangering yourself!"
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance noRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 2) add: -1 1 0 9 1 add: -1 1 0 9 2 init: self) ; roomConv, "(CONFUSED, UNBELIEVING) Alexander? Of Daventry? I...I don't believe you.", "I assure you, it is I. Forgive me if I intrude, my lady, but I have been so...concerned for your safety."
			)
			(1
				(self setScript: cassimaStands self)
			)
			(2
				(self setScript: ringScr self 0)
			)
			(3
				((ScriptID 800 2) add: -1 1 0 9 3 add: -1 1 0 9 4 init: self) ; roomConv, "(DOUBTFUL, BUT WANTING TO BELIEVE) Why should I believe you? Alexander of Daventry is somewhere around the world from this small land. (BRAVELY ANGRY) It is a trick, and an unforgivable one. You might tell your master I said so!", "(SHYLY) Princess, I am your most humble servant. I could not offer you trickery though my life depended on it. I know this is a bit odd, but I came from Daventry to see you. I had to."
			)
			(4
				(self setScript: ringScr self)
			)
			(5
				((ScriptID 800 2) ; roomConv
					add: -1 1 0 9 5 ; "(MELTING INTO BELIEF AND RELIEF, SOFTLY) It really IS you, Alexander."
					add: -1 1 0 9 6 ; "It really is. Are you glad I'm here?"
					add: -1 1 0 9 7 ; "(EXCITED) With all my heart! But I don't understand. How did you get into the castle? How did you get into the WALLS?"
					add: -1 1 0 9 8 ; "(RELIEVED, MORE CONFIDENT) It would take too long to explain. I've been on the islands for some time now, trying to find a way to get to you! I had a feeling you needed help."
					init: self
				)
			)
			(6
				(gMessager say: 1 0 9 9 self) ; "(HAPPY, THEN URGENT) Oh, I AM happy to see you, Alexander. I'm afraid I shouldn't be, though! You're endangering yourself terribly by being here!"
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance endDialog of Script
	(properties)

	(method (dispose)
		(ClearFlag 102)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 80 0) tstFlag: #rFlag3 16) ; rgCastle
					(self setScript: watchedVizInStudy self)
				else
					(self setScript: didn_tWatchVizInStudy self)
				)
			)
			(1
				(gMessager say: 1 0 12 0 self) ; "But Abdul would tear the castle apart if I were to disappear from my room! You shall have to do what you can to delay his plans from your end."
			)
			(2
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 4)
				)
				(= seconds 11)
			)
			(3
				(gGame handsOff:)
				(gFeatures delete: cassimaFeature)
				(cassHead
					view: 7833
					loop: 5
					cel: 0
					posn: 133 79
					show:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(= cycles 30)
			)
			(5
				(cassHead cycleSpeed: 6 setCycle: Beg self)
			)
			(6
				(cassHead hide:)
				(= cycles 2)
			)
			(7
				(gMessager say: 1 0 13 1 self) ; "Oh, no! Someone's coming!"
			)
			(8
				(gMessager say: 1 0 13 2 self) ; "The lock on Cassima's door rattles abruptly."
			)
			(9
				(gMessager say: 1 0 13 3 self) ; "(WHISPERED,URGENT) Alexander, hurry! Step away before they see you!"
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance watchedVizInStudy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 2) ; roomConv
					add: -1 1 0 10 1 ; "I'm afraid I'm not the only one in danger. Princess, be brave! I have heard such vileness today! Such evil!"
					add: -1 1 0 10 2 ; "What is it?"
					add: -1 1 0 10 3 ; "Alhazred...he is not what he appears."
					add: -1 1 0 10 4 ; "I've known that for years, Alexander. But with mother and father gone, I'm afraid there's no stopping him."
					add: -1 1 0 10 5 ; "But tell me of what evil you speak. I've been so afraid for my kingdom, not knowing what he plans!"
					add: -1 1 0 10 6 ; "The kingdom IS in trouble, but the real threat at the moment is to YOUR safety, Princess. Alhazred has such plans.... You don't WANT to wed Alhazred, do you?"
					add: -1 1 0 10 7 ; "How can you ask? Of course not!"
					init: self
				)
			)
			(1
				(self setScript: (ringScr start: 8 yourself:) self)
			)
			(2
				(gMessager say: 1 0 10 8 self) ; "If you do not wish to marry him, Cassima, you SHALL not. I promise you. But we must get you out of here, NOW. You are not safe."
			)
			(3
				(self setScript: ringScr self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance didn_tWatchVizInStudy of Script
	(properties
		name {didn'tWatchVizInStudy}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 2) ; roomConv
					add: -1 1 0 11 1 ; "I don't care about the danger! I would brave anything to learn...."
					add: -1 1 0 11 2 ; "What is it?"
					add: -1 1 0 11 3 ; "Alhazred. Do you WANT to wed him, Cassima?"
					init: self
				)
			)
			(1
				(self setScript: (ringScr start: 5 yourself:) self)
			)
			(2
				(gMessager say: 1 0 11 4 self) ; "Oh, please believe me when I say that I never agreed to marry that man! Even when my father trusted Abdul absolutely, I never liked him. But with Mother and Father gone, I'm afraid there's no stopping him."
			)
			(3
				(self setScript: ringScr self)
			)
			(4
				(gMessager say: 1 0 11 5 self oneOnly: 0) ; "If you do not wish to marry him, Cassima, you SHALL not. I promise you. Only come with me now, and we shall escape."
			)
			(5
				(self setScript: ringScr self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance giveLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client seconds: 0)
				(alexArm
					view: 7832
					loop: 5
					cel: 0
					posn: 173 83
					show:
					setCycle: CT 1 1 self
				)
			)
			(1
				(gMessager say: 5 61 22 1 self) ; "I found this letter in the vizier's bedroom.  I...I think you should know what it says."
			)
			(2
				(alexArm cel: 2)
				(cassArm
					view: 7832
					loop: 4
					cel: 0
					posn: 113 86
					setCycle: CT 2 1 self
				)
			)
			(3
				(cassArm setCycle: End self)
				(alexArm setCycle: End)
			)
			(4
				(cassHead
					init:
					show:
					view: 7832
					setPri: 15
					loop: 7
					cel: 0
					x: 137
					y: 59
				)
				(= seconds 5)
			)
			(5
				(cassHead view: 7832 loop: 8 cel: 0 x: 136 y: 60)
				(= cycles 40)
			)
			(6
				(cassHead hide:)
				(= cycles 2)
			)
			(7
				(gMessager say: 5 61 22 2 self) ; "(HORRIFIED)<Gasp!> I can't believe it! I had my suspicions, but this confirms everything! Alexander, YOU must keep the letter. You might have a chance to show it to someone who can help you stop Alhazred. Just be careful, please."
			)
			(8
				(cassArm setCycle: CT 2 -1 self)
				(alexArm setCycle: CT 2 -1 self)
			)
			(9 0)
			(10
				(alexArm setCycle: Beg self)
				(cassArm setCycle: Beg self)
			)
			(11 0)
			(12
				(alexArm hide:)
				(cassArm loop: 1 cel: 0 stopUpd:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 4)
				)
				(client seconds: 8)
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
				(gEgo put: 8 870) ; dagger
				(gGame givePoints: 3)
				(gGame handsOff:)
				(client seconds: 0)
				(alexArm
					view: 7832
					loop: 3
					cel: 0
					x: 172
					y: 84
					show:
					setCycle: CT 1 1 self
				)
			)
			(1
				(gMessager say: 5 8 0 1 self) ; "Here, take this dagger. It's not much, but it might come in handy."
			)
			(2
				(alexArm cel: 2)
				(cassArm
					view: 7832
					loop: 2
					cel: 0
					x: 113
					y: 86
					setCycle: CT 2 1 self
				)
			)
			(3
				(cassArm cel: 3)
				(alexArm setCycle: End self)
			)
			(4
				(alexArm hide:)
				(= cycles 2)
			)
			(5
				(gMessager say: 5 8 0 2 self) ; "Why, it's perfect! This is just the sort of thing I've been looking for! Thank you, Alexander. I'll keep it close and use it if I must."
			)
			(6
				(cassArm setCycle: End self)
			)
			(7
				(cassArm loop: 1 cel: 0 stopUpd:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 4)
				)
				(client seconds: 8)
				(self dispose:)
			)
		)
	)
)

(instance convScr of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassima cycleSpeed: 8 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance cassimaStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassima
					setLoop: 1
					cel: 0
					posn: 140 108
					setPri: 13
					setCycle: End self
				)
			)
			(1
				(cassima
					setLoop: -1
					setScale: Scaler 150 100 171 108
					view: 784
					setCycle: StopWalk -1
				)
				(self dispose:)
			)
		)
	)
)

(instance ringScr of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassima setMotion: MoveTo 140 146 self)
			)
			(1
				(if (not register)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(cassima setMotion: MoveTo 136 185 self)
			)
			(3
				(cassimaInset addToPic:)
				(cassima dispose:)
				(cassArm init: stopUpd:)
				(alexArm init: hide:)
				(SetFlag 102)
				(= cycles 4)
			)
			(4
				(UnLoad 128 783)
				(UnLoad 128 784)
				(self dispose:)
			)
			(5
				(cassHead init: view: 7833 loop: 1 cel: 0)
				(= seconds 3)
			)
			(6
				(cassHead hide: view: 7832)
				(= cycles 3)
			)
			(7
				(self dispose:)
			)
			(8
				(alexArm
					view: 7833
					loop: 0
					cel: 0
					posn: 172 84
					show:
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(9
				(self dispose:)
			)
			(10
				(alexArm cel: 1 cycleSpeed: 8 setCycle: Beg self)
			)
			(11
				(alexArm view: 7832 hide:)
				(= cycles 2)
			)
			(12
				(= state 0)
				(self dispose:)
			)
		)
	)
)

(instance chinkOverlay of View
	(properties
		x 251
		y 118
		view 7801
		priority 14
		signal 16400
	)
)

(instance background of View
	(properties
		x 175
		y 82
		view 780
		signal 24592
	)
)

(instance cassima of Actor
	(properties
		x 155
		y 103
		view 783
		signal 24576
		illegalBits 0
	)
)

(instance cassimaInset of View
	(properties
		x 161
		y 190
		z 101
		sightAngle 180
		view 7832
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) endDialog) (< (endDialog seconds:) 2))
			(endDialog seconds: 4)
		)
		(switch theVerb
			(8 ; dagger
				(endDialog setScript: giveDagger)
			)
			(61 ; letter
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 8)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag2 8) ; rgCastle
					(endDialog setScript: giveLetter)
				else
					(gMessager say: 5 theVerb 28) ; "Cassima has already been upset enough by that letter."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cassArm of Prop
	(properties
		x 113
		y 86
		view 7832
		loop 1
		priority 15
		signal 16400
		cycleSpeed 8
	)
)

(instance alexArm of Prop
	(properties
		x 113
		y 86
		view 7832
		loop 3
		priority 15
		signal 16400
		cycleSpeed 8
	)
)

(instance alexHead of View
	(properties
		x 194
		y 68
		view 7832
		loop 6
		priority 15
		signal 16
	)
)

(instance cassHead of Prop
	(properties
		x 137
		y 59
		view 7832
		loop 7
		priority 15
		signal 16400
	)
)

(instance cassimaFeature of Feature
	(properties
		x 121
		y 191
		noun 5
		nsTop 46
		nsLeft 92
		nsBottom 135
		nsRight 151
		sightAngle 180
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 8 61) ; dagger, letter
			(cassimaInset doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

