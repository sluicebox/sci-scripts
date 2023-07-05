;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 745)
(include sci.sh)
(use Main)
(use n913)
(use Motion)
(use Actor)
(use System)

(public
	closeupWedding 0
)

(instance closeupWedding of Script
	(properties)

	(method (init)
		(super init: &rest)
		(SetFlag 99)
		(gCurRoom noun: 3)
		((ScriptID 80 0) setFlag: #rFlag2 2048) ; rgCastle
		(gWalkHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (setScript)
		(= seconds 0)
		(super setScript: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar at: 0) (gTheIconBar curIcon:))
				(& (event type:) $1040) ; evMOVE | direction
			)
			(event claimed: 1)
			(= next (ScriptID 744 1)) ; saladinKillEgo
			(self cue:)
		)
		(event claimed:)
	)

	(method (dispose)
		(gTheIconBar disable:)
		(gWalkHandler delete: self)
		(gDirectionHandler delete: self)
		(genieHead dispose: delete:)
		(vizierHead dispose: delete:)
		(saladinArm dispose: delete:)
		(alexHead dispose: delete:)
		(priestHead dispose: delete:)
		(saladinHead dispose: delete:)
		(glint1 dispose: delete:)
		(glint2 dispose: delete:)
		(gCurRoom drawPic: 740)
		(ClearFlag 99)
		(gCurRoom noun: 3)
		(gCast eachElementDo: #show eachElementDo: #stopUpd)
		(super dispose:)
		(gEgo startUpd:)
		(if (IsFlag 156)
			(gEgo posn: 149 144)
		)
		(UnLoad 128 160)
		(UnLoad 128 161)
		(UnLoad 128 902)
		(UnLoad 129 160)
		(UnLoad 143 160)
		(DisposeScript 1005)
		(DisposeScript 745)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #startUpd)
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 160)
				(gGlobalSound number: 740 loop: -1 play:)
				(vizierHead addToPic:)
				(saladinArm init: stopUpd:)
				(saladinHead init:)
				(alexHead init:)
				(priestHead init:)
				(= seconds (= cycles 2))
			)
			(2
				(gTheIconBar enable:)
			)
			(3
				((ScriptID 740 7) ; roomConv
					add: 160 1 0 1 1 ; "(TO ALEXANDER) Prince Alexander, here? This is an outrage!"
					add: 160 1 0 1 2 ; "(TO SALADIN) How dare you allow this traitor to get past you, Saladin! You stupid mutt! Can't you even keep the castle free of assassins during your own princess's wedding? Kill him! Kill him now!"
					add: 160 1 0 1 3 ; "<Grrr>Lord Alhazred.... With all due respect, you are not quite king yet. And this IS a wedding ceremony, not an execution."
					add: 160 1 0 1 4 ; "What? How dare you contradict me, you flea-bitten mongrel? I gave a direct order. Obey me or feel my wrath!"
					add: 160 1 0 1 5 ; "(TO CASSIMA) M'lady, I apologize for my behavior, but I am yours to command in all things. I wanted merely to hear your own wishes from your own lips."
					add: 160 1 0 1 6 ; "Tell me what is it that you wish me to do with this young man, and I will obey."
					init: self
				)
			)
			(4
				(glint1 init: setCycle: End self)
				(glint2 init: setCycle: End)
			)
			(5
				(gGlobalSound number: 746 loop: -1 play:)
				(glint1 setCycle: Beg self)
				(glint2 setCycle: Beg)
			)
			(6
				((ScriptID 740 7) add: 160 1 0 1 7 add: 160 1 0 1 8 init: self) ; roomConv, "Why Captain, you heard my dear Abdul. If he wishes this atrocious young man's death, then I want nothing more than to see him get his wish. Obey thy liege now and always.", "(VERY SAD AND RESIGNED) As you wish, princess."
			)
			(7
				(glint1 dispose:)
				(glint2 dispose:)
				(genieHead init: cel: 0)
				(= cycles 10)
			)
			(8
				(DisposeScript 939)
				(saladinArm cel: 2 startUpd:)
				(if (not (= register ((ScriptID 80 0) tstFlag: #rFlag1 128))) ; rgCastle
					(saladinArm setCycle: Beg self)
				else
					(saladinArm setScript: drawSword self)
					(= cycles 1)
				)
			)
			(9
				(if (not register)
					(= next 0)
					(gMessager say: 1 0 2 0 self 160) ; "Just as Saladin prepares to run Alexander through with his sword, a shout is heard from the direction of the grand hall...."
				else
					(gGame handsOn:)
					(++ state)
				)
			)
			(10
				(saladinArm setScript: 0 setCycle: End self)
			)
			(11
				(= cycles 3)
			)
			(12
				(gGame handsOff:)
				(gTheIconBar disable:)
				(if (not next)
					(if (not register)
						(UnLoad 128 738)
						((ScriptID 740 5) view: 7424 loop: 0 cel: 0 setCycle: 0) ; saladin
						(= next (ScriptID 742 3)) ; kingQueenEntry
					else
						((ScriptID 744 1) register: 29) ; saladinKillEgo
						(= next (ScriptID 744 1)) ; saladinKillEgo
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance showMirror of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(saladinHead dispose: delete:)
		(priestHead dispose: delete:)
		(alexHead dispose: delete:)
		(mirror dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drawSword caller: 0)
				(saladinArm setScript: 0)
				(if (saladinArm cel:)
					(saladinArm setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 4 13 0 1 self 160) ; "Look into this mirror, 'my love,' and show us your true heart!"
			)
			(2
				(genieHead init: cel: 1 setCycle: End)
				(mirror init: cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(3
				(gGame givePoints: 3)
				(saladinArm addToPic:)
				(priestHead cel: 1 addToPic:)
				(saladinHead cel: 1 addToPic:)
				(alexHead cel: 1 addToPic:)
				(genieHead addToPic:)
				(mirror addToPic:)
				(= cycles 18)
			)
			(4
				(gMessager say: 4 13 0 2 self 160) ; "AIEEE! That mirror! NO!!!"
			)
			(5
				(client seconds: 0 next: (ScriptID 744 0)) ; genieCastSpell
				((ScriptID 740 5) view: 7424 loop: 0 cel: 0 setCycle: 0) ; saladin
				(gTheIconBar disable:)
				(client dispose:)
			)
		)
	)
)

(instance showReplicaLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 56 0 0 self 160) ; "I have this lamp, Alhazred...."
			)
			(1
				(closeupWedding next: (ScriptID 744 1) changeState: 12) ; saladinKillEgo
			)
		)
	)
)

(instance drawSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(if (> (saladinArm cel:) 0)
					(saladinArm cel: (- (saladinArm cel:) 1) startUpd:)
					(= cycles 2)
				else
					(self dispose:)
				)
			)
			(2
				(saladinArm stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(class CloseupProp of Prop
	(properties
		controlColor 0
	)

	(method (onMe param1)
		(return
			(or
				(super onMe: param1)
				(& controlColor (OnControl CONTROL (param1 x:) (param1 y:)))
			)
		)
	)
)

(instance genieHead of CloseupProp
	(properties
		x 147
		y 58
		noun 4
		modNum 160
		view 160
		loop 1
		cel 1
		priority 9
		signal 16
		controlColor 2
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 33 18) ; ribbon, cassimaHair
				(gMessager say: noun 18 0 0 0 modNum) ; "Cassima doesn't seem to care whether Alexander lives or dies right now. She is, therefore, probably not interested in anything she might have sent him through Sing Sing."
			)
			((OneOf theVerb 57 58 59 60 43) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, huntersLamp
				((ScriptID 740 7) add: modNum noun 43 0 1) ; roomConv, "I have this lamp, 'princess.'"
				(if (!= theVerb 43) ; huntersLamp
					((ScriptID 740 7) add: modNum noun 57 0 1) ; roomConv, "I have this lamp, 'princess.'"
				else
					((ScriptID 740 7) add: modNum noun 43 0 2) ; roomConv, "(NASTY/GENIE) And a poor-looking one it is, too! Why should I care about that old thing?"
				)
				((ScriptID 740 7) init:) ; roomConv
			)
			((OneOf theVerb 56 2) ; fakeLamp5, Talk
				(gGame handsOff:)
				(closeupWedding seconds: 0 next: (ScriptID 744 1)) ; saladinKillEgo
				(gMessager say: noun theVerb 0 0 closeupWedding modNum)
			)
			((OneOf theVerb 67 63) ; peppermint, mint
				(gGame handsOff:)
				(SetFlag 156)
				(closeupWedding seconds: 0 next: (ScriptID 744 1)) ; saladinKillEgo
				(gMessager say: 4 67 0 0 closeupWedding 160) ; "Perhaps the princess would care for some delicious peppermint leaves?"
			)
			(else
				(switch theVerb
					(13 ; mirror
						(closeupWedding setScript: showMirror)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance vizierHead of CloseupProp
	(properties
		x 120
		y 53
		noun 7
		modNum 160
		view 160
		loop 3
		controlColor 4
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 33 18) ; ribbon, cassimaHair
				(= theVerb 65) ; note
				(super doVerb: 65)
			)
			((OneOf theVerb 57 58 59 60 43) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, huntersLamp
				(= theVerb 43) ; huntersLamp
				(super doVerb: 43)
			)
			((== theVerb 56) ; fakeLamp5
				(closeupWedding setScript: showReplicaLamp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alexHead of CloseupProp
	(properties
		x 51
		y 50
		view 160
		loop 2
		controlColor 8
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance priestHead of CloseupProp
	(properties
		x 270
		y 56
		noun 8
		modNum 160
		view 160
		loop 4
		controlColor 32
	)
)

(instance saladinArm of CloseupProp
	(properties
		x 5
		y 79
		noun 5
		modNum 160
		view 160
		loop 7
		cel 3
		controlColor 16
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 33 18) ; ribbon, cassimaHair
			(gMessager say: noun 33 0 0 0 modNum) ; "Saladin is unlikely to see that small token of esteem as being enough to contradict the living Cassima."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance saladinHead of View
	(properties
		x 10
		y 24
		view 160
		loop 5
	)

	(method (doVerb)
		(saladinArm doVerb: &rest)
	)
)

(instance mirror of Prop
	(properties
		x 35
		y 102
		view 160
		cel 2
	)
)

(instance glint1 of Prop
	(properties
		x 179
		y 47
		view 902
		priority 15
		signal 24576
		cycleSpeed 4
	)
)

(instance glint2 of Prop
	(properties
		x 169
		y 47
		view 902
		priority 15
		signal 24576
		cycleSpeed 4
	)
)

